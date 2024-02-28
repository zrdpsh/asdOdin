import java.lang.reflect.Array;

class NativeDictionary<T>
{
    public int size;
    public String [] slots;
    public T [] values;
    public int step = 2;

    public NativeDictionary(int sz, Class clazz)
    {
      size = sz;
      slots = new String[size];
      values = (T[]) Array.newInstance(clazz, this.size);

      for (int i = 0; i < size; i++) slots[i] = null;
    }

    public int hashFun(String key)
    {
        int sum = 0;
        for (int i = 0; i < key.length(); i++){
            sum += key.charAt(i);
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

    public void put(String key, T value)
    {
        int slot = seekSlot(key);
        if (slot != -1) {
            slots[slot] = key;
            values[slot] = value;
        }
    }

    public T get(String key)
    {
        int slot = find(key);
        if (slot != -1) return values[slot];

        return null;
    }

    public int find(String value)
    {
        int i = hashFun(value);
        if(value.equals(slots[i])) return i;

        for (i = 0; i < size; i++)
            if(value.equals(slots[i]))
                return i;

        return -1;
    }
}
