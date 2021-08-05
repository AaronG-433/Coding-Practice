import java.util.*;

class Solution {
   public int[] productExceptSelf(int[] nums)
   {
      // Create an array and initialize value to max value
      int[] answer = new int[nums.length];

      // Example input: 1, 2, 3, 4
      // 1, 1, 2, 6
      // Go from left to right, storing values then multiplying
      int leftProduct = 1;
      for (int i=0; i < nums.length; i++)
      {
         answer[i] = leftProduct;
         leftProduct = leftProduct * nums[i];
      }

      // 24, 12, 4, 1
      // Go from right to left, storing values then multiplying
      int rightProduct = 1;
      for (int i=nums.length-1; i >= 0; i --)
      {
         answer[i] = answer[i] * rightProduct;
         rightProduct = rightProduct * nums[i];
      }

      return answer;
   }
}

///////// O(2n) space complexity
// class Solution {
//    public int[] productExceptSelf(int[] nums)
//    {
//       // Create an array and initialize value to max value
//       int[] leftSide = new int[nums.length];
//       int[] rightSide = new int[nums.length];
//       int[] answer = new int[nums.length];

//       int leftProduct = 1;
//       for (int i=0; i < nums.length; i++)
//       {
//          leftSide[i] = leftProduct;
//          leftProduct = leftProduct * nums[i];
//       }

//       int rightProduct = 1;
//       for (int i=nums.length-1; i >= 0; i --)
//       {
//          rightSide[i] = rightProduct;
//          rightProduct = rightProduct * nums[i];

//          answer[i] = leftSide[i] * rightSide[i];
//       }

//       return answer;
//    }
// }