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
    int i=0, n;
    public TreeNode bstFromPreorder(int[] preorder) {
        n = preorder.length;
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public TreeNode build(int preorder[], int min, int max){
        if(i==n) return null;
        int val = preorder[i];
        if(val < min || val > max) return null;
        TreeNode root = new TreeNode(val);
        i++;
        root.left = build(preorder, min, val);
        root.right = build(preorder, val, max);
        return root;
    }
}