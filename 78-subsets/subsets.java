class Solution {
    List<List<Integer>> res;
    int n;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        n = nums.length;
        f(0, nums, new ArrayList<>());
        return res;
    }
    public void f(int i, int nums[], List<Integer> path){
        if(i==n){
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[i]);
        f(i+1, nums, path);
        path.remove(path.size()-1);
        f(i+1, nums, path);
    }
}