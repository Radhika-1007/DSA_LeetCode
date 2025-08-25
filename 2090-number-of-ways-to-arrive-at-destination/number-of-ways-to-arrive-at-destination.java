class Pair{
    long first;
    int second;
    Pair(long f, int s){
        first = f;
        second = s;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int road[]: roads){
            int u = road[0];
            int v = road[1];
            int time = road[2];
            adj.get(u).add(new Pair(time, v));
            adj.get(v).add(new Pair(time, u));
        }
        long dist[] = new long[n];
        int ways[] = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> Long.compare(x.first ,y.first));
        pq.add(new Pair(0,0));
        int mod = (int)(1e9 + 7);
        while(!pq.isEmpty()){
            long time = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();
            if(time > dist[node]) continue;
            for(Pair it: adj.get(node)){
                int adjNode = it.second;
                long edTime = it.first;
                if(time + edTime < dist[adjNode]){
                    dist[adjNode] = time + edTime;
                    pq.add(new Pair(time + edTime, adjNode));
                    ways[adjNode] = ways[node];
                }
                else if(time + edTime == dist[adjNode]){
                    ways[adjNode] = (int)((ways[adjNode] +(long) ways[node]) % mod);
                }
            }
        }
        return ways[n-1];
    }
}