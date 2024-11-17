package stack;
public class Stack<T> {
    private T[] data;
    private int size;
    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }
    public void push(T element) {
        if (size == data.length) {System.out.println("stack is full");};
        size++;
        data[size] = element;
    }
    public T pop() {
        if (size == 0) return null;
        T toRet = data[size];
        data[size] = null;
        size--;
        return toRet;
    }
    public T peek() {
        if (size == 0) return null;
        return data[size];
    }
}