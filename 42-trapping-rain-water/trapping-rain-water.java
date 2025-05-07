class Solution {
    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0, total = 0;
        int l = 0;
        int r = height.length - 1;
        while(l<=r){
            if(height[l] < height[r]){
                if(leftMax >= height[l]){
                    total += leftMax - height[l];
                    l++;
                }
                else leftMax = height[l];
            }
            else{
                if(rightMax >= height[r]){
                    total += rightMax -height [r];
                    r--;
                }
                else rightMax =height [r];
            }    
        }
        return total;
    }
}