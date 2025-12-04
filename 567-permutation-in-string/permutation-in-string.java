class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int s1count[] = new int[26];
        for(char c: s1.toCharArray()){
            s1count[c - 'a']++;
        }
        int left = 0;
        int s2count[] = new int[26];
        for(int i=0; i<s2.length(); i++){
            s2count[s2.charAt(i) - 'a']++;
            if( i>= s1.length()){
                s2count[s2.charAt(left) - 'a']--;
                left++;
            }
            if(Arrays.equals(s1count, s2count)){
                return true;
            }
        }
        return false;
    }
}