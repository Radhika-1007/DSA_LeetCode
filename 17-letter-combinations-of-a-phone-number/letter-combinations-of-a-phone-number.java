class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String map[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(0, map, digits, res, new StringBuilder());
        return res;
    }
    public void backtrack(int index, String map[], String digits, List<String> res, StringBuilder path){
        if(index == digits.length()){
            res.add(path.toString());
            return;
        }
        String letters = map[digits.charAt(index) - '0'];
        for(char ch: letters.toCharArray()){
            path.append(ch);
            backtrack(index+1, map, digits, res, path);
            path.deleteCharAt(path.length()-1);
        }
    }
}