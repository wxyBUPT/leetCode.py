package main.java.bupt.wxy.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xiyuanbupt on 1/17/17.
 127. Word Ladder
 Difficulty: Medium

 Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the word list
 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 Subscribe to see which companies asked this question
 */

/**
 * dfs 和bfs 真的有很大的差别, 想想本题为什么不适用dfs, 因为本题真的不适合dfs, 解空间根本不是一个树, 而是一个有环图,
 * 并且有很难记录当前访问到多少层.  上述两个问题其实都可以大量的代码解决, 但是多麻烦啊
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);
        // 使用null来标记这一层的结束
        queue.add(null);
        Set<String> visited=new HashSet<>();
        visited.add(beginWord);
        int level=1;

        while (!queue.isEmpty()){
            String str=queue.poll();
            if(str!=null){
                char[] chars=str.toCharArray();

                for(int i=0;i<chars.length;i++){
                    char ori=chars[i];
                    for(char a='a';a<='z';a++){
                        chars[i]=a;
                        String n_str=new String(chars);
                        if(endWord.equals(n_str))return level+1;
                        if(wordList.contains(n_str)&&!visited.contains(n_str)){
                            queue.add(n_str);
                            visited.add(n_str);
                        }
                    }
                    chars[i]=ori;
                }
            }else {
                level++;
                // this level nodes has been visited, add new end flag
                if(!queue.isEmpty()){
                    queue.add(null);
                }
            }
        }
        return 0;
    }
}
