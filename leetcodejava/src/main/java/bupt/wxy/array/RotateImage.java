package bupt.wxy.array;

/**
 * Created by xiyuanbupt on 1/3/17.
 * 48. Rotate Image
 * Difficulty: Medium
 * <p>
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Follow up:
 * Could you do this in-place?
 */
public class RotateImage {

    // 下面的算法申请了额外的空间,
    public void rotateUseSpace(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return;
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                tmp[j][n - 1 - i] = matrix[i][j];
            }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = tmp[i][j];
    }
}
