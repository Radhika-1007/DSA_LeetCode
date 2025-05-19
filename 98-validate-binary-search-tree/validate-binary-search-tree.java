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
class Solution {
    public boolean isValidBST(TreeNode root) {
        return ValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean ValidBST(TreeNode root, long minV, long maxV){
        if(root == null) return true;
        if(root.val >= maxV || root.val <= minV) return false;
        return ValidBST(root.left, minV, root.val) && ValidBST(root.right, root.val, maxV);

    }
}