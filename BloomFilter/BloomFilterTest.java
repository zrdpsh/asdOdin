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
        int res2 = bf.hash2("1234567890");

        Assertions.assertTrue(res == 5);
        Assertions.assertTrue(res2 == 27);
    }

    @Test
    void add() {
    }

    @Test
    void isValue() {
    }
}