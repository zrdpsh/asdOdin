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
        try {
            return linkedList.pop();
        } catch (NoSuchElementException e) {
            return null;
        }
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
