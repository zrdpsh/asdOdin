package NativeDictionary;

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
      // возвращает true если ключ имеется,
      // иначе false
      return false;
    }

    public void put(String key, T value)
    {
        int slot = seekSlot(key);
        if (slot != -1) {
            slots[slot] = key;
            values[slot] = value;
        }
      // гарантированно записываем 
      // значение value по ключу key
    }

    public T get(String key)
    {
      // возвращает value для key, 
      // или null если ключ не найден
      return null;
    }
}
