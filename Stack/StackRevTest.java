package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class StackRevTest {

    @Test
    void sizeNull() {
        StackRev<Integer> testStack = new StackRev<Integer>();

        int a = testStack.size();

        Assertions.assertTrue(a == 0);
    }

    @Test
    void sizeOne() {
        StackRev<Integer> testStack = new StackRev<Integer>();
        testStack.push(1001);

        int a = testStack.size();

        Assertions.assertTrue(a == 1);
    }

    @Test
    void sizeMany() {
        StackRev<Integer> testStack = new StackRev<Integer>();

        Random rand = new Random();
        int ri = rand.nextInt(10000);

        for (int i = 0; i < ri; i++) testStack.push(i);

        int a = testStack.size();

        Assertions.assertTrue(a == ri);
    }

    @Test
    void popOne() {
        StackRev<Integer> testStack = new StackRev<Integer>();

        testStack.push(1001);

        Assertions.assertTrue(testStack.pop() == 1001) ;
        Assertions.assertTrue(testStack.size() == 0);
    }

    @Test
    void popSeveral() {
        StackRev<Integer> testStack = new StackRev<Integer>();

        testStack.push(1001);
        testStack.push(2002);
        testStack.pop();

        Assertions.assertTrue(testStack.pop() == 1001) ;
        Assertions.assertTrue(testStack.size() == 0);
    }

    @Test
    void popLast() {
        StackRev<Integer> testStack = new StackRev<Integer>();

        Random rand = new Random();
        int ri = rand.nextInt(10000);

        for (int i = 0; i < ri; i++) testStack.push(i);

        Assertions.assertTrue(testStack.pop() == (ri-1));
        Assertions.assertTrue(testStack.size() == (ri-1));
    }

    @Test
    void pushNull() {
        StackRev<Integer> testStack = new StackRev<Integer>();

        testStack.push(null);

        Assertions.assertTrue(testStack.pop() == null) ;
        Assertions.assertTrue(testStack.size() == 0);
    }

    @Test
    void pushOne() {
        StackRev<Integer> testStack = new StackRev<Integer>();

        testStack.push(1001);

        Assertions.assertTrue(testStack.pop() == 1001) ;
        Assertions.assertTrue(testStack.size() == 0);
    }

    @Test
    void pushMany() {
        StackRev<Integer> testStack = new StackRev<Integer>();

        Random rand = new Random();
        int ri = rand.nextInt(10000);

        for (int i = 0; i < ri; i++) testStack.push(i);

        Assertions.assertTrue(testStack.size() == ri);
    }

    @Test
    void peekOnly() {
        StackRev<Integer> testStack = new StackRev<Integer>();

        testStack.push(1001);

        Assertions.assertTrue(testStack.peek() == 1001) ;
    }

    @Test
    void peekLast() {
        StackRev<Integer> testStack = new StackRev<Integer>();

        Random rand = new Random();
        int ri = rand.nextInt(10000);

        for (int i = 0; i < ri; i++) testStack.push(i);

        Assertions.assertTrue(testStack.peek() == (ri-1));
    }
}