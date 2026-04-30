class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int n= nums.length, sum = 0;
        if(k==0){
            for(int i=0; i<n-1; i++){
                if(nums[i] == 0 && nums[i+1] == 0) return true;
            }
            return false;
        }
        for(int i=0; i<n; i++){
            sum += nums[i];
            int rem = sum %k;
            if(mp.containsKey(rem)){
                int prevIndex = mp.get(rem);
                if(i-prevIndex >=2) return true;
            }    
            else mp.put(rem, i);
        }
        return false;
    }
}