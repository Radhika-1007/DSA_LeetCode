class Solution {
    class Pair{
        String first;
        int second;
        Pair(String f, int s){
            first = f;
            second = s;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<Pair>();
        Set<String> st = new HashSet<>();
        for(int i=0; i<wordList.size(); i++){
            st.add(wordList.get(i));
        }
        q.offer(new Pair(beginWord, 1));
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int sqlen = q.peek().second;
            q.poll();
            if(word.equals(endWord)) return sqlen;
            for(int i=0; i<word.length(); i++){
                char wordChars[] = word.toCharArray();
                for(char ch = 'a'; ch <= 'z'; ch++){
                    wordChars[i] = ch;
                    String newWord = new String(wordChars);
                    if(st.contains(newWord)){
                        st.remove(newWord);
                        q.offer(new Pair(newWord, sqlen + 1));
                    }
                }
            }
        }
        return 0;
    }
}