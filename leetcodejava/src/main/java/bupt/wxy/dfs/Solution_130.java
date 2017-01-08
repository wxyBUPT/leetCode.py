package main.java.bupt.wxy.dfs;

/**
 * Created by xiyuanbupt on 1/8/17.
 130. Surrounded Regions   Add to List QuestionEditorial Solution  My Submissions
 Total Accepted: 70898
 Total Submissions: 405574
 Difficulty: Medium
 Contributors: Admin
 Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X
 */

/**
 * 另外一种方法是使用并查集, 所有与边缘相互连接的节点都属于一组
 */
public class Solution_130 {

    int m,n;

    public void solve(char[][] board){
        if((m=board.length)==0||(n=board[0].length)==0)return;
        if(m<2||n<2)return;
        for(int i=0;i<m;i++){
            if(board[i][0]=='O')boundaryDFS(board,i,0);
            if(board[i][n-1]=='O')boundaryDFS(board,i,n-1);
        }

        for(int j=0;j<n;j++){
            if(board[0][j]=='O')boundaryDFS(board,0,j);
            if(board[m-1][j]=='O')boundaryDFS(board,0,j);
        }
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(board[i][j]=='O')board[i][j]='X';
                if(board[i][j]=='*')board[i][j]='O';
            }
    }

    void boundaryDFS(char[][] board, int i, int j){
        if(i<0||i>m-1||j<0||j>n-1)return;
        if(board[i][j]=='O')board[i][j]='*';
        if(i>1&&board[i-1][j]=='O')boundaryDFS(board,i-1,j);
        if(i<m-2&&board[i+1][j]=='O')boundaryDFS(board,i+1,j);
        if(j>1&&board[i][j-1]=='O')boundaryDFS(board,i,j-1);
        if(j<n-2&&board[i][j+1]=='O')boundaryDFS(board,i,j+1);
    }
}
