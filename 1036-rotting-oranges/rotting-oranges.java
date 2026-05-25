class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0, time = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1) fresh++; 
                else if(grid[i][j] == 2) q.offer(new int[]{i, j});
            }
        }
        int dir[][] = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
        while(!q.isEmpty() && fresh>0){
            int size = q.size();
            for(int i=0; i<size; i++){
                int curr[] = q.poll();
                int r = curr[0];
                int c = curr[1];
                for(int d=0; d<4; d++){
                    int nr = r + dir[d][0];
                    int nc = c + dir[d][1];
                    if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc] == 1){
                        fresh--;
                        grid[nr][nc] = 2;
                        q.offer(new int[] {nr, nc});
                    }
                }
            }
            time++;
        }
        return (fresh == 0)? time: -1;
    }
}