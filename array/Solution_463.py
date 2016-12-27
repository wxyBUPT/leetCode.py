#coding=utf-8
__author__ = 'xiyuanbupt'
# e-mail : xywbupt@gmail.com
'''

463. Island Perimeter   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 13704
Total Submissions: 24304
Difficulty: Easy
Contributors: amankaraj
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:
'''


class Solution(object):

    # 80.38%
    def islandPerimeter(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if not grid or not grid[0]:
            return 0

        row = len(grid)
        col = len(grid[0])
        row_1 = row - 1
        col_1 = col - 1

        land = 0
        neighbours =0
        for i in range(row):
            for j in range(col):
                if grid[i][j]==1:
                    land +=1
                    if i<row_1 and grid[i+1][j]==1:
                        neighbours+=1
                    if j<col_1 and grid[i][j+1] == 1:
                        neighbours += 1
        return land * 4 - neighbours * 2


