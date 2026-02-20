class Solution {
    int n;
    public int subarraysWithKDistinct(int[] nums, int k) {
       n = nums.length;
       return atMostK(nums, k) - atMostK(nums, k-1);
    }
    public int atMostK(int nums[], int k){
        HashMap<Integer, Integer> mp = new HashMap<>();
        int left = 0, count = 0;
        for(int right=0; right<n; right++){
            mp.put(nums[right], mp.getOrDefault(nums[right], 0)+1);
            while(mp.size() > k){
                mp.put(nums[left], mp.get(nums[left])-1);
                if(mp.get(nums[left]) == 0) mp.remove(nums[left]);
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}