class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<>());
        int indegree[] = new int[numCourses];
        for(int edge[]: prerequisites){
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0) q.offer(i);
        }
        int count = 0;
        int ans[] = new int[numCourses];
        int idx = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[idx++] = node;
            count++;
            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.offer(it);
            }
        }
        return (count == numCourses)? ans: new int[0];
    }
}