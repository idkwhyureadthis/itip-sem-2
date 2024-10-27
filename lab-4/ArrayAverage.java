public class ArrayAverage {
    public static void main(String[] args) {
        Object[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int sum = 0;
        int counted = 0;
        try {
            for (int i = 0; i < 10; i++){
                sum += (int)arr[i];
                counted++;
            }
        }
        catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("Array size less than 10");
        } catch (ClassCastException c) {
            System.out.println("wrong data provided");
            return;
        } f {
            System.out.printf("Average of first 10 elements is: %f", (float)sum / counted);
        }
    }
}