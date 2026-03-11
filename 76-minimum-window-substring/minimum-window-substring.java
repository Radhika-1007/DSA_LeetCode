class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        if(n < m) return "";
        int freq[] = new int[128];
        for(char c: t.toCharArray()) freq[c]++;
        int minLen = Integer.MAX_VALUE, cut = 0, start = -1, left = 0, right = 0;
        while(right < n){
            if(freq[s.charAt(right)] > 0) cut++;
            freq[s.charAt(right)] --;
            while(cut == m){
                if(right - left+1 < minLen){
                    minLen = right-left+1;
                    start = left;
                }
                freq[s.charAt(left)]++;
                if(freq[s.charAt(left)] > 0) cut--;
                left++;
            }
            right++;
        }
        return start == -1? "": s.substring(start, start + minLen);
    }
}