class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for(int weight: weights){
            low = Math.max(low, weight);
            high += weight;
        } 
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canShip(weights, days, mid)) high = mid-1;
            else low = mid + 1;
        }
        return low;
    }
    private boolean canShip(int weights[], int days, int capacity){
        int currentLoad = 0, dayNeeded = 1;
        for(int w: weights){
            if(currentLoad + w <= capacity) currentLoad += w;
            else{
                dayNeeded++;
                currentLoad = w;
            }
        }
        return dayNeeded <= days;
    }
}