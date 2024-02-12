package Stack;

public class Queue2Stacks<T> {
    private Stack<T> head;
    private StackRev<T> bd;
    private int len;

    public Queue2Stacks() {
        head = new Stack<T>();
        bd = new StackRev<T>();
        len = 0;
    }

    public void enqueue(T item) {

    }

    public T dequeue() {
        T elem;

    }

    public int size() {
        return len;
    }
}