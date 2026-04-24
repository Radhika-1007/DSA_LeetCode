class Solution {
    List<List<Integer>> res;
    int n;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        n = candidates.length;
        Arrays.sort(candidates);
        f(0, candidates, target, new ArrayList<>());
        return res;
    }
    public void f(int ind, int nums[], int target, List<Integer> path){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=ind; i<n; i++){
            if(i>ind && nums[i] == nums[i-1]) continue;
            if(nums[i] > target) break;
            path.add(nums[i]);
            f(i+1, nums, target-nums[i], path);
            path.remove(path.size()-1);
        }
    }
}