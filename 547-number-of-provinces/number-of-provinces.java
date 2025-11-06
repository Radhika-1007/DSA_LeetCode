class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int vis[] = new int[n];
        int curr = 0;
        for(int i=0; i<n; i++){
            if(vis[i] == 0){
                curr++;
                dfs(isConnected, vis, i);
            }
        }
        return curr;
    }
    public void dfs(int isConnected[][], int vis[], int node){
        vis[node] = 1;
       for(int i=0; i<isConnected.length; i++){
            if(isConnected[node][i] == 1 && vis[i] == 0){
                dfs(isConnected, vis, i);
            }
       }
    }
}