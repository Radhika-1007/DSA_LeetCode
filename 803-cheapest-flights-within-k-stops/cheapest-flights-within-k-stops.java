class Pair{
    int f;
    int s;
    Pair(int f, int s){
        this.f = f;
        this.s = s;
    }
}
class Tuple{
    int first;
    int second;
    int third;
    Tuple(int f, int s, int t){
        first = f;
        second = s;
        third = t;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int flight[] : flights){
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        Queue<Tuple> q = new LinkedList<>();
        int dist[] = new int[n];
        for(int i=0; i<n; i++) dist[i] = Integer.MAX_VALUE;
        q.offer(new Tuple(0, src, 0)); // stops, node, dist
        dist[src] = 0;
        while(!q.isEmpty()){
            Tuple curr = q.poll();
            int stops = curr.first;
            int node = curr.second;
            int price = curr.third;
            if(stops > k) continue;
            for(Pair it: adj.get(node)){
                int adjNode = it.f;
                int adjPrice = it.s;
                if(adjPrice + price < dist[adjNode] && stops <= k){
                    dist[adjNode] = adjPrice + price;
                    q.add(new Tuple(stops+1, adjNode, adjPrice + price));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}