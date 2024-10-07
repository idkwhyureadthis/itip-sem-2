package hashmap;

public class Order{
    private Item[] items;
    private String address;
    private float totalPrice;

    public Order(String address, float totalPrice, Item[] items){
        this.totalPrice = totalPrice;
        this.address = address;
        this.items = items;
    }


    public String getAddress(){
        return this.address;
    }

    public float getTotalPrice(){
        return this.totalPrice;
    }

    public Item[] getItems(){
        return items;
    }
}