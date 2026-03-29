class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        if(n < m) return "";
        int freq[] = new int[128];
        for(char c: t.toCharArray()){
            freq[c]++;
        }
        int left = 0, minLen = Integer.MAX_VALUE, right = 0, st = -1, cut = 0;
        while(right < n){
            if(freq[s.charAt(right)] > 0) cut++;
            freq[s.charAt(right)]--;
            while(cut == m){
               if(right - left + 1 < minLen){
                minLen = right - left + 1;
                st = left;
            }
                freq[s.charAt(left)]++;
                if(freq[s.charAt(left)] > 0) cut--;
                left++;
            }
            right++;
        }
        return st == -1 ? "" : s.substring(st, st + minLen);
    }
}