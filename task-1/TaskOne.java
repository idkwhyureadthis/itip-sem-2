public class TaskOne {
    private static final double GALLON_RATE = 3.785;
    private static final int BOXES_CAPACITY = 20;
    private static final int BAGS_CAPACITY = 50;
    private static final int BARRELS_CAPACITY = 100;
    private static final double TAX_PERCENTAGE = 0.28;
    private static final int TABLE_CAPACITY = 2;
    
    public static void main(String[] args){
        System.out.println("1:");
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));
        System.out.println("2:");
        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));
        System.out.println("3:");
        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));
        System.out.println("4:");
        System.out.println(triangleType(5,5,5));
        System.out.println(triangleType(5,4,5));
        System.out.println(triangleType(5,4,3));
        System.out.println(triangleType(5,1,1));
        System.out.println("5:");
        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));
        System.out.println("6:");
        System.out.println(howManyItems(22D, 1.4D, 2D));
        System.out.println(howManyItems(45D, 1.8D, 1.9D));
        System.out.println(howManyItems(100D, 2D, 2D));
        System.out.println("7:");
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));
        System.out.println("8:");
        System.out.println(gcd(18, 48));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));
        System.out.println("9:");
        System.out.println(ticketSaler(70, 1500D));
        System.out.println(ticketSaler(24, 950D));
        System.out.println(ticketSaler(53, 1250D));
        System.out.println("10:");
        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));
    }

    private static double convert(int gallons){
        return gallons * GALLON_RATE;
    }

    private static int fitCalc(int time, int intensity){
        return time * intensity;
    }

    private static int containers(int boxes, int bags, int barrels){
        return boxes * BOXES_CAPACITY + bags * BAGS_CAPACITY + barrels * BARRELS_CAPACITY;
    }

    private static String triangleType(int x, int y, int z){
        if (x + y <= z || x + z <= y || z + y <= x){
            return "not a triangle";
        }
        if (x == y && y == z){
            return "isosceles";
        }
        if (x == y || y == z || x == z){
            return "equilateral";
        }
        return "different-sided";
    }

    public static int ternaryEvaluation(int a, int b){
        return (a > b)? a : b;
    }


    private static int howManyItems(double clothSize, double w, double h){
        int maxHalves;

        maxHalves = (int)(clothSize / (w * h));
        return maxHalves / 2;
    }


    private static int gcd(int n1, int n2)
    {
        if (n2 != 0)
            return gcd(n2, n1 % n2);
        else
            return n1;
    }


    private static int factorial(int n){
        int answer = 1;
        for (int i = 1; i <= n; i++){
            answer *= i;
        }
        return answer;
    }


    private static double ticketSaler(int sold, double price){
        double beforeTax = sold * price;
        return beforeTax - beforeTax * TAX_PERCENTAGE;
    }


    private static int tables(int studends, int tables){
        int tablesNeeded = studends / TABLE_CAPACITY + ((studends % TABLE_CAPACITY != 0) ? 1 : 0);
        return Math.max(0, tablesNeeded - tables);
    }
}
