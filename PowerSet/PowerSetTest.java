package PowerSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerSetTest {

    @Test
    void size() {
    }

    @Test
    void put() {
    }

    @Test
    void get() {
    }

    @Test
    void remove() {
    }

    @Test
    void intersection() {
    }

    @Test
    void union() {
    }

    @Test
    void differenceDefault() {
        PowerSet ps1 = new PowerSet();
        PowerSet ps2 = new PowerSet();
        PowerSet ps3 = new PowerSet();

        for (int i = 0; i < 10; i++) {
            if (i%2 == 0) ps1.put(String.valueOf(i));
            if (i%3 == 0) ps2.put(String.valueOf(i));
            if (i%2 == 0 ^ i%3 == 0) ps3.put(String.valueOf(i));
        }

        PowerSet res = ps1.difference(ps2);
        String[] resString = res.getContents();
        String[] testString = ps3.getContents();

        Assertions.assertTrue(res.size() == 9);
        Assertions.assertTrue(res.equals(testString);
    }

    @Test
    void differenceEmptyDifference() {
        PowerSet ps1 = new PowerSet();
        PowerSet ps2 = new PowerSet();

        for (int i = 0; i < 10; i++) {
            ps1.put(String.valueOf(i));
            ps2.put(String.valueOf(i));
        }

        PowerSet res = ps1.difference(ps2);

        Assertions.assertTrue(res.size() == 0);
    }

    @Test
    void isSubsetNull() {
        PowerSet ps1 = new PowerSet();
        PowerSet ps2 = new PowerSet();

        Assertions.assertTrue(ps1.isSubset(ps2));
    }

    @Test
    void isSubsetDefault() {
        PowerSet ps1 = new PowerSet();
        PowerSet ps2 = new PowerSet();

        for (int i = 0; i < 10; i++) {
            ps1.put(String.valueOf(i));
            ps2.put(String.valueOf(i));
        }

        Assertions.assertTrue(ps1.isSubset(ps2));
    }


    @Test
    void speedTest() {
        PowerSet ps1 = new PowerSet();
        PowerSet ps2 = new PowerSet();

        for (int i = 0; i < 20000; i++) {
            ps1.put(String.valueOf(i));
            ps2.put(String.valueOf(i));
        }

        Assertions.assertTrue(ps1.isSubset(ps2));
    }


}