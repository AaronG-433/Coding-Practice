import java.util.*;

class Solution
{
   public int countSubstrings(String s)
   {
      int count = s.length();

      char[] sArr = s.toCharArray();

      for (int i=0; i < s.length(); i++)
      {
         // Calculate palindrome for odd windows
         int left = i-1;
         int right = i+1;
         count = countPalindromicSubstring(count, left, right, sArr);

         // Calculate palindrome for even windows
         left = i;
         right = i+1;
         count = countPalindromicSubstring(count, left, right, sArr);
      }

      return count;
   }

   private int countPalindromicSubstring(int count, int left, int right, char[] sArr)
   {
      while ( (left >= 0 && right < sArr.length) && (sArr[left] == sArr[right]) )
      {
         --left;
         ++right;
         ++count;
      }

      return count;
   }
}