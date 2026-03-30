class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int arr[] = new int[c + 2];
        arr[0] = 0; arr[c+1] = n;
        for(int i=1; i<=c; i++){
            arr[i] = cuts[i-1];
        }
        Arrays.sort(arr);
        int dp[][] = new int[c+2][c+2];
        int cost;
        for(int i=c; i>=1; i--){
            for(int j=i; j<=c; j++){
                int minCost = Integer.MAX_VALUE;
                for(int ind = i; ind<=j; ind++){
                    cost = arr[j+1] - arr[i-1] + dp[i][ind-1] + dp[ind+1][j];
                    minCost = Math.min(minCost, cost); 
                }
                dp[i][j] = minCost;
            }
        }
        return dp[1][c];
    }
}