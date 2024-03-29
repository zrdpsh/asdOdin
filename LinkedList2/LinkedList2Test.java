package LinkedList2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;



class LinkedList2Test {

    @Test
    void findNull() {
        LinkedList2 testList = new LinkedList2();

        Node res = testList.find(5);
        Assertions.assertTrue(testList.count() == 0);
        Assertions.assertTrue(res == null);
        Assertions.assertTrue(testList.head == null);
        Assertions.assertTrue(testList.tail == null);
    }

    @Test
    void findOne() {
        LinkedList2 testList = new LinkedList2();

        testList.addInTail(new Node(7));

        Node res = testList.find(7);
        Assertions.assertTrue(testList.count() == 1);
        Assertions.assertTrue(res.value == 7);
        Assertions.assertTrue(testList.head.value == 7);
        Assertions.assertTrue(testList.tail.value == 7);
    }

    @Test
    void findMany() {
        LinkedList2 testList = new LinkedList2();

        for (int i = 0; i < 100; i++) {
            testList.addInTail(new Node(7));
        }

        testList.addInTail(new Node(1991));

        Node res = testList.find(1991);
        Assertions.assertTrue(testList.count() == 101);
        Assertions.assertTrue(res.value == 1991);
        Assertions.assertTrue(testList.head.value == 7);
        Assertions.assertTrue(testList.tail.value == 1991);
    }

    @Test
    void findAllNull() {
        LinkedList2 testList = new LinkedList2();

        ArrayList<Node> res = testList.findAll(5);

        Assertions.assertTrue(res.size() == 0);
        Assertions.assertTrue(testList.head == null);
        Assertions.assertTrue(testList.tail == null);
    }

    @Test
    void findAllOne() {
        LinkedList2 testList = new LinkedList2();

        testList.addInTail(new Node(7));

        ArrayList<Node> res = testList.findAll(7);

        Assertions.assertTrue(res.size() == 1);
        Assertions.assertTrue(res.get(0).value == 7);
        Assertions.assertTrue(testList.head.value == 7);
        Assertions.assertTrue(testList.tail.value == 7);
    }

    @Test
    void findAllMany() {
        LinkedList2 testList = new LinkedList2();

        testList.addInTail(new Node(1991));
        testList.addInTail(new Node(7));
        testList.addInTail(new Node(1991));

        ArrayList<Node> res = testList.findAll(1991);

        Assertions.assertTrue(res.size() == 2);
        Assertions.assertTrue(res.get(0).value == 1991);
        Assertions.assertTrue(res.get(1).value == 1991);
        Assertions.assertTrue(testList.head.value == 1991);
        Assertions.assertTrue(testList.tail.value == 1991);
    }

    @Test
    void removeNull() {
        LinkedList2 testList = new LinkedList2();

        boolean res = testList.remove(5);

        Assertions.assertTrue(testList.count() == 0);
        Assertions.assertTrue(res == false);
        Assertions.assertTrue(testList.head == null);
        Assertions.assertTrue(testList.tail == null);
    }


    @Test
    void removeOneFromOne() {
        LinkedList2 testList = new LinkedList2();

        testList.addInTail(new Node(7));

        boolean res = testList.remove(7);

        Assertions.assertTrue(testList.count() == 0);
        Assertions.assertTrue(res == true);

        Assertions.assertTrue(testList.head == null);

        Assertions.assertTrue(testList.tail == null);
    }

    @Test
    void removeOneFromMany() {
        LinkedList2 testList = new LinkedList2();

        testList.addInTail(new Node(7));
        testList.addInTail(new Node(5));
        testList.addInTail(new Node(2007));

        boolean res = testList.remove(7);

        Assertions.assertTrue(testList.count() == 2);
        Assertions.assertTrue(res == true);

        Assertions.assertTrue(testList.head.value == 5);
        Assertions.assertTrue(testList.head.prev == null);

        Assertions.assertTrue(testList.tail.value == 2007);
        Assertions.assertTrue(testList.tail.next == null);
    }

