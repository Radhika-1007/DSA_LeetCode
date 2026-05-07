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
    class Tuple{
        TreeNode node;
        int row, col;
        Tuple(TreeNode n, int r, int c){
            node = n;
            row = r;
            col = c;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));
        while(!q.isEmpty()){
            Tuple curr = q.poll();
            TreeNode node = curr.node;
            int col = curr.col;
            int row = curr.row;
            mp.putIfAbsent(col, new TreeMap<>());
            mp.get(col).putIfAbsent(row, new PriorityQueue<>());
            mp.get(col).get(row).offer(node.val);
            if(node.left != null){
                q.offer(new Tuple(node.left, row+1, col-1));
            }
            if(node.right != null){
                q.offer(new Tuple(node.right, row+1, col+1));
            }
        }
        for(TreeMap<Integer, PriorityQueue<Integer>> rows: mp.values()){
            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> pq: rows.values()){
                while(!pq.isEmpty()) list.add(pq.poll());
            }
            ans.add(list);
        }
        return ans;
    }
}