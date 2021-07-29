import java.util.*;

///////////////////// Note: this method could work but it timeouts when testing
   // more time consuming, O(n^2) with lots of O(1) functions
class Solution2 {
   public List<List<Integer>> threeSum(int[] nums)
   {
      // Initialize return variable
      HashSet<List<Integer>> tripletsSet = new HashSet<>();

      // Add size 3 check because the loop doesn't work for this
      if (nums.length == 3 && (nums[0] + nums[1] + nums[2] == 0))
         return Arrays.asList(Arrays.asList(nums[0], nums[1], nums[2]));
      
      // Loop through all numbers and perform 2 sum on them on each as a target
      for (int i=0; i < nums.length-2; i++)
      {
         int target = nums[i];
         Map<Integer, Integer> seenValues = new HashMap<Integer, Integer>();
         for (int w=i+1; w < nums.length-1; w++)
         {
            int remainder = - target - nums[w];
            System.out.println("I: " + i + "; W: " + w);
            
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

      // remove duplicates by adding them to a set then back to the list
      List<List<Integer>> triplets = new ArrayList<>(tripletsSet);
      
      return triplets;
   }
}

//// Guided solution following the 2 pointer solution (faster and easier to understand)
// https://www.youtube.com/watch?v=nZyzf4ZxHWA
class Solution {
   public List<List<Integer>> threeSum(int[] nums)
   {
      // Initial check
      if (nums.length < 3)
         return new ArrayList<>();

      // First sort the array in O(nlogn) time
      Arrays.sort(nums);

      // Now that it's sorted, we know that we want num1+num2+num3=0 so we need to add
         // positive and negative numbers
      
      // Use a hash set to remove possible duplicates
      Set<List<Integer>> triplets = new HashSet<>();

      // We need two loops with 3 total pointers: one for the initial value and two more
         // that we move to make sum=0
      for (int i=0; i < nums.length-2; i++)
      {
         int left = i+1;
         int right = nums.length-1;

         // Due to the array being sorted, we can increase sum by incrementing left OR
            // decrease sum by decrementing right
         while (left < right)
         {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum == 0)
            {
               triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));

               // Move pointers because solution for these numbers was found
               left++;
               right--;
            }
            else if (sum < 0)
               left++;  // Increase sum
            else
               right--; // Decrease sum
         }
      }

      return new ArrayList<>(triplets);
   }
}