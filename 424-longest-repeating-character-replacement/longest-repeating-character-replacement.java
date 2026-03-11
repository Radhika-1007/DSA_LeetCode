class Solution {
    public int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        int n = s.length(), maxLen = 0, maxFreq = 0, left = 0;
        for(int right = 0; right<n; right++){
            char c = s.charAt(right);
            freq[c - 'A']++;
            maxFreq = Math.max(maxFreq, freq[c - 'A']);
            if(right - left + 1 - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left+1);
        }
        return maxLen;
    }
}