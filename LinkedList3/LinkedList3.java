package LinkedList3;

import java.util.ArrayList;

public class LinkedList3 {

    private Node dummy;

    public LinkedList3()
    {
        this.dummy = new Node();
        this.dummy.next = this.dummy;
        this.dummy.prev = this.dummy;
    }

    public Node dummy() {
        return this.dummy;
    }


    public void addInTail(Node _item)
    {
        _item.prev = this.dummy.prev;
        _item.prev.next = _item;
        _item.next = this.dummy;
        this.dummy.prev = _item;
    }

    public Node find(int _value)
    {
        Node tmp = this.dummy.next;
        while(tmp != this.dummy) {
            if (tmp.value == _value) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();

        Node tmp = this.dummy.next;
        while(tmp != this.dummy) {
            if (tmp.value == _value) {
                nodes.add(tmp);
            }
            tmp = tmp.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        Node tmp = this.dummy.next;

        if (tmp != this.dummy) {
            if (tmp.value == _value) {
                tmp.prev.next = tmp.next;
                tmp.next.prev = tmp.prev;
                return true;
            }
        }

        return false;
    }

    public void removeAll(int _value)
    {
        Node tmp = this.dummy.next;

        if (tmp != this.dummy) {
            if (tmp.value == _value) {
                tmp.prev.next = tmp.next;
                tmp.next.prev = tmp.prev;
            }
        }
    }

    public void clear()
    {
        this.dummy.next = this.dummy;
        this.dummy.prev = this.dummy;
    }

    public int count()
    {
        int res = 0;

        Node tmp = this.dummy.next;
        while(tmp != this.dummy) {
            res+=1;
            tmp = tmp.next;
        }

        return res;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeAfter == null) {
            this.addInTail(_nodeToInsert);
            return;
        }

        _nodeToInsert.prev = _nodeAfter;
        _nodeToInsert.next = _nodeAfter.next;
        _nodeAfter.next = _nodeToInsert;
        _nodeToInsert.next.prev = _nodeToInsert;

    }
}

class Node
{
    public Node next;
    public Node prev;
    public int value;

    public Node() {
        this.next = null;
        this.prev = null;
    }

    public Node(int _value) {
        this.next = null;
        this.prev = null;
        this.value = _value;
    }
}

