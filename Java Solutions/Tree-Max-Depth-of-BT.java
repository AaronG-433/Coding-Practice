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

class Solution1
{
   public int maxDepth(TreeNode root)
   {
      int maximumDepth = 0;

      if (root == null)
         return maximumDepth;

      return depthTraversal(root, maximumDepth);
   }

   private int depthTraversal (TreeNode currentNode, int maximumDepth)
   {
      // Increment for current node
      ++maximumDepth;
      int leftDepth = maximumDepth;
      int rightDepth = maximumDepth;
      
      if (currentNode.left != null)
      {
         leftDepth = depthTraversal(currentNode.left, maximumDepth);
      }

      if (currentNode.right != null)
      {
         rightDepth = Math.max(maximumDepth, depthTraversal(currentNode.right, maximumDepth));
      }

      return Math.max(leftDepth, rightDepth);
   }
}

// Can be done in one line but prefer independent null check
class Solution
{
   public int maxDepth(TreeNode root)
   {
      if (root == null)
         return 0;

      return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
   }
}