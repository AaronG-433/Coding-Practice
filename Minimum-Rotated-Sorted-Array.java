import java.util.*;

class Solution
{
   int minimum = Integer.MAX_VALUE;
   int[] inputNums;

   public int findMin(int[] nums)
   {
      inputNums = nums;
      int numsLength = nums.length-1;

      if (nums[0] <= nums[numsLength])
         minimum = nums[0];
      else
         binarySearch(0, numsLength);

      return minimum;
   }

   // 10 11 12 13 14 0 1 2 3 4 5 6 7 8 9
   private void binarySearch(int left, int right)
   {
      if(left < right)    // Calculate the index values
      {
         int mid = left + (right - left)/2;

         if (inputNums[mid] > inputNums[left])
            binarySearch(mid, right);  // Check right side
         else
            binarySearch(left, mid);   // Check left side
      }
      else if (left == right)
         minimum = inputNums[left+1];  // Add +1 because if mid is the answer, left will be
            // be given due to round down for Java
      
      return;
   }
}