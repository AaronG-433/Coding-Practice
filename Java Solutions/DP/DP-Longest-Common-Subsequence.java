import java.util.*;


/* Notes:
   Problem: Two strings, return length of longest common subsequence that is in both
   Ideas:
      1) Map all possible subsequences of text1 to a hash set then check all possible
      subsequences in text2 and record the longest length
         - Problem: this is not DP so take this and change it
      2) Use an m x n matrix to keep track of longest common subsequence up to that point
         - This is the tabulation (bottom-up) approach
      3) Use recursive calls to solve using memoization (top-down)
         - This method is significantly slower than tabulation due to recursive calls
*/


class Solution_3_Memoization
{
   // Declare global variable for recursive calls (1000+1 for largest possible strings)
   int longestCommon[][] = new int [1000+1][1000+1];
   String globalText1;
   String globalText2;


   private int maxCommonSub(int i, int w)
   {
      // End reached
      if (i == 0 || w == 0)
         return 0;

      // Value already computed so reference it
      if (longestCommon[i][w] != -1)
         return longestCommon[i][w];

      // Compute value and store it
      if (globalText1.charAt(i-1) == globalText2.charAt(w-1))
         return longestCommon[i][w] = 1 + maxCommonSub(i-1, w-1);
      else
         return longestCommon[i][w] =  Math.max( maxCommonSub(i-1, w), maxCommonSub(i, w-1) );
   }

   public int longestCommonSubsequence(String text1, String text2)
   {
      globalText1 = text1;
      globalText2 = text2;

      // Fill with -1 to help determine if we've already calculated an anwer for a certain cell
      for (int[] array : longestCommon)
         Arrays.fill(array, -1);
      return maxCommonSub(globalText1.length(), globalText2.length());
   }
}

         
class Solution_2_Tabulation
{
   public int longestCommonSubsequence(String text1, String text2)
   {
      // Declare variables
      int length1 = text1.length();
      int length2 = text2.length();
      int longestCommon[][] = new int[length1+1][length2+1];

      // We loop through all of text1 and text2 and reference one char in 1 to all chars in 2
      // Rows are text1 and columns are text2 (so calculate all columns row by row)
      // Can't reference cell directly above or left of current because could be duplicate
         // chars if chars = to each other. So, reference top left diagonal when =

      // So we use a 2D array and reference each char at that point in the string
      // Go from 1->length so we can reference empty cells along i,w = 0
      // EX: "abcde" "adc"
         //     a d c
         //   0 0 0 0
         // a 0 1 1 1
         // b 0 1 1 1
         // c 0 1 1 2
         // d 0 1 2 2
         // e 0 1 2 2


      for (int i=1; i <= length1; i++)   // Loop through text1
      {
         for (int w=1; w <= length2; w++)   // Loop through text2
         {
            if (text1.charAt(i-1) == text2.charAt(w-1))   // If char found, increment diagonal
               longestCommon[i][w] = longestCommon[i-1][w-1] + 1;
            else     // Store longest found in previous cells (left and above cells)
               longestCommon[i][w] = Math.max(longestCommon[i-1][w], longestCommon[i][w-1]);
         }
      }

      return longestCommon[length1][length2];
   }
}


// Solution for idea 1: bad because it is not DP and has a very long time complexity
   // Tried this solution to better understand how to create and compare subsequences
   // and to get a better idea of the worst case time complexity
class Solution_1_Bad
{
   Set<String> text1Subsequences = new HashSet<>();
   int longestSubsequence = 0;

   public int longestCommonSubsequence(String text1, String text2)
   {

      // 1st idea
      // To create all possible subsequences, we go from right to left, using a left
         // incrementing pointer and a right boundary pointer

      /* Ex: abcde
         a
         b ab
         c ac abc
         d ad abd abcd
         e ae abe abce abcde
         Problem: missing b, c, d start subsequences

         Ex: pick and don't pick on abcde
         bcde, a | bcde,""
         cde, ab | cde, a || cde, b | cde, ""
      */
      
      // Find and save all possible subsequences for text1 into a hash set
      findAllSubsequences(text1, "");

      // Compare all subsequences of text2 to saved subsequences of tex and update longest
         // as you go
      compareSubsequences(text2, "");
      return longestSubsequence;
   }

   // At each point, by picking the first char and not picking, we branch and come up with
      // all possible subsequences
   private void findAllSubsequences(String sub, String ans)
   {
      if (sub.length() == 0)
      {
         text1Subsequences.add(ans);
         return;
      }

      // "Pick" the first char, add it to answer, and repeat
      findAllSubsequences(sub.substring(1), ans + sub.charAt(0));

      // "Don't pick" the first char and repeat
      findAllSubsequences(sub.substring(1), ans);
   }

   private void compareSubsequences(String sub, String ans)
   {
      // Update longest if longer subsequence found
      if (text1Subsequences.contains(ans))
         longestSubsequence = Math.max(longestSubsequence, ans.length());

      if (sub.length() == 0)
         return;

      compareSubsequences(sub.substring(1), ans + sub.charAt(0)); // Pick
      compareSubsequences(sub.substring(1), ans); // Don't pick
   }
}