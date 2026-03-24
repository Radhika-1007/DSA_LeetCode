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
    int preIndex = 0;
    HashMap<Integer, Integer> mp = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for(int i=0; i<n; i++){
            mp.put(inorder[i], i);
        }
        return f(preorder, 0, n-1);
    }
    public TreeNode f(int preorder[], int left, int right){
        if(left > right) return null;
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        int index = mp.get(rootVal);
        root.left = f(preorder, left, index-1);
        root.right = f(preorder, index+1, right);
        return root;
    }
}