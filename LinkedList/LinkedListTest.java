package LinkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Random;


class LinkedListTest {
    int UPPERBOUND = 5;

    @Test
    void findAllMultiple() {
        LinkedList testList = generateListWithSameValue(3);
        ArrayList<Node> blueprintList = new ArrayList<>();
        for (int i = 0; i < UPPERBOUND; i++) {
            Node y = new Node(3);
            blueprintList.add(y);
        }

        ArrayList<Node> returnedNodes = testList.findAll(3);

        Assertions.assertTrue(blueprintList.size() == returnedNodes.size());
        for (int i = 0; i < returnedNodes.size(); i++) {
            Assertions.assertTrue(returnedNodes.get(i).value == blueprintList.get(i).value);
        }
    }

    @Test
    void findAllOne() {
        LinkedList testList = new LinkedList();
        Node x = new Node(1);
        testList.addInTail(x);

        ArrayList<Node> blueprintList = new ArrayList<>();
        Node y = new Node(1);
        blueprintList.add(y);

        ArrayList<Node> returnedNodes = testList.findAll(1);

        Assertions.assertTrue(blueprintList.size() == returnedNodes.size());
        Assertions.assertTrue(blueprintList.getFirst().value == returnedNodes.getFirst().value);


    }

    @Test
    void findAllNull() {
        LinkedList testList = new LinkedList();

        ArrayList<Node> returnedNodes = testList.findAll(1);

        Assertions.assertTrue(returnedNodes.size() == 0);
    }


    @Test
    void removeNull() {
        LinkedList testList = new LinkedList();

        boolean testResult = testList.remove(4);

        Assertions.assertFalse(testResult);
        Assertions.assertTrue(testList.count() == 0);
        Assertions.assertTrue(testList.head == null);
        Assertions.assertTrue(testList.tail == null);
    }

    @Test
    void removeOne() {
        LinkedList testList = new LinkedList();

        Node x = new Node(4);
        testList.addInTail(x);

        boolean testResult = testList.remove(4);

        Assertions.assertTrue(testResult);
        Assertions.assertTrue(testList.count() == 0);
    }

    @Test
    void removeFromLongList() {
        LinkedList testList = generateListWithSameValue(3);

        boolean testResult = testList.remove(3);

        Assertions.assertTrue(testResult);
        Assertions.assertTrue(testList.count() == (UPPERBOUND-1));
    }

    @Test
    void removeAllNull() {
        LinkedList testList = new LinkedList();

        testList.removeAll(4);

        Assertions.assertTrue(testList.count() == 0);
        Assertions.assertTrue(testList.head == null);
        Assertions.assertTrue(testList.tail == null);

    }

    @Test
    void removeAllOne() {
        LinkedList testList = new LinkedList();

        Node x = new Node(4);
        testList.addInTail(x);

        testList.removeAll(4);

        Assertions.assertTrue(testList.count() == 0);
        Assertions.assertTrue(testList.head == null);
        Assertions.assertTrue(testList.tail == null);

    }


    @Test
    void removeAllLongList() {
        LinkedList testList = generateListWithSameValue(4);

        testList.addInTail(new Node(5));
        testList.addInTail(new Node(5));

        testList.removeAll(5);

        int count = testList.count();
        Assertions.assertTrue( count == UPPERBOUND);
        Assertions.assertTrue(testList.head.value == 4);
        Assertions.assertTrue(testList.tail.value == 4);

    }

    @Test
    void clearMultiple() {
        LinkedList testList = generateMultipleElements(UPPERBOUND, 20);

        testList.clear();

        Assertions.assertTrue(testList.count() == 0);
        Assertions.assertTrue(testList.head == null);
        Assertions.assertTrue(testList.tail == null);

    }

    @Test
    void countNull() {
        LinkedList testList = new LinkedList();

        int testResult = testList.count();
        Assertions.assertTrue(testList.count() == 0);
        Assertions.assertTrue(testList.head == null);
        Assertions.assertTrue(testList.tail == null);
    }

    @Test
    void countOne() {
        LinkedList testList = new LinkedList();

        Node x = new Node(4);
        testList.addInTail(x);

        Assertions.assertTrue(testList.count() == 1);
        Assertions.assertTrue(testList.head.value == 4);
        Assertions.assertTrue(testList.tail.value == 4);
    }

    @Test
    void countMultiple() {
        LinkedList testList = generateListWithSameValue(3);

        Assertions.assertTrue(testList.count() == UPPERBOUND);
        Assertions.assertTrue(testList.head.value == 3);
        Assertions.assertTrue(testList.tail.value == 3);
    }

    @Test
    void insertAfterFirst() {
        LinkedList testList = generateListWithSameValue(3);

        Node testNode = new Node(5);

        testList.insertAfter(testList.head, testNode);
        testList.removeAll(3);

        Assertions.assertTrue(testList.count() == 1);
        Assertions.assertTrue(testList.find(5).value == 5);
    }

    @Test
    void insertAfterLast() {
        LinkedList testList = generateListWithSameValue(3);

        Node testNode = new Node(5);

        testList.insertAfter(testList.tail, testNode);
        testList.removeAll(3);

        Assertions.assertTrue(testList.count() == 1);
        Assertions.assertTrue(testList.find(5).value == 5);
    }

    void insertAfterSome() {
        LinkedList testList = new LinkedList();

        testList.addInTail(new Node(1));
        Node specificNodeInsideList = new Node(2);
        testList.addInTail(specificNodeInsideList);
        Node testNode = new Node(5);

        testList.insertAfter(specificNodeInsideList, testNode);
        testList.removeAll(1);
        testList.removeAll(2);

        Assertions.assertTrue(testList.count() == 1);
        Assertions.assertTrue(testList.find(5).value == 5);
    }


    public LinkedList generateMultipleElements(int maxValue, int listLength) {
        LinkedList res = new LinkedList();
        Random rand = new Random();

        for (int i = 0; i < listLength; i++) {
            Node y = new Node(i);
            res.addInTail(y);
        }

        return res;
    }

    public LinkedList generateListWithSameValue(int val) {
        LinkedList res = new LinkedList();

        for (int i = 0; i < UPPERBOUND; i++) {
            res.addInTail(new Node(val));
        }

        return res;
    }
}