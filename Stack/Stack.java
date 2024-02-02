package Stack;

import java.util.*;

public class Stack<T>
{
    LinkedList<T> linkedList;

    public Stack()
    {
        linkedList = new LinkedList<>();
        // инициализация внутреннего хранилища стека
    }

    public int size()
    {
        return linkedList.size();
    }

    public T pop()
    {
        try {
            return linkedList.pop();
        } catch (NoSuchElementException exception) {
            return null;
        }
    }

    public void push(T val)
    {
        linkedList.push(val);
    }

    public T peek()
    {
        // ваш код
        return linkedList.peek();
    }
}
