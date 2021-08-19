import java.util.*;

// Longest Repeating Character Replacement
class Solution
{
   public int characterReplacement(String s, int k)
   {
      /* Problem: Given a string s and int k. You can choose any char and change it to any
      other uppercase English char at most k times. Return the length of the longest 
      substring containing the same letter after these operations are performed

      Ideas: use sliding window while keeping track of the number of each char

      Notes: we can have a long repeat for one char
      Ex: ABAB, k=2    AAABBBBAAA, k=1    AABABBA, k=1
      */

      // Declare variable
      int[] charCount = new int[26];
      int start = 0;
      int maxLength = 0;
      int maxCharCount = 0;

      for (int end=0; end<s.length(); end++)
      {
         ++charCount[s.charAt(end) - 'A'];   // Add char to current substring
         maxCharCount = Math.max(maxCharCount, charCount[s.charAt(end) - 'A']); // update max
         // Note: we only care about max possible so we don't need to update maxChar if
            // our window shrinks

         // Check if the current window can be entirely converted to one char
         // If we need more conversions than we have, shrink the window
            // end-start+1 is the current substring and maxCharCount is the most repeating
            // chars in it so we subtract from each other to get needed conversions
         while (end-start+1 - maxCharCount > k)
         {
            // Remove leftmost char from window
            --charCount[s.charAt(start)-'A'];
            ++start;
         }

         maxLength = Math.max(maxLength, end-start+1);
      }

      return maxLength;
   }
}