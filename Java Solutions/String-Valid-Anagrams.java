import java.util.*;

class Solution
{
   public boolean isAnagram(String s, String t)
   {
      Map<Character, Integer> sMap = new HashMap<>();

      if (s.length() != t.length())
         return false;

      for (int i=0; i<s.length(); i++)
      {
         char sChar = s.charAt(i);
         if (sMap.containsKey(sChar))
            sMap.put(sChar, sMap.get(sChar)+1);
         else
            sMap.put(sChar, 1);
      }

      for (int i=0; i<t.length(); i++)
      {
         char tChar = t.charAt(i);
         if (!sMap.containsKey(tChar) || sMap.get(tChar) == 0)
            return false;
         else
            sMap.put(tChar, sMap.get(tChar)-1);
      }

      return true;
   }
}