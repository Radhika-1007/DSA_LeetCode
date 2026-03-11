class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length(), left = 0;
        if(n > m) return false;
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        for(char c: s1.toCharArray()) freq1[c - 'a']++;
        for(int right = 0; right < m; right++){
            freq2[s2.charAt(right) - 'a']++;
            if(right >= n){
                freq2[s2.charAt(left) - 'a']--;
                left++;
            }
            if(Arrays.equals(freq1, freq2)) return true;
        }
        return false;
    }
}