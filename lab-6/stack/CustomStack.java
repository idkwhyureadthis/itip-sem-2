package stack;
public class CustomStack<T> {
    private T[] data;
    private int size;
    @SuppressWarnings("unchecked")
    public CustomStack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == data.length;
    }

    public void push(T element) {
        if (this.isFull()) {System.out.println("stack is full");};
        size++;
        data[size] = element;
    }
    public T pop() {
        if (this.isEmpty()) return null;
        return data[size--];
    }
    
    public T peek() {
        if (this.isEmpty()) return null;
        return data[size];
    }
}