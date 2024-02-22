package HashTable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void hashFunZero() {
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
    void seekSlot() {
    }

    @Test
    void put() {
    }

    @Test
    void find() {
    }
}