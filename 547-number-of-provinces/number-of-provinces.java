class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean vis[] = new boolean[isConnected.length];
        int curr = 0;
        for(int i=0; i<isConnected.length; i++){
            if(!vis[i]){
                dfs(isConnected, vis, i);
                curr++;
            }
        }
        return curr;
    }
    private void dfs(int[][] isConnected, boolean vis[], int node){
        vis[node] = true;
        for(int i=0; i<isConnected.length; i++){
            if(isConnected[node][i] == 1 && !vis[i]){
                dfs(isConnected, vis, i);
            }
        }
    }
}