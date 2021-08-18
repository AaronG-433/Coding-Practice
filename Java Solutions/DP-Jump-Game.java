import java.util.*;

class Solution
{
   /* Problem: We are given an array of our max jump lengths. We want to reach the end
      of the array and return true if possible.
   Notes:
      - We can jump less than the labelled max (Ex: if 3, we can jump 2 and 1 as well)

   */

   public boolean canJump(int[] nums)
   {
      return tabulation(nums);
   }

   private boolean tabulation(int[] nums)
   {
      int jumpLengthNeeded = 0;

      // Start from the end of the array and go back to the beginning, incrementing a counter
      // as you move past each index to specify jump length needed. If the jump length
      // in the array at the current index is >= the count, that means we can jump so reset
      // the counter for next jump length needed.

      /* Ex: [3,2,1,0,4]
         i=4, count = 0
         i=3, increment count, count=1 >0 so continue
         i=2, inc, count=2 >1, continue
         i=1, inc, count=3 >2, continue
         i=0, inc, count=4 >3, continue
         count ends with a needed jump length of 4 so return false

         Ex: [2,3,1,1,4]
         i=4, count=0
         i=3, increment count,   count=1 = 1 so count=0
         i=2, inc, count=1 =1,   count=0
         i=1, inc, count=1 <3,   count=0
         i=0, inc, count=1 <2,   count=0
         count ends with 0 jumps needed so return true
      */

      for (int i=nums.length-2; i>=0; i--)
      {
         // Increment needed count to reach index
         ++jumpLengthNeeded;
         if (nums[i] >= jumpLengthNeeded)
         jumpLengthNeeded = 0;
      }

      // If we need to jump at this point, we cannot reach the last index of the array
      if (jumpLengthNeeded != 0)
         return false;
      else
         return true;
   }
}