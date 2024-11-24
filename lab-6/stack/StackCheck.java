package stack;
public class StackCheck{
    public static void main(String[] args) {
        CustomStack<Integer> stack = new CustomStack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.print();
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.print();
        stack.push(4);
        stack.print();
        System.out.println(stack.pop());
        stack.print();
    }
}
