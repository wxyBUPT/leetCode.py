#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com

'''
419. Battleships in a Board   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 10494
Total Submissions: 17474
Difficulty: Medium
Contributors: ben65
Given an 2D board, count how many different battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:

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

Subscribe to see which companies asked this question
'''

class Solution(object):

    # 右边或者上边有值的不算
    def countBattleships(self, board):
        """
        :type board: List[List[str]]
        :rtype: int
        """
        if not board and not board[0]:
            return 0
        row = len(board)
        col = len(board[0])
        res = 0
        for i in range(row):
            for j in range(col):
                if board[i][j] == '.':continue
                if i-1>-1 and board[i-1][j]=='X':continue
                if j-1>-1 and board[i][j-1]=='X':continue
                res += 1
        return res

