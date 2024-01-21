package LinkedList2;

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
        // здесь будет ваш код поиска
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
            this.head = tmp;
            this.head.prev = null;
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
        // здесь будет ваш код удаления всех узлов по заданному значению
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
        // здесь будет ваш код вставки узла после заданного узла

        // если _nodeAfter = null
        // добавьте новый элемент первым в списке
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