class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        f(0, nums, res, new ArrayList<>());
        return res;
    }
    public void f(int i, int nums[], List<List<Integer>> res, List<Integer> path){
        if(i >= nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[i]);
        f(i+1, nums, res, path);
        path.remove(path.size()-1);
        f(i+1, nums, res, path);
    }
}