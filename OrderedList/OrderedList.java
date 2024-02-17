import javax.print.DocFlavor;
import java.util.*;


 class Node<T>
  {
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
      value = _value;
      next = null;
      prev = null;
    }
  }

 public class OrderedList<T>
  {
    public Node<T> head, tail;
    private boolean _ascending;
    private int len;

    public OrderedList(boolean asc)
    {
      head = null;
      tail = null;
      _ascending = asc;
      len = 0;
    }

    public int compare(T v1, T v2)
    {
        int res = 0;

        if (v1.getClass() == Integer.class) res = ((Integer) v1).compareTo((Integer) v2);

        if (v1.getClass() == String.class) {
            String str1 = ((String) v1).trim();
            String str2 = ((String) v2).trim();
            res = str1.compareTo(str2);
        }

        if (res < 0) res = -1;
        if (res > 0) res = 1;

        return res;
    }

    public void add(T value)
    {
        Node<T> nd = new Node<>(value);
        if (head == null) {
            this.head = nd;
        }

//        this.tail = _item;
        // автоматическая вставка value 
        // в нужную позицию
    }

    public Node<T> find(T val)
    {
        Node<T> nd = this.head;

        int compareRes = this.compare(nd.value, val);

        for (int i = 0; i < this.len; i++) {
            if (compareRes == 0) return nd;
            if (this._ascending && compareRes < 0) return null;
            if ((!this._ascending) && compareRes > 0) return null;
            nd = nd.next;
        }
        return null;
    }

    public void delete(T val)
    {
        // здесь будет ваш код
    }

    public void clear(boolean asc)
    {
        _ascending = asc;
        this.head = null;
        this.tail = null;
        len = 0;
        // здесь будет ваш код
    }

    public int count()
    {
       return len;
    }

    ArrayList<Node<T>> getAll()
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }
  }
