class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int mp1[] = new int[256];
        int mp2[] = new int[256];
        for(int i=0; i<n; i++){
            if(mp1[s.charAt(i)] != mp2[t.charAt(i)]) return false;
            mp1[s.charAt(i)] = i+1;
            mp2[t.charAt(i)] = i+1;
        }
        return true;
    }
}