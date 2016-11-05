class TrieNode {
    // Initialize your data structure here.
        
    char mVal;
    TrieNode[] arrLinks = null;
    
    public TrieNode(char val) {
        mVal = val;
    }
    
    public TrieNode getLink(char val) {
        return arrLinks != null ? arrLinks[val - 'a'] : null;
    }
    
    public TrieNode addLink(char val) {
        if(arrLinks == null) {
            arrLinks = new TrieNode[26];
        }
        
        int idx = val - 'a';
        TrieNode node = arrLinks[idx];
        if(node == null) {
            node = new TrieNode(val);
            arrLinks[idx] = node;
        }
        
        return node;
    }
    
    boolean mIsWord = false;
    public void markWord() {
        mIsWord = true;
    }
    
    public boolean isWord() { return mIsWord; }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode('0');
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for(int i=0; i< word.length(); i++) {
            char c = word.charAt(i);
            cur = cur.addLink(c);
        }
        cur.markWord();
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i=0; i< word.length() && cur != null; i++) {
            char c = word.charAt(i);
            cur = cur.getLink(c);
        }
        
        return cur != null && cur.isWord();
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i=0; i< prefix.length() && cur != null; i++) {
            char c = prefix.charAt(i);
            cur = cur.getLink(c);
        }
        
        return cur != null;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
