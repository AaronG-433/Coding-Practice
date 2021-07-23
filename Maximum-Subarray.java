import java.util.*;

class Solution {
   public int maxSubArray(int[] nums)
   {
      int largestSum = nums[0];
      int currentSum = nums[0];

      for (int i=1; i<nums.length; i++)
      {
         currentSum += nums[i];

         // Update currentSum if current num is greater than sum
         // if (nums[i] > currentSum)
         //    currentSum = nums[i];
         currentSum = Integer.max(currentSum, nums[i]);

         // Update largest if current is greater
         // if (largestSum < currentSum)
         //    largestSum = currentSum;
         largestSum = Integer.max(currentSum, largestSum);
      }

      return largestSum;
   }
}