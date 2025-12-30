class Solution {
    public int find(int u, int parent[]){
        if(u != parent[u]){
            parent[u] = find(parent[u], parent);
        }
        return parent[u];
    }
    public boolean union(int u, int v, int parent[]){
        int pu = find(u, parent);
        int pv = find(v, parent);
        if(pu == pv) return false; // cycle detected
        parent[pu] = pv;
        return true;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int parent[] = new int[n+1];
        for(int i=1; i<=n; i++) parent[i] = i;
        for(int e[]: edges){
            if(!union(e[0], e[1], parent)) return e;
        }
        return new int[]{};
    }
}