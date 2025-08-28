class Solution {
    public int rob(int[] nums) {
         int n = nums.length;
        if (n == 1) return nums[0]; // only one house

        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();

        // create two cases: exclude first or exclude last
        for (int i = 0; i < n; i++) {
            if (i != 0) temp1.add(nums[i]);         // exclude first
            if (i != n - 1) temp2.add(nums[i]);     // exclude last
        }

        int dp1[] = new int[temp1.size()];
        int dp2[] = new int[temp2.size()];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int case1 = cache(temp1.size() - 1, dp1, temp1);
        int case2 = cache(temp2.size() - 1, dp2, temp2);

        return Math.max(case1, case2);
    }
    public int cache(int ind, int dp[], ArrayList<Integer> nums) {
        if (ind < 0) return 0;
        if (ind == 0) return nums.get(ind);
        if (dp[ind] != -1) return dp[ind];

        int pick = nums.get(ind) + cache(ind - 2, dp, nums);
        int notpick = cache(ind - 1, dp, nums);

        return dp[ind] = Math.max(pick, notpick);
    }
}