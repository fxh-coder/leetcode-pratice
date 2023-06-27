package stage6_10;

public class LC_spiralMatrixII {
    /**
     * 力扣螺旋矩阵II
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int cnt = 1;

        while(left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = cnt++;
            }
            for (int i = top + 1; i <= bottom ; i++) {
                matrix[i][right] = cnt++;
            }

            if(left < right && top < bottom) {
                for (int i = right - 1; i > left; i--) {
                    matrix[bottom][i] = cnt++;
                }
                for (int i = bottom; i > top; i--) {
                    matrix[i][left] = cnt++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }


        return matrix;
    }
}
