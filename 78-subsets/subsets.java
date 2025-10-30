class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f(nums, 0, ans, new ArrayList<>());
        return ans;
    }
    public void f(int[] nums, int i, List<List<Integer>> ans, List<Integer> curr){
        if(i>=nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        f(nums, i+1, ans, curr);
        curr.remove(curr.size()-1);
        f(nums, i+1, ans, curr);

    }
}