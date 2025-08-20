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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        return helper(inorder, root);
    }
    public List<Integer> helper(List<Integer> inorder, TreeNode root){
        if(root == null) return inorder;
        helper(inorder, root.left);
        inorder.add(root.val);
        helper(inorder, root.right);
        return inorder;
    }
}