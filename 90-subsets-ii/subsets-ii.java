class Solution {
    List<List<Integer>> res;
    int n;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        n = nums.length;
        Arrays.sort(nums);
        f(0, nums, new ArrayList<>(), res);
        return res;
    }
    public void f(int idx, int nums[], List<Integer> path, List<List<Integer>> res){
        res.add(new ArrayList<>(path));
        for(int i=idx; i<n; i++){
            if(i>idx && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            f(i+1, nums, path, res);
            path.remove(path.size()-1);
        }
    }
}