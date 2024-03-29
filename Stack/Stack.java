package Stack;

import java.util.LinkedList;

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
            if (c == ')' && stack.size() == 0) return false;
            if (c == ')') stack.pop();

        }
        return (stack.size() == 0);
    }


    public static int postfixCalc(String expr) {

        Stack<Comparable> parsdNums = new Stack();

        String buffer = "";
        char prevChar = 'a';

        for (int i = 0; i < expr.length(); i++) {
            char s = expr.charAt(i);

            int t1 = (int) parsdNums.pop();
            int t2 = (int) parsdNums.pop();

            if (s == '+') {
                parsdNums.push(t1 + t2);
            }
            if (s == '-') {
                parsdNums.push((int) t1 - t2);
            }
            if (s == '*') {
                parsdNums.push((int) t1 * t2);
            }
            if (s == '/') {
                parsdNums.push((int) t1 / t2);
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


    public static boolean symbolChecker2(String str) {

        int flg =  0;

        for(int i = 0; i < str.length(); i++){

            char c = str.charAt(i);

            if (c == '(') flg += 1;
            if (c == ')') flg -= 1;

        }
        return (flg == 0);
    }
}
