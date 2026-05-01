class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = Integer.MIN_VALUE, n = heights.length;
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                int length = heights[st.pop()];
                int right = i, left = (st.isEmpty())? -1: st.peek();
                int area = (right - left - 1) * length;
                maxArea = Math.max(maxArea, area);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int length = heights[st.pop()];
            int right = n, left = (st.isEmpty())? -1: st.peek();
            int area = (right - left - 1) * length;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}