/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> res;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        res = new ArrayList<>();
        Map<TreeNode, TreeNode> mp = new HashMap<>();
        buildParent(root, null, mp);
        Set<TreeNode> st = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        st.add(target);
        int level = 0;
        while(!q.isEmpty()){
            if(level == k){
                for(TreeNode node: q) res.add(node.val);
                return res;
            }
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                if(node.left != null && !st.contains(node.left)) {
                    q.offer(node.left);
                    st.add(node.left);
                }    
                if(node.right != null && !st.contains(node.right)){
                    q.offer(node.right);
                    st.add(node.right);
                }
                TreeNode par = mp.get(node);
                if( par != null && !st.contains(par)) {
                    q.offer(par);
                    st.add(par);
                }    
            }
            level++;
        }
        return res;
    }
    public void buildParent(TreeNode node, TreeNode par, Map<TreeNode, TreeNode> mp){
        if(node == null) return;
        mp.put(node, par);
        buildParent(node.left, node, mp);
        buildParent(node.right, node, mp);
    }
}