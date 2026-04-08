class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if(n>m) return findMedianSortedArrays(nums2, nums1);
        int low = 0, high = n;
        while(low <= high){
            int i= (low + high)/2;
            int j = (n+m+1)/2 - i;
            int Aleft = (i==0)? Integer.MIN_VALUE: nums1[i-1];
            int Aright = (i==n)? Integer.MAX_VALUE: nums1[i];
            int Bleft = (j==0)? Integer.MIN_VALUE: nums2[j-1];
            int Bright = (j==m)? Integer.MAX_VALUE: nums2[j];
            if(Aleft <= Bright && Bleft <= Aright){
                if((n+m)%2==0){
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright))/2.0;
                }
                else return Math.max(Aleft, Bleft);
            }
            else if(Aleft > Bright){
                high = i-1;
            }
            else{
                low = i+1;
            }
        }
        return 0.0;
    }
}