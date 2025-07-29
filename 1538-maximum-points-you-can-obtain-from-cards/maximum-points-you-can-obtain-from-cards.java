class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int n = cardPoints.length ;
        for(int i=0; i<k; i++){
            sum += cardPoints[i];
        }
        int maxi = sum;
        for(int i=0; i<k; i++){
            sum = sum + cardPoints[n-i-1] - cardPoints[k-i-1];
            maxi=Math.max(maxi, sum);
        }
        return maxi;
    }
} 