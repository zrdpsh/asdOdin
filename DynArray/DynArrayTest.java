package DynArray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;

class DynArrayTest {

    @Test
    void makeArrayChangeCapacity() {
        DynArray testDA = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 16; i++) testDA.append(i);
        testDA.append(16);

        Integer a = (Integer) testDA.getItem(16);

        Assertions.assertTrue(testDA.count == 17);
        Assertions.assertTrue(testDA.capacity == 32);
        Assertions.assertTrue(a == 16);
    }
    

    @Test
    void getItemGetFrst() {
        DynArray testDA = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 3; i++) testDA.append(i);

        Integer a = (Integer) testDA.getItem(0);

        Assertions.assertTrue(testDA.count == 3);
        Assertions.assertTrue(testDA.capacity == 16);
        Assertions.assertTrue(a == 0);
    }

    @Test
    void getItemGetLst() {
        DynArray testDA = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 3; i++) testDA.append(i);

        Integer a = (Integer) testDA.getItem(2);

        Assertions.assertTrue(testDA.count == 3);
        Assertions.assertTrue(testDA.capacity == 16);
        Assertions.assertTrue(a == 2);
    }

    @Test
    void appendWithoutOverload() {
        DynArray testDA = new DynArray<Integer>(Integer.class);

        testDA.append(11);

        Integer a = (Integer) testDA.getItem(0);
        Assertions.assertTrue(testDA.count == 1);
        Assertions.assertTrue(testDA.capacity == 16);
        Assertions.assertTrue(a == 11);
    }

    @Test
    void appendWithOverload() {
        DynArray testDA = new DynArray<Integer>(Integer.class);

        for (int i = 0; i < 16; i++) testDA.append(i);
        testDA.append(16);

        Integer a = (Integer) testDA.getItem(16);

        Assertions.assertTrue(testDA.count == 17);
        Assertions.assertTrue(testDA.capacity == 32);
        Assertions.assertTrue(a == 16);
    }

    @Test
    void insertWithoutOverload() {
        DynArray testDA = new DynArray<Integer>(Integer.class);

        testDA.append(0);
        testDA.insert(1001, 0);

        Integer a = (Integer) testDA.getItem(0);

        Assertions.assertTrue(testDA.count == 2);
        Assertions.assertTrue(testDA.capacity == 16);
        Assertions.assertTrue(a == 1001);
    }

    @Test
    void insertWithOverload() {
        DynArray testDA = new DynArray<Integer>(Integer.class);

        for (int i = 0; i < 16; i++) testDA.append(i);
        testDA.insert(1001, 0);

        Integer a = (Integer) testDA.getItem(0);

        Assertions.assertTrue(testDA.count == 17);
        Assertions.assertTrue(testDA.capacity == 32);
        Assertions.assertTrue(a == 1001);
    }

    @Test
    void InsertAtCountPosition() {
        DynArray testDA = new DynArray<Integer>(Integer.class);

        for (int i = 0; i < 16; i++) testDA.append(i);

        testDA.insert(1001, testDA.count);

        Integer a = (Integer) testDA.getItem(testDA.count-1);

        Assertions.assertTrue(testDA.count == 17);
        Assertions.assertTrue(testDA.capacity == 32);
        Assertions.assertTrue(a == 1001);
    }

    @Test
    public void NullPointerInsertBelowZero() {
        DynArray testDA = new DynArray<Integer>(Integer.class);

        Exception exception = assertThrows(Exception.class, () -> {
            testDA.insert(1001, -1);
        });

        String expectedMessage = "Illegal index";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void removeNullElements() {

        DynArray testDA = new DynArray<Integer>(Integer.class);

        Exception exception = assertThrows(Exception.class, () -> {
            testDA.remove(0);
        });

        String expectedMessage = "Illegal index";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void removeOneElement() {
        DynArray testDA = new DynArray<Integer>(Integer.class);


        testDA.append(0);
        testDA.remove(0);

        Integer a = (Integer) testDA.getItem(0);

        Assertions.assertTrue(testDA.count == 0);
        Assertions.assertTrue(testDA.capacity == 16);
        Assertions.assertTrue(a == null);
    }

    @Test
    void removeWithoutOverloadFromTheBeginning() {
        DynArray testDA = new DynArray<Integer>(Integer.class);

        for (int i = 0; i < 16; i++) testDA.append(i);
        testDA.remove(0);

        Integer a = (Integer) testDA.getItem(0);
        Integer b = (Integer) testDA.getItem(15);

        Assertions.assertTrue(testDA.count == 15);
        Assertions.assertTrue(testDA.capacity == 16);
        Assertions.assertTrue(a == 1);
        Assertions.assertTrue(b == null);
    }

    @Test
    void removeWithoutOverloadFromTheEnd() {
        DynArray testDA = new DynArray<Integer>(Integer.class);

        for (int i = 0; i < 16; i++) testDA.append(i);
        testDA.remove(15);

        Integer a = (Integer) testDA.getItem(14);
        Integer b = (Integer) testDA.getItem(15);

        Assertions.assertTrue(testDA.count == 15);
        Assertions.assertTrue(testDA.capacity == 16);
        Assertions.assertTrue(a == 14);
        Assertions.assertTrue(b == null);
    }

    @Test
    void removeWithoutOverloadFromTheMiddle() {
        DynArray testDA = new DynArray<Integer>(Integer.class);

        for (int i = 0; i < 16; i++) testDA.append(i);
        testDA.remove(7);
        testDA.insert(7, 7);
        testDA.remove(7);

        Integer a = (Integer) testDA.getItem(7);
        Integer b = (Integer) testDA.getItem(15);

        Assertions.assertTrue(testDA.count == 15);
        Assertions.assertTrue(testDA.capacity == 16);
        Assertions.assertTrue(a == 8);
        Assertions.assertTrue(b == null);
    }

    @Test
    void removeWithOverloadFromTheBeginning() {
        DynArray testDA = new DynArray<Integer>(Integer.class);

        for (int i = 0; i < 17; i++) testDA.append(i);
        testDA.remove(0);
        testDA.remove(0);

        Integer a = (Integer) testDA.getItem(0);
        Integer b = (Integer) testDA.getItem(14);
        Integer c = (Integer) testDA.getItem(15);

        Assertions.assertTrue(testDA.count == 15);
        Assertions.assertTrue(testDA.capacity == 21);
        Assertions.assertTrue(a == 2);
        Assertions.assertTrue(b == 16);
        Assertions.assertTrue(c == null);
    }

    @Test
    void removeWithOverloadFromTheEnd() {
        DynArray testDA = new DynArray<Integer>(Integer.class);

        for (int i = 0; i < 17; i++) testDA.append(i);
        testDA.remove(16);
        testDA.remove(15);

        Integer a = (Integer) testDA.getItem(15);
        Integer b = (Integer) testDA.getItem(16);

        Assertions.assertTrue(testDA.count == 15);
        Assertions.assertTrue(testDA.capacity == 21);
        Assertions.assertTrue(a == null);
        Assertions.assertTrue(b == null);
    }

    @Test
    public void NullPointerRemoveBelowZero() {
        DynArray testDA = new DynArray<Integer>(Integer.class);

        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            testDA.remove(-1);
        });

        String expectedMessage = "Illegal index";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void removeAll() {
        DynArray testDA = new DynArray<Integer>(Integer.class);

        for (int i = 0; i < 16; i++) testDA.append(i);

        for (int i = 0; i < 16; i++) testDA.remove(0);

        Integer a = (Integer) testDA.getItem(0);
        Integer b = (Integer) testDA.getItem(15);

        Assertions.assertTrue(testDA.count == 0);
        Assertions.assertTrue(testDA.capacity == 16);
        Assertions.assertTrue(a == null);
        Assertions.assertTrue(b == null);
    }

}
