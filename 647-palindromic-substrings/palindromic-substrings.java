class Solution {
    int n;
    public int countSubstrings(String s) {
        n = s.length();
        int count = 0;
        for(int i=0; i<n; i++){
            count += f(s, i, i);
            count += f(s, i, i+1);
        }
        return count;
    }
    public int f(String s, int l, int r){
        int res = 0;
        while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
            res++;
            l--;
            r++;
        }
        return res;
    }
}