    @Test
    void removeOneInTheMiddle() {
        LinkedList2 testList = new LinkedList2();

        testList.addInTail(new Node(7));
        testList.addInTail(new Node(5));
        testList.addInTail(new Node(2007));

        boolean res = testList.remove(5);

        Assertions.assertTrue(testList.count() == 2);
        Assertions.assertTrue(res == true);

        Assertions.assertTrue(testList.head.value == 7);
        Assertions.assertTrue(testList.head.prev == null);

        Assertions.assertTrue(testList.tail.value == 2007);
    }

    @Test
    void removeMany() {
        LinkedList2 testList = new LinkedList2();
        testList.addInTail(new Node(7));
        testList.addInTail(new Node(8));
        testList.addInTail(new Node(1995));

        boolean res = testList.remove(8);

        Assertions.assertTrue(testList.count() == 2);

        Assertions.assertTrue(testList.head.value == 7);
        Assertions.assertTrue(testList.head.prev == null);

        Assertions.assertTrue(testList.tail.value == 1995);
    }

    @Test
    void removeAllNull() {
        LinkedList2 testList = new LinkedList2();

        testList.removeAll(5);

        Assertions.assertTrue(testList.count() == 0);
        Assertions.assertTrue(testList.head == null);
        Assertions.assertTrue(testList.tail == null);
    }

    @Test
    void removeAllFirst() {
        LinkedList2 testList = new LinkedList2();


        testList.addInTail(new Node(5));
        testList.addInTail(new Node(7));
        testList.addInTail(new Node(9));

        testList.removeAll(5);

        Assertions.assertTrue(testList.count() == 2);

        Assertions.assertTrue(testList.head.value == 7);
        Assertions.assertTrue(testList.head.prev == null);

        Assertions.assertTrue(testList.tail.value == 9);
        Assertions.assertTrue(testList.tail.next == null);
    }

    @Test
    void removeAllOneInMiddle() {
        LinkedList2 testList = new LinkedList2();


        testList.addInTail(new Node(5));
        testList.addInTail(new Node(6));
        testList.addInTail(new Node(7));
        testList.addInTail(new Node(9));

        testList.removeAll(7);

        Assertions.assertTrue(testList.count() == 3);

        Assertions.assertTrue(testList.head.value == 5);
        Assertions.assertTrue(testList.head.prev == null);

        Assertions.assertTrue(testList.tail.value == 9);
        Assertions.assertTrue(testList.tail.next == null);
    }

    @Test
    void removeAllTwo() {
        LinkedList2 testList = new LinkedList2();


        testList.addInTail(new Node(5));
        testList.addInTail(new Node(7));
        testList.addInTail(new Node(5));

        testList.removeAll(5);

        Assertions.assertTrue(testList.count() == 1);

        Assertions.assertTrue(testList.head.value == 7);
        Assertions.assertTrue(testList.head.prev == null);

        Assertions.assertTrue(testList.tail.value == 7);
        Assertions.assertTrue(testList.tail.next == null);
    }

    @Test
    void removeAllMany() {
        LinkedList2 testList = new LinkedList2();

        testList.addInTail(new Node(1995));
        testList.addInTail(new Node(7));
        testList.addInTail(new Node(1995));
        testList.addInTail(new Node(8));
        testList.addInTail(new Node(1995));

        testList.removeAll(1995);

        Assertions.assertTrue(testList.count() == 2);

        Assertions.assertTrue(testList.head.value == 7);
        Assertions.assertTrue(testList.head.prev == null);

        Assertions.assertTrue(testList.tail.value == 8);
        Assertions.assertTrue(testList.tail.next == null);
    }

    @Test
    void removeAllFromTheMiddle() {
        LinkedList2 testList = new LinkedList2();

        testList.addInTail(new Node(7));
        testList.addInTail(new Node(1995));
        testList.addInTail(new Node(8));
        testList.addInTail(new Node(1995));
        testList.addInTail(new Node(9));

        testList.removeAll(1995);

        Assertions.assertTrue(testList.count() == 3);

        Assertions.assertTrue(testList.head.value == 7);
        Assertions.assertTrue(testList.head.prev == null);

        Assertions.assertTrue(testList.tail.value == 9);
        Assertions.assertTrue(testList.tail.next == null);
    }

