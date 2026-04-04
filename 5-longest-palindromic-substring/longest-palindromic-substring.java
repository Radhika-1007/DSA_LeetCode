class Solution {
    int n;
    public String longestPalindrome(String s) {
        n = s.length();
        int start = 0, end = 0;
        for(int i=0; i<n; i++){
            int len1 = f(i, i, s);
            int len2 = f(i, i+1, s);
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len - 1)/2;
                end = i + (len)/2;
            }
        }
        return s.substring(start, end+1);
    }
    public int f(int l, int r, String s){
        while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
}