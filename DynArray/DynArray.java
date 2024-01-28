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

    public void insert(T itm, int index) {
        if (index < 0 || index > this.count) throw new IndexOutOfBoundsException("Illegal index: " + index);

        if ((this.count+1) > this.capacity) makeArray(this.capacity*2);
        for (int i = this.count; i > index; i--) {
            this.array[i] = this.array[i-1];
        }
        this.array[index] = itm;
        this.count++;
    }

    public void remove(int index)
    {
        if (index < 0 || index >= (this.count)) throw new IndexOutOfBoundsException("Illegal index: " + index);

        if ((this.count-1)/(this.capacity/2) < 0.5)
        {
            makeArray((int) (this.capacity/1.5));

            if ((this.capacity/1.5)<16) this.capacity = 16;
        }

        for (int i = index; i < (this.count-1); i++) {
            this.array[i] = this.array[i+1];
        }

        this.array[count-1] = null;

        count--;
    }

}
