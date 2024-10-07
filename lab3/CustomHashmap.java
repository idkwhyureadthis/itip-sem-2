package hashmap;

import java.util.HashMap;

public class CustomHashmap {

    private HashMap<Integer, Order> hashMap;

    public CustomHashmap(){
        hashMap = new HashMap<>();
    }

    public void insert(int key, Order value){
        hashMap.put(key, value);
    }

    public Order getValue(int key){
        return hashMap.get(key);
    }

    public Order delete(int key){
        return hashMap.remove(key);
    }
}


