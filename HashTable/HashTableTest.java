package HashTable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void hashFunZeroPos() {
        HashTable ht = new HashTable(97, 2);

        ht.put("a");

        int res = ht.find("a");

        Assertions.assertTrue(res == 0);
    }

    @Test
    void hashFunOneLesser() {
        HashTable ht = new HashTable(98, 2);

        ht.put("a");

        int res = ht.find("a");

        Assertions.assertTrue(res == 97);
    }

    @Test
    void hashFunOneGreater() {
        HashTable ht = new HashTable(96, 2);

        ht.put("a");

        int res = ht.find("a");

        Assertions.assertTrue(res == 1);
    }

    @Test
    void hashFunFullLongTable() {
        HashTable ht = new HashTable(97, 2);

        String tstStr = "a";

        for (int i = 0; i < 97; i++) {
            ht.put(tstStr);
            tstStr += (char) (i%2+'a');
        }

        int res = ht.find("a");
        int res2 = ht.put("c");

        Assertions.assertTrue(res == 0);
        Assertions.assertTrue(res2 == -1);
    }

    @Test
    void seekSlotEmpty() {
        HashTable ht = new HashTable(10, 2);
        int res2 = ht.find("b");

        Assertions.assertTrue(res2 == -1);
    }

    @Test
    void seekSlotPlusOneStep() {
        HashTable ht = new HashTable(10, 2);

        ht.put("d");
        ht.put("n");
        int res = ht.find("d");
        int res2 = ht.find("n");

        Assertions.assertTrue(res == 0);
        Assertions.assertTrue(res2 == 2);
    }


    @Test
    void seekSlotLastSlot() {
        HashTable ht = new HashTable(5, 2);

        ht.put("i");
        ht.put("j");
        ht.put("k");
        ht.put("l");
        ht.put("n");

        int res = ht.find("n");

        Assertions.assertTrue(res == 4);
    }

    @Test
    void putSlotFullTable() {
        HashTable ht = new HashTable(10, 2);

        ht.put("d");
        ht.put("e");
        ht.put("f");
        ht.put("g");
        ht.put("h");
        ht.put("i");
        ht.put("j");
        ht.put("k");
        ht.put("l");
        ht.put("m");
        ht.put("n");

        int res = ht.find("n");

        Assertions.assertTrue(res == -1);
    }

    @Test
    void putFullPrimeSize() {
        HashTable ht = new HashTable(17, 3);

        ht.put("d");
        ht.put("e");
        ht.put("f");
        ht.put("g");
        ht.put("h");
        ht.put("i");

        ht.put("j");
        ht.put("k");
        ht.put("l");
        ht.put("m");
        ht.put("n");
        ht.put("o");

        ht.put("p");
        ht.put("q");
        ht.put("r");
        ht.put("s");
        ht.put("t");

        int res = ht.find("f");
        int res2 = ht.find("d");

        int charPos = "f".charAt(0)%17;

        Assertions.assertTrue(res == charPos);
        Assertions.assertTrue(res2 == 15);
    }



    @Test
    void putSameString() {
        HashTable ht = new HashTable(5, 5);

        ht.put("d");

        int res = ht.put("d");
        int res2 = ht.find("d");

        Assertions.assertTrue(res == res2);
    }

    @Test
    void putStepEqualsSize() {
        HashTable ht = new HashTable(5, 5);

        ht.put("d");
        ht.put("i");

        int res = ht.find("d");
        int res2 = ht.find("i");

        Assertions.assertTrue(res == 0);
        Assertions.assertTrue(res2 == 1);
    }


    @Test
    void findAbsentValue() {
        HashTable ht = new HashTable(17, 3);

        ht.put("where ");
        ht.put("is ");
        ht.put("my ");

        int resTest = ht.find("mind? ");

        Assertions.assertEquals(-1, resTest);
    }

    @Test
    void findSimpleIndex() {
        HashTable ht = new HashTable(17, 3);

        ht.put("where ");
        ht.put("is ");
        ht.put("my ");
        int res = ht.put("mind? ");

        int resTest = ht.find("mind? ");
        int resTest2 = ht.find("mind?");

        Assertions.assertEquals(res, resTest);
        Assertions.assertNotEquals(res, resTest2);
    }
}