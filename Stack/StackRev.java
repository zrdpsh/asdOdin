package Stack;

import java.util.LinkedList;

public class StackRev<T> {
    LinkedList<T> linkedList;

    public StackRev()
    {
        linkedList = new LinkedList<>();
    }

    public int size()
    {
        return linkedList.size();
    }

    public T pop()
    {
        T r = null;

        if (!linkedList.isEmpty()) r = linkedList.removeFirst();

        return r;
    }

    public void push(T val)
    {
        linkedList.addFirst(val);
    }

    public T peek()
    {
        return linkedList.peekFirst();
    }
}
