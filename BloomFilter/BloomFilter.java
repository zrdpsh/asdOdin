package BloomFilter;

public class BloomFilter
{
    private static final int RAND1 = 17;
    private static final int RAND2 = 223;
    int MASK = 0x0_000_0000;
    int binaryString;

    public int filter_len;

      public BloomFilter(int f_len)
      {
        filter_len = f_len;
        binaryString = MASK;

      }

      public int hash1(String str1)
      {
          return hF(str1, RAND1);
      }

      public int hash2(String str1)
      {
          return hF(str1, RAND2);
      }

      public void add(String str1)
      {
          binaryString = hash1(str1) | binaryString;
          binaryString = hash2(str1) | binaryString;
      }

      public boolean isValue(String str1)
      {
          int i1 = hash1(str1);
          int i2 = hash2(str1);

        return ((binaryString & i1) == i1) && ((binaryString & i2) == i2) ;
      }

      private int hF(String str, int rand) {
          int sum = 0;
          for (int i = 0; i < str.length(); i++) {
              sum = (sum*rand + str.charAt(i)) % filter_len;
          }

          return sum | MASK;
      }
}
