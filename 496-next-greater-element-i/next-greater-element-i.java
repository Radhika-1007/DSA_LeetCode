class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nge = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int n = nums2.length;
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek() <= nums2[i]){
                st.pop();
            }
            int nextGreater = st.isEmpty()? -1: st.peek();
            nge.put(nums2[i], nextGreater);
            st.push(nums2[i]);
        }
        int result[] = new int[nums1.length];
        for(int i = 0; i<result.length; i++){
            result[i] = nge.get(nums1[i]);
        }
        return result;
    }
}