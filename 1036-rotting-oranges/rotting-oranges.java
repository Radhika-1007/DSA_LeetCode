class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int []> q = new LinkedList<>();
        int dir[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int n = grid.length, m = grid[0].length, fresh = 0, time = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
                else if(grid[i][j] == 1) fresh++;
            }
        }
        while(!q.isEmpty() && fresh > 0) {
            int len = q.size();
            for(int i=0; i<len; i++){
                int curr[] = q.poll();
                int row = curr[0];
                int col = curr[1];
                for(int d=0; d<4; d++){
                    int nr = row + dir[d][0];
                    int nc = col + dir[d][1];
                    if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr, nc});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return (fresh == 0)? time: -1;
    }
}