class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        f(0, nums, new ArrayList<>());
        return res;
    }
    public void f(int i, int nums[], List<Integer> path){
        if(i>=nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[i]);
        f(i+1, nums, path);
        path.remove(path.size() - 1);
        f(i+1, nums, path);
    }
}