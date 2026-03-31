class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mp = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int n = nums2.length, m = nums1.length;
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek() <= nums2[i]) st.pop();
            mp.put(nums2[i], (st.isEmpty()? -1: st.peek()));
            st.push(nums2[i]);
        }
        for(int i=0; i<m; i++){
            nums1[i] = mp.get(nums1[i]);
            
        }
        return nums1;
    }
}