package shopkeeping;

import java.util.*;

public class SoldItems {
    private int size;
    private Map<Item, Integer> data;
    public SoldItems(){
        data = new LinkedHashMap<>();
        size = 0;
    }
    public SoldItems(int capacity){
        data = new LinkedHashMap<>(capacity);
        size = 0;
    }

    public void sell(Item key, int quantity){
        data.put(key, data.getOrDefault(key, 0) + quantity);
    }

    public int get(Item key){
        return data.get(key);
    }

    public int getOrDefault(Item key, int def){
        return data.getOrDefault(key, def);
    }

    public int getHighestSale(){
        return Collections.max(data.values());
    }

    public void printSoldItems(){
        for(Map.Entry<Item, Integer> entry : data.entrySet()){
            System.out.printf("item: %s : %d sales \n", entry.getKey().getName(), entry.getValue());
        }
    }

    public long totalSellPrice(){
        long price = 0;
        for (Map.Entry<Item, Integer> entry : data.entrySet()){
            price += entry.getKey().getPrice() * entry.getValue();
        }
        return price;
    }
}
