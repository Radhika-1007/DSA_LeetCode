class Pair{
    int waqt, node;
    Pair(int time, int n){
        waqt = time;
        node = n;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());
        for(int time[]: times){
            adj.get(time[0]).add(new Pair(time[2], time[1]));
        }
        int dist[] = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.waqt - b.waqt));
        pq.add(new Pair(0, k));
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int time = pq.peek().waqt;
            pq.poll();
            for(Pair it: adj.get(node)){
                if(time + it.waqt < dist[it.node]){
                    dist[it.node] = time + it.waqt;
                    pq.add(new Pair(dist[it.node], it.node));
                }
            }
        }
        int ans = 0;
        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(dist[i], ans);
        }
        return ans;
    }
}