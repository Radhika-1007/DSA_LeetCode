class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = 1_000_000_007;
        int engineers[][] = new int[n][2];
        for(int i=0; i<n; i++){
            engineers[i][0] = speed[i];
            engineers[i][1] = efficiency[i];
        } 
        Arrays.sort(engineers, (a, b) ->(b[1] - a[1]));
        long speedSum = 0, maxPerformance = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int engineer[]: engineers){
            int sp = engineer[0];
            int eff = engineer[1];
            pq.offer(sp);
            speedSum += sp;
            if(pq.size() > k){
                speedSum -= pq.poll();
            }
            long performance = speedSum * eff;
            maxPerformance = Math.max(maxPerformance, performance);
        }
        return (int)(maxPerformance % MOD);
    }
}