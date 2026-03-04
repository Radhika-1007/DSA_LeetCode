class Solution {
    public void sortColors(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        int index = 0;
        for(int i=0; i<=2; i++){
            int count = mp.getOrDefault(i, 0);
            while(count-- > 0){
                nums[index++] = i;
            }
        }
    }
}