package com.sv.leetcode123.theLeecodeAwakens;

import com.sv.leetcode123.ch5_tree.TreeNode;

/**
 * Created by hill on 2016/11/6.
 * <p>
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * <p>
 * Implement a trie with insert, search, and startsWith methods.
 * You may assume that all inputs are consist of lowercase letters a-z.
 * <p>
 * <p>
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("somestring");
 * trie.search("key");
 * <p>
 * <p>
 * <p>
 * Space : O(n)
 * Time  : O(n)
 * Your runtime beats 52.28% of java submissions.
 * <p>
 * <p>
 * <p>
 * reference
 * http://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
 * https://leetcode.com/articles/implement-trie-prefix-tree/
 */

public class ImplementTrie {

    class TrieNode {

        TrieNode[] child;
        boolean isLeaf;

        public TrieNode() {
            child = new TrieNode[26];
            isLeaf = false;
        }
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                char curr = word.charAt(i);
                int index = curr - 'a';
                if (p.child[index] == null) {
                    TrieNode temp = new TrieNode();
                    p.child[index] = temp;
                    p = temp;
                } else {
                    p = p.child[index];
                }
            }
            p.isLeaf = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode node = searchNode(word);
            return (node.isLeaf && node != null);
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode node = searchNode(prefix);
            return (node != null);
        }


        public TrieNode searchNode(String s) {

            if (s.length() == 0) {
                return null;
            }

            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int index = c - 'a';

                if (p.child[index] == null) {
                    return null;
                }

                p = p.child[index];
            }

            return p;
        }
    }

}
