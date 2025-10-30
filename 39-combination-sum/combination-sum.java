class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        f(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
    public void f(int[] candidates, int target, int i, List<Integer> ds, List<List<Integer>> ans){
        if(i==candidates.length){
            if(target == 0){
            ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(candidates[i] <= target){
            ds.add(candidates[i]);
            f(candidates, target-candidates[i], i, ds, ans);
            ds.remove(ds.size() - 1); 
        }
        f(candidates, target, i+1, ds, ans);
    }
}