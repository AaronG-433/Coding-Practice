import java.util.*;

class Solution
{
   public boolean isValid(String s)
   {
      if (s.length() == 1)
         return false;

      // [0] = (), [1] = {}, and [2] = []

      Stack<Character> tempStack = new Stack<>();

      for (int i=0; i<s.length(); i++)
      {
         char current = s.charAt(i);
         
         if (current == '(' || current == ')')
         {
            if (current == '(')
               tempStack.push(current);
            else if (tempStack.isEmpty() || tempStack.peek() != '(')
            {
               return false;
            }
            else
               tempStack.pop();
         }
         else if (current == '{' || current == '}')
         {
            if (current == '{')
               tempStack.push(current);
            else if (tempStack.isEmpty() || tempStack.peek() != '{')
            {
               return false;
            }
            else
               tempStack.pop();

         }
         else if (current == '[' || current == ']')
         {
            if (current == '[')
               tempStack.push(current);
            else if (tempStack.isEmpty() || tempStack.peek() != '[')
            {
               return false;
            }
            else
               tempStack.pop();

         }

      }

      if (!tempStack.isEmpty())
         return false;

      return true; 
   }
}