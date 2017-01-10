package main.java.bupt.wxy.backtracking;

/**
 * Created by xiyuanbupt on 1/10/17.
 79. Word Search   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 105483
 Total Submissions: 416634
 Difficulty: Medium
 Contributors: Admin
 Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */
public class Solution_79 {

    char[] str;
    char[][] board;
    boolean[][] visited;
    int m, n;
    int len;


    //06.26%
    public boolean exist(char[][] board, String word) {
        if((m=board.length)==0||(n=board[0].length)==0)return false;
        visited=new boolean[m][n];
        this.board=board;
        str=word.toCharArray();
        len=str.length;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(exist(i,j,0))return true;
        return false;
    }

    // 函数默认i, j 点是没有访问过的 并且是合法的点
    boolean exist(int i, int j, int index){
        if(index==len-1&&board[i][j]==str[index])return true;
        if(board[i][j]!=str[index])return false;
        visited[i][j]=true;

        if(i>0&&!visited[i-1][j]&&exist(i-1,j,index+1))return true;
        if(i<m-1&&!visited[i+1][j]&&exist(i+1,j,index+1))return true;
        if(j>0&&!visited[i][j-1]&&exist(i,j-1,index+1))return true;
        if(j<n-1&&!visited[i][j+1]&&exist(i,j+1,index+1))return true;
        visited[i][j]=false;
        return false;
    }
}
