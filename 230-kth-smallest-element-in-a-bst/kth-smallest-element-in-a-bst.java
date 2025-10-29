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
    int cut = 0;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        def(root, k);
        return result;
    }
    public void def(TreeNode root, int k){
        if(root == null) return;
        def(root.left, k);
        cut++;
        if(cut == k){
            result = root.val;
            return;
        }
        def(root.right, k);
    }
}