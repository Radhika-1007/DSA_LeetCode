class Solution {
    public int orangesRotting(int[][] grid) {
        int delr[] = {-1, 0, 1, 0};
        int delc[] = {0, 1, 0, -1};
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1) freshCount++;
            }
        }
        int time = bfs(grid, q, delr, delc, freshCount);
        return time;

    }
    private int bfs(int[][] grid, Queue<int[]> q,int delr[], int delc[], int freshCount){
        int n = grid.length;
        int m = grid[0].length;
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean rottenThisMinute = false;
            for(int i=0; i<size; i++){
                int pos[] = q.poll();
                int r = pos[0];
                int c = pos[1];
                for(int d=0; d<4; d++){
                    int nr = r + delr[d];
                    int nc = c + delc[d];
                    if(nr>=0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr, nc});
                        freshCount--;
                        rottenThisMinute = true;
                    }
                }
                
            }
            if(rottenThisMinute) time++;
        }
        return freshCount == 0 ? time : -1;
    }
}