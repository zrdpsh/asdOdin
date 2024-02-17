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

        // -1 если v1 < v2
        // 0 если v1 == v2
        // +1 если v1 > v2
      return res;
    }

    public void add(T value)
    {
        // автоматическая вставка value 
        // в нужную позицию
    }

    public Node<T> find(T val)
    {
        Node<T> nd = this.head;


        return null; // здесь будет ваш код
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
       return 0; // здесь будет ваш код подсчёта количества элементов в списке
    }

    ArrayList<Node<T>> getAll() // выдать все элементы упорядоченного 
                           // списка в виде стандартного списка
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
