import java.util.*;

// Longest Substring Without Repeating Characters
class Solution
{
   public int lengthOfLongestSubstring(String s)
   {
      int longest = 0;
      int subStart = 0;
      Map<Character, Integer> charMap = new HashMap<>();

      //"dvdddfvabcd"

      /* Notes: we want the longest possible substring length without repeating characters
         Ideas: use a hashmap to store chars and their indexes. If a char exists in the map
            AND the index exists in our current substring, update our substring
         Explanation: This is basically the sliding window approach where we have a left and
            right bounds that we scale to only include valid answers.
         EX: dvdf -> vdf is max
         d
         dv
         dvd -> vd (shrink left till we remove duplicate)
         vdf
      */

      for (int i=0; i<s.length(); i++)
      {
         char currChar = s.charAt(i);

         // If we repeat, update start of substring if char exists in current substring
         if (charMap.get(currChar) != null && charMap.get(currChar) >= subStart)
            subStart = charMap.get(currChar)+1;
         
         // Add or update chars in substring
         charMap.put(currChar, i);
         
         // Update longestLength, if necessary
         int currentLength = i+1 - subStart;    // +1 b/c 0 start index
         if (currentLength > longest)
            longest = currentLength;
      }

      return longest;
   }
}