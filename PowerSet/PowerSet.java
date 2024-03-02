package PowerSet;

public class PowerSet
{
    public int ss;
    private int size;

    private String[] slots;
    private int step = 3;


   public PowerSet()
   {
     // ваша реализация хранилища
      //
       ss = 20000;
       slots = new String[ss];
       size = 0;
       for (int i = 0; i < ss; i++) slots[i] = null;

   }

   public int size()
   {
        return size;
   }

    public String[] getContents() {
        return slots;
    }


    public int hashFun(String value)
    {
        int sum = 0;
        for (int i = 0; i < value.length(); i++){
            sum += value.charAt(i);
        }
      return (sum % ss);
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


   public void put(String value)
   {
     // всегда срабатывает
       int i;
       i = seekSlot(value);
       if(i != -1) slots[i] = value;
   }

    public boolean get(String value)
    {
        int i = hashFun(value);
        if(value.equals(slots[i])) return true;

        for (i = 0; i < size; i++)
            if(value.equals(slots[i])) return true;

        return false;
    }

    public boolean remove(String value)
    {
        int i = hashFun(value);
        if(value.equals(slots[i])) {
            slots[i] = null;
            return true;
        }

        for (i = 0; i < size; i++)
            if(value.equals(slots[i])) {
                slots[i] = null;
                return true;
            }
        return false;
    }

    public PowerSet intersection(PowerSet set2)
    {
        PowerSet res = new PowerSet();
        String[] s2str = set2.getContents();

        for (int i = 0; i < size; i++) {
            if (set2.get(slots[i])) res.put(slots[i]);
        }

        return res;
    }

    public PowerSet union(PowerSet set2)
    {
        PowerSet res = new PowerSet();
        String[] s2str = set2.getContents();

        for (int i = 0; i < size; i++) res.put(slots[i]);
        for (int i = 0; i < s2str.length; i++) res.put(s2str[i]);

        return res;
    }

    public PowerSet difference(PowerSet set2)
    {
        PowerSet u = this.union(set2);
        PowerSet s = this.intersection(set2);
        String[] sStr = s.getContents();

        for (int i = 0; i < sStr.length; i++) {
            if (u.get(sStr[i])) u.remove(sStr[i]);
        }

        return u;
    }

    public boolean isSubset(PowerSet set2)
    {
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
        for (int i = 0; i < size; i++) {
            if (!set2.get(slots[i])) return false;
        }
        return true;
    }

   public boolean a(int m) {
      return false;
   }
}
