class Solution {
    public void dfs(int i, int nums[], List<Integer> path,       List<List<Integer>> res){
        if(i == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        //include
        path.add(nums[i]);
        dfs(i+1, nums, path, res);
        //exclude
        path.remove(path.size() - 1);
        dfs(i+1, nums, path, res);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, nums, path, res);
        return res;
    }
}