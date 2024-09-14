public class FitCalculator {
    public static void main(String[] args) {
        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));
    }
    
    private static int fitCalc(int time, int intensity){
        return time * intensity;
    }
}
