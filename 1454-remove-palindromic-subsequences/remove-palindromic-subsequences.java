class Solution {
    public int removePalindromeSub(String s) {
        if(s.equals("")) return 0;
        if(isPalindrome(s, 0, s.length()-1)) return 1;
        return 2;
    }
    public boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}