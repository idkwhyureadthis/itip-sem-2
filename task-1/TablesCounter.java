public class TablesCounter {
    private static final int TABLE_CAPACITY = 2;
    public static void main(String[] args) {
        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));
    }
    
    private static int tables(int studends, int tables){
        int tablesNeeded = studends / TABLE_CAPACITY + ((studends % TABLE_CAPACITY != 0) ? 1 : 0);
        return Math.max(0, tablesNeeded - tables);
    }
}
