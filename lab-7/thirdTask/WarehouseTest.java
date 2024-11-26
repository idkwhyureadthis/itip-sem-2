package thirdTask;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class WarehouseTest {
    public static void main(String[] args){
        Warehouse wh = new Warehouse(20);
        Loader ld = new Loader(wh);
        Storage st = new Storage(wh);

        Thread t1 = new Thread(ld);
        Thread t2 = new Thread(st);

        t2.start();
        t1.start();

        try {
            t1.join();
            t2.join();
        } catch(InterruptedException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Погрузка окончена");
    }
}

class Loader implements Runnable{
    private Warehouse wh;

    public Loader(Warehouse wh){
        this.wh = wh;
    }

    public void run(){
        while(wh.isItemsLeft() || wh.getTotalWeight() != 0){
            wh.load();
        }
    }
}

class Storage implements Runnable{
    private Warehouse wh;

    public Storage(Warehouse wh){
        this.wh = wh;
    }

    public void run(){
        while(wh.isItemsLeft()){
            wh.getNewItem();
        }
    }
}


class Warehouse{
    private List<Integer> loaded = new LinkedList<>();
    private int itemsLeft;
    ReentrantLock locker;
    Condition condition;
    public Warehouse(int items){
        locker = new ReentrantLock();
        condition = locker.newCondition();
        itemsLeft = items;
    }

    public boolean isItemsLeft(){
        return itemsLeft != 0;
    }

    public int getItemsTo150(){
        List<Integer> toRet = new LinkedList<>();
        if (this.getTotalWeight() < 150){
            toRet.addAll(loaded);
            loaded.clear();
            return toRet.size();
        }
        int lastInd = 0;
        int curr = 0;
        for (int i = 0; i < loaded.size(); i++){
            if (curr + loaded.get(i) > 150){
                break;
            } else {
                toRet.add(loaded.get(i));
                lastInd = i;
            }
        }
        loaded.subList(0, lastInd).clear();
        return lastInd;
    }

    public void load(){
        locker.lock();
        try{
            while(this.getTotalWeight() < 150 && this.isItemsLeft()){
                condition.await();
            }
            int loadedItems = this.getItemsTo150();
            System.out.printf("Идёт отгрузка %d товаров со склада\n", loadedItems);
            TimeUnit.SECONDS.sleep(2);
            System.out.println("предметы были отгружены\n");
            System.out.printf("Оставшиеся товары на складе %s \n", loaded.toString());
            condition.signalAll();
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }
    


    public void getNewItem(){
        locker.lock();
        try{
            while (this.getTotalWeight() >= 150){
                condition.await();
            }
            Random random = new Random();
            int newItem = random.nextInt(50) + 1;
            loaded.add(newItem);
            System.out.printf("Поступил новый предмет весом %d\n", newItem);
            itemsLeft--;
            condition.signalAll();
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }

    public int getTotalWeight(){
        int sm = 0;
        for (int i: loaded){
            sm += i;
        }
        return sm;
    }
}