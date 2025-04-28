class Solution {
    private void findPermutation(int arr[], List<List<Integer>> ans, boolean map[], List<Integer> ds){
        if(ds.size() == arr.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = 0; i<arr.length; i++){
            if(!map[i]){
                map[i] = true;
                ds.add(arr[i]);
                findPermutation(arr, ans, map, ds);
                ds.remove(ds.size() - 1);
                map[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean map[] = new boolean[nums.length];
        findPermutation(nums, ans, map, new ArrayList<>());
        return ans;
    }
}