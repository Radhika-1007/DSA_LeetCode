class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length(), m = p.length(), left = 0;
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        for(char c: p.toCharArray()) freq2[c - 'a']++;
        for(int right = 0; right < n; right++){
            freq1[s.charAt(right) - 'a']++;
            if(right >= m){
                freq1[s.charAt(left) - 'a']--;
                left++;
            }
            if(Arrays.equals(freq1, freq2)) res.add(left);
        }
        return res;
    }
}