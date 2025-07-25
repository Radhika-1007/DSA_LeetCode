class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int frequency[] = new int[26];
        int maxFreq = 0;
        int maxLength = 0;
        int left = 0;
        for(int right=0; right<n; right++){
            frequency[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, frequency[s.charAt(right) - 'A']);
            if(right-left+1-maxFreq > k){
                frequency[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}