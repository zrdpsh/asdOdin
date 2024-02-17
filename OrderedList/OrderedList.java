package OrderedList;

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

        if (v1 == null || v2 == null) return res;

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
            this.tail = nd;
            len++;
            return;
        }

        Node<T> tmpNd = this.head;

        if (_ascending && (compare(nd.value, tmpNd.value) < 0)) {
            addInHead(nd, tmpNd);
            return;
        }

        if (!_ascending && (compare(nd.value, tmpNd.value) > 0)) {
            addInHead(nd, tmpNd);
            return;
        }

        for (;tmpNd.next != null; tmpNd = tmpNd.next) {
            if (_ascending && (compare(nd.value, tmpNd.value) < 0)) {
                tmpNd.prev.next = nd;
                nd.next = tmpNd;
                len++;
                return;
            }

            if (!_ascending && (compare(nd.value, tmpNd.value) > 0)) {
                tmpNd.prev.next = nd;
                nd.next = tmpNd;
                len++;
                return;
            }
        }

        if (_ascending && (compare(nd.value, tmpNd.value) < 0)) {
            addBeforeTail(nd, tmpNd);
            return;
        }

        if (!_ascending && (compare(nd.value, tmpNd.value) > 0)) {
            addBeforeTail(nd, tmpNd);
            return;
        }

        nd.prev = tmpNd;
        nd.prev.next = nd;
        nd.next = null;
        this.tail = nd;
        len++;

    }

    private void addInHead(Node<T> added, Node<T> moved) {
        added.prev = null;
        added.next = moved;
        moved.prev = added;
        this.head = added;
        this.len++;
    }

      private void addBeforeTail(Node<T> added, Node<T> moved) {
          added.prev = moved.prev;
          added.prev.next = added;
          added.next = moved;
          moved.prev = added;
          len++;
      }

//    private void addWithFlag

    public Node<T> find(T val)
    {
        Node<T> nd = this.head;

        for (int i = 0; i < this.len; i++) {
            int compareRes = this.compare(nd.value, val);
            if (compareRes == 0) return nd;
            if (this._ascending && compareRes > 0) return null;
            if ((!this._ascending) && compareRes < 0) return null;
            nd = nd.next;
        }
        return null;
    }

    public void delete(T val)
    {
        Node<T> nd = find(val);
        if (nd == null) return;

        if (this.head == this.tail) {
             this.clear(true);
             len = len - (len > 0 ? 1 : 0);
             return;
        }

        if (nd.prev == null) {
            this.head = nd.next;
            nd.next.prev = null;
            len = len - (len > 0 ? 1 : 0);
            return;
        }

        if (nd.next == null) {
            this.tail = nd.prev;
            nd.prev.next = null;
            len = len - (len > 0 ? 1 : 0);
            return;
        }

        nd.prev.next = nd.next;
        nd.next.prev = nd.prev;
        len = len - (len > 0 ? 1 : 0);
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
