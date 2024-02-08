import java.util.*;

public class Queue<T>
{
      private LinkedList<T> queue;

      public Queue()
      {
            queue = new LinkedList<>();
      }

      // O(1) - independent of collection length
      public void enqueue(T item)
      {
            queue.add(item);
      }

      // O(1) - independent of collection length
      public T dequeue()
      {
            return queue.pollFirst();
      }

      // O(1) - size is stored as a variable
      public int size()
      {
            return queue.size();
      }

}
