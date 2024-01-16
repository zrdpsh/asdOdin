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
        // здесь будет ваш код поиска всех узлов
        Node currentNode = this.head;
        while (currentNode.next != null) {
            if (currentNode.next.value == _value) {
                nodes.add(currentNode);
            }
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        // здесь будет ваш код удаления одного узла по заданному значению
        Node targetNode = this.find(_value);
        if (targetNode != null) {
            Node previousNode = head;
            while (previousNode.next != targetNode) previousNode = previousNode.next;
            previousNode.next = targetNode.next;
            return true; // если узел был удалён
        }
        return false;

    }

    public void removeAll(int _value)
    {
        // здесь будет ваш код удаления всех узлов по заданному значению
        while (true) {
            boolean flag = this.remove(_value);
            if (flag == false) break;
        }
    }

    public void clear()
    {
        // здесь будет ваш код очистки всего списка
        head = null;
        head.next = tail;
    }

    public int count()
    {
        int res = 0;
        while (this.head.next != null) {
            res++;
        }
//        return 0; // здесь будет ваш код подсчёта количества элементов в списке
        return res;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeAfter == null) this.head = _nodeToInsert;
        else {
            _nodeToInsert.next = _nodeAfter.next;
            _nodeAfter.next = _nodeToInsert;
        }
        // здесь будет ваш код вставки узла после заданного

        // если _nodeAfter = null ,
        // добавьте новый элемент первым в списке
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