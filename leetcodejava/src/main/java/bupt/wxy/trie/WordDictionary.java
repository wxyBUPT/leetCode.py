package main.java.bupt.wxy.trie;

/**
 * Created by xiyuanbupt on 1/11/17.
 211. Add and Search Word - Data structure design   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 42703
 Total Submissions: 212685
 Difficulty: Medium
 Contributors: Admin
 Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 For example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 */

// 下面是自己实现的字典树,与discus 基本一致 74.30%
public class WordDictionary {

    class DictNode{
        DictNode[] child=new DictNode[26];
        // 是否有这个单词
        boolean has=false;
    }
    DictNode root=new DictNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        DictNode curr=root;
        for(char c:word.toCharArray()){
            if(curr.child[c-'a']==null)curr.child[c-'a']=new DictNode();
            curr=curr.child[c-'a'];
        }
        // 表示有这个单词
        curr.has=true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }

    public boolean search(char[] words, int i, DictNode root){
        // 退出的情况
        if(i==words.length){
            return root.has;
        }

        if(words[i]=='.'){
            for(DictNode node:root.child){
                if(node!=null&&search(words,i+1,node))return true;
            }
        }else {
            if(root.child[words[i]-'a']!=null&&search(words,i+1,root.child[words[i]-'a']))return true;
        }
        return false;
    }
}
