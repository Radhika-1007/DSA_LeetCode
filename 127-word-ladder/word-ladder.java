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
        Set<String> st = new HashSet<>(wordList);
        if(!wordList.contains(endWord)) return 0;
        Queue<Pair>q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int sqlen = q.peek().second;
            q.poll();
            if(word.equals(endWord)) return sqlen;
            for(int i=0; i<word.length(); i++){
                char wordChars[] = word.toCharArray();
                for(char ch = 'a'; ch<='z'; ch++){
                    wordChars[i] = ch;
                    String newWord = new String(wordChars);
                    if(st.contains(newWord)){
                        q.offer(new Pair(newWord, sqlen+1));
                        st.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}