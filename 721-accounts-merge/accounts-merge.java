class DisjointSet{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0; i<=n; i++){
            size.add(1);
            parent.add(i);
        }
    }
    public int findUpar(int node){
        if(node == parent.get(node)) return node;
        int ulp = findUpar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    public void unionSize(int u, int v){
        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);
        if(ulp_u == ulp_v) return;
        if(size.get(ulp_u) > size.get(ulp_v)){
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
        else{
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(!mp.containsKey(mail)){
                    mp.put(mail, i);
                }
                else{
                    ds.unionSize(i, mp.get(mail));
                }
            }
        }
        List<List<String>> merged = new ArrayList<>();
        for(int i=0; i<n; i++) merged.add(new ArrayList<>());
        for(Map.Entry<String, Integer> it: mp.entrySet()){
            String mail = it.getKey();
            int node = ds.findUpar(it.getValue());
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