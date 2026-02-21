class Solution {
    int n, m;
    public int strStr(String haystack, String needle) {
        n = haystack.length();
        m = needle.length();
        int lps[] = buildlps(needle);
        int i=0, j=0;
        while(i<n){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            if(j==m) return i-m;
            else if(i<n && haystack.charAt(i) != needle.charAt(j)){
                if(j!=0){
                    j = lps[j-1];
                }
                else i++;
            }
        }
        return -1;
    }
    public int[] buildlps(String needle){
        int len = 0;
        int lps[] = new int[m];
        int i=1;
        while(i<m){
            if(needle.charAt(i) == needle.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len != 0){
                    len = lps[len-1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}