import java.util.*;

class Solution
{
   public List<List<String>> groupAnagrams (String[] strs)
   {
      Map<String, List<String>> map = new HashMap<>();

      for (String s : strs)
      {
         char[] chars = new char[26];
         for (char c : s.toCharArray())
            chars[c - 'a']++;
         
         // Create key and create new entry if not already in map
         String key = String.valueOf(chars);
         if (!map.containsKey(key))
            map.put(key, new ArrayList<>());
         map.get(key).add(s);
      }

      return new ArrayList<>(map.values());
   }
}

// My naieve solution that times out
// List<List<String>> answer = new ArrayList<List<String>>();
//       List<String> subAnswers = new ArrayList<String>();

//       // 1: Only one string so return it
//       if (strs.length == 1)
//       {
//          subAnswers.add(strs[0]);
//          answer.add(subAnswers);
//          return answer;
//       }

//       // Loop through all strings and pair anagrams together
//       Set<String> stringSet = new HashSet<>();
//       for (int i=0; i<strs.length; i++)   // Loop through every string
//       {
//          String current = strs[i];

//          // If we have already added the string, continue to next string
//          if (stringSet.contains(current))
//             continue;

//          // Loop through current string and count each char
//          char[] values = new char[26];
//          for (int j=0; j<current.length(); j++)
//             values[current.charAt(j)-'a']++;

//          // Loop through all remaining strings and pair anagrams
//          for (int w=i+1; w<strs.length; w++)
//          {
//             // Check if we already added this string
//             String sub = strs[w];
//             if (stringSet.contains(sub) || current.length() != sub.length())
//                continue;

//             // Clone char count of current string
//             char[] temp = values.clone();
//             // If we find an anagram, add it to hashset so we don't compare twice

//          }
//          // Add paired anagrams to answer
//          subAnswers.add(current);
//          answer.add(subAnswers);

//          // Clear variable and store string
//          stringSet.add(current);
//          subAnswers.clear();
//       }


//       return answer;