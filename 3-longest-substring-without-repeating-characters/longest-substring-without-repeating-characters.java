class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int left = 0, max = 0;
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            if(mp.containsKey(c)){
                left = Math.max(mp.get(c) + 1, left);
            }
            mp.put(c, right);
            max = Math.max(max, right-left+1);
        }
        return max;
    }
}