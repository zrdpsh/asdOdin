package OrderedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class OrderedListTest {

    @Test
    void compareNull() {
        OrderedList<Integer> ol = new OrderedList<Integer>(true);

        int res = ol.compare(1, null);

        Assertions.assertTrue(res == 0);
    }

    @Test
    void compareEqual() {
        OrderedList<Integer> ol = new OrderedList<Integer>(true);

        int res = ol.compare(1, 1);

        Assertions.assertTrue(res == 0);
    }

    @Test
    void compareGreater() {
        OrderedList<Integer> ol = new OrderedList<Integer>(true);

        int res = ol.compare(2, 1);

        Assertions.assertTrue(res == 1);
    }

    @Test
    void compareLower() {
        OrderedList<Integer> ol = new OrderedList<Integer>(true);

        int res = ol.compare(1, 2);

        Assertions.assertTrue(res == -1);
    }

    @Test
    void addToEmptyList() {
        OrderedList<Integer> ol = new OrderedList<Integer>(true);

        ol.add(3007);

        Assertions.assertTrue(ol.find(3007) != null);
        Assertions.assertTrue(ol.count() == 1);
    }

    @Test
    void addToHeadAsc() {
        OrderedList<Integer> ol = new OrderedList<Integer>(true);

        ol.add(100);
        ol.add(10);

        Node<Integer> a = ol.find(10);

        Assertions.assertTrue(a != null);
        Assertions.assertTrue(a.next.value == 100);
        Assertions.assertTrue(ol.count() == 2);
    }

    @Test
    void addToHeadDesc() {
        OrderedList<Integer> ol = new OrderedList<Integer>(false);

        ol.add(10);
        ol.add(100);


        Node<Integer> a = ol.find(100);

        Assertions.assertTrue(a != null);
        Assertions.assertTrue(a.next.value == 10);
        Assertions.assertTrue(ol.count() == 2);
    }

    @Test
    void addAsc() {
        OrderedList<Integer> ol = new OrderedList<Integer>(true);

        ol.add(1);
        ol.add(10);
        ol.add(100);
        ol.add(1000);

        Node<Integer> a = ol.find(1);
        Node<Integer> b = ol.find(10);
        Node<Integer> c = ol.find(100);
        Node<Integer> d = ol.find(1000);

        Assertions.assertTrue(a != null);
        Assertions.assertTrue(b != null);
        Assertions.assertTrue(c != null);
        Assertions.assertTrue(d != null);
        Assertions.assertTrue(a.next.value == 10);
        Assertions.assertTrue(b.next.value == 100);
        Assertions.assertTrue(c.next.value == 1000);
        Assertions.assertTrue(d.next == null);
        Assertions.assertTrue(ol.count() == 4);
    }

    @Test
    void addDesc() {
        OrderedList<Integer> ol = new OrderedList<Integer>(false);

        ol.add(1);
        ol.add(10);
        ol.add(100);
        ol.add(1000);

        Node<Integer> a = ol.find(1);
        Node<Integer> b = ol.find(10);
        Node<Integer> c = ol.find(100);
        Node<Integer> d = ol.find(1000);

        Assertions.assertTrue(a != null);
        Assertions.assertTrue(b != null);
        Assertions.assertTrue(c != null);
        Assertions.assertTrue(d != null);
        Assertions.assertTrue(d.next.value == 100);
        Assertions.assertTrue(c.next.value == 10);
        Assertions.assertTrue(b.next.value == 1);
        Assertions.assertTrue(a.next == null);
        Assertions.assertTrue(ol.count() == 4);
    }

    @Test
    void addInTailAsc() {
        OrderedList<Integer> ol = new OrderedList<Integer>(true);

        ol.add(10);
        ol.add(100);

        Node<Integer> a = ol.find(100);

        Assertions.assertTrue(a != null);
        Assertions.assertTrue(a.prev.value == 10);
        Assertions.assertTrue(ol.count() == 2);
    }

    @Test
    void addInTailDesc() {
        OrderedList<Integer> ol = new OrderedList<Integer>(false);

        ol.add(100);
        ol.add(10);


        Node<Integer> a = ol.find(10);

        Assertions.assertTrue(a != null);
        Assertions.assertTrue(a.prev.value == 100);
        Assertions.assertTrue(ol.count() == 2);
    }

    @Test
    void addBeforeTail() {
        OrderedList<Integer> ol = new OrderedList<Integer>(true);

        ol.add(10);
        ol.add(11);
        ol.add(101);
        ol.add(100);

        Node<Integer> a = ol.find(100);

        Assertions.assertTrue(a != null);
        Assertions.assertTrue(a.prev.value == 11);
        Assertions.assertTrue(ol.count() == 4);
    }

    @Test
    void addInMiddle() {
        OrderedList<Integer> ol = new OrderedList<Integer>(true);

        ol.add(10);
        ol.add(100);
        ol.add(11);

        Node<Integer> a = ol.find(11);

        Assertions.assertTrue(a != null);
        Assertions.assertTrue(a.prev.value == 10);
        Assertions.assertTrue(a.next.value == 100);
        Assertions.assertTrue(ol.count() == 3);
    }

    @Test
    void findInEmptyList() {
        OrderedList<Integer> ol = new OrderedList<Integer>(true);

        Node<Integer> a = ol.find(100);

        Assertions.assertTrue(a == null);
        Assertions.assertTrue(ol.count() == 0);
    }

    @Test
    void deleteFromEmptyList() {
        OrderedList<Integer> ol = new OrderedList<Integer>(true);

        ol.delete(3007);

        Assertions.assertTrue(ol.count() == 0);
        Assertions.assertTrue(ol.head == null);
        Assertions.assertTrue(ol.tail == null);
    }

    @Test
    void deleteOne() {
        OrderedList<Integer> ol = new OrderedList<Integer>(true);

        ol.add(3007);
        ol.delete(3007);

        Assertions.assertTrue(ol.count() == 0);
        Assertions.assertTrue(ol.head == null);
        Assertions.assertTrue(ol.tail == null);
    }

    @Test
    void deleteFromHead() {
        OrderedList<Integer> ol = new OrderedList<Integer>(true);

        ol.add(10);
        ol.add(11);
        ol.add(101);
        ol.add(100);

        ol.delete(10);

        Assertions.assertTrue(ol.count() == 3);
        Assertions.assertTrue(ol.head.value == 11);
    }

    @Test
    void deleteFromTail() {
        OrderedList<Integer> ol = new OrderedList<Integer>(true);

        ol.add(10);
        ol.add(11);
        ol.add(101);
        ol.add(100);

        ol.delete(101);

        Assertions.assertTrue(ol.count() == 3);
        Assertions.assertTrue(ol.tail.value == 100);
    }

    @Test
    void clear() {
        OrderedList<Integer> ol = new OrderedList<Integer>(true);

        ol.add(10);
        ol.add(100);
        ol.add(11);

        ol.clear(true);

        Assertions.assertTrue(ol.count() == 0);
    }

    @Test
    void countNull() {
        OrderedList<Integer> ol = new OrderedList<Integer>(true);

        Assertions.assertTrue(ol.count() == 0);
    }

    @Test
    void countRand() {
        OrderedList<Integer> ol = new OrderedList<Integer>(true);

        Random rand = new Random();
        int ri = rand.nextInt(10000);

        for (int i = 0; i < ri; i++) ol.add(i);

        Assertions.assertTrue(ol.count() == ri);
        Assertions.assertTrue(ol.head.value == 0);
        Assertions.assertTrue(ol.tail.value == (ri-1));
    }

//    @Test
//    void getAll() {
//        OrderedList<Integer> ol = new OrderedList<Integer>(true);
//
//        ol.add(10);
//        ol.add(100);
//        ol.add(11);
//
//        ArrayList<Node<Integer>> a = ol.getAll();
//
//        ArrayList<Node<Integer>> b = new ArrayList<Node<Integer>>();
//        b.add(new Node<>(10));
//        b.add(new Node<>(11));
//        b.add(new Node<>(110));
//
//
//        Assertions.assertTrue(ol.count() == 3);
//        Assertions.assertTrue(a.equals(b));
//    }
}