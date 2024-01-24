package LinkedList4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class LinkedList4Test {

    @Test
    void findNull() {
        LinkedList4 testList = new LinkedList4();

        Node res = testList.find(5);
        Assertions.assertTrue(testList.count() == 0);
        Assertions.assertTrue(res == null);
        Assertions.assertTrue(testList.dummy().next == testList.dummy());
    }

    @Test
    void findOne() {
        LinkedList4 testList = new LinkedList4();

        testList.addInTail(new Node(7));

        Node res = testList.find(7);
        Assertions.assertTrue(testList.count() == 1);
        Assertions.assertTrue(res.value == 7);
        Assertions.assertTrue(testList.dummy().next.value == 7);
        Assertions.assertTrue(testList.dummy().prev.value == 7);
    }

    @Test
    void findMany() {
        LinkedList4 testList = new LinkedList4();

        for (int i = 0; i < 100; i++) {
            testList.addInTail(new Node(7));
        }

        testList.addInTail(new Node(1991));

        Node res = testList.find(1991);
        Assertions.assertTrue(testList.count() == 101);
        Assertions.assertTrue(res.value == 1991);
        Assertions.assertTrue(testList.dummy().next.value == 7);
        Assertions.assertTrue(testList.dummy().prev.value == 1991);
    }

    @Test
    void findAllNull() {
        LinkedList4 testList = new LinkedList4();

        ArrayList<Node> res = testList.findAll(5);

        Assertions.assertTrue(res.size() == 0);
        Assertions.assertTrue(testList.dummy().next == testList.dummy());
    }

    @Test
    void findAllOne() {
        LinkedList4 testList = new LinkedList4();

        testList.addInTail(new Node(7));

        ArrayList<Node> res = testList.findAll(7);

        Assertions.assertTrue(res.size() == 1);
        Assertions.assertTrue(res.get(0).value == 7);
        Assertions.assertTrue(testList.dummy().next.value == 7);
        Assertions.assertTrue(testList.dummy().prev.value == 7);
    }

    @Test
    void findAllMany() {
        LinkedList4 testList = new LinkedList4();

        testList.addInTail(new Node(1991));
        testList.addInTail(new Node(7));
        testList.addInTail(new Node(1991));

        ArrayList<Node> res = testList.findAll(1991);

        Assertions.assertTrue(res.size() == 2);
        Assertions.assertTrue(res.get(0).value == 1991);
        Assertions.assertTrue(res.get(1).value == 1991);
//        Assertions.assertTrue(testList.head.value == 1991);
//        Assertions.assertTrue(testList.tail.value == 1991);
    }

    @Test
    void removeNull() {
        LinkedList4 testList = new LinkedList4();

        boolean res = testList.remove(5);

        Assertions.assertTrue(testList.count() == 0);
        Assertions.assertTrue(res == false);
        Assertions.assertTrue(testList.dummy().next == testList.dummy());
    }


    @Test
    void removeOneFromOne() {
        LinkedList4 testList = new LinkedList4();

        testList.addInTail(new Node(7));

        boolean res = testList.remove(7);

        Assertions.assertTrue(testList.count() == 0);
        Assertions.assertTrue(res == true);

        Assertions.assertTrue(testList.dummy().next == testList.dummy());
    }

    @Test
    void removeOneFromMany() {
        LinkedList4 testList = new LinkedList4();

        testList.addInTail(new Node(7));
        testList.addInTail(new Node(5));
        testList.addInTail(new Node(2007));

        boolean res = testList.remove(7);

        Assertions.assertTrue(testList.count() == 2);
        Assertions.assertTrue(res == true);

        Assertions.assertTrue(testList.dummy().next.value == 5);
        Assertions.assertTrue(testList.dummy().next.prev == testList.dummy());

        Assertions.assertTrue(testList.dummy().prev.value  == 2007);
        Assertions.assertTrue(testList.dummy().prev.next == testList.dummy());
    }

    @Test
    void removeOneInTheMiddle() {
        LinkedList4 testList = new LinkedList4();

        testList.addInTail(new Node(7));
        testList.addInTail(new Node(5));
        testList.addInTail(new Node(2007));

        boolean res = testList.remove(5);

        Assertions.assertTrue(testList.count() == 2);
        Assertions.assertTrue(res == true);

        Assertions.assertTrue(testList.dummy().next.value == 7);
        Assertions.assertTrue(testList.dummy().next.prev == testList.dummy());

        Assertions.assertTrue(testList.dummy().prev.value == 2007);
        Assertions.assertTrue(testList.dummy().prev.next == testList.dummy());
    }

    @Test
    void removeMany() {
        LinkedList4 testList = new LinkedList4();
        testList.addInTail(new Node(7));
        testList.addInTail(new Node(8));
        testList.addInTail(new Node(1995));

        boolean res = testList.remove(8);

        Assertions.assertTrue(testList.count() == 2);

        Assertions.assertTrue(testList.dummy().next.value == 7);
        Assertions.assertTrue(testList.dummy().next.prev == testList.dummy());

        Assertions.assertTrue(testList.dummy().prev.value == 1995);
        Assertions.assertTrue(testList.dummy().prev.next == testList.dummy());
    }

    @Test
    void removeAllNull() {
        LinkedList4 testList = new LinkedList4();

        testList.removeAll(5);

        Assertions.assertTrue(testList.count() == 0);
        Assertions.assertTrue(testList.dummy().next == testList.dummy());
    }

    @Test
    void removeAllFirst() {
        LinkedList4 testList = new LinkedList4();


        testList.addInTail(new Node(5));
        testList.addInTail(new Node(7));
        testList.addInTail(new Node(9));

        testList.removeAll(5);

        Assertions.assertTrue(testList.count() == 2);

        Assertions.assertTrue(testList.dummy().next.value == 7);
        Assertions.assertTrue(testList.dummy().next.prev == testList.dummy());

        Assertions.assertTrue(testList.dummy().prev.value == 9);
        Assertions.assertTrue(testList.dummy().prev.next == testList.dummy());
    }

    @Test
    void removeAllOneInMiddle() {
        LinkedList4 testList = new LinkedList4();


        testList.addInTail(new Node(5));
        testList.addInTail(new Node(6));
        testList.addInTail(new Node(7));
        testList.addInTail(new Node(9));

        testList.removeAll(7);

        Assertions.assertTrue(testList.count() == 3);

        Assertions.assertTrue(testList.dummy().next.value == 5);
        Assertions.assertTrue(testList.dummy().next.prev == testList.dummy());

        Assertions.assertTrue(testList.dummy().prev.value == 9);
        Assertions.assertTrue(testList.dummy().prev.next == testList.dummy());
    }

    @Test
    void removeAllTwo() {
        LinkedList4 testList = new LinkedList4();


        testList.addInTail(new Node(5));
        testList.addInTail(new Node(7));
        testList.addInTail(new Node(5));

        testList.removeAll(5);

        Assertions.assertTrue(testList.count() == 1);

        Assertions.assertTrue(testList.dummy().next.value == 7);
        Assertions.assertTrue(testList.dummy().next.prev == testList.dummy());

        Assertions.assertTrue(testList.dummy().prev.value == 7);
        Assertions.assertTrue(testList.dummy().prev.next == testList.dummy());
    }

    @Test
    void removeAllMany() {
        LinkedList4 testList = new LinkedList4();

        testList.addInTail(new Node(1995));
        testList.addInTail(new Node(7));
        testList.addInTail(new Node(1995));
        testList.addInTail(new Node(8));
        testList.addInTail(new Node(1995));

        testList.removeAll(1995);

        Assertions.assertTrue(testList.count() == 2);

        Assertions.assertTrue(testList.dummy().next.value == 7);
        Assertions.assertTrue(testList.dummy().next.prev == testList.dummy());

        Assertions.assertTrue(testList.dummy().prev.value == 8);
        Assertions.assertTrue(testList.dummy().prev.next == testList.dummy());
    }

    @Test
    void removeAllFromTheMiddle() {
        LinkedList4 testList = new LinkedList4();

        testList.addInTail(new Node(7));
        testList.addInTail(new Node(1995));
        testList.addInTail(new Node(8));
        testList.addInTail(new Node(1995));
        testList.addInTail(new Node(9));

        testList.removeAll(1995);

        Assertions.assertTrue(testList.count() == 3);

        Assertions.assertTrue(testList.dummy().next.value == 7);
        Assertions.assertTrue(testList.dummy().next.prev == testList.dummy());

        Assertions.assertTrue(testList.dummy().prev.value == 9);
        Assertions.assertTrue(testList.dummy().prev.next == testList.dummy());
    }

    @Test
    void clear() {
        LinkedList4 testList = new LinkedList4();

        for (int i = 0; i < 100; i++) {
            testList.addInTail(new Node(7));
        }

        testList.clear();
        Assertions.assertTrue(testList.count() == 0);
        Assertions.assertTrue(testList.dummy().next == testList.dummy());
    }

    @Test
    void countNull() {
        LinkedList4 testList = new LinkedList4();

        Assertions.assertTrue(testList.count() == 0);
        Assertions.assertTrue(testList.dummy().next == testList.dummy());
    }

    @Test
    void countOne() {
        LinkedList4 testList = new LinkedList4();
        Node x = new Node(4);
        testList.addInTail(x);

        Assertions.assertTrue(testList.count() == 1);
        Assertions.assertTrue(testList.dummy().next.value == 4);
        Assertions.assertTrue(testList.dummy().prev.value == 4);
        Assertions.assertTrue(testList.dummy().next.prev == testList.dummy());
        Assertions.assertTrue(testList.dummy().prev.next == testList.dummy());
    }

    @Test
    void countMany() {
        LinkedList4 testList = new LinkedList4();
        testList.addInTail(new Node(7));
        testList.addInTail(new Node(8));
        testList.addInTail(new Node(1995));

        Assertions.assertTrue(testList.count() == 3);;
        Assertions.assertTrue(testList.dummy().next.value == 7);
        Assertions.assertTrue(testList.dummy().prev.value == 1995);
        Assertions.assertTrue(testList.dummy().next.prev == testList.dummy());
        Assertions.assertTrue(testList.dummy().prev.next == testList.dummy());
    }


    @Test
    void insertAfterSingleElement() {
        LinkedList4 testList = new LinkedList4();

        testList.insertAfter(null, new Node(2007));

        Assertions.assertTrue(testList.count() == 1);

        Assertions.assertTrue(testList.dummy().next.value == 2007);
        Assertions.assertTrue(testList.dummy().prev.value == 2007);
        Assertions.assertTrue(testList.dummy().next.prev == testList.dummy());
        Assertions.assertTrue(testList.dummy().prev.next == testList.dummy());
    }

    @Test
    void insertAfterNull() {
        LinkedList4 testList = new LinkedList4();
        testList.addInTail(new Node(3007));

        testList.insertAfter(null, new Node(2007));

        Assertions.assertTrue(testList.count() == 2);
        Assertions.assertTrue(testList.dummy().next.value == 2007);
        Assertions.assertTrue(testList.dummy().prev.value == 3007);
        Assertions.assertTrue(testList.dummy().next.prev == testList.dummy());
        Assertions.assertTrue(testList.dummy().prev.next == testList.dummy());
    }

    @Test
    void insertAfterMiddle() {
        LinkedList4 testList = new LinkedList4();
        testList.addInTail(new Node(2007));
        testList.addInTail(new Node(3007));

        testList.insertAfter(testList.dummy().next, new Node(2507));

        Assertions.assertTrue(testList.count() == 3);
        Assertions.assertTrue(testList.dummy().next.value == 2007);
        Assertions.assertTrue(testList.dummy().prev.value == 3007);
        Assertions.assertTrue(testList.dummy().next.prev == testList.dummy());
        Assertions.assertTrue(testList.dummy().prev.next == testList.dummy());
    }

    @Test
    void insertAfterLast() {
        LinkedList4 testList = new LinkedList4();
        testList.addInTail(new Node(2007));
        testList.addInTail(new Node(3007));

        testList.insertAfter(testList.dummy().prev, new Node(5007));

        Assertions.assertTrue(testList.count() == 3);
        Assertions.assertTrue(testList.dummy().next.value == 2007);
        Assertions.assertTrue(testList.dummy().prev.value == 5007);
        Assertions.assertTrue(testList.dummy().next.prev == testList.dummy());
        Assertions.assertTrue(testList.dummy().prev.next == testList.dummy());
    }
}