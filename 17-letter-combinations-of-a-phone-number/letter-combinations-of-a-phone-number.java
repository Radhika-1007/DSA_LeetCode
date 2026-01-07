class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String map[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(0, digits, map, res, new StringBuilder());
        return res;
    }
    void backtrack(int index, String digits, String map[], List<String> res, StringBuilder path){
        if(index == digits.length()){
            res.add(path.toString());
            return;
        }
        String letters = map[digits.charAt(index)- '0'];
        for(char ch: letters.toCharArray()){
            path.append(ch);
            backtrack(index+1, digits, map, res, path);
            path.deleteCharAt(path.length()-1);
        }
    }
}