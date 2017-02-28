package main.java.bupt.wxy.math;

/**
 * Created by xiyuanbupt on 2/27/17.
 59. Spiral Matrix II Add to List
 Description  Submission  Solutions
 Total Accepted: 73766
 Total Submissions: 192341
 Difficulty: Medium
 Contributors: Admin
 Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 For example,
 Given n = 3,

 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 */
public class SpiralMatrixII {

    // 四个方向是一个状态机, 可以互相切换
    // 4.81%
    public int[][] generateMatrixn(int n) {

        int[][] res=new int[n][n];

        int i=0,j=0,di=0,dj=1;
        for(int k=0, max=n*n;k<max;k++){
            res[i][j]=k+1;
            if(res[Math.abs((i+di)%n)][Math.abs((j+dj)%n)]  !=0){
                int tmp=-di;
                di=dj;
                dj=tmp;
            }
            i=i+di;
            j=j+dj;

        }
        return res;
    }

    // 正常的想法是上下左右移动
    // 17.22%
    public int[][] generateMatrix(int n){

        int[][] matrix=new int[n][n];
        // 上下左右分别代表目前还没有数据的行
        int left=0,ritht=n-1;
        int top=0, down=n-1;
        int k=1;
        // 左下右上移动
        // 不用太多考虑for循环越界的问题
        while (left<=ritht){
            // 填充最上面
            for (int j=left;j<=ritht;j++){
                matrix[top][j]=k++;
            }
            top++;
            // 右面
            for(int i=top;i<=down;i++){
                matrix[i][ritht]=k++;
            }
            ritht--;
            // 下面
            for(int j=ritht;j>=left;j--){
                matrix[down][j]=k++;
            }
            down--;
            for(int i=down;i>=top;i--){
                matrix[i][left]=k++;
            }
            left++;
        }
        return matrix;
    }
}
