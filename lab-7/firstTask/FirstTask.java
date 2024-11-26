package firstTask;

import java.util.Arrays;

public class FirstTask{
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,5};
        MyRunnable runnable1 = new MyRunnable(Arrays.copyOfRange(nums, 0, nums.length / 2));
        MyRunnable runnable2 = new MyRunnable(Arrays.copyOfRange(nums, nums.length / 2, nums.length));
        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e){
            System.err.println(e.getMessage());
            return;
        }
        System.out.println(runnable1.returnSum() + " " + runnable2.returnSum());
        System.out.println(runnable1.returnSum() + runnable2.returnSum());
    }
}