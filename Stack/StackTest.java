package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static Stack.Stack.*;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void sizeNull() {
        Stack<Integer> testStack = new Stack<Integer>();

        int a = testStack.size();

        Assertions.assertTrue(a == 0);
    }

    @Test
    void sizeOne() {
        Stack<Integer> testStack = new Stack<Integer>();
        testStack.push(1001);

        int a = testStack.size();

        Assertions.assertTrue(a == 1);
    }

    @Test
    void sizeMany() {
        Stack<Integer> testStack = new Stack<Integer>();

        Random rand = new Random();
        int ri = rand.nextInt(10000);

        for (int i = 0; i < ri; i++) testStack.push(i);

        int a = testStack.size();

        Assertions.assertTrue(a == ri);
    }

    @Test
    void popOne() {
        Stack<Integer> testStack = new Stack<Integer>();

        testStack.push(1001);

        Assertions.assertTrue(testStack.pop() == 1001) ;
        Assertions.assertTrue(testStack.size() == 0);
    }

    @Test
    void popSeveral() {
        Stack<Integer> testStack = new Stack<Integer>();

        testStack.push(1001);
        testStack.push(2002);
        testStack.pop();

        Assertions.assertTrue(testStack.pop() == 1001) ;
        Assertions.assertTrue(testStack.size() == 0);
    }

    @Test
    void popLast() {
        Stack<Integer> testStack = new Stack<Integer>();

        Random rand = new Random();
        int ri = rand.nextInt(10000);

        for (int i = 0; i < ri; i++) testStack.push(i);

        Assertions.assertTrue(testStack.pop() == (ri-1));
        Assertions.assertTrue(testStack.size() == (ri-1));
    }

    @Test
    void pushNull() {
        Stack<Integer> testStack = new Stack<Integer>();

        testStack.push(null);

        Assertions.assertTrue(testStack.pop() == null) ;
        Assertions.assertTrue(testStack.size() == 0);
    }

    @Test
    void pushOne() {
        Stack<Integer> testStack = new Stack<Integer>();

        testStack.push(1001);

        Assertions.assertTrue(testStack.pop() == 1001) ;
        Assertions.assertTrue(testStack.size() == 0);
    }

    @Test
    void pushMany() {
        Stack<Integer> testStack = new Stack<Integer>();

        Random rand = new Random();
        int ri = rand.nextInt(10000);

        for (int i = 0; i < ri; i++) testStack.push(i);

        Assertions.assertTrue(testStack.size() == ri);
    }

    @Test
    void peekOnly() {
        Stack<Integer> testStack = new Stack<Integer>();

        testStack.push(1001);

        Assertions.assertTrue(testStack.peek() == 1001) ;
    }

    @Test
    void peekLast() {
        Stack<Integer> testStack = new Stack<Integer>();

        Random rand = new Random();
        int ri = rand.nextInt(10000);

        for (int i = 0; i < ri; i++) testStack.push(i);

        Assertions.assertTrue(testStack.peek() == (ri-1));
    }

    @Test
    void symbolCheckerNull() {
        Assertions.assertTrue(symbolChecker(""));
    }

    @Test
    void symbolCheckerBasicTrue() {
        Assertions.assertTrue(symbolChecker("(()((())()))"));
    }


    @Test
    void symbolCheckerBasicFalse() {
        Assertions.assertFalse(symbolChecker("(()((())())"));
    }

    @Test
    void symbolCheckerBasicFalseWithEqualNumberOfParenthesis() {
        Assertions.assertFalse(symbolChecker("(()))("));
    }

    @Test
    void symbolCheckerRightFirst() {
        Assertions.assertFalse(symbolChecker("))()"));
    }


    @Test
    void symbolCheckerNull2() {
        Assertions.assertTrue(symbolChecker2(""));
    }

    @Test
    void symbolCheckerBasicTrue2() {
        Assertions.assertTrue(symbolChecker2("(()((())()))"));
    }


    @Test
    void symbolCheckerBasicFalse2() {
        Assertions.assertFalse(symbolChecker2("(()((())())"));
    }

    @Test
    void symbolCheckerBasicFalseWithEqualNumberOfParenthesis2() {
        Assertions.assertTrue(symbolChecker2("(()))("));
    }

    @Test
    void symbolCheckerRightFirst2() {
        Assertions.assertFalse(symbolChecker2("))()"));
    }



    @Test
    void postfixCalcBasic() {
        Assertions.assertTrue(postfixCalc("1 2 + 3 *") == 9);
    }

    @Test
    void postfixCalcExample() {
        Assertions.assertTrue(postfixCalc("8 2 + 5 * 9 + =") == 59);
    }

    @Test
    void postfixCalcSubtraction() {
        Assertions.assertTrue(postfixCalc("1 2 + 3 -") == 0);
    }

    @Test
    void postfixCalcDivision() {
        Assertions.assertTrue(postfixCalc("1 2 + 6 * 54 /") == 3);
    }

    @Test
    void postfixCalcEqualSign() {
        Assertions.assertTrue(postfixCalc("1 2 + 6 * = 54 /") == 18);
    }

    @Test
    void postfixCalcDivisionMinimal() {
        Assertions.assertTrue(postfixCalc("2 18 /") == 9);
    }
}