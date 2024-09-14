public class GCDCalc {
    public static void main(String[] args){
        System.out.println(gcd(18, 48));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));
    }

    private static int gcd(int n1, int n2)
    {
        if (n2 != 0)
            return gcd(n2, n1 % n2);
        else
            return n1;
    }
}
