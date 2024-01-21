import java.util.*;

public class LinkedList2
{
    public Node head;
    public Node tail;

    public LinkedList2()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item)
    {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value)
    {
        Node tmp = this.head;
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

        Node tmp = this.head;
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
        if (this.head == null) return false;

        Node tmp = this.head;

        if (tmp.value == _value) {
            tmp = tmp.next;
            tmp.prev = null;
            this.head = tmp;
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
            this.tail = tmp;
            this.tail.next = null;
            return true;
        }
        return false;
    }

    public void removeAll(int _value)
    {
        if (this.head == null) return;

        Node tmp = this.head;

        if (tmp.value == _value) {
            tmp = tmp.next;
            this.head = tmp;
            this.head.prev = null;
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
            this.tail = tmp;
            this.tail.next = null;
        }
    }

    public void clear()
    {
        this.head = null;
        this.tail = null;
    }

    public int count()
    {
        int res = 0;

        Node tmp = this.head;
        while(tmp != null) {
            res+=1;
            tmp = tmp.next;
        }

        return res;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeAfter == null) {
            _nodeToInsert.next = this.head;
            this.head.prev = _nodeToInsert;
            this.head = _nodeToInsert;
            return;
        }

        _nodeToInsert.prev = _nodeAfter;
        _nodeToInsert.next = _nodeAfter.next;
        _nodeAfter.next = _nodeToInsert;

        if (_nodeToInsert.next == null) {
            this.tail = _nodeToInsert;
            return;
        }

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
}