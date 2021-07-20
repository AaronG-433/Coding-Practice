import java.util.*;

///////////////////// Note: this method can work but it keeps timing out
class Solution {
   public List<List<Integer>> threeSum(int[] nums)
   {
      // Initialize return variable
      HashSet<List<Integer>> tripletsSet = new HashSet<>();
      
      // Loop through all numbers and perform 2 sum on them
      for (int i=0; i < nums.length; i++)
      {
         int target = nums[i];
         Map<Integer, Integer> seenValues = new HashMap<Integer, Integer>();
         for (int w=0; w < nums.length; w++)
         {
            // If w is same as i, skip
            if (i != w)
            {
               int remainder = - target - nums[w];
               // If the value exists, add 3 values together, sort, then add to triplets
               if (seenValues.containsValue(remainder))
               {
                  List<Integer> temp = Arrays.asList(target, nums[w], remainder);
                  Collections.sort(temp);
                  tripletsSet.add(temp);
               }
               
               seenValues.put(w, nums[w]);
            }
         }
      }

      // remove duplicates by adding them to a set then back to the list
      List<List<Integer>> triplets = new ArrayList<>(tripletsSet);
      
      return triplets;
   }
}