package lab3;


import java.util.LinkedList;
import java.util.ArrayList;

public class HashTable<K, V> {
    private static class Entry<K, V> {
        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private final ArrayList<LinkedList<Entry<K, V>>> table;
    private int size;

    public HashTable() {
        table = new ArrayList<>(16);
        size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.size();
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table.get(index) == null) {
            table.set(index, new LinkedList<>());
        }
        for (Entry<K, V> entry : table.get(index)) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table.get(index).add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        if (table.get(index) != null) {
            for (Entry<K, V> entry : table.get(index)) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null; // Возвращаем null, если ключ не найден
    }

    public V remove(K key) {
        int index = hash(key);
        if (table.get(index) != null) {
            for (Entry<K, V> entry : table.get(index)) {
                if (entry.getKey().equals(key)) {
                    V value = entry.getValue();
                    table.get(index).remove(entry);
                    size--;
                    return value;
                }
            }
        }
        return null; // Возвращаем null, если ключ не найден
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}