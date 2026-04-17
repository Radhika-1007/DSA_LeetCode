class Tuple{
    int dist, row, col;
    Tuple(int d, int r, int c){
        dist = d;
        row = r;
        col = c;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        int dist[][] = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;
        int dir[][] = {{-1,0}, {0,1}, {0, -1}, {1, 0}};
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        pq.offer(new Tuple(0, 0, 0));
        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            int d = t.dist, r = t.row, c = t.col;
            if(r == n-1 && c == m-1) return d;
            for(int i=0; i<4; i++){
                int nr = r + dir[i][0], nc = c + dir[i][1];
                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    int effort = Math.abs(heights[nr][nc] - heights[r][c]);
                    int maxEffort = Math.max(d, effort);
                    if(maxEffort < dist[nr][nc]){
                        dist[nr][nc] = maxEffort;
                        pq.offer(new Tuple(dist[nr][nc], nr, nc));
                    }
                }
            }
        }
        return 0;
    }
}