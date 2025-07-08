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
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Set<String> s = new HashSet<>();
        for(int i=0; i<wordList.size(); i++){
            s.add(wordList.get(i));
        }
        s.remove(beginWord);
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
                    if(s.contains(newWord)){
                        s.remove(newWord);
                        q.add(new Pair(newWord, sqlen+1));
                    }
                }
            }
        }
        return 0;
    }
}