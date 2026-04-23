class Solution {
    List<List<Integer>> res;
    int n;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        n = nums.length;
        int vis[] = new int[n];
        f(0, vis, new ArrayList<>(), nums);
        return res;
    }
    public void f(int ind, int vis[], List<Integer> path, int nums[]){
        if(path.size() == n){
            res.add(new ArrayList<>(path));
        }
        for(int i=0; i<n; i++){
            if(vis[i] == 0){
                vis[i] = 1;
                path.add(nums[i]);
                f(i+1, vis, path, nums);
                path.remove(path.size()-1);
                vis[i] = 0;
            }
        }
    }
}