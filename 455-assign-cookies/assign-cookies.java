class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        if(g.length == 0 || s.length == 0) return 0;
        int count = 0, i = 0, j = 0;
        while(j<s.length && i<g.length){
            if(s[j] >= g[i]){
                count++;
                i++;
                j++;
            }
            else j++;
        }
        return count;
    }
}