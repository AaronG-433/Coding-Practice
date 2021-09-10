import java.util.*;

class Solution
{
   /* Notes: Knowing how much money is in each house, what's the max money I can steal tonight
      Constraints: all robberies happen tonight so no 2 adjacent house can be hit
   */

   public int rob(int[] nums)
   {
      // return tabulation(nums);

      // Create memo to store calculated values (fill with -1 for check)
         // Note: can use a hash map instead of memo where <key,value> = <index, money>
      int[] memo = new int[nums.length];
      Arrays.fill(memo, -1);
      int houseToRob = nums.length-1;
      return memoization(nums, memo, houseToRob);
   }

   // Top down
   private int memoization(int[] nums, int[] memo, int house)
   {
      // Return already calculated values
      if (memo[house] != -1)
         return memo[house];

      // Base case
      if (house == 0)
         return memo[0] = nums[0];
      else if (house == 1)
         return memo[1] = Math.max(nums[0], nums[1]);

      // Calculate value by choosing max b/t previous two houses
      return memo[house] = Math.max( memoization(nums, memo, house-1), 
         nums[house] + memoization(nums, memo, house-2) );
   }

   // Bottom up: Passed with 100% faster speed
   private int tabulation (int[] nums)
   {
      int[] dpTable = new int[nums.length];

      // Valid length check
      if (nums.length == 1)
         return nums[0];
      
      // Base cases
      dpTable[0] = nums[0];
      dpTable[1] = Math.max(nums[0], nums[1]);

      // At every point, check if previous > current+nums[previous-1] and choose max
      for (int i=2; i < nums.length; i++)
         dpTable[i] = Math.max(dpTable[i-1], nums[i] + dpTable[i-2] );

      return dpTable[nums.length-1];
   }
}