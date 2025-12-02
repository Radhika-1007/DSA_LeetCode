class DisjointSet{
    int parent[], size[];
    DisjointSet(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px == py) return;
        if(size[px] < size[py]){
            parent[px] = py;
            size[py] += size[px];
        }
        else{
            parent[py] = px;
            size[px] += size[py];
        }
    }
    int getSize(int x){
        return size[find(x)];
    }
}
class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        //step 1 union of 1's
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0) continue;
                for(int d=0; d<4; d++){
                    int nr = i + dir[d][0];
                    int nc = j + dir[d][1];
                    if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc] == 1){
                        int nodeNo = i * n + j;
                        int adjNo = nr * n + nc;
                        ds.union(nodeNo, adjNo);
                    }
                }
            }
        }
        //step 2 changing 0 to 1 and storing in set
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1) continue;
                HashSet<Integer> set = new HashSet<>();
                for(int d=0; d<4; d++){
                    int nr = i + dir[d][0];
                    int nc = j + dir[d][1];
                    if(nr>=0 && nr<n && nc>=0 && nc <n && grid[nr][nc] == 1){ 
                        set.add(ds.find(nr * n + nc ));
                    }
                }
                int sizeTotal = 0;
                for(int it: set){
                    sizeTotal += ds.size[it];
                }
                max = Math.max(max, sizeTotal + 1);
            }
        }
        for(int cellNo = 0; cellNo < n*n; cellNo++){
            max = Math.max(max, ds.size[ds.find(cellNo)]);
        }
        return max;
    }
}