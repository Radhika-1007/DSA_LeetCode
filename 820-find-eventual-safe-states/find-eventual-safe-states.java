class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int indegree[] = new int[n];
        ArrayList<ArrayList<Integer>> reverseList = new ArrayList<>();
        for(int i=0; i<n; i++) reverseList.add(new ArrayList<>());
        for(int i=0; i<n; i++){
            for(int it: graph[i]){
                reverseList.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0) q.offer(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int it: reverseList.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.offer(it);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}