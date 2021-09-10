import java.util.*;

class Solution
{
   public boolean isPalindrome (String s)
   {
      // Create input by only adding alpha numeric characters
      int left = 0;
      int right = s.length()-1;
      while (left <= right)
      {
         char leftChar = s.charAt(left);
         char rightChar = s.charAt(right);
         
         if (!isAlphanumeric(leftChar))
            left++;
         else if (!isAlphanumeric(rightChar))
            right--;
         else
         {
            leftChar = Character.toLowerCase(leftChar);
            rightChar = Character.toLowerCase(rightChar);
            System.out.println(leftChar + "  " + rightChar);
            if (leftChar != rightChar)
               return false;
            else
            {
               left++;
               right--;
            }
         }
      }

      return true;
   }

   private boolean isAlphanumeric (char c)
   {
      if ( ('0' <= c && c <= '9') || ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z'))
         return true;
      else
         return false;
   }
}