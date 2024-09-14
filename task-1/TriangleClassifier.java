public class TriangleClassifier {
    public static void main(String[] args) {
        System.out.println(triangleType(5,5,5));
        System.out.println(triangleType(5,4,5));
        System.out.println(triangleType(5,4,3));
        System.out.println(triangleType(5,1,1));
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
}
