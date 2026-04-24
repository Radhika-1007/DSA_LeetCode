class Solution {
    List<List<Integer>> res;
    int n;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        n = candidates.length;
        f(0, candidates, target, new ArrayList<>());
        return res;
    }
    public void f(int i, int nums[], int target, List<Integer> path){
        if(i==n){
            if(target == 0){
            res.add(new ArrayList<>(path));
            }
            return;
        }
        if(nums[i] <= target){
            path.add(nums[i]);
            f(i, nums, target - nums[i], path);
            path.remove(path.size()-1);
        }
        f(i+1, nums, target, path);
    }
}