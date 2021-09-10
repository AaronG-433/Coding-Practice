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

      int oneBack = 1;
      int twoBack = 1;
      for (int i=1; i < s.length(); i++)
      {
         int count = 0;
         
         // Get char and convert to int
         int current = Character.getNumericValue(s.charAt(i));

         // Check if valid single digit
         if (current != 0)
            count += oneBack;

         // Check if next char is 0 and skip double check if so
            // This is because current int will be needed to satisfy the coming 0
         if (i != s.length()-1 && s.charAt(i+1) == '0')
         {
            // Update back values
            twoBack = oneBack;
            oneBack = count;
            continue;
         }

         // Check if valid double digit (no 0 as first char and 0 < doubleDigit <= 26)
         current = Integer.parseInt(s, i-1, i+1, 10);
         if (s.charAt(i-1) != '0' && 0 < current && current <= 26)
            count += twoBack;

         // Update back values
         twoBack = oneBack;
         oneBack = count;
      }

      return oneBack;
   }

   private int memoization (String s, int[] memo, int index, int previous)
   {
      return 0;
   }
}