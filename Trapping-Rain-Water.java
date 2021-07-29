import java.util.*;


// Personal solution that runs in O(n) time but takes O(n) space complexity
class Solution
{
   public int trap(int[] height)
   {
      int trappedWater = 0;

      // Initial check
      if (height.length < 3)  // No possible way to trap water with only 2 bars
         return 0;
      
      // Ex: 5 4 3 2 1 0 1 2 3 4 5
         // potential = 0+1+2+3+4+5+4+3+2+1+0
      int[] possibleWaterLeft = new int[height.length];
      int leftMax = 0;
      int[] possibleWaterRight = new int[height.length];
      int rightMax = 0;

      int w=height.length-1;
      for (int i=0; i < height.length-1; i++)
      {
         if (height[i] > leftMax)
            leftMax = height[i];
         
         if (height[w] > rightMax)
            rightMax = height[w];
         
         possibleWaterLeft[i] = leftMax - height[i];

         possibleWaterRight[w] = rightMax - height[w];

         w--;
      }

      // Loop through and add minimum to trappedWater
      for (int i=0; i < height.length-1; i++)
      {
         trappedWater += Math.min(possibleWaterLeft[i], possibleWaterRight[i]);
         System.out.println("I: " + i + "; Left: " + possibleWaterLeft[i] +
            "; Right: " + possibleWaterRight[i]);
      }

      return trappedWater;
   }
}