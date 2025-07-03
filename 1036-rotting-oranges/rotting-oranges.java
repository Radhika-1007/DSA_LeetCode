class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int time=0, fresh=0;
        Queue<int []> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2) q.add(new int[]{i,j});
                if(grid[i][j] == 1) fresh++;
            }
        }
        int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}}; 
        while(!q.isEmpty() && fresh !=0){
           int len = q.size();
           for(int i=0; i<len; i++){
                int[] pos = q.poll();
                int r = pos[0];
                int c = pos[1];
                for(int j=0; j<4; j++){
                    int nr = r + dir[j][0];
                    int nc = c + dir[j][1];
                    if(nr >= 0 && nr < n && nc >=0 && nc < m && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr, nc});
                        fresh--;
                    }
                }
           }
           time++;
        }
        return (fresh == 0)? time : -1;
    }
}