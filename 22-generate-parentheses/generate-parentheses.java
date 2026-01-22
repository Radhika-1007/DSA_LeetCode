class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        f(0, 0, n, res, new StringBuilder());
        return res;
    }
    public void f(int open, int close, int n, List<String> res, StringBuilder path){
        if(path.length() == 2*n){
            res.add(path.toString());
            return;
        }
        if(open < n){
            path.append('(');
            f(open+1, close, n, res, path);
            path.deleteCharAt(path.length()-1);
        }    
        if(close < open){
            path.append(')');
            f(open, close+1, n, res, path);
            path.deleteCharAt(path.length()-1);
        }    
         
    }
}