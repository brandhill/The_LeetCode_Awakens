 /*
  * Auther: Johnny Lee
  * Time:  O(word.length + 1)
  * Space: O(n * word.length + 1)
  * First thought: 忘記區分"abc"和"ab"
  */
  
class TrieNode {
    char c;
    HashMap<Integer, TrieNode> children = new HashMap();
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < chars.length; i++) {
            TrieNode childNode;
            if (!cur.children.containsKey(chars[i] - 'a')) {
                childNode = new TrieNode();
                childNode.c = chars[i];
                cur.children.put(chars[i] - 'a', childNode);
            } else {
                childNode = cur.children.get(chars[i] - 'a');
            }
            
            cur = childNode;
        }
        
        TrieNode endNode = new TrieNode();
        endNode.c = '\n';
        cur.children.put('\n' - 'a', endNode);
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < chars.length; i++) {
            if (!cur.children.containsKey(chars[i] - 'a')) {
                return false;
            }
            cur = cur.children.get(chars[i] - 'a');
        }
        if (cur.children.containsKey('\n' - 'a')) {
            return true;  
        }
        
        return false;
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < chars.length; i++) {
            if (!cur.children.containsKey(chars[i] - 'a')) {
                return false;
            }
            cur = cur.children.get(chars[i] - 'a');
        }
        
        return true;        
    }
}