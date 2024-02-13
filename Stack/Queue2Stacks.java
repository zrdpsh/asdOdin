package Stack;

public class Queue2Stacks<T> {
    private Stack<T> head;
    private Stack<T> tail;
    private int len;

    public Queue2Stacks() {
        head = new Stack<T>();
        tail = new Stack<T>();
        len = 0;
    }

    public void enqueue(T item) {
        head.push(item);
        len++;
    }

    public T dequeue() {
        if (tail.size() == 0) fillTail();

        T elem = tail.pop();

        if (len > 0) len--;

        return elem;
    }

    private void fillTail() {
        int sz = this.head.size();
        for (int i = 0; i < sz; i+=1) {
            this.tail.push(this.head.pop());
        }
    }

    public int size() {
        return len;
    }
}