import java.util.*;

// Naive: Double for loop for O(n^2) time
// Note: last value is always 0
class Solution1
{
   public int[] dailyTemperatures(int[] temperatures)
   {
      int[] daysTillWarmer = new int[temperatures.length];

      // Initial check, if only 1 day then return 0
      if (temperatures.length == 1)
         return daysTillWarmer;

      // Loop through array twice
      for (int i=0; i<temperatures.length-2; i++)
      {
         // Loop until greater value or end of array is reached
         int w=i+1;
         while (w < temperatures.length-1 && temperatures[i] >= temperatures[w])
            w++;
         
         // Add number of days if warmer day found
         if (temperatures[i] < temperatures[w])
            daysTillWarmer[i] = w-i;
      }

      return daysTillWarmer;
   }
}

// Better: Use a stack for O(n) time and space complexity
class Solution2
{
   public int[] dailyTemperatures(int[] temperatures)
   {
      int tempsLength = temperatures.length;
      int[] answer = new int[tempsLength];   // int arrays in java initialize to 0 for all cells
      Stack<Integer> stack = new Stack<>();
      
      // Loop array from right to left and store indices in stack pointing to warmer day
      // If stack is empty, push current indice onto stack and store 0 in answer[i]
      // If not empty, check if temp[i] >= temp[stack]
         // If yes, pop stack and push i then store 0 in answer[i]
         // If no, push i onto stack and store i-stack in answer[i]
      
      for (int i=tempsLength-1; i >= 0; i--)
      {
         if (stack.isEmpty())
            stack.push(i);
         else
         {
            // Go through stack until larger number is found or stack becomes empty
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()])
               stack.pop();
            
            if (!stack.isEmpty() && temperatures[i] < temperatures[stack.peek()])
               answer[i] = stack.peek() - i;
               
            stack.push(i);
         }
      }

      return answer;
   }
}

// Alternate faster: use an extra array to keep track of the indices of future warmer days
   // to make O(n) time and space complexity
class Solution
{
   public int[] dailyTemperatures(int[] temperatures)
   {
      int tempsLength = temperatures.length;
      int[] answer = new int[tempsLength];   // int arrays in java initialize to 0 for all cells
      int[] indexes = new int[tempsLength];  // Points towards last big number

      if (tempsLength == 1)
         return answer;

      // Initialize last value in indexes to -1 as a last seen max indicator
      indexes[tempsLength-1] = -1;

      int currTemp;
      int comparePtr;
      int distance;  // distance between current and compare temps

      for (int i=tempsLength-2; i >=0; i--)
      {
         currTemp = temperatures[i];
         comparePtr = i+1;
         distance = 1;

         // We loop through the indexes until we find a warmer day or the hottest day
            // we have currently seen indicated by indexes = -1
            // Each index is only looped over once so O(1) time
         while (indexes[comparePtr] != -1 && currTemp >= temperatures[comparePtr])
         {
            distance += answer[comparePtr];     // add distances as we compare days
            comparePtr = indexes[comparePtr];   // look at next warmest day
         }

         // If current is greater, set as new max. 
         if (currTemp >= temperatures[comparePtr])
            indexes[i] = -1;
         else  // save distance from current to warmer day
         {
            answer[i] = distance;
            indexes[i] = comparePtr;
         }
      }

      return answer;
   }
}