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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        boolean ltor = true;
        while(!qu.isEmpty()){
            int size = qu.size();
            List<Integer> ll = new ArrayList<>();
            for(int i = 0; i<size; i++){
                TreeNode node = qu.poll();
                if(ltor)ll.add(node.val);
                else ll.add(0, node.val);
                if(node.left != null){
                    qu.add(node.left);
                }
                if(node.right != null){
                    qu.add(node.right);
                }
            }
            ltor = !ltor;
            result.add(ll);
        }
        return result;
    }
}