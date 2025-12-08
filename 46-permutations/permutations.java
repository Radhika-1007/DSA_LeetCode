class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int freq[] = new int[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        f(nums, freq, ans, path);
        return ans;
    }
    private void f(int nums[], int freq[], List<List<Integer>> ans, List<Integer> path){
        if(path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(freq[i] == 0){
                freq[i] = 1;
                path.add(nums[i]);
                f(nums, freq, ans, path);
                path.remove(path.size()-1);
                freq[i] = 0;
            }
        }
    }
}