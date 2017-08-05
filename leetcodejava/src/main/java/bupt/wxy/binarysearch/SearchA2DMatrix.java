package bupt.wxy.binarysearch;

/**
 * Created by xiyuanbupt on 3/1/17.
 74. Search a 2D Matrix
 Difficulty: Medium
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 */
public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        // 寻找target的左插入点
        // 8.09%
        if(matrix.length==0||matrix[0].length==0)return false;

        int lo=0,hi=matrix.length;
        while (lo<hi){
            int mid=lo+(hi-lo)/2;
            if(matrix[mid][0]<target){
                lo=mid+1;
            }else {
                hi=mid;
            }
        }
        if(lo!=matrix.length&&matrix[lo][0]==target)return true;
        if(lo==0){
            return matrix[0][0]==target;
        }
        int[] line=matrix[lo-1];
        // 使用普通的二分查找
        lo=0;
        hi=line.length-1;
        while (lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(line[mid]==target)return true;
            else if(line[mid]<target){
                lo=mid+1;
            }else {
                hi=mid-1;
            }
        }
        return false;
    }
}
