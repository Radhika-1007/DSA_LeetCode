class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean vis[] = new boolean[n];
        int curr = 0;
        for(int i=0; i<n; i++){
            if(!vis[i]){
                dfs(isConnected, vis, i);
                curr++;
            }
        }
        return curr;
    }
    private void dfs(int isConnected[][], boolean vis[], int node){
        vis[node] = true;
        for(int j=0; j < isConnected.length; j++){
            if(isConnected[node][j] == 1 && !vis[j]){
                dfs(isConnected, vis, j);
            }
        }
    }
}