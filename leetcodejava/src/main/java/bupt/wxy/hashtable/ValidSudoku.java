package main.java.bupt.wxy.hashtable;

/**
 * Created by xiyuanbupt on 1/13/17.
 36. Valid Sudoku
 Total Accepted: 104399
 Total Submissions: 307887
 Difficulty: Easy
 Contributors: Admin
 Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


 A partially filled sudoku which is valid.

 Note:
 */

import java.util.HashSet;

/**
 * 查看数独是否合法
 */
public class ValidSudoku {

    // 对九个网格分别处理
    // 本题目比较简单, 不需要判断数独是否有解
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<9; i++){
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> columns = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < 9;j++){
                if(board[i][j]!='.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i]!='.' && !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
            }
        }
        return true;
    }
}
