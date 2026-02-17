class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        int maxLen = 0, n = s.length(), left = 0;
        for(int right=0; right<n; right++){
            char ch = s.charAt(right);
            if(mp.containsKey(ch)){
                left = Math.max(left, mp.get(ch)+1);
            }
            mp.put(ch, right);
            maxLen = Math.max(maxLen, right - left+1);
        }
        return maxLen;
    }
}