import java.util.*;

/*
   Notes: 
   Ideas:
      1) Use a hashset for wordDict and loop through string, creating substring and 
         checking if word is in dict as we go
         - Problem: if we have similiar words like 'cat' and 'cats', this will not work
      2) Use a double for loop where i is the right bounds and j increments up to i. If a
         word is found, increase count at that point.
*/


class Solution
{
   public boolean wordBreak(String s, List<String> wordDict)
   {
      return tabulation(s, wordDict);
   }

   ////// TODO: Top down approach
   private boolean memoization(String s, List<String> wordDict)
   {
      return false;
   }

   // Bottom up approach using a 1D array
   private boolean tabulation(String s, List<String> wordDict)
   {
      // Start from left to right, propagate true if words in dict are found
      boolean [] indexTrack = new boolean[s.length()];
      for (int i=0; i < s.length(); i++)
      {
         for (int w=0; w <= i; w++)
         {
            if ( wordDict.contains( s.substring(w, i+1) ) )
            {
               if (w > 0)
                  indexTrack[i] = indexTrack[i] || indexTrack[w-1];    // Set current = to past value
               else
                  indexTrack[i] = true;
            }
         }
      }
      
      return indexTrack[s.length()-1];
   }
}