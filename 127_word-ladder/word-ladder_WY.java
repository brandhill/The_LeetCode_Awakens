public class Solution {
    
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        wordList.remove(beginWord); // MUST
        
        LinkedList<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;
        while(!queue.isEmpty()) {
            int size = queue.size(); // avoid the need for another queue
            while(size-- > 0) {
                String word = queue.poll();
                for(int i=0;i<word.length(); i++) {
                    char[] charArray = word.toCharArray();
                    for(char c='a'; c<='z'; c++) {
                        charArray[i] = c;
                        String nextWord = new String(charArray);
                        
                        if(endWord.equals(nextWord)) return level+1;
                        
                        if(wordList.contains(nextWord)) {
                            queue.add(nextWord);
                            wordList.remove(nextWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
