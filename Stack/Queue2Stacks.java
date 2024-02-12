package Stack;

public class Queue2Stacks<T> {
    private Stack<T> tail;
    private Stack<T> bd;
    private int len;

    public Queue2Stacks() {
        tail = new Stack<T>();
        bd = new Stack<T>();
        len = 0;
    }

    public void enqueue(T item) {
        for (int i = 0; i < len; i++) bd.push(tail.pop());
        tail.push(item);
        for (int i = 0; i < len; i++) tail.push(bd.pop());

        len++;
    }

    public T dequeue() {
        T elem;
        if (len > 0) len--;

        return tail.pop();
    }

    public int size() {
        return len;
    }
}