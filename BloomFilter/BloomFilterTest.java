package BloomFilter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BloomFilterTest {

    @Test
    void hash1Default() {
        BloomFilter bf = new BloomFilter(32);

        int res = bf.hash1("0123456789");
        int res2 = bf.hash1("1234567890");

        Assertions.assertTrue(res == 13);
        Assertions.assertTrue(res2 == 29);
    }

    @Test
    void hash2Default() {
        BloomFilter bf = new BloomFilter(32);

        int res = bf.hash2("0123456789");
        String resB = Integer.toBinaryString(13);
        int res2 = bf.hash2("1234567890");

        Assertions.assertTrue(res == 5);
        Assertions.assertTrue(res2 == 27);
    }

    @Test
    void addDefault() {
        BloomFilter bf = new BloomFilter(32);

        bf.add("0123456789");

        Assertions.assertTrue(bf.isValue("0123456789"));
        Assertions.assertFalse(bf.isValue("1234567890"));
    }

    @Test
    void isValueDefault() {
        BloomFilter bf = new BloomFilter(32);
        bf.binaryString = 0x0_000_000d;

        Assertions.assertTrue(bf.isValue("0123456789"));
    }

    @Test
    void isValueTestRow() {
        BloomFilter bf = new BloomFilter(32);
        String[] testRow = {"0123456789", "1234567890", "2345678901",
                "3456789012", "4567890123", "5678901234", "6789012345",
                "7890123456", "8901234567", "9012345678"};

        for (int i = 0; i < testRow.length; i++) {
            bf.add(testRow[i]);
        }

        for (int i = 0; i < testRow.length; i++) {
            Assertions.assertTrue(bf.isValue("0123456789"));
        }
    }
}