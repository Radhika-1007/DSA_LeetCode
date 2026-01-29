class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        f(0, k, arr, n, res, new ArrayList<>());
        return res;
    }
    public void f(int ind, int k, int arr[], int n, List<List<Integer>> res, List<Integer> path){
        if(k == 0 && n == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i= ind; i<arr.length; i++){
            if(i > ind && arr[i] == arr[i-1]) continue;
            if(arr[i] > n) break;
            path.add(arr[i]);
            f(i+1, k-1, arr, n - arr[i], res, path);
            path.remove(path.size()-1);
        }
    }
}