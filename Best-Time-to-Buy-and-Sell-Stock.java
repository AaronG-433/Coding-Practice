import java.util.*;

class Solution {
public int maxProfit(int[] prices)
   {
      // Loop once with two pointers, one to buy (low) and one for current index (i)

      int minimum = Integer.MAX_VALUE;
      int profit = 0;

      for (int i=0; i < prices.length; i++)
      {
         // if (minimum > prices[i])
         //    minimum = prices[i];
         // else if(prices[i] - minimum > profit)
         //    profit = prices[i] - minimum;

         // If stock is less than minimum, update minimum
         minimum = Math.min(minimum, prices[i]);

         // If current stock can be sold for more profit, update
         profit = Math.max(profit, prices[i] - minimum);
      }

      return profit;
   }
}