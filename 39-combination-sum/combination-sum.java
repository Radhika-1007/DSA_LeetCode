class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combine = new ArrayList<>();
        f(0, target, candidates, combine, new ArrayList<>());
        return combine;
    }
    public void f(int i, int target, int candidates[], List<List<Integer>> combine, List<Integer> path){
        if(i == candidates.length){
            if(target == 0){
                combine.add(new ArrayList<>(path));
            }
            return;
        }
        if(candidates[i] <= target){
            path.add(candidates[i]);
            f(i, target - candidates[i], candidates, combine, path);
            path.remove(path.size()-1);
        }
        f(i+1, target, candidates, combine, path);
    }
}