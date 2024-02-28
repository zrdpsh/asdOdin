package NativeDictionary;

import Hasndable.Hasndable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NativeDictionaryTest {

    @Test
    void hashFunZeroPos() {
        NativeDictionary nd = new NativeDictionary(97, 2);

        nd.put("a");

        int res = nd.find("a");

        Assertions.assertTrue(res == 0);
    }

    @Test
    void hashFunOneLesser() {
        NativeDictionary nd = new NativeDictionary(98, 2);

        nd.put("a");

        int res = nd.find("a");

        Assertions.assertTrue(res == 97);
    }

    @Test
    void hashFunOneGreater() {
        NativeDictionary nd = new NativeDictionary(96, 2);

        nd.put("a");

        int res = nd.find("a");

        Assertions.assertTrue(res == 1);
    }

    @Test
    void hashFunFullLongTable() {
        NativeDictionary nd = new NativeDictionary(97, 2);

        String tstStr = "a";

        for (int i = 0; i < 97; i++) {
            nd.put(tstStr);
            tstStr += (char) (i%2+'a');
        }

        int res = nd.find("a");
        int res2 = nd.put("c");

        Assertions.assertTrue(res == 0);
        Assertions.assertTrue(res2 == -1);
    }

    @Test
    void seekSlotEmpty() {
        NativeDictionary nd = new NativeDictionary(10, 2);
        int res2 = nd.find("b");

        Assertions.assertTrue(res2 == -1);
    }

    @Test
    void seekSlotPlusOneStep() {
        NativeDictionary nd = new NativeDictionary(10, 2);

        nd.put("d");
        nd.put("n");
        int res = nd.find("d");
        int res2 = nd.find("n");

        Assertions.assertTrue(res == 0);
        Assertions.assertTrue(res2 == 2);
    }


    @Test
    void seekSlotLastSlot() {
        NativeDictionary nd = new NativeDictionary(5, 2);

        nd.put("i");
        nd.put("j");
        nd.put("k");
        nd.put("l");
        nd.put("n");

        int res = nd.find("n");

        Assertions.assertTrue(res == 4);
    }

    @Test
    void putSlotFullTable() {
        NativeDictionary nd = new NativeDictionary(10, 2);

        nd.put("d");
        nd.put("e");
        nd.put("f");
        nd.put("g");
        nd.put("h");
        nd.put("i");
        nd.put("j");
        nd.put("k");
        nd.put("l");
        nd.put("m");
        nd.put("n");

        int res = nd.find("n");

        Assertions.assertTrue(res == -1);
    }

    @Test
    void putFullPrimeSize() {
        NativeDictionary nd = new NativeDictionary(17, 3);

        nd.put("d");
        nd.put("e");
        nd.put("f");
        nd.put("g");
        nd.put("h");
        nd.put("i");

        nd.put("j");
        nd.put("k");
        nd.put("l");
        nd.put("m");
        nd.put("n");
        nd.put("o");

        nd.put("p");
        nd.put("q");
        nd.put("r");
        nd.put("s");
        nd.put("t");

        int res = nd.find("f");
        int res2 = nd.find("d");

        int charPos = "f".charAt(0)%17;

        Assertions.assertTrue(res == charPos);
        Assertions.assertTrue(res2 == 15);
    }



    @Test
    void putSameString() {
        NativeDictionary nd = new NativeDictionary(5, 5);

        nd.put("d");

        int res = nd.put("d");
        int res2 = nd.find("d");

        Assertions.assertTrue(res == res2);
    }

    @Test
    void putStepEqualsSize() {
        NativeDictionary nd = new NativeDictionary(5, 5);

        nd.put("d");
        nd.put("i");

        int res = nd.find("d");
        int res2 = nd.find("i");

        Assertions.assertTrue(res == 0);
        Assertions.assertTrue(res2 == 1);
    }


    @Test
    void findAbsentValue() {
        NativeDictionary nd = new NativeDictionary(17, 3);

        nd.put("where ");
        nd.put("is ");
        nd.put("my ");

        int resTest = nd.find("mind? ");

        Assertions.assertEquals(-1, resTest);
    }

    @Test
    void findSimpleIndex() {
        NativeDictionary nd = new NativeDictionary(17, 3);

        nd.put("where ");
        nd.put("is ");
        nd.put("my ");
        int res = nd.put("mind? ");

        int resTest = nd.find("mind? ");
        int resTest2 = nd.find("mind?");

        Assertions.assertEquals(res, resTest);
        Assertions.assertNotEquals(res, resTest2);
    }
}