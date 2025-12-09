class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(i!=0) temp1.add(nums[i]);
            if(i!=n-1) temp2.add(nums[i]);
        }
        int dp1[] = new int[temp1.size()];
        int dp2[] = new int[temp2.size()];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.max(f(temp1.size() -1, dp1, temp1), f(temp2.size()-1, dp2, temp2));
    }
    private int f(int i, int dp[], ArrayList<Integer> nums){
        if(i<0) return 0;
        if(i==0) return nums.get(0);
        if(dp[i] != -1) return dp[i];
        int pick = nums.get(i) + f(i-2, dp, nums);
        int notpick = f(i-1, dp, nums);
        return dp[i] = Math.max(pick, notpick);    
    }
}