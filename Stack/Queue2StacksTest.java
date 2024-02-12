package Stack;

import Queue.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class Queue2StacksTest {

    @Test
    void enqueueNull() {
        Queue2Stacks<Integer> tQueue = new Queue2Stacks<Integer>();

        Assertions.assertTrue(tQueue.size() == 0);
    }

    @Test
    void enqueueOne() {
        Queue2Stacks<Integer> tQueue = new Queue2Stacks<Integer>();

        tQueue.enqueue(1900);

        Assertions.assertTrue(tQueue.size() == 1);
    }

    @Test
    void enqueueMany() {
        Queue2Stacks<Integer> tQueue = new Queue2Stacks<Integer>();

        Random rand = new Random();
        int ri = rand.nextInt(10000);

        for (int i = 0; i < ri; i++) tQueue.enqueue(i);

        Assertions.assertTrue(tQueue.size() == ri);
    }


    @Test
    void dequeueNull() {
        Queue2Stacks<Integer> tQueue = new Queue2Stacks<Integer>();

        Assertions.assertTrue(tQueue.dequeue() == null);
        Assertions.assertTrue(tQueue.size() == 0);
    }

    @Test
    void dequeueOne() {
        Queue2Stacks<Integer> tQueue = new Queue2Stacks<Integer>();

        tQueue.enqueue(1900);

        Assertions.assertTrue(tQueue.dequeue() == 1900);
        Assertions.assertTrue(tQueue.size() == 0);
    }

    @Test
    void dequeueMany() {
        Queue2Stacks<Integer> tQueue = new Queue2Stacks<Integer>();

        Random rand = new Random();

        int ri = rand.nextInt(10000);

        for (int i = 0; i < ri; i++) tQueue.enqueue(i);
        tQueue.dequeue();
        tQueue.dequeue();

        Assertions.assertTrue(tQueue.dequeue() == 2);
        Assertions.assertTrue(tQueue.size() == (ri-3));
    }
}