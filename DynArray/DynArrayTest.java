package DynArray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynArrayTest {

    @Test
    void makeArray() {
    }

    @Test
    void getItemGetFirst() {
        DynArray testDA = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 10; i++) testDA.append(i);

        Integer a = (Integer) testDA.getItem(0);
        Assertions.assertTrue(testDA.count == 9);
        Assertions.assertTrue(testDA.capacity == 16);
        Assertions.assertTrue(a == 0);

    }

    @Test
    void append() {
    }

    @Test
    void insert() {
    }

    @Test
    void remove() {
    }
}