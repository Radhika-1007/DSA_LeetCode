class Solution {
    public int maxArea(int[] height) {
        int n = height.length, left = 0, right = n-1, maxArea = Integer.MIN_VALUE;
        while(left < right){
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if(height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }
}