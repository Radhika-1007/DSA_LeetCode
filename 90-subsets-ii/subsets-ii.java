class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        f(0, nums, res, new ArrayList<>());
        return res;
    }
    public void f(int ind, int nums[], List<List<Integer>> res, List<Integer> path){
       res.add(new ArrayList<>(path)); 
        for(int i=ind; i<nums.length; i++){
            if(i>ind && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            f(i+1, nums, res, path);
            path.remove(path.size()-1);
        }
    }
}