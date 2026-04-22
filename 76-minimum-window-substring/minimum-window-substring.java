class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length(), st = -1, left = 0, minLen = Integer.MAX_VALUE, right = 0, cut = 0;
        if(n<m) return "";
        int freq[] = new int[256];
        for(char c : t.toCharArray()) freq[c]++;
        while(right < n){
            char ch = s.charAt(right);
            if(freq[ch] > 0) cut++;
            freq[ch]--;
            while(cut == m){
               if(right - left + 1< minLen){
                    minLen = right - left + 1;
                    st = left;
               }
                freq[s.charAt(left)]++;
                if(freq[s.charAt(left)] > 0) cut--;
                left++;
            }
            right++;
        }
        return (st == -1)? "": s.substring(st, st + minLen);
    }
}