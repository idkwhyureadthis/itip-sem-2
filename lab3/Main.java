package lab3;

import hashmap.*;


public class Main {
    public static void main(String[] args) {
        CustomHashmap customHashmap = new CustomHashmap();
        customHashmap.insert(1, new Order("Авиамоторная 8а", 148.8f, new Item[]{new Item("ноутбук", "ноутбук сэрголда (тостер)"), new Item("помидоры", "крутые помидоры ёмаё")}));
        customHashmap.insert(2, new Order("Авиамоторная 8а", 140.8f, new Item[]{new Item("ноутбук", "ноутбук сэрголда (тостер)")}));
        customHashmap.insert(3, new Order("Авиамоторная 8а", 8f, new Item[]{new Item("помидоры", "крутые помидоры ёмаё")}));
        Order order = customHashmap.getValue(1);
        for (Item i: order.getItems()){
            System.out.println(i.getName() + " " + i.getDescription());
        }
        order = customHashmap.getValue(5);
        System.out.println(order);

        order = customHashmap.getValue(3);
        for (Item i: order.getItems()){
            System.out.println(i.getName() + " " + i.getDescription());
        }

        customHashmap.delete(1);
        order = customHashmap.getValue(1);
        System.out.println(order);
    }
}
