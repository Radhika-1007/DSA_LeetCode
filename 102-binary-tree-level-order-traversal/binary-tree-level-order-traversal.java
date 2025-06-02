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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> wrapperList = new LinkedList<>();
        if(root == null) return wrapperList;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelNum = q.size();
            List<Integer> subList = new LinkedList<>();
            for(int i=0; i<levelNum; i++){
                TreeNode curr = q.poll();
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
                subList.add(curr.val);

            }
            wrapperList.add(subList);
        }
        return wrapperList;
    }
}