import java.util.*;

class Solution {
   public int[] twoSum(int[] nums, int target)
   {
      // Create hashmap to store know values
      Map<Integer, Integer> seenNums = new HashMap<Integer, Integer>();

      // Loop through nums and check if target - newValue = seenValue in map
      for (int i=0; i < nums.length; i++)
      {
         int remainder = target - nums[i];

         if (seenNums.containsKey(remainder))      // If existing remainder, return both
            return new int[] {seenNums.get(remainder), i};
         else
            seenNums.put(nums[i], i);
      }

      return new int[] {0,0};
   }
}