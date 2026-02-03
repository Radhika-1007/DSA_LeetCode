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
    int cut = 0, result;
    public int kthSmallest(TreeNode root, int k) {
        f(root, k);
        return result;
    }
    public void f(TreeNode root, int k){
        if(root == null) return;
        f(root.left, k);
        cut++;
        if(cut == k){
            result = root.val;
        }
        f(root.right, k);
    }
}