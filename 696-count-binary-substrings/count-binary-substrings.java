class Solution {
    public int countBinarySubstrings(String s) {
        int prev=0, curr=1, count = 0, n = s.length();
        for(int i=1; i<n; i++){
            if(s.charAt(i) == s.charAt(i-1)) curr++;
            else{
                count += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
        }
        count += Math.min(prev, curr);
        return count;
    }
}