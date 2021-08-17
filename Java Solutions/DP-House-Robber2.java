import java.util.*;

class Solution
{
   /* Notes:
      Problem: houses in a circle, can't rob adjacent house, how do we get max money
      Issues: no set start due to looping, must take into account at start of program
   */

   public int rob(int[] nums)
   {
      // return tabulation(nums);

      int[] memo = new int[nums.length];
      Arrays.fill(memo, -1);
      int rob1

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

      int rob1 = robMax(nums, 0, nums.length-2);
      int rob2 = robMax(nums, 1, nums.length-1);

      return Math.max(rob1, rob2);
   }

   // Return most money we can rob from start to end interval of houses
   private int robMax(int[] nums, int start, int end)
   {
      int prev2 = nums[start];
      int prev1 = Math.max(nums[start], nums[start+1]);
      for (int i=start+2; i <= end; i++)
      {
         int current = Math.max(prev1, nums[i] + prev2);
         prev2 = prev1;
         prev1 = current;
      }

      return prev1;
   }

   private int memoization (int[] memo, int[] nums, int house)
   {
      return 0;
   }
}