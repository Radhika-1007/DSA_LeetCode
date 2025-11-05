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
        StringBuilder reversed = new StringBuilder(s).reverse();
        return s.equals(reversed.toString());
    }
}