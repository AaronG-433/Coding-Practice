import java.util.*;

class Solution
{
   /* Problem: Robot in top left of m x n grid. It can only move down or right and is 
      trying to reach the bottom right corner. How many unique paths are there?
   Notes:
      - Can only move down or right, not left or up.
      - m is the number of rows and n is the number of columns

   */

   public int uniquePaths(int m, int n)
   {
      return tabulation(m, n);
   }

   private int tabulation (int m, int n)
   {
      // The topmost row and leftmost column are our base cases
      int[][] table = new int[m][n];
      for (int i=0; i<m; i++)
         Arrays.fill(table[i], 1);

      // Loop through every location
      for (int i=1; i<m; i++)
      {
         for (int w=1; w<n; w++)
         {
            // set current square = to the number of available paths from previous squares
            table[i][w] = table[i-1][w] + table[i][w-1];
         }
      }

      return table[m-1][n-1];
   }
}