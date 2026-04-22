class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int left = 0, n = s.length(), max = 0;
        for(int right = 0; right<n; right++){
            char c = s.charAt(right);
            if(mp.containsKey(c)) left = Math.max(left, mp.get(c) + 1);
            mp.put(c, right);
            max = Math.max(max, right - left + 1);
        }  
        return max; 
    }
}