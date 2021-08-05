import java.util.*;

class Solution
{
   public int search(int[] nums, int target)
   {
      // Search through an ascending sorted array for the target int
      // The array can be rotated around a pivot

      // Null check
      if (nums.length == 0)
         return -1;

      // Length of 1 check
      if (nums.length == 1)
      {
         if (nums[0] == target)
            return 0;
         else
            return -1;
      }

      int pivotIndex = findPivotIndex(nums);
      System.out.println("Minimum: " + nums[pivotIndex] + "; Pivot: " + pivotIndex);

      // Discover if target exists
      int targetIndex = findTarget(nums, pivotIndex, target);
      

      return targetIndex;
   }

   private int findPivotIndex (int[] nums)
   {
      int left = 0;
      int right = nums.length-1;

      // Sorted check with no rotation
      if (nums[0] < nums[nums.length-1])
         return nums.length-1;   // Return end of array so checks "left side" which is entire array

      // Binary search to find the "pivot", or maximum value
      while (left < right)
      {
         int mid = left + (right - left)/2;
         
         // Ex: [4 5 0 1 2 3], pivot in left side
         // Because sorted, all previous elements should be greater than current element
            // except for the pivot value
         if (nums[mid] > nums[(mid+1) % nums.length]) // Ex: ...,5,0,...
            return mid;
         else if (nums[(mid-1) % nums.length] > nums[mid])  // Ex: ...,5,0,...
            return (mid-1) % nums.length;
         else if (nums[left] > nums[mid])
            right = mid-1;
         else
            left = mid+1;
      }

      return -1;  // Should never reach here
   }

   private int findTarget (int[] nums, int pivotIndex, int target)
   {
      int targetIndex = -1;
      int left, right;

      if (target < nums[0])      // 7 0 1 2 3 4 5 6   // 1 3
      {
         // Check the pivot+1 to the end of array (right side of pivot)
         left = pivotIndex+1;
         right = nums.length-1;
      }
      else
      {
         // Check the start up to and including pivot (left side of pivot)
         left = 0;
         right = pivotIndex;
      }

      // Binary search
      while (left <= right)
      {
         int mid = left + (right - left)/2;

         if (nums[mid] == target)   // Value exists and is found
            return mid;
         else if (nums[mid] < target)
            left = mid+1;
         else
            right = mid-1;

         System.out.println("Left: " + left + "; Right: " + right);
      }

      return targetIndex;
   }
}