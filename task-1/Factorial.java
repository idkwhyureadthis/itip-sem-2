public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));
    }

    private static int factorial(int n){
        int answer = 1;
        for (int i = 1; i <= n; i++){
            answer *= i;
        }
        return answer;
    }
}
