package bupt.wxy.binarysearch;

/**
 * Created by xiyuanbupt on 3/1/17.
 240. Search a 2D Matrix II
 Difficulty: Medium
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted in ascending from left to right.
 Integers in each column are sorted in ascending from top to bottom.
 For example,

 Consider the following matrix:

 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]
 Given target = 5, return true.

 Given target = 20, return false.


 */
public class SearchA2DMatrix_II {

    // 算法思想类似于二分查找, 并且"mid"值是二维矩阵给的
    // 32.69%
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0)return false;
        int row=matrix.length-1;
        int col=0;
        while (col<matrix[0].length&&row>-1){
            if(matrix[row][col]==target)return true;
            if(matrix[row][col]<target)col++;
            else row--;
        }
        return false;
    }
}
