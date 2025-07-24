class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        for(int right = 0; right < s.length(); right++){
            char curr = s.charAt(right);
            if(map.containsKey(curr) && map.get(curr) >= left){
                left = map.get(curr) + 1;
            }
            map.put(curr, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}