public class TernaryCalculator {
    public static void main(String[] args) {
        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));
    }

    public static int ternaryEvaluation(int a, int b){
        return (a > b)? a : b;
    }
}
