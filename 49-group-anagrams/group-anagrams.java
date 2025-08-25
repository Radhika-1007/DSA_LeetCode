class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();
        for(String str: strs){
            char chars[] = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if(!mp.containsKey(sortedStr)){
                mp.put(sortedStr, new ArrayList<>());
            }
            mp.get(sortedStr).add(str);
        }
        return new ArrayList<>(mp.values());
    }
}