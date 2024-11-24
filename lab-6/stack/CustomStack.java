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

    public int size(){
        return size;
    }

    public void print(){
        if(this.isEmpty()){
            System.out.println("stack is empty");
        }
        for (int i = size - 1; i > 0; i--){
            System.out.print(data[i] + " -> ");
        }
        System.out.println(data[0]);
    }

    public boolean isFull(){
        return size == data.length;
    }

        
    public T peek() {
        if (this.isEmpty()) return null;
        return data[size - 1];
    }

    public void push(T element) {
        if (this.isFull()) {System.out.println("stack is full");};
        data[size] = element;
        size++;
    }
    public T pop() {
        if (this.isEmpty()) return null;
        size--;
        T elem = data[size];
        return elem;
    }
}