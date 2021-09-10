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
   // Try with Global then w/o
   TreeNode inverted = new TreeNode();

   public TreeNode invertTree(TreeNode root)
   {     
      swapChildren(root);

      return root;
   }

   private void swapChildren(TreeNode currNode)
   {
      if (currNode == null)
         return;
      
      // Swap children
      TreeNode temp = currNode.right;

      currNode.right = currNode.left;
      currNode.left = temp;

      // Swap children of this nodes children
      swapChildren(currNode.left);
      swapChildren(currNode.right);
   }
}