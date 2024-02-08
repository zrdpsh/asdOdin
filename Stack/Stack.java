package Stack;

import java.util.*;

public class Stack<T>
{
    LinkedList<T> linkedList;

    public Stack()
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

        if (!linkedList.isEmpty()) r = linkedList.pop();

        return r;
    }

    public void push(T val)
    {
        linkedList.push(val);
    }

    public T peek()
    {
        return linkedList.peek();
    }
}
