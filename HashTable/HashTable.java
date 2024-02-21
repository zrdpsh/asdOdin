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
         // всегда возвращает корректный индекс слота
        char[] carr = new char[value.length()];
        int sum = 0;
        for (int i = 0; i < value.length(); i++){
            carr[i] = value.charAt(i);
            sum += carr[i] - '0';
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
          // check slot by step
          i = checkWithStep(i, key);
          // check each slot
          if(i >= size){
              i = checkEachElement(i, key);
          }
          /**
           * if have't free slot or already have this key
           */
          if(i >= size)
              return -1;
          return i;
      }

      public int checkWithStep(int i, String key) {
          while(i < size && slots[i] != null){
              if(slots[i].equals(key))
                  break;
              i += step;
          }
          return i;

      }

      public int checkEachElement(int i, String key) {
          i = 0;
          while(i < size && slots[i] != null){
              if(slots[i].equals(key))
                  break;
              i++;
          }
          return i;
      }

     public int put(String value)
     {
         // записываем значение по хэш-функции
         
         // возвращается индекс слота или -1
         // если из-за коллизий элемент не удаётся разместить 
//         return -1;

         int i;
         i = seekSlot(value);
         if(i != -1){
             slots[i] = value;
         }
         return i;
     }

     public int find(String value)
     {
         // находит индекс слота со значением, или -1
//         return -1;
         int i = hashFun(value);
         if(value.equals(slots[i]))
             return i;

         for (i = 0; i < size; i++)
             if(value.equals(slots[i]))
                 return i;
         return -1;

         }
  }
