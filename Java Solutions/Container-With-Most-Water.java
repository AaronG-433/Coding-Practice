import java.util.*;

class Solution
{
   public int maxArea(int[] height)
   {
      // We have points (i, ai) and want max Area = height * width
      // Height = min(ai1, ai2) and Width = i2 - i1 where point 2 is to the right of point 1

      // Initial check
      if (height.length == 2)
         return Math.min(height[0], height[1]);

      // Loop through and
      int left = 0;
      int right = height.length-1;
      int max = Math.min(height[left], height[right]) * (right-left);
      while (left < right)
      {
         // Keep larger height and shift the lower height b/c we are capped at the lower height
         if (height[left] < height[right])  // If heights are equal, shift right
            ++left;
         else
            --right;

         int current = Math.min(height[left], height[right]) * (right-left);
         max = Math.max(max, current);
      }

      return max;
   }
}