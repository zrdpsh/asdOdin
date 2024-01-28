package DynArray;

public class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz)
    {
        clazz = clz;

        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity)
    {
        T[] temp = (T[]) java.lang.reflect.Array.newInstance(this.clazz, new_capacity);
        this.capacity = new_capacity;
        if (this.array != null) {
            for (int i = 0; i < count; i++) temp[i] = this.array[i];
        }
        this.array = temp;
    }

    public T getItem(int index)
    {
        if (index < 0 || index > this.capacity) throw new IndexOutOfBoundsException("Illegal index: " + index);
        else return this.array[index];
    }

    public void append(T itm)
    {
        // ваш код
        if (count+1 > capacity) makeArray(capacity*2);
        this.array[count] = itm;
        this.count++;
    }

    public void insert(T itm, int index)
    {
        if (index < 0 || index > this.capacity) throw new IndexOutOfBoundsException("Illegal index: " + index);

        if ((count+1) > capacity) makeArray(capacity*2);
        for (int i = count; i > index; i--) {
            this.array[i] = this.array[i-1];
        }
        this.array[index] = itm;
        count++;
    }

    public void remove(int index)
    {
        if (index < 0 || index > (this.capacity-1)) throw new IndexOutOfBoundsException("Illegal index: " + index);

        if ((count-1) < (capacity/2))
        {
            if ((capacity/1.5)>16)
            {
                makeArray((int) (capacity/1.5));
            }
        }
        for (int i = index; i < (count-1); i++) {
            this.array[i] = this.array[i+1];
        }

        this.array[count-1] = null;

        count--;
    }

}