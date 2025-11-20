class Pair{
    int node, time;
    Pair(int n, int t){
        node = n;
        time = t;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());
        for(int time[]: times){
            adj.get(time[0]).add(new Pair(time[1], time[2]));
        }
        int dist[] = new int[n+1];
        for(int i=0; i<=n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.time - y.time);
        pq.offer(new Pair(k, 0));
        while(!pq.isEmpty()){
            int no = pq.peek().node;
            int t = pq.peek().time;
            pq.poll();
            for(Pair it: adj.get(no)){
                if(t + it.time < dist[it.node]){
                    dist[it.node] = t + it.time;
                    pq.offer(new Pair(it.node, dist[it.node]));
                }
            }
        }
        int ans = 0;
        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}