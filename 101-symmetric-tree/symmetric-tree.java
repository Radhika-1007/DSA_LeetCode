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
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricHelp(root.left, root.right);
    }
    private boolean isSymmetricHelp(TreeNode l, TreeNode r){
        if(l == null || r == null) return l == r;
        if(l.val != r.val) return false;
        return isSymmetricHelp(l.left, r.right) && isSymmetricHelp(l.right, r.left);
    }
}