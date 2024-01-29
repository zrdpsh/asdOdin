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
        // ваш код
        return null;  // если стек пустой
    }

    public void push(T val)
    {
        // ваш код
    }

    public T peek()
    {
        // ваш код
        return null; // если стек пустой
    }
}
