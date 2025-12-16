class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        if(g.length == 0 || s.length == 0) return 0;
        int i = 0, j = 0;
        while(j<s.length && i<g.length){
            if(s[j] >= g[i]){
                i++;
            }
            j++;
        }
        return i;
    }
}