class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        f(1, n, k, ans, new ArrayList<>());
        return ans;
    }
    public void f(int i, int n, int k, List<List<Integer>> ans, List<Integer> curr){
        if(curr.size() == k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(i>n) return;
        curr.add(i);
        f(i+1, n, k, ans, curr);
        curr.remove(curr.size()-1);
        f(i+1, n, k, ans, curr);
    }
}