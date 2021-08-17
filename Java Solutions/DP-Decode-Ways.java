import java.util.*;

class Solution
{
   /* Problem: For some encoded number mappings, return possible number of ways to decode
      Notes: 1->A, 2->B, ..., Z->26
         06 != 6 so 0 must be used with another character
         Cannot be greater than 26
         Otherwise, if say 26, it can either be decoded as 2,6 or 26
   */

   public int numDecodings(String s)
   {
      return tabulation(s);
   }

   private int tabulation(String s)
   {
      // Leading zero check
      if (s.charAt(0) == '0')
         return 0;

      int[] table = new int[s.length()];
      table[0] = 1;

      /* Ex: 11126
         1
         1,1  11
         1,1,1  1,1,11  11,1
         1,1,1,2  1,1,11,2  11,1,2  1,1,12  11,12
         1,1,1,2,6  1,1,11,2,6  11,1,2,6  1,1,12,6  11,12,6  1,1,1,26  1,1,11,26  11,1,26
      */
      // At each point, add possible number of ways to decode
      // If single digit, add i-1 possible ways
      // If double digit, add i-2 possible ways\
      // This is because if number is two digits, you add this to the end of the possible
         // ways to decode BEFORE you include the single digit

      //// TODO: add initial value for length of 1 and 2
      //// TODO: perform using array or one/twoback int trackers
      int oneBack = 0;
      int twoBack = 0;
      for (int i=0; i < s.length(); i++)
      {
         // Get char and convert to int
         int current = Character.getNumericValue(s.charAt(i));

         // If current is 0, don't add number of ways

         // If previous+current >26, don't add

         // 

      }

      return 0;
   }

   private int memoization (String s, int[] memo, int index, int previous)
   {
      return 0;
   }
}