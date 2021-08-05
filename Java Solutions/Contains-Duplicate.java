import java.util.*;

class Solution {
public boolean containsDuplicate(int[] nums)
   {
      // Use a hashset as we don't need to store 2 objects
      Set<Integer> numsSet = new HashSet<>();

      for (int num : nums)
      {
         if (numsSet.contains(num))
            return true;
         else
            numsSet.add(num);
      }

      return false;
   }
}