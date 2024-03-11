package NativeCache;

class NativeCache<T>
{
    public int size;
    public String [] slots;
    public T [] values;
    public int [] hits;
    Class clazz;

    int step = 2;

    public NativeCache(int size, Class clazz) {
        this.clazz = clazz;
        this.size = size;
        this.slots = new String[size];
        this.values = (T[]) java.lang.reflect.Array.newInstance(this.clazz, size);
        this.hits = new int[size];
    }

    public int hashFun(String value)
    {
        int sum = 0;
        for (int i = 0; i < value.length(); i++){
            sum += value.charAt(i);
        }
        return (sum % size);
    }


    public int seekSlot(String value)
    {
        int i;
        i = hashFun(value);
        i = checkIndex(i, value);
        return i;
    }

    public int checkIndex(int i, String key) {
        i = checkViaStep(i, key);
        if (i >= size) i = checkEach(key);
        if (i >= size) i = -1;
        return i;
    }

    public int checkViaStep(int i, String key) {
        for(;i < size && slots[i] != null; i+=step){
            if(slots[i%size].equals(key)) break;
        }
        return i;
    }

    public int checkEach(String key) {
        int i = 0;
        for(; i < size && slots[i] != null; i++){
            if(slots[i%size].equals(key)) break;
        }
        return i;
    }


    public boolean isKey(String key)
    {
        int slot = hashFun(key);
        if (slots[slot] != null && slots[slot].equals(key)) return true;

        for (slot = 0; slot < slots.length; slot++) {
            if (slots[slot] != null && slots[slot].equals(key)) return true;
        }

        return false;
    }

    public int find(String value)
    {
        int i = hashFun(value);
        if(value.equals(slots[i]))
            return i;

        for (i = 0; i < size; i++)
            if(value.equals(slots[i]))
                return i;

        return -1;
    }


    public T get(String str) {
        int i = find(str);
        if (i != -1) {
            hits[i] += 1;
            return values[i];
        }

        return null;
    }

    public void put(String str, T value)
    {
        int i;
        i = seekSlot(str);
        if(i != -1) {
            slots[i] = str;
            values[i] = value;
        }

        if (i == -1) {
            int minIx = minValue(this.hits);
            slots[minIx] = str;
            values[minIx] = value;
            hits[minIx] = 0;
        }
    }

    public static int minValue(int[] hits) {
        int res = 0;

        for (int i = 0; i < hits.length; i++) {
            if (hits[i] < hits[res]) res = i;
        }

        return res;
    }


}
