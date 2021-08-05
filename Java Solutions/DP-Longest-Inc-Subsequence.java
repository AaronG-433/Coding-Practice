import java.util.*;

class Solution
{
   public int lengthOfLIS(int[] nums)
   {
      int[] longestArr = new int[nums.length];
      Arrays.fill(longestArr, 1);   // Fill with 1 as that is the lowest possible value
      int longest = 1;

      // We want longest increaseing subsequence so in order but elements can be removed
      // Constraints: can't change order, going from lowest to highest
      // We want to store the previous longest sequence ending and count at that point
      // Reset count upon finding lower value and store new count as you go

      // Bottom up approach no guidance
      // Use i as your right bounds and calculate longest sequence
      // As we calculate, we use past stored values to check if a longer sequence was seen
      for (int i=1; i <= nums.length-1; i++)
      {
         for (int j=0; j<i; j++)
         {
            if (nums[i] > nums[j])  // If current value at j less, check if past sequence greather
               longestArr[i] = Math.max(longestArr[i], longestArr[j] +1);
         }
         longest = Math.max(longest, longestArr[i]);
      }


      //Ex: [10 11 12 13 14 6 7 8 15 1000 2000 30 40 50]
      //                                          i   j
      //                                       i  2   1
      //                                   i   3  2   1
      //                               i   1   3  2   1
      //                           i   2   1   3  2   1
      //                        i  4   2   1   3  2   1
      //                      i 5  4   2   1   3  2   1
      
      // Top down approach with guided assistance
      // for (int i=nums.length-2; i >= 0; i--)
      // {
      //    for (int j=nums.length-1; j > i; j--)
      //    {
      //       if (nums[j] > nums[i])
      //          longestArr[i] = Math.max(longestArr[i], longestArr[j] +1);
      //    }
      //    longest = Math.max(longest, longestArr[i]);
      // }

      return longest;
   }
}