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
        if(len == 0){
            head.push(item);
        }else{
            bd.push(item);
        }
        len++;
    }

    public T dequeue() {
        T elem;
        if(len==1){
            elem = head.pop();
        }else{
            elem = head.pop();
            head.push(bd.pop());
        }
        if(len > 0)
            len--;
        return elem;
    }

    public int size() {
        return len;
    }
}