    @Test
    void clear() {
        LinkedList2 testList = new LinkedList2();

        for (int i = 0; i < 100; i++) {
            testList.addInTail(new Node(7));
        }

        testList.clear();
        Assertions.assertTrue(testList.count() == 0);
        Assertions.assertTrue(testList.head == null);
        Assertions.assertTrue(testList.tail == null);
    }

    @Test
    void countNull() {
        LinkedList2 testList = new LinkedList2();

        Assertions.assertTrue(testList.count() == 0);
        Assertions.assertTrue(testList.head == null);
        Assertions.assertTrue(testList.tail == null);
    }

    @Test
    void countOne() {
        LinkedList2 testList = new LinkedList2();
        Node x = new Node(4);
        testList.addInTail(x);

        Assertions.assertTrue(testList.count() == 1);
        Assertions.assertTrue(testList.head.value == 4);
        Assertions.assertTrue(testList.tail.value == 4);
    }

    @Test
    void countMany() {
        LinkedList2 testList = new LinkedList2();
        testList.addInTail(new Node(7));
        testList.addInTail(new Node(8));
        testList.addInTail(new Node(1995));

        Assertions.assertTrue(testList.count() == 3);
        Assertions.assertTrue(testList.head.value == 7);
        Assertions.assertTrue(testList.tail.value == 1995);
    }


    @Test
    void insertAfterSingleElement() {
        LinkedList2 testListInsert = new LinkedList2();

        testListInsert.insertAfter(null, new Node(2007));

        Assertions.assertTrue(testListInsert.count() == 1);
        Assertions.assertTrue(testListInsert.head.value == 2007);
        Assertions.assertTrue(testListInsert.head.prev == null);
        Assertions.assertTrue(testListInsert.tail.value == 2007);
        Assertions.assertTrue(testListInsert.tail.next == null);
    }

    @Test
    void insertAfterNull() {
        LinkedList2 testListInsert = new LinkedList2();
        testListInsert.addInTail(new Node(3007));

        testListInsert.insertAfter(null, new Node(2007));

        Assertions.assertTrue(testListInsert.count() == 2);
        Assertions.assertTrue(testListInsert.head.value == 2007);
        Assertions.assertTrue(testListInsert.head.prev == null);
        Assertions.assertTrue(testListInsert.tail.value == 3007);
        Assertions.assertTrue(testListInsert.tail.next == null);
    }

    @Test
    void insertAfterMiddle() {
        LinkedList2 testListInsert = new LinkedList2();
        testListInsert.addInTail(new Node(2007));
        testListInsert.addInTail(new Node(3007));

        testListInsert.insertAfter(testListInsert.head, new Node(2507));

        Assertions.assertTrue(testListInsert.count() == 3);
        Assertions.assertTrue(testListInsert.head.value == 2007);
        Assertions.assertTrue(testListInsert.head.next.value == 2507);
        Assertions.assertTrue(testListInsert.head.prev == null);
        Assertions.assertTrue(testListInsert.tail.value == 3007);
        Assertions.assertTrue(testListInsert.tail.prev.value == 2507);
        Assertions.assertTrue(testListInsert.tail.next == null);
    }

    @Test
    void insertAfterLast() {
        LinkedList2 testListInsert = new LinkedList2();
        testListInsert.addInTail(new Node(2007));
        testListInsert.addInTail(new Node(3007));

        testListInsert.insertAfter(testListInsert.tail, new Node(5007));

        Assertions.assertTrue(testListInsert.count() == 3);
        Assertions.assertTrue(testListInsert.head.value == 2007);
        Assertions.assertTrue(testListInsert.head.next.value == 3007);
        Assertions.assertTrue(testListInsert.head.prev == null);
        Assertions.assertTrue(testListInsert.tail.value == 5007);
        Assertions.assertTrue(testListInsert.tail.prev.value == 3007);
        Assertions.assertTrue(testListInsert.tail.next == null);
    }
}