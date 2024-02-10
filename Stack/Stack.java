package Stack;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

import static java.util.Map.entry;

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

        Stack<Comparable> parsdNums = new Stack();

        String buffer = "";
        char prevChar = 'a';

        for (int i = 0; i < expr.length(); i++) {
            char s = expr.charAt(i);

            if (s == '+') {
                parsdNums.push((int) parsdNums.pop() + (int) parsdNums.pop());
            }
            if (s == '-') {
                parsdNums.push((int) parsdNums.pop() - (int) parsdNums.pop());
            }
            if (s == '*') {
                parsdNums.push((int) parsdNums.pop() * (int) parsdNums.pop());
            }
            if (s == '/') {
                parsdNums.push((int) parsdNums.pop() / (int) parsdNums.pop());
            }

            if (s == '=') {
                return (int) parsdNums.pop();
            }

            if (Character.isDigit(s)) buffer += s;

            if (s == ' ' && Character.isDigit(prevChar)) {
                parsdNums.push(Integer.parseInt(buffer));
                buffer = "";
            }

            prevChar = s;

        }
        return (int) parsdNums.pop();
    }
}
