package HashTable;

public class HashTable
  {
    public int size;
    public int step;
    public String [] slots; 

    public HashTable(int sz, int stp)
    {
      size = sz;
      step = stp;
      slots = new String[size];
      for(int i=0; i<size; i++) slots[i] = null;
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
        int res = -1;
          for(;i < size*step; i+=step){
              if(slots[i%size] == null || slots[i%size].equals(key)) {
                  res = i%size;
                  break;
              }
          }
          return res;
      }

     public int put(String value)
     {
         int i;
         i = seekSlot(value);
         if(i != -1) slots[i] = value;
         return i;
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
  }
