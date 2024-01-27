package DynArray;

import java.lang.reflect.Array;

public class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz)
    {
        clazz = clz; // нужен для безопасного приведения типов
        // new DynArray<Integer>(Integer.class);

        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity)
    {
        // array = (T[]) Array.newInstance(this.clazz, new_capacity);
        T[] temp = (T[]) Array.newInstance(this.clazz, new_capacity);;
        this.capacity = new_capacity;
        for (int i = 0; i < capacity; i++) temp[i] = this.array[i];
        this.array = temp;
    }

    public T getItem(int index)
    {
        if (index < 0 || index > this.capacity) throw new IndexOutOfBoundsException("Illegal index" + index);
        else return this.array[index];

        // ваш код
//        return null;
    }

    public void append(T itm)
    {
        // ваш код
        if (count > (capacity/2)) makeArray(capacity*2);
        this.array[count] = itm;
        this.count++;
    }

    public void insert(T itm, int index)
    {
        // ваш код
        if ((count+1) > (capacity/2)) makeArray((int) (capacity*2));
        for (int i = index; index < count; i++) {
            this.array[i-1] = this.array[i];
        }
    }

    public void remove(int index)
    {
        // ваш код
        if ((count-1) > (capacity/2) && ((int)capacity/1.5)>16) makeArray((int) (capacity/1.5));
        for (int i = index; index < count; i++) {
            this.array[i-1] = this.array[i];
        }
    }

}