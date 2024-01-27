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

    public boolean remove(int _value)
    {
        if (this.head == null)
        {
            return false;
        }
        
        Node currentNode = this.head;
        if (currentNode.value == _value) {
            if (currentNode.next == null) {
                head = null;
                tail = null;
                return true;
            } else {
                this.head = currentNode.next;
                return true;
            }
        } else {
            while (true) {
                Node previousNode = currentNode;
                currentNode = currentNode.next;
                if (currentNode.next != null) {
                    if (currentNode.value == _value) {
                        previousNode.next = currentNode.next;
                        return true;
                    }
                } else {
                    if (currentNode.value == _value) {
                        previousNode.next = null;
                        this.tail = previousNode;
                        return true;
                    } else {
                        return false;
                        }
                    }
                }
            }
        }

    public void removeAll(int _value)
    {
            if (this.head == null)
            {
                return;
            }
            Node currentNode = this.head;
            while (true) {
                if (currentNode.value == _value) {
                    if (currentNode.next == null) {
                        head = null;
                        tail = null;
                        break;
                    } else {
                        this.head = currentNode.next;
                        currentNode = this.head;
                    }
                } else {
                    if (currentNode.next != null) {
                        Node previousNode = currentNode;
                        currentNode = currentNode.next;
                        if (currentNode.value == _value) {
                            previousNode.next = currentNode.next;
                            currentNode = previousNode;
                        }
                    } else {
                        this.tail = currentNode;
                        break;
                    }
                }
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
//            while (previousNode.next != null) {
//                previousNode = previousNode.next;
//                res++;
//            }
            for (;previousNode.next != null; previousNode = previousNode.next) res++;
        }
        return res;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeAfter == null) {
            this.addInTail(_nodeToInsert);
        } else {
            if (_nodeAfter.next == null) {
                _nodeAfter.next = _nodeToInsert;
                this.tail = _nodeToInsert;
            } else {
                _nodeAfter.next.next = _nodeToInsert.next;
                _nodeAfter.next = _nodeToInsert;
            }
        }
    }

    public LinkedList solderTwoLists(LinkedList snd) {
        LinkedList res = new LinkedList();

        Node fstLstNd = this.head;
        Node sndLstNd = snd.head;

        if (fstLstNd != null && sndLstNd != null ) {
            Node resNode = new Node(fstLstNd.value + sndLstNd.value);
            res.addInTail(resNode);
            res.head = resNode;

            fstLstNd = fstLstNd.next;
            sndLstNd = sndLstNd.next;

            while (true) {
                if (fstLstNd != null && sndLstNd != null) {
                    resNode = new Node(fstLstNd.value + sndLstNd.value);
                    res.addInTail(resNode);
                    fstLstNd = fstLstNd.next;
                    sndLstNd = sndLstNd.next;

                } else if (fstLstNd == null && sndLstNd == null) {
                    res.tail = resNode;
                    return res;
                } else {
                    return null;
                }
            }
        }
        return null;
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

