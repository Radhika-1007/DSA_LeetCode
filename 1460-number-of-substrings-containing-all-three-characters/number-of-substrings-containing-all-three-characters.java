class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        mp.put('a', -1);
        mp.put('b', -1);
        mp.put('c', -1);
        for(int i=0; i<s.length(); i++){
            mp.put(s.charAt(i), i);
            if(mp.get('a') != -1 && mp.get('b') != -1 && mp.get('c') != -1){
                int minIndex = Math.min(mp.get('a'), Math.min(mp.get('b'), mp.get('c')));{
                    ans += minIndex + 1;
                }
            }
        }
        return ans;
    }
}