class Solution {
    public String longestCommonPrefix(String[] strs) {
        int s = strs[0].length(), n = strs.length;
        for(int i=0; i<s; i++){
            char ch = strs[0].charAt(i);
            for(int j=1; j<n; j++){
                if(i==strs[j].length() || ch != strs[j].charAt(i)){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}