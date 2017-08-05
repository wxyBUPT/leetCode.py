package bupt.wxy.backtracking;

import java.util.*;

/**
 * Created by xiyuanbupt on 2/13/17.
 212. Word Search II
 Description  Submission  Solutions  Add to List
 Total Accepted: 37959
 Total Submissions: 168720
 Difficulty: Hard
 Contributors: Admin
 Given a 2D board and a list of words from the dictionary, find all words in the board.

 Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 For example,
 Given words = ["oath","pea","eat","rain"] and board =

 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]
 Return ["eat","oath"].
 Note:
 You may assume that all inputs are consist of lowercase letters a-z.
 */
public class WordSearchII {
    char[][] board;
    char[] curr;
    boolean[][] visited;
    int m,n;


    public List<String> findWords(char[][] board, String[] words) {
        if((m=board.length)==0||(n=board[0].length)==0)return null;
        visited=new boolean[m][n];
        Set<String> res=new HashSet<>();
        this.board=board;
        for(String word:words){
            if(exist(word))res.add(word);
        }
        return new ArrayList<>(res);
    }

    public boolean exist(String word){
        curr=word.toCharArray();
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(backtracking(i,j,0))return true;
            }
        return false;
    }

    public boolean backtracking(int i, int j, int index){
        if(index==curr.length)return true;
        if(i<0||i>=m||j<0||j>=n)return false;
        if(visited[i][j])return false;
        if(board[i][j]!=curr[index])return false;
        visited[i][j]=true;
        boolean exist = backtracking(i-1,j,index+1)||
                backtracking(i+1,j,index+1)||
                backtracking(i,j-1,index+1)||
                backtracking(i,j+1,index+1);
        visited[i][j]=false;
        return exist;
    }
}
