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
        // количество элементов в множестве
      
        return size;
   }

    public int hashFun(String value)
    {
        int sum = 0;
        for (int i = 0; i < value.length(); i++){
            sum += value.charAt(i);
        }
        return (sum % ss);
    }

    public String[] getContents() {
       return slots;
    }


   public void put(String value)
   {
     // всегда срабатывает
   }

    public boolean get(String value)
    {
        // возвращает true если value имеется в множестве,
        // иначе false
        return false;
    }

    public boolean remove(String value)
    {
        // возвращает true если value удалено
        // иначе false
        return false;
    }

    public PowerSet intersection(PowerSet set2)
    {
        // пересечение текущего множества и set2
        return null;
    }

    public PowerSet union(PowerSet set2)
    {
        PowerSet res = new PowerSet();
        // объединение текущего множества и set2
        for (int i = 0; i < size; i++) set2.put(slots[i]);

        return set2;
    }

    public PowerSet difference(PowerSet set2)
    {
        PowerSet res = new PowerSet();
        // разница текущего множества и set2

        for (int i = 0; i < size; i++) {
            String tmp =
            if (!set2.get(slots[i])) res.put();
        }
        return null;
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
