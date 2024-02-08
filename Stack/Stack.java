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

        Stack<Comparable> parsedNumbers = new Stack();

        int res = 0;

        for (int i = 0; i < expr.length(); i++) {
            char s = expr.charAt(i);
            switch (s) {
                case '+':
                    res = (int) parsedNumbers.pop() + (int) parsedNumbers.pop();
                    parsedNumbers.push(res);
                    break;
                case '*':
                    res = (int) parsedNumbers.pop() * (int) parsedNumbers.pop();
                    parsedNumbers.push(res);
                    break;
                case '=':
                case ' ':
                    break;
                default:
                    parsedNumbers.push(Character.getNumericValue(s));
            }
        }

        return (int) parsedNumbers.pop();
    }
}
