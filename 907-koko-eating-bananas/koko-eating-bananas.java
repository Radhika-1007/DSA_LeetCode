class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length, max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            max = Math.max(piles[i], max);
        }
        int low = 1, high = max;
        while(low <= high){
            int mid = low + (high - low)/2;
            long time = 0;
            for(int pile: piles){
                time += (pile + mid - 1)/mid;
            }
            if(time <= h) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}