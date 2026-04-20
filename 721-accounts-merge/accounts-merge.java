class Solution {
    class DSU{
        int parent[];
        DSU(int n){
            parent = new int[n];
            for(int i=0; i<n; i++) parent[i] = i;
        }
        int find(int u){
            if(parent[u] == u) return u;
            return parent[u] = find(parent[u]);
        }
        void union(int a, int b){
            int pa = find(a);
            int pb = find(b);
            if(pa != pb) parent[pa] = pb;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU ds = new DSU(n);
        Map<String, Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(!mp.containsKey(mail)) mp.put(mail, i);
                else ds.union(mp.get(mail), i);
            }
        }
        List<List<String>> merged = new ArrayList<>();
        for(int i=0; i<n; i++) merged.add(new ArrayList<>());
        for(Map.Entry<String, Integer> it: mp.entrySet()){
            String mail = it.getKey();
            int node = ds.find(it.getValue());
            merged.get(node).add(mail);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(merged.get(i).size() == 0) continue;
            Collections.sort(merged.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it: merged.get(i)){
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
}