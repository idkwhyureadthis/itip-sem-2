package shopkeeping;

public class Item {
    private String name;
    private float price;
    private String description;

    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public float getPrice(){
        return price;
    }

    public void setDescription(String description){
        this.description = description;
    }
    
    public String getDescription(){
        return description;
    }

    public Item(String name, float price){
        this.name = name;
        this.price = price;
        description = "";
    }
}
