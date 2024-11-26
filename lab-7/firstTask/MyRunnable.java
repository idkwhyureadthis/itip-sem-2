package firstTask;

public class MyRunnable implements Runnable {
    private int sm;
    private int[] nums;
    public MyRunnable(int[] nums) {
        this.nums = nums;
    }
    public void run() {
        sm = 0;
        for(int i: nums){
            sm += i;
        }
    }

    public int returnSum(){
        return sm;
    }
}