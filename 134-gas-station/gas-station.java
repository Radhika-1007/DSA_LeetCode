class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
       int tank = 0, total = 0, start = 0, n = gas.length;
        for(int i=0; i<n; i++){
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;
            if(tank < 0){
                start = i+1;
                tank = 0;
            }
        }
        if(total < 0) return -1;
        return start; 
    }
}