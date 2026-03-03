class Solution {
    int n;
    public int countSubstrings(String s) {
        n = s.length();
        int count = 0;
        for(int i=0; i<n; i++){
            count += f(i, i, s);
            count += f(i, i+1, s);
        }
        return count;
    }
    public int f(int l, int r, String s){
        int res = 0;
        while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
            res++;
            l--;
            r++;
        }
        return res;
    }
}