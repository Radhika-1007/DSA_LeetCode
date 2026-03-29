class Solution {
    int n;
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        int provinces = 0;
        int vis[] = new int[n];
        for(int i=0; i<n; i++){
            if(vis[i] == 0){
                dfs(i, vis, isConnected);
                provinces++;
            }
        }
        return provinces;
    }
    public void dfs(int node, int vis[], int isConnected[][]){
        vis[node] = 1;
        for(int i=0; i<n; i++){
            if(isConnected[node][i] == 1 && vis[i] == 0){
                dfs(i, vis, isConnected);
            }
        }
    }
}