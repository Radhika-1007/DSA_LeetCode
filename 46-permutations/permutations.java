class Solution {
    private void findpermute(int ind, int nums[], List<List<Integer>> ans){
        int n = nums.length;
        if(ind == n){
            List<Integer> ds = new ArrayList<>();
            for(int i = 0; i<n; i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = ind; i<n; i++){
            swap(nums, i, ind);
            findpermute(ind+1, nums, ans);
            swap(nums, i, ind);
        }
    }
    private void swap(int arr[], int i, int j){
        int temp = arr[i]; 
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findpermute(0, nums, ans);
        return ans;
    }
    
}