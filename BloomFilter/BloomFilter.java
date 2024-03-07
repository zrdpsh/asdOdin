package BloomFilter;

public class BloomFilter
{
    private static final int RAND1 = 17;
    private static final int RAND2 = 223;

    public int filter_len;

      public BloomFilter(int f_len)
      {
        filter_len = f_len;
        // создаём битовый массив длиной f_len ...

      }

      // хэш-функции
      public int hash1(String str1)
      {
          int rand = 17;
        // 17
        //for(int i=0; i<str1.length(); i++)
        //{
        //    int code = (int)str1.charAt(i);
        //}
        // реализация ...

        return hF(str1, RAND1);
      }
      public int hash2(String str1)
      {
        // 223
        // реализация ...
          return hF(str1, RAND2);
      }

      public void add(String str1)
      {
        // добавляем строку str1 в фильтр
          int i1 = hash1(str1);
          int i2 = hash2(str1);
      }

      public boolean isValue(String str1)
      {
        // проверка, имеется ли строка str1 в фильтре
        return false;
      }

      private int hF(String str, int rand) {
          int sum = 0;
          for (int i = 0; i < str.length(); i++) {
              sum = (sum*rand + str.charAt(i)) % filter_len;
          }

          return sum;
      }
}
