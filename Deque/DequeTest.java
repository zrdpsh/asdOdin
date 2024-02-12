package Deque;

import Queue.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    @Test
    void addFrontOne() {
        Deque<Integer> tDeque = new Deque<Integer>();

        tDeque.addFront(1900);

        Assertions.assertTrue(tDeque.size() == 1);
    }

    @Test
    void addFrontMany() {
        Deque<Integer> tDeque = new Deque<Integer>();

        Random rand = new Random();
        int ri = rand.nextInt(10000);

        for (int i = 0; i < ri; i++) tDeque.addFront(i);

        Assertions.assertTrue(tDeque.size() == ri);
        Assertions.assertTrue(tDeque.removeTail() == 0);
    }

    @Test
    void addTailOne() {
        Deque<Integer> tDeque = new Deque<Integer>();

        tDeque.addTail(1900);

        Assertions.assertTrue(tDeque.size() == 1);
    }

    @Test
    void addTailMany() {
        Deque<Integer> tDeque = new Deque<Integer>();

        Random rand = new Random();
        int ri = rand.nextInt(10000);

        for (int i = 0; i < ri; i++) tDeque.addTail(i);

        Assertions.assertTrue(tDeque.size() == ri);
        Assertions.assertTrue(tDeque.removeTail() == (ri-1));
    }

    @Test
    void removeFrontOne() {
        Deque<Integer> tDeque = new Deque<Integer>();

        tDeque.addTail(1900);

        Assertions.assertTrue(tDeque.removeFront() == 1900);
        Assertions.assertTrue(tDeque.size() == 0);
    }

    @Test
    void removeFrontMany() {
        Deque<Integer> tDeque = new Deque<Integer>();

        Random rand = new Random();
        int ri = rand.nextInt(10000);

        for (int i = 0; i < ri; i++) tDeque.addTail(i);

        tDeque.removeFront();
        tDeque.removeFront();

        Assertions.assertTrue(tDeque.removeFront() == 2);
        Assertions.assertTrue(tDeque.size() == (ri-3));
    }

    @Test
    void removeTailOne() {
        Deque<Integer> tDeque = new Deque<Integer>();

        tDeque.addFront(1900);

        Assertions.assertTrue(tDeque.removeTail() == 1900);
        Assertions.assertTrue(tDeque.size() == 0);
    }

    @Test
    void removeTailMany() {
        Deque<Integer> tDeque = new Deque<Integer>();

        Random rand = new Random();
        int ri = rand.nextInt(10000);

        for (int i = 0; i < ri; i++) tDeque.addFront(i);

        tDeque.removeTail();
        tDeque.removeTail();

        Assertions.assertTrue(tDeque.removeTail() == 2);
        Assertions.assertTrue(tDeque.size() == (ri-3));
    }

    @Test
    void size() {
        Queue<Integer> tQueue = new Queue<Integer>();

        Assertions.assertTrue(tQueue.size() == 0);
    }
}