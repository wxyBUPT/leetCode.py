package main.java.bupt.wxy.bfs;

import java.util.*;

/**
 * Created by xiyuanbupt on 1/17/17.
 126. Word Ladder II
 Total Accepted: 59875
 Total Submissions: 439864
 Difficulty: Hard
 Contributors: Admin
 Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the word list
 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]
 Return
 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]
 Note:
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 Subscribe to see which companies asked this question
 */

/**
 * 同样使用bfs, 跟127题相比改进的地方有: 1 queue中元素为 Path, 记录当前路径 2 对于下一层的元素, 如果遍历到不马上删除, 而是保留在下一层
 */
public class WordLadder_IITImeLimitedExi {

    // 下面解法超时
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Queue<List<String>> queue=new LinkedList<>();
        List<String> begin=new ArrayList<>();begin.add(beginWord);
        queue.add(begin);
        queue.add(null);
        Set<String> visited=new HashSet<>();
        visited.add(beginWord);

        List<List<String>> res=new LinkedList<>();


        while (!queue.isEmpty()){
            List<String> pre=queue.poll();
            if(pre!=null){
                String last=pre.get(pre.size()-1);
                char[] chars=last.toCharArray();
                for(int i=0;i<chars.length;i++){
                    char ori=chars[i];
                    for(char a='a';a<='z';a++){
                        chars[i]=a;

                        String n_str=new String(chars);

                        if(endWord.equals(n_str)){
                            // 找到路径
                            pre.add(n_str);
                            res.add(pre);
                        }
                        else if(wordList.contains(n_str)&&!visited.contains(n_str)){
                            visited.add(n_str);
                            List<String> n_pah=new ArrayList<>(pre);
                            n_pah.add(n_str);
                            queue.add(n_pah);
                        }
                    }
                    chars[i]=ori;
                }
            }else {
                // 执行清理工作
                if(res.size()>0)return res;
                if(!queue.isEmpty()){
                    for(List<String> path:queue){
                        visited.add(path.get(path.size()-1));
                    }
                    queue.add(null);
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        WordLadder_IITImeLimitedExi sl=new WordLadder_IITImeLimitedExi();

        Set<String> wordList=new HashSet<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("log");
        wordList.add("lot");

        for(List<String> list:sl.findLadders("hit","cog",wordList)){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
