class Solution {
    private boolean check(int[][] graph, int color[], int start, int col){
        color[start] = col;
        for(int it: graph[start]){
            if(color[it] == -1){
                if(check(graph, color, it, 1-col)==false)return false;
            }
            else if(color[it] == col) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        for(int i=0; i<color.length; i++) color[i] = -1;
        for(int i=0; i<color.length; i++){
            if(color[i] == -1){
                if(check(graph, color, i, 0) == false) return false;
            }
        }
        return true;
    }
}