import java.util.*;

class Solution {
   public int climbStairs(int n)
   {
      int distinctWays[] = new int [n+1];

      // Must explicity add 1st and 2nd values
      distinctWays[1] = 1;

      // Initial check
      if (n == 1)
         return distinctWays[1];
      
      distinctWays[2] = 2;

      // Add previous two values to calculate the current number of distinct ways
      for (int i=3; i<=n; i++)
         distinctWays[i] = distinctWays[i-1] + distinctWays[i-2];

      return distinctWays[n];
   }
}