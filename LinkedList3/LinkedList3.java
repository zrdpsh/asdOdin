package LinkedList3;

import java.util.ArrayList;

public class LinkedList3 {

    private DummyNode dummy;

    public LinkedList3()
    {
        this.dummy = new DummyNode();
    }

    public DummyNode dummy() {
        return this.dummy;
    }

    public void addInTail(Node _item)
    {
        if (this.dummy.next == null) {
            this.dummy.next = _item;
            this.dummy.prev = _item;
            this.dummy.next.next = dummy;
            this.dummy.prev.prev = dummy;
        } else {
            _item.prev = this.dummy.prev;
            _item.next = this.dummy;

        }
        this.dummy.prev = _item;
    }

    public Node find(int _value)
    {
        Node tmp = this.dummy.next;
        while(tmp != null) {
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
        while(tmp != null) {
            if (tmp.value == _value) {
                nodes.add(tmp);
            }
            tmp = tmp.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        if (this.dummy == null) return false;

        Node tmp = this.dummy.next;

        if (tmp.value == _value) {
            tmp = tmp.next;
            if (tmp == null) {
                this.clear();
                return true;
            }
            tmp.prev = this.dummy;
            this.dummy.next = tmp;
            return true;
        }

        tmp = tmp.next;

        while (tmp.next != null) {
            if (tmp.value == _value) {
                tmp.prev.next = tmp.next;
                tmp.next.prev = tmp.prev;
                return true;
            }
            tmp = tmp.next;
        }

        if (tmp.value == _value) {
            tmp = tmp.prev;
            tmp.next = this.dummy;
            this.dummy.prev = tmp;
            return true;
        }
        return false;
    }

    public void removeAll(int _value)
    {
        if (this.dummy == null) return;

        Node tmp = this.dummy.next;

        if (tmp.value == _value) {
            tmp = tmp.next;
            if (tmp == null) {
                this.clear();
                return;
            }
            this.dummy.next = tmp;
            tmp.prev = this.dummy;
        }

        while (tmp.next != null) {
            if (tmp.value == _value) {
                tmp.prev.next = tmp.next;
                tmp.next.prev = tmp.prev;
            }
            tmp = tmp.next;
        }

        if (tmp.value == _value) {
            tmp = tmp.prev;
            this.dummy.prev = tmp;
            tmp.next = this.dummy;
        }
    }

    public void clear()
    {
        this.dummy = null;
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
        if (_nodeAfter == null && this.dummy == null) {
            this.addInTail(_nodeToInsert);
            return;
        }

        if (_nodeAfter == null) {
            _nodeToInsert.prev = this.dummy;
            _nodeToInsert.next = this.dummy.next;
            _nodeToInsert.next.prev = _nodeToInsert;
            this.dummy.next = _nodeToInsert;
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
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }

    public Node()
    {
        next = null;
        prev = null;
    }
}

class DummyNode extends Node
{
    public Node next;
    public Node prev;

    public DummyNode()
    {
        super();
    }
}


