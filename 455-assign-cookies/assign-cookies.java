class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length, m = s.length;
        if(m == 0 || n == 0) return 0;
        int i = 0, j = 0;
        while(j<m && i<n){
            if(s[j] >= g[i]){
                i++;
            }
            j++;
        }
        return i;
    }
}