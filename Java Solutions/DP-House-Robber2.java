import java.util.*;

class Solution
{
   /* Notes:
      Problem: houses in a circle, can't rob adjacent house, how do we get max money
      Issues: no set start due to looping, must take into account at start of program
   */

   public int rob(int[] nums)
   {
      return tabulation(nums);
   }

   // Bottom up
   private int tabulation (int[] nums)
   {
      // Length check
      if (nums.length == 1)
         return nums[0];
      if (nums.length == 2)
         return Math.max(nums[0], nums[1]);

      // Since we have a loop of houses, we know we can't have the first and last houses
      // So, do house robber from 0 to length-2 and then 1 to length-1 to account for this
      // Return the max of these two
      
      // Start from first house at [0] to 2nd to last house
      int[] table = new int[nums.length];
      // int prev1 = 0;
      // int prev2 = nums[0];
      table[0] = nums[0];
      table[1] = Math.max(nums[0], nums[1]);
      for (int i=2; i <= nums.length-2; i++)
         table[i] = Math.max(table[i-1], nums[i] + table[i-2]);
      
      int max = table[nums.length-2];

      // Start from second house to last house
      Arrays.fill(table, 0);
      table[1] = nums[1];
      table[2] = Math.max(nums[1], nums[2]);
      for (int i=3; i <= nums.length-1; i++)
      {
         table[i] = Math.max(table[i-1], nums[i] + table[i-2]);
      }

      return Math.max(max, table[nums.length-1]);
   }

   private int memoization (int[] memo, int[] nums, int house)
   {
      return 0;
   }
}