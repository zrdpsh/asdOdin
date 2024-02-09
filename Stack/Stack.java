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

        Stack<Comparable> parsedNumbers = new Stack();

        int result = 0;
        String buffer = "";

        HashMap<Character, IntBinaryOperator> functions = new HashMap<>();
        functions.put('+', (a, b) -> a+b);
        functions.put('-', (a, b) -> a-b);
        functions.put('*', (a, b) -> a*b);
        functions.put('/', (a, b) -> a/b);

//        Map<Character, BinaryOperator<Integer>> functions2 = Map.ofEntries(
//                entry('+', Integer::sum),
//                entry('-', (a, b) -> a-b),
//                entry('*', (a, b) -> a*b),
//                entry('/', (a, b) -> a/b)
//        );

        for (int i = 0; i < expr.length(); i++) {
            char s = expr.charAt(i);

            IntBinaryOperator op = null;
            
            Character.isDigit(s) ? buffer += s : Character.isWhitespace(s) ? parsedNumbers.push(Integer.parseInt(buffer)) : op = functions.get(s);

            result = op.applyAsInt((Integer) parsedNumbers.pop(), (Integer) parsedNumbers.pop());
//            switch (s) {
//                case '+':
//                    result= (int) parsedNumbers.pop() + (int) parsedNumbers.pop();
//                    parsedNumbers.push(result);
//                    break;
//                case '*':
//                    result= (int) parsedNumbers.pop() * (int) parsedNumbers.pop();
//                    parsedNumbers.push(result);
//                    break;
//                case '-':
//                    result= (int) parsedNumbers.pop() - (int) parsedNumbers.pop();
//                    parsedNumbers.push(result);
//                    break;
//                case '/':
//                    result= (int) parsedNumbers.pop() / (int) parsedNumbers.pop();
//                    parsedNumbers.push(result);
//                    break;
//                case ' ':
//                    parsedNumbers.push(Integer.parseInt(buffer));
//                    buffer = "";
//                    break;
//                case '=':
//                    break;
//                default:
//                    buffer += s;
//            }
            


//            Character.isDigit(s) ? buffer += s : functions.get(s);
//
//            Character.isDigit(s) ? Character.is
//                    parsedNumbers.push(Integer.parseInt(buffer))
//                            :
//                    ()-> {
//                        IntBinaryOperator op = functions.get(s);
//                        result = op((Integer) parsedNumbers.pop(), (Integer) parsedNumbers.pop());
//                    };
//
//            IntBinaryOperator op = functions.get(s);
//            result = op((Integer) parsedNumbers.pop(), (Integer) parsedNumbers.pop());
        }
    }
}
