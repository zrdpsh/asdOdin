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
        do {
            if (currentNode.value == _value) {
                nodes.add(currentNode);
            }
            currentNode = currentNode.next;
        } while (currentNode.next != null);
        return nodes;
    }

    public boolean remove(int _value)
    {
        Node targetNode = this.find(_value);
        if (targetNode != null) {
            Node previousNode = head;
            while (previousNode.next != targetNode) previousNode = previousNode.next;
            previousNode.next = targetNode.next;
            return true;
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
        head.next = tail;
    }

    public int count()
    {
        int res = 0;
        while (this.head.next != null) {
            res++;
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