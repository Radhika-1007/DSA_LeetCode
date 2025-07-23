class Pair{
    int first, second;
    Pair(int f, int s){
        first = f;
        second = s;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());
        for(int time[] : times){
            adj.get(time[0]).add(new Pair(time[1], time[2]));
        }
        PriorityQueue<Pair> pq= new PriorityQueue<>((x,y) -> x.second-y.second);
        int dist[] = new int[n+1];
        for(int i=0; i<=n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;
        pq.add(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.first;
            int time = curr.second;
            for(Pair it: adj.get(node)){
                int adjNode = it.first;
                int weight = it.second;
                if(time + weight < dist[adjNode]){
                    dist[adjNode] = time + weight;
                    pq.add(new Pair(adjNode, dist[adjNode]));
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