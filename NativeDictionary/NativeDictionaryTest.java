package NativeDictionary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NativeDictionaryTest {

    @Test
    void putNewKey() {
        NativeDictionary nd = new NativeDictionary(10, String.class);

        nd.put("a", "17");

        int res = nd.find("a");
        String res2 = (String) nd.get("a");

        Assertions.assertTrue(res == 7);
        Assertions.assertEquals(res2, "17");
    }

    @Test
    void putExistingKey() {
        NativeDictionary nd = new NativeDictionary(10, String.class);

        nd.put("a", "17");
        nd.put("a", "18");

        int res = nd.find("a");
        String res2 = (String) nd.get("a");

        Assertions.assertTrue(res == 7);
        Assertions.assertEquals(res2, "18");
    }

    @Test
    void areThereKeyTrue() {
        NativeDictionary nd = new NativeDictionary(10, String.class);

        nd.put("a", "17");

        Boolean res = nd.isKey("a");

        Assertions.assertTrue(res);
    }

    @Test
    void areThereKeyFalse() {
        NativeDictionary nd = new NativeDictionary(10, String.class);

        nd.put("a", "17");

        Boolean res = nd.isKey("b");

        Assertions.assertFalse(res);
    }

    @Test
    void getPresentValue() {
        NativeDictionary nd = new NativeDictionary(10, String.class);

        nd.put("a", "17");

        String res = (String) nd.get("a");

        Assertions.assertEquals(res, "17");
    }

    @Test
    void getAbsentValue() {
        NativeDictionary nd = new NativeDictionary(10, String.class);

        nd.put("a", "17");

        int res = nd.find("b");

        Assertions.assertTrue(res == -1);
    }
}