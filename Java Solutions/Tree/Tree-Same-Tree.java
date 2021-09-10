/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution
{
   public boolean isSameTree(TreeNode p, TreeNode q)
   {

      // Null checks
      if ( (p == null && q != null) || (p != null && q == null) )
         return false;

      if (p == null && q == null)
         return true;


      // Check if values are equal
      if (p.val == q.val)
         return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
      else
         return false;
   }
}