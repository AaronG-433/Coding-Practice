import java.util.*;

class Solution
{
   public int combinationSum4(int[] nums, int target)
   {
      //return tabulation(nums, target);


      int[] memo = new int[target+1];
      Arrays.fill(memo, -1);
      memo[0] = 1;
      return memoization(memo, nums, target);
   }

   // Bottom up approach: 
   private int tabulation(int[] nums, int target)
   {
      int[] table = new int[target+1];

      // Base case
      table[0] = 1;
      
      // Calculate all possible solutions for every possible remainder (ignore 0)
      for (int remain = 1; remain <= target; remain++)
      {
         int possibleCombos = 0;
         for (int num : nums)    // 1 2 3
         {
            // If number is greater than remainder, skip
            if (num > remain)
               continue;

            possibleCombos += table[remain-num];
         }
         table[remain] = possibleCombos;
      }

      return table[target];
   }

   // Top down approach
   private int memoization(int[] memo, int[] nums, int remain)
   {
      // If value already calculated, return it
      if (memo[remain] != -1)
         return memo[remain];

      // Use answer variable because memo[remain] = -1
      int answer = 0;
      for (int num : nums)
         if (num <= remain)
            answer += memoization(memo, nums, remain - num);

      memo[remain] = answer;
      return memo[remain];
   }
}