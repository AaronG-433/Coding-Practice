import java.util.*;


// Personal attempt with some guidance
class Solution
{
   public int coinChange(int[] coins, int amount)
   {
      int numOfCoins[] = new int[amount+1];

      // For every coin, subtract from an amount
         // Then, check if new min can be found via previousValues+1

      for (int tempAmount=1; tempAmount <= amount; tempAmount++)
      {
         int minNum = amount+1;  // Amount+1 as amount is the maximum possible
         for (int coin : coins)
         {
            if (coin <= tempAmount)    // Subtract the coin if possible
            {  // Then check if tempAmount-coin exists
               minNum = Math.min(minNum, numOfCoins[tempAmount-coin] + 1);
            }
         }

         numOfCoins[tempAmount] = minNum;
      }

      return (numOfCoins[amount] ==  amount+1 ? -1 : numOfCoins[amount]);
   }
}