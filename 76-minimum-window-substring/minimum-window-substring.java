class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        int hash[] = new int[128];
        for(int i=0; i<m; i++) hash[t.charAt(i)]++;
        int left=0, right=0, minLen=Integer.MAX_VALUE, cut=0, sLen=-1;
        while(right<n){
            if(hash[s.charAt(right)] > 0) cut++;
            hash[s.charAt(right)]--;
            while(cut == m){
                if(right-left+1 < minLen){
                    minLen = right-left+1;
                    sLen = left;
                }
                hash[s.charAt(left)]++;
                if(hash[s.charAt(left)] > 0) cut--;
                left++;
            }
            right++;
        }
        return (sLen == -1)? "": s.substring(sLen, sLen+minLen);
    }
}