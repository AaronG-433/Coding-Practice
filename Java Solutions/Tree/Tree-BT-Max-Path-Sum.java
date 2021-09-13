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
   int maxSum = -1000;
   public int maxPathSum(TreeNode root)
   {
      // If root is a leaf, return root
      if (root.left == null && root.right == null)
         return root.val;

      maxCalc(root);

      return maxSum;
   }

   // Return largest child sequence that can include the parent
   private int maxCalc (TreeNode root)
   {
      // Check if current node, by itself, is greater than maxSum (good for negatives)
      if (root.val > maxSum)
         maxSum = root.val;

      // When we reach a leaf, return it
      if (root.left == null && root.right == null)
         return root.val;

      int left = -1000;
      // If not leaf, call sum on left and right leaves (if they exist)
      if (root.left != null)
         left = maxCalc(root.left);

      int right = -1000;
      if (root.right != null)
         right = maxCalc(root.right);

      // Calculate child sequences
      int childSequence = left + root.val + right;
      int leftSeq = left + root.val;
      int rightSeq = root.val + right;

      // Compare with left and right sequences to find current max possible
      int currMax = Math.max( childSequence, Math.max(leftSeq, rightSeq));

      // Check if child sequence is larger
      maxSum = Math.max(maxSum, currMax);

      return root.val + Math.max(0, Math.max(left, right));
   }
}