class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(!mp.containsKey(nums[i])){
                mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
            }
            else{
                return true;
            }
        }
        return false;
    }
}