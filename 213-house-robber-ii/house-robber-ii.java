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
        int case1 = f(dp1, temp1, temp1.size()-1);
        int case2 = f(dp2, temp2, temp2.size()-1);
        return Math.max(case1, case2);
    }
    private int f(int dp[], ArrayList<Integer> nums, int ind){
        if(ind<0) return 0;
        if(ind==0) return nums.get(ind);
        if(dp[ind] != -1) return dp[ind];
        int pick = nums.get(ind) + f(dp, nums, ind-2);
        int notpick = f(dp, nums, ind-1);
        return dp[ind] = Math.max(pick, notpick);
    }
}