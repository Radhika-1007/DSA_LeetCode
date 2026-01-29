class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String map[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(0, map, res, new StringBuilder(), digits);
        return res;
    }
    public void backtrack(int index, String map[], List<String> res, StringBuilder path, String digits){
        if(index == digits.length()){
            res.add(path.toString());
            return;
        }
        String letters = map[digits.charAt(index) - '0'];
        for(char ch: letters.toCharArray()){
            path.append(ch);
            backtrack(index+1, map, res, path, digits);
            path.deleteCharAt(path.length()-1);
        }
    }
}