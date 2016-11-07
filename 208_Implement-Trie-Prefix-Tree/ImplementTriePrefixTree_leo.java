class TrieNode {
    // Initialize your data structure here.
    TrieNode[] next = new TrieNode[26];
    boolean mWordEnd;
}

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    // Inserts a word into the trie.
    public void insert(String word) {
       TrieNode node = root;
       for (int i = 0, size = word.length(); i < size; i++) {
           char c = word.charAt(i);
           int index = c-'a';
           if (null == node.next[index]) {
               node.next[index] = new TrieNode();
           }
           node = node.next[index];
       }
       node.mWordEnd = true;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0, size = word.length(); i < size; i++) {
            int index = word.charAt(i) - 'a';
            if (null == node.next[index]) return null;
            node = node.next[index];
        }
        return node;
    }
    
    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return null != node && node.mWordEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return null != searchPrefix(prefix);
    }
}
