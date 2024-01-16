package LinkedList;

import java.util.*;

public class LinkedList
{
    public Node head;
    public Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }


    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.value == _value) {
                    nodes.add(currentNode);
            }
            currentNode = currentNode.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        if (this.head == null) return false;
        else if (this.head.value == _value) {
            this.head = this.head.next;
            return true;
        } else {
            Node previousNode = this.head;
            do {
                if (previousNode.next.value == _value) {
                    previousNode.next = previousNode.next.next;
                    return true;
                } else {
                    previousNode = previousNode.next;
                }
            } while (previousNode.next != null);
        }
        return false;
    }

    public void removeAll(int _value)
    {
        while (true) {
            boolean flag = this.remove(_value);
            if (flag == false) break;
        }
    }

    public void clear()
    {
        head = null;
        tail = null;
    }

    public int count()
    {
        int res = 0;
        Node previousNode = this.head;
        if (this.head != null) {
            res++;
            while (previousNode.next != null) {
                previousNode = previousNode.next;
                res++;
            }
        }
        return res;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeAfter == null) this.head = _nodeToInsert;
        else {
            _nodeToInsert.next = _nodeAfter.next;
            _nodeAfter.next = _nodeToInsert;
        }
    }

}

class Node
{
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }
}