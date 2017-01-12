public class WordDictionary {

    class Node {
        Node[] children = new Node[26];
        boolean isWord = false;
        
        void addNext(char c, Node node) {
            children[c - 'a'] = node;
        }
        Node getNext(char c) {
            return children[c - 'a'];
        }
    }
    
    Node mRoot = new Node();
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        if(word.length() == 0)
            return;
            
        Node curr = mRoot;
        Node next = null;
        for(int i=0; i<word.length(); i++) {
            next = curr.getNext(word.charAt(i));
            if(next == null) {
                next = new Node();
                curr.addNext(word.charAt(i), next);
            }
            curr = next;
        }
        next.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchFrom(word, 0, mRoot);
    }
    
    private boolean searchFrom(String word, int idx, Node pNode) {

        if(pNode == null) return false;
        if(idx == word.length()) {
            return pNode != null && pNode.isWord;
        }
        
        if(word.charAt(idx) == '.') {
            for(int i=0; i<pNode.children.length; i++) {
                Node curr = pNode.children[i];
                if(curr != null) {
                    boolean ret = searchFrom(word, idx+1, curr);
                    if(ret) return true;
                }
            }
            return false;
        } else {
            Node curr = pNode.getNext(word.charAt(idx));
            return searchFrom(word, idx+1, curr);
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
