class Solution {
    private void subsetSum(int ind, int arr[], List<Integer> ds, List<List<Integer>> ansList){
            ansList.add(new ArrayList<>(ds));
        for(int i = ind; i<arr.length; i++){
            if(i != ind && arr[i] == arr[i-1])continue;
            ds.add(arr[i]);
            subsetSum(i+1, arr, ds, ansList);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        subsetSum(0, nums, new ArrayList<>(), ansList);
        return ansList;
    }
}