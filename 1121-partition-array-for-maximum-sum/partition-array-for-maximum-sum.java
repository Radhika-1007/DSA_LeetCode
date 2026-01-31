class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return f(0, arr, k, dp, n);
    }
    public int f(int i, int arr[], int k, int dp[], int n){
        if(i==n) return 0;
        if(dp[i] != -1) return dp[i];
        int len = 0, maxi = Integer.MIN_VALUE, maxAns = Integer.MIN_VALUE;
        for(int j=i; j<Math.min(n, i+k); j++){
            len++;
            maxi = Math.max(arr[j], maxi);
            int sum = len * maxi + f(j+1, arr, k, dp, n);
            maxAns = Math.max(maxAns, sum);
        }
        return dp[i] = maxAns;
    }
}