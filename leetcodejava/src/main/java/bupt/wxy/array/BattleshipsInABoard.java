package main.java.bupt.wxy.array;

/**
 * Created by xiyuanbupt on 2/28/17.
 419. Battleships in a Board Add to List
 Description  Submission  Solutions
 Total Accepted: 16892
 Total Submissions: 27959
 Difficulty: Medium
 Contributors: ben65
 Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:

 You receive a valid board, made of only battleships or empty slots.
 Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 Example:
 X..X
 ...X
 ...X
 In the above board there are 2 battleships.
 Invalid Example:
 ...X
 XXXX
 ...X
 This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
 Follow up:
 Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?

 Subscribe to see which companies asked this question.
 */
public class BattleshipsInABoard {

    // 可以设置visite数组, 但是题意并不想让你使用visited数组
    // 4.58% 虽然最近的几道题得分比较低,但是都在第一个正太区间
    public int countBattleships(char[][] board) {

        int res=0;
        int m,n;
        if((m=board.length)==0||(n=board[0].length)==0)return res;

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(board[i][j]=='X'){
                    if(i+1<m&&board[i+1][j]=='X')continue;
                    if(j+1<n&&board[i][j+1]=='X')continue;
                    res++;
                }
            }
        return res;
    }
}
