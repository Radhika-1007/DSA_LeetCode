class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        int left = 0, maxlen = 0;
        for(int right=0; right<s.length(); right++){
            char c = s.charAt(right);
           if(mp.containsKey(c)){
                left = Math.max(left, mp.get(c)+ 1);
           }
           mp.put(c, right);
           maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }
}