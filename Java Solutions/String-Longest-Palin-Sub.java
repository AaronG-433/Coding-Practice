import java.util.*;

class Solution
{
   public String longestPalindrome(String s)
   {
      // Minimum possible palindrome based on constraints
      int start = 0; // store start of longest palindrome
      int maxLength = 1;  // store length of longest palindrome

      char[] sArray = s.toCharArray(); // This is faster than s.charAt()

      int len = s.length();
      int size;   // The size of one side of the palindrome
      for (int i=0; i < len; i++)
      {
         // Check for odd palindromes (odds have a shared middle value)
         size = 1;
         while ( (i-size >=0 && i+size < len) && (sArray[i-size] == sArray[i+size]))
         {
            if (size*2 + 1 > maxLength)
            {
               start = i-size;
               maxLength = size*2+1;
            }
            ++size;  // increment size until not a palindrome
         }


         // Check for even palindromes (left side gets middle value)
         size = 0;
         while ( (i-size >= 0 && i+size+1 < len) && (sArray[i-size] == sArray[i+size+1]))
         {
            // Must increment to account for size (Ex: "aa" would be 0 length)
            if ( (size+1)*2 > maxLength)
            {
               start = i-size;
               maxLength = (size+1)*2;
            }
            ++size;
         }
      }

      return s.substring(start, start+maxLength);
   }
}