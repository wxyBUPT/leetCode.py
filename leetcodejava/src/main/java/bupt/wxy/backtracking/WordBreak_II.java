package main.java.bupt.wxy.backtracking;

/**
 * Created by xiyuanbupt on 1/16/17.
 140. Word Break II
 Total Accepted: 77199
 Total Submissions: 347415
 Difficulty: Hard
 Contributors: Admin
 Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.

 Return all such possible sentences.

 For example, given
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].

 A solution is ["cats and dog", "cat sand dog"].
 */

import java.util.*;

/**
 * 题目有dp 的解法和backtracking 的解法, dp解法见dp目录
 * 如果使用回溯法超时的时候一定要考虑使用记忆化
 * 为了方便看与dp 的区别, 所以dp方法也写在这里
 */
public class WordBreak_II {

    Map<String, List<String>> cache=new HashMap<>();

    // 70.72%
    public List<String> wordBreak(String s, List<String> wordDict){

        if(cache.containsKey(s))return cache.get(s);
        List<String> res=new LinkedList<>();
        if(s.length()==0){
            res.add("");return res;
        }

        for(String word:wordDict){
            if(s.startsWith(word)){
                List<String> next=wordBreak(s.substring(word.length()), wordDict);
                for(String str:next){
                    res.add(word+(str.length()==0?"":" ")+str);
                }
            }
        }
        cache.put(s,res);
        return res;
    }

    // 超时!!!!!! 分析为什么超时????????我分析应该是 String word=s.substring(j, i) 稳定的执行了 On*n 次
    // 开始还以为dp方法肯定回比backtracking 用时更短, 看来以后要勇敢的使用 backtracking 了, 并且backtracking
    // 配合上mem
    public List<String> wordBreakDp(String s, List<String> wordDict){
        List<String>[] dp=new List[s.length()+1];
        Set<String> set=new HashSet<>(wordDict);
        dp[0]=new ArrayList<>();
        dp[0].add("");
        for(int i=1;i<dp.length;i++){
            dp[i]=new LinkedList<>();
            for(int j=0;j<i;j++){
                String word=s.substring(j,i);
                if(set.contains(word)&&dp[j].size()!=0){
                    for(String str:dp[j]){
                        dp[i].add(str+(str.length()==0?"":" ")+word);
                    }
                }
            }
        }
        return dp[s.length()];
    }

    /**
    // 不知道为什么一个dfs可以写的这么丑, 完成dfs 的时候尽量按照最后的结果来写
    Map<String, List<List<String>>> mem=new HashMap<>();

    public List<String> wordBreakUgly(String s, List<String> wordDict){
        List<List<String>> lists=dfs(s, wordDict);
        List<String> res=new ArrayList<>(lists.size());
        for(List<String> strs:lists){
            StringBuilder sb=new StringBuilder();
            for(String str:strs){
                sb.append(str).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
        }
        return res;
    }

    List<List<String>> dfs(String s, List<String> wordDict){
        if(mem.containsKey(s))return mem.get(s);
        if(s.length()==0)return null;
        List<List<String>> res=new LinkedList<>();

        for(String word:wordDict){
            if(s.startsWith(word)){

                List<List<String>> next=dfs(s.substring(word.length()),wordDict);

                if(next==null){
                    List<String> tmp=new ArrayList<>();
                    tmp.add(word);
                    res.add(tmp);
                }else {
                    for(List<String> list:next){
                        List<String> tmp=new LinkedList<>(list);
                        tmp.add(0,word);
                        res.add(tmp);
                    }
                }

            }
        }
        mem.put(s,res);
        return res;
    }

    // 写bt 一般没有bug, 但是问题是超时了
    // 一般情况下请留意 memorized DFS
    public List<String> wordBreakWithNoMemorized(String s, List<String> wordDict) {
        List<String> res=new ArrayList<>();
        backtrackWithNoMemorized(res,new ArrayList<>(),s,wordDict);
        return res;
    }

    void backtrackWithNoMemorized(List<String> res, List<String> curr, String s, List<String> wordDict) {
        if(s.length()==0){
            StringBuilder sb=new StringBuilder();
            for(String str:curr){
                sb.append(str).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
        }

        for(String word:wordDict){
            if(s.startsWith(word)){
                curr.add(word);
                backtrackWithNoMemorized(res,curr,s.substring(word.length()),wordDict);
                curr.remove(curr.size()-1);
            }
        }
    }

    public static void main(String[] args){
        System.out.println("ab".substring(0));
        System.out.println("ab".substring(1));
        System.out.println("ab".substring(2));
        System.out.println("ab".substring(2)==null);
    }
     **/
}
