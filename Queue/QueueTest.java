package Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void enqueueNull() {
        Queue<Integer> tQueue = new Queue<Integer>();

        Assertions.assertTrue(tQueue.size() == 0);
    }

    @Test
    void enqueueOne() {
        Queue<Integer> tQueue = new Queue<Integer>();

        tQueue.enqueue(1900);

        Assertions.assertTrue(tQueue.size() == 1);
    }

    @Test
    void enqueueMany() {
        Queue<Integer> tQueue = new Queue<Integer>();

        Random rand = new Random();
        int ri = rand.nextInt(10000);

        for (int i = 0; i < ri; i++) tQueue.enqueue(i);

        Assertions.assertTrue(tQueue.size() == ri);
    }


    @Test
    void dequeueNull() {
        Queue<Integer> tQueue = new Queue<Integer>();

        Assertions.assertTrue(tQueue.dequeue() == null);
        Assertions.assertTrue(tQueue.size() == 0);
    }

    @Test
    void dequeueOne() {
        Queue<Integer> tQueue = new Queue<Integer>();

        tQueue.enqueue(1900);

        Assertions.assertTrue(tQueue.dequeue() == 1900);
        Assertions.assertTrue(tQueue.size() == 0);
    }

    @Test
    void dequeueMany() {
        Queue<Integer> tQueue = new Queue<Integer>();

        Random rand = new Random();
        int ri = rand.nextInt(10000);

        for (int i = 0; i < ri; i++) tQueue.enqueue(i);
        tQueue.dequeue();
        tQueue.dequeue();

        Assertions.assertTrue(tQueue.dequeue() == 2);
        Assertions.assertTrue(tQueue.size() == (ri-3));
    }


    @Test
    void cycleQueueOne() {
        Queue<Integer> tQueue = new Queue<Integer>();

        tQueue.enqueue(1900);

        tQueue.cycleQueue(1);

        Assertions.assertTrue(tQueue.dequeue() == 1900);
    }

    @Test
    void cycleQueueTwoItems() {
        Queue<Integer> tQueue = new Queue<Integer>();

        tQueue.enqueue(1900);
        tQueue.enqueue(2666);

        tQueue.cycleQueue(1);

        Assertions.assertTrue(tQueue.dequeue() == 2666);
    }

    @Test
    void cycleQueueCircle() {
        Queue<Integer> tQueue = new Queue<Integer>();

        for (int i = 1; i < 11; i++) tQueue.enqueue(i);

        tQueue.cycleQueue(11);

        Assertions.assertTrue(tQueue.dequeue() == 2);
    }



}