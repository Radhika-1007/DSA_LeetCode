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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        List<List<Integer>> ans = new ArrayList<>();

        for (int x : queries) {
            List<Integer> res = new ArrayList<>();
            res.add(floor(arr, x));
            res.add(findCeil(arr, x));
            ans.add(res);
        }

        return ans;
    }
    private void inorder(TreeNode root, List<Integer> arr){
        if(root == null) return;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }
    public int findCeil(List<Integer> arr, int x) {
       int start = 0, end = arr.size() - 1, ans = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr.get(mid) == x) return x;
            else if(arr.get(mid) > x){
                ans = arr.get(mid);
                end = mid-1; 
            }
            else{
                start = mid+1;
            }
        }
        return ans;
        
    }

    public int floor(List<Integer> arr, int x) {
        int start = 0, end = arr.size() - 1, ans = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr.get(mid) == x) return x;
            else if(arr.get(mid) > x){
                end = mid-1; 
            }
            else{
                ans = arr.get(mid);
                start = mid+1;
            }
        }
        return ans;
    }
}