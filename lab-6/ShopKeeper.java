import shopkeeping.Item;
import shopkeeping.SoldItems;

public class ShopKeeper {
    public static void main(String[] args){
        SoldItems s = new SoldItems();
        Item i1 = new Item("tomato", 50);
        s.sell(i1, 10);
        
        System.out.println(s.getHighestSale());

        Item i2 = new Item("apple", 200);
        s.sell(i2, 200);
        System.out.println(s.getHighestSale());
        s.printSoldItems();
    }
}
