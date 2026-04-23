class Solution {
    List<List<Integer>> res;
    int n;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        n = nums.length;
        Arrays.sort(nums);
        f(0, nums, new ArrayList<>());
        return res;
    }
    public void f(int ind, int nums[], List<Integer> path){
        res.add(new ArrayList<>(path));
        for(int i = ind; i<n; i++){
            if(i>ind && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            f(i+1, nums, path);
            path.remove(path.size() - 1);
        }
    }
}