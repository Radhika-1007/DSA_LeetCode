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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ll = new ArrayList<>();
        postorder(root, ll);
        return ll;
    }
    private void postorder(TreeNode node, List<Integer> ll){
        if(node == null) return;
        postorder(node.left, ll);
        postorder(node.right, ll);
        ll.add(node.val);
    }
}