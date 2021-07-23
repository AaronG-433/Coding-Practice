import java.util.*;

class Solution {
   public int maxProduct(int[] nums)
   {
      int largestProduct = Integer.MIN_VALUE;
      int leftProduct = 1;
      int rightProduct = 1;

      // -1, 2, 3, -2, -4

      // Zero checks:
         // -1, 2, 3, 0, 3, 2, -1
         // -1, -2, -3, 0
         // -1, 0, -2, -3, 0
      // -1, 2, 3, 4, 5, -6
      // Count the number of negatives

      // 0, even, or odd negatives; if even, then can multiply everything escept if 0
      // If odd, max is either from left to right or right to left

      // Grab products from left to right and right to left, updating max as you go
         // This takes into account an odd number of negatives and 0 value by comparing
         // both products at every point and updating max as you go
         // Reset counters at 0 to account for edge cases (EX: -1, 2, 3, 0)
      for (int i=0; i < nums.length; i++)
      {
         leftProduct *= nums[i];
         rightProduct *= nums[nums.length - i - 1];

         largestProduct = Integer.max(largestProduct, Integer.max(leftProduct, rightProduct));

         // Reset products after a 0 is reached
         if (nums[i] == 0)
            leftProduct = 1;

         if (nums[nums.length - i - 1] == 0)
            rightProduct = 1;
      }

      return largestProduct;
   }
}