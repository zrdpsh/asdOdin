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

    public static boolean symbolChecker(String str) {

        Stack stack = new Stack();

        for(int i = 0; i < str.length(); i++){

            char c = str.charAt(i);

            if (c == '(') stack.push(c);
            else if (c == ')') stack.pop();
            else break;

        }
        return (stack.peek() == null);
    }

    public static int postfixCalc(String expr) {



        return 0;
    }

}
