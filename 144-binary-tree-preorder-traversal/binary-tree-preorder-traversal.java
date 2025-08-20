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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        return helper(preorder, root);
    }
    public List<Integer> helper(List<Integer> preorder, TreeNode root){
        if(root == null) return preorder;
        preorder.add(root.val);
        helper(preorder, root.left);
        helper(preorder, root.right);
        return preorder;
    }
}