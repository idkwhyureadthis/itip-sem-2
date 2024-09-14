public class Converter{
    private static final double GALLON_RATE = 3.785;
    public static void main(String[] args){
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));
    }

    private static double convert(int gallons){
        return gallons * GALLON_RATE;
    }
}