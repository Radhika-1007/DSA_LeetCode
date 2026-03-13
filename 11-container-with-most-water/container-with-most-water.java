class Solution {
    public int maxArea(int[] height) {
        int n = height.length, left = 0, right = n-1, maxWater = Integer.MIN_VALUE;
       while(left < right){
            int waterstored = Math.min(height[left], height[right]) * (right - left);
            maxWater = Math.max(maxWater, waterstored);
            if(height[left] < height[right]) left++;
            else right--;
       }
       return maxWater;
    }
}