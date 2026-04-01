class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, maxArea = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                int length = heights[st.pop()];
                int right = i, left = (st.isEmpty()? -1: st.peek());
                int area = (right - left - 1) * length;
                maxArea = Math.max(area, maxArea);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int idx = st.pop();
            int length = heights[idx];
            int left = (st.isEmpty()? -1: st.peek()), right = n;
            int area = (right - left -1) * length;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}