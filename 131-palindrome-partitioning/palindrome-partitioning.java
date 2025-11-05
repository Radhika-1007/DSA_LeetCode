class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(0, s, result, new ArrayList<>());
        return result;
    }
    private void backtrack(int i, String s, List<List<String>> result, List<String> path){
        if(i==s.length()){
            result.add(new ArrayList<>(path));
        }
        for(int j=i; j<s.length(); j++){
            String substr = s.substring(i, j+1);
            if(isPalindrome(substr)){
                path.add(substr);
                backtrack(j+1, s, result, path);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s){
       int left = 0, right = s.length()-1;
       while(left < right){
            if(s.charAt(left++) != s.charAt(right--)) return false;
       }
       return true;
    }
}