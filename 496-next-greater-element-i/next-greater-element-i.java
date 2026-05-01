class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<m; i++){
            while(!st.isEmpty() && nums2[i] > st.peek()){
                mp.put(st.pop(), nums2[i]);
            }
            st.push(nums2[i]);
        }
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = mp.getOrDefault(nums1[i], -1);
        }
        return arr;
    }
}