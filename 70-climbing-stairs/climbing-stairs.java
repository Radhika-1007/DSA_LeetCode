class Solution {
    public int climbStairs(int n) {
        int prev2 = 1, prev = 2;
        if(n<=2) return n;
        for(int i=3; i<=n; i++){
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}