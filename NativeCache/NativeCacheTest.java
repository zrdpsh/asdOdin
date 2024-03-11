package NativeCache;

import HashTable.HashTable;
import PowerSet.PowerSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NativeCacheTest {

    @Test
    void hashFunZeroPos() {
        NativeCache nC = new NativeCache(97, String.class);

        nC.put("a", "Kevin Spacey");

        int res = nC.find("a");

        Assertions.assertTrue(res == 0);
    }

    @Test
    void hashFunOneLesser() {
        NativeCache nC = new NativeCache(98, String.class);

        nC.put("a", "Kevin Spacey");

        int res = nC.find("a");

        Assertions.assertTrue(res == 97);
    }

    @Test
    void hashFunOneGreater() {
        NativeCache nC = new NativeCache(96, String.class);

        nC.put("a", "Kevin Spacey");

        int res = nC.find("a");

        Assertions.assertTrue(res == 1);
    }

    @Test
    void hashFunFullLongTable() {
        NativeCache nC = new NativeCache(97, String.class);

        String tstStr = "a";
        int tstKey = 97;

        for (int i = 0; i < 97; i++) {
            nC.put(String.valueOf((char) tstKey), tstStr);
            tstStr += (char) (i%2+'a');
            tstKey += 1;
        }

        int res = nC.find("a");

        assertTrue(res == 0);
        assertTrue(nC.find("<c>") == -1);
    }


    @Test
    void seekSlotEmpty() {
        NativeCache nC = new NativeCache(10, String.class);
        int res2 = nC.find("b");

        Assertions.assertTrue(res2 == -1);
    }

    @Test
    void seekSlotPlusOneStep() {
        NativeCache nC = new NativeCache(10, String.class);

        nC.put("d", "0");
        nC.put("n", "01");
        int res = nC.find("d");
        int res2 = nC.find("n");

        Assertions.assertTrue(res == 0);
        Assertions.assertTrue(res2 == 2);
    }

    @Test
    void seekSlotLastSlot() {
        NativeCache nC = new NativeCache(5, String.class);

        nC.put("i", "i");
        nC.put("j", "j");
        nC.put("k", "k");
        nC.put("l", "l");
        nC.put("n", "n");

        int res = nC.find("n");

        Assertions.assertTrue(res == 4);
    }

    @Test
    void putSlotFullTable() {
        NativeCache nC = new NativeCache(10, String.class);

        nC.put("d", "d");
        nC.put("e", "e");
        nC.put("f", "f");
        nC.put("g", "g");
        nC.put("h", "h");
        nC.put("i", "i");
        nC.put("j", "j");
        nC.put("k", "k");
        nC.put("l", "l");
        nC.put("m", "m");
        nC.put("n", "n");

        int res = nC.find("d");

        Assertions.assertTrue(res == -1);
    }

    @Test
    void putFullPrimeSize() {
        NativeCache nC = new NativeCache(17, String.class);

        nC.put("d", "d");
        nC.put("e", "e");
        nC.put("f", "f");
        nC.put("g", "g");
        nC.put("h", "h");
        nC.put("i", "i");

        nC.put("j", "j");
        nC.put("k", "k");
        nC.put("l", "l");
        nC.put("m", "m");
        nC.put("n", "n");
        nC.put("o", "o");

        nC.put("p", "p");
        nC.put("q", "q");
        nC.put("r", "r");
        nC.put("s", "s");
        nC.put("t", "t");

        int res = nC.find("f");
        int res2 = nC.find("d");

        int charPos = "f".charAt(0)%17;

        Assertions.assertTrue(res == charPos);
        Assertions.assertTrue(res2 == 15);
    }

    @Test
    void putSameString() {
        NativeCache nC = new NativeCache(5, String.class);

        nC.put("d", "d");
        int res = nC.find("d");

        nC.put("d", "d");
        int res2 = nC.find("d");

        Assertions.assertTrue(res == res2);
    }

    @Test
    void putStepEqualsSize() {
        NativeCache nC = new NativeCache(2, String.class);

        nC.put("d", "d");
        nC.put("i", "i");

        int res = nC.find("d");
        int res2 = nC.find("i");

        Assertions.assertTrue(res == 0);
        Assertions.assertTrue(res2 == 1);
    }

    @Test
    void findAbsentValue() {
        NativeCache nC = new NativeCache(17, String.class);

        nC.put("where ", "where ");
        nC.put("is ", "is ");
        nC.put("my ", "my ");

        int resTest = nC.find("mind? ");

        Assertions.assertEquals(-1, resTest);
    }

    @Test
    void findSimpleIndex() {
        NativeCache nC = new NativeCache(17, String.class);

        nC.put("where ", "where ");
        nC.put("is ", "is ");
        nC.put("my ", "my ");
        nC.put("mind? ", "mind? ");

        int resTest = nC.find("mind? ");
        int resTest2 = nC.find("mind?");

        Assertions.assertEquals(9, resTest);
        Assertions.assertEquals(-1, resTest2);
    }

    @Test
    void isKeyEmpty() {
        NativeCache nC = new NativeCache(97, String.class);

        boolean res = nC.isKey("a");

        Assertions.assertFalse(res);
    }

    @Test
    void isKeyAbsent() {
        NativeCache nC = new NativeCache(97, String.class);

        nC.put("a", "Kevin Spacey");
        boolean res = nC.isKey("b");

        Assertions.assertFalse(res);
    }

    @Test
    void isKeyActual() {
        NativeCache nC = new NativeCache(97, String.class);

        nC.put("a", "Kevin Spacey");
        boolean res = nC.isKey("a");

        Assertions.assertTrue(res);
    }

    @Test
    void findEmpty() {
        NativeCache nC = new NativeCache(97, String.class);

        int res = nC.find("a");

        Assertions.assertTrue(res == -1);
    }

    @Test
    void findNothing() {
        NativeCache nC = new NativeCache(97, String.class);

        nC.put("a", "Kevin Spacey");
        int res = nC.find("b");

        Assertions.assertTrue(res == -1);
    }

    @Test
    void findSomething() {
        NativeCache nC = new NativeCache(97, String.class);

        nC.put("a", "Kevin Spacey");
        int res = nC.find("a");

        Assertions.assertTrue(res == 0);
    }

    @Test
    void getAbsentValue() {
        NativeCache nC = new NativeCache(10, String.class);

        nC.put("a", "17");

        String res = (String) nC.get("b");

        Assertions.assertTrue(res==null);
    }

    @Test
    void getActualValue() {
        NativeCache nC = new NativeCache(10, String.class);

        nC.put("a", "17");

        String res = (String) nC.get("a");

        Assertions.assertEquals(res, "17");
    }

    @Test
    void putNewKey() {
        NativeCache nC = new NativeCache(10, String.class);

        nC.put("a", "17");

        int res = nC.find("a");
        String res2 = (String) nC.get("a");

        Assertions.assertTrue(res == 7);
        Assertions.assertEquals(res2, "17");
    }

    @Test
    void putExistingKey() {
        NativeCache nC = new NativeCache(10, String.class);

        nC.put("a", "17");
        nC.put("a", "18");

        int res = nC.find("a");
        String res2 = (String) nC.get("a");

        Assertions.assertTrue(res == 7);
        Assertions.assertEquals(res2, "18");
    }


    @Test
    void speedTest() {
        NativeCache nC = new NativeCache(5000, String.class);

        for (int i = 0; i < 50000; i++) {
            nC.put(String.valueOf(i), String.valueOf(i));
        }

    }

    @Test
    void speedTestWithGet() {
        NativeCache nC = new NativeCache(5000, String.class);

        for (int i = 0; i < 50000; i++) {
            nC.put(String.valueOf(i), String.valueOf(i));
        }

        for (int i = 0; i < 50000; i++) {
            String m = (String) nC.get(String.valueOf(i));
        }

    }

    @Test
    void speedTestWithIsKey() {
        NativeCache nC = new NativeCache(5000, String.class);

        for (int i = 0; i < 50000; i++) {
            nC.put(String.valueOf(i), String.valueOf(i));
        }

        boolean m = true;

        for (int i = 0; i < 50000; i++) {
            m = nC.isKey(String.valueOf(i));
        }

    }

}