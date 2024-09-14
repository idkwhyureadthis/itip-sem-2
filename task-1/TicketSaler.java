public class TicketSaler {
    private static final double TAX_PERCENTAGE = 0.28;
    public static void main(String[] args){
        System.out.println(ticketSaler(70, 1500D));
        System.out.println(ticketSaler(24, 950D));
        System.out.println(ticketSaler(53, 1250D));
    }
    
    private static double ticketSaler(int sold, double price){
        double beforeTax = sold * price;
        return beforeTax - beforeTax * TAX_PERCENTAGE;
    }
}
