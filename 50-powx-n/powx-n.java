class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n<0) return 1/myPow(x, -(n+1)) / x;
        double half = myPow(x, n/2);
        if(n%2 != 0) return x*half*half;
        else return half*half;
    }
}