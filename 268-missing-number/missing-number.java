class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        HashSet<Integer> st = new HashSet<>();
        for(int num : nums) {
            st.add(num);
        }
        for(int i=0; i<=n; i++){
            if(!st.contains(i)) return i;
        }
        return 0;
    }
}