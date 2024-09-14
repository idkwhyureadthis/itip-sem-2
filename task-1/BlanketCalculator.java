public class BlanketCalculator{
    public static void main(String[] args) {
        System.out.println(howManyItems(22D, 1.4D, 2D));
        System.out.println(howManyItems(45D, 1.8D, 1.9D));
        System.out.println(howManyItems(100D, 2D, 2D));
    }

    private static int howManyItems(double clothSize, double w, double h){
        int maxHalves;

        maxHalves = (int)(clothSize / (w * h));
        return maxHalves / 2;
    }
}