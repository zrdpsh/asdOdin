package Deque;

import java.util.*;

public class Deque<T>
{
    LinkedList<T> lL;
    T elem;
    int len;

    public Deque()
    {
        lL = new LinkedList<>();
        len = 0;
    }

    public void addFront(T item)
    {
        lL.addFirst(item);
        len++;
    }

    public void addTail(T item)
    {
        lL.addLast(item);
        len++;
    }

    public T removeFront()
    {
        if (len > 0) {
            elem = lL.removeFirst();
            len--;
            return elem;
        }
        return null;
    }

    public T removeTail()
    {
        if (len > 0) {
            elem = lL.removeLast();
            len--;
            return elem;
        }
        return null;
    }
        
    public int size()
    {
     return len;
    }

    public boolean isPalindrome(String givenString)
    {
        Deque<String> deq = new Deque<String>();

        String[] newArr = givenString.toLowerCase().split("");

        for (int i = 0; i < newArr.length; i++) {
            deq.addTail(newArr[i]);
        }

        int arrLn = (newArr.length-1)/2;

        for (int i = 0; i < arrLn; i++) {
            if (!deq.removeTail().equals(deq.removeFront())) return false;
        }
        return true;
    }
}
