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
        int dir[][] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int distance[][] = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[0][0] = 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x,y) -> x.dist - y.dist);
        pq.add(new Tuple(0, 0, 0));
        while(!pq.isEmpty()){
            int d = pq.peek().dist;
            int r = pq.peek().row;
            int c = pq.peek().col;
            pq.remove();
            if(r == n-1 && c == m-1) return d;
            for(int i=0; i<4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    int effort = Math.abs(heights[nr][nc] - heights[r][c]);
                    int maxEffort = Math.max(d, effort);
                    if(maxEffort < distance[nr][nc]){
                        distance[nr][nc] = maxEffort;
                        pq.add(new Tuple(maxEffort, nr, nc));
                    }
                }
            }
        }
        return 0;
    }
}