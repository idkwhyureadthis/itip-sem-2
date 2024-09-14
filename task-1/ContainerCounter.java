public class ContainerCounter {
    private static final int BOXES_CAPACITY = 20;
    private static final int BAGS_CAPACITY = 50;
    private static final int BARRELS_CAPACITY = 100;
    public static void main(String[] args) {
        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));
    }
    
    private static int containers(int boxes, int bags, int barrels){
        return boxes * BOXES_CAPACITY + bags * BAGS_CAPACITY + barrels * BARRELS_CAPACITY;
    }
}
