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
        // размер текущего стека
        return linkedList.size();
    }

    public T pop()
    {
        try {
            return linkedList.pop();
        } catch (NoSuchElementException exception) {
            return null;
        }
//        // ваш код
//        return null;  // если стек пустой
    }

    public void push(T val)
    {
        linkedList.push(val);
        // ваш код
    }

    public T peek()
    {
        // ваш код
        return null; // если стек пустой
    }
}
