import java.util.*;


class Solution
{
   public int[] productExceptSelf(int[] nums)
   {
      // Idea: go from right to left then left to right, multiplying values at each point as you go
      int[] answer = new int[nums.length];
      Arrays.fill(answer, 1);

      // Go from right to left, keeping the products as you go
      int right = 1;
      int left = 1;
      int end = nums.length-1;
      for (int start=0; start<=nums.length-1; start++)
      {
         // Store products into answer
         answer[start] *= left;
         answer[end] *= right;

         // Update products
         left *= nums[start];
         right *= nums[end];
         
         end--;
      }

      return answer;
   }
}