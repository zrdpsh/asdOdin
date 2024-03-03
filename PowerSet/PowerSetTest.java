package PowerSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerSetTest {

    @Test
    void sizeDefault() {
        PowerSet ps1 = new PowerSet();

        for (int i = 0; i < 10; i++) {
            ps1.put(String.valueOf(i));
        }


        Assertions.assertTrue(ps1.size() == 10);
    }

    @Test
    void putDefault() {
        PowerSet ps1 = new PowerSet();

        for (int i = 0; i < 2; i++) {
            ps1.put(String.valueOf(i));
        }

        String[] resString = ps1.getContents();
        String[] testString = {"1", "2", "3"};


        Assertions.assertTrue(ps1.size() == 3);
        Assertions.assertTrue(testString.equals(resString));
    }

    @Test
    void geDefault() {
        PowerSet ps1 = new PowerSet();

        for (int i = 0; i < 2; i++) {
            ps1.put(String.valueOf(i));
        }

        boolean res = ps1.get("0");


        Assertions.assertTrue(ps1.size() == 3);
        Assertions.assertTrue(res);
    }

    @Test
    void removeDefault() {
        PowerSet ps1 = new PowerSet();

        for (int i = 0; i < 2; i++) {
            ps1.put(String.valueOf(i));
        }

        Assertions.assertTrue(ps1.remove("0"));
        Assertions.assertFalse(ps1.get("0"));
        Assertions.assertTrue(ps1.size() == 2);
    }

    @Test
    void intersectionDefault() {
        PowerSet ps1 = new PowerSet();
        PowerSet ps2 = new PowerSet();

        for (int i = 0; i < 10; i++) {
            ps1.put(String.valueOf(i));
            ps2.put(String.valueOf(i));
        }

        PowerSet res = ps1.intersection(ps2);

        String[] testString = ps1.getContents();
        String[] testString2 = ps2.getContents();

        Assertions.assertTrue(res.size() == 10);
        Assertions.assertTrue(testString.equals(testString2));
    }

    @Test
    void unionDefault() {
        PowerSet ps1 = new PowerSet();
        PowerSet ps2 = new PowerSet();
        PowerSet ps3 = new PowerSet();

        for (int i = 0; i < 10; i++) {
            if (i%2 == 0) ps1.put(String.valueOf(i));
            if (!(i%2 == 0)) ps2.put(String.valueOf(i));
            ps3.put(String.valueOf(i));
        }

        PowerSet res = ps1.union(ps2);
        String[] resString = res.getContents();

        String[] testString = ps3.getContents();

        Assertions.assertTrue(res.size() == 10);
        Assertions.assertTrue(resString.equals(testString));
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
        Assertions.assertTrue(resString.equals(testString));
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