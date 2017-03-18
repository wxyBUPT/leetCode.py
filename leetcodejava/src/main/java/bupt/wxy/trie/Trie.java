package main.java.bupt.wxy.trie;

/**
 * Created by xiyuanbupt on 1/16/17.
 208. Implement Trie (Prefix Tree)   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 61060
 Total Submissions: 238568
 Difficulty: Medium
 Contributors: Admin
 Implement a trie with insert, search, and startsWith methods.

 */
class TrieNode {
    // Initialize your data structure here.
    TrieNode[] nodes;
    boolean hasWord;
    public TrieNode() {
        nodes=new TrieNode[26];
        hasWord=false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            int index=c-'a';
            if(curr.nodes[index]==null){
                curr.nodes[index]=new TrieNode();
            }
            curr=curr.nodes[index];
        }
        curr.hasWord=true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            int index=c-'a';
            if(curr.nodes[index]==null)return false;
            curr=curr.nodes[index];
        }
        return curr.hasWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(char c:prefix.toCharArray()){
            int index=c-'a';
            if(curr.nodes[index]==null)return false;
            curr=curr.nodes[index];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
