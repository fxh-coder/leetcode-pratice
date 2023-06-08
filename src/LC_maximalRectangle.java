public class LC_maximalRectangle {
    /**
     * 力扣最大矩形
     * 原理：记录每一列持续为1的高度（如果前面一行当前列为0，那么当前行重新计算），然后
     *      记录下每一行中到当前列为止，左边第一次小于当前列高度的下标，右边第一次小于
     *      当前列高度的小标，然后使用这两者的差值减一当作宽度，然后根据当前的行数，计算面积
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0)
            return 0;
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for(int row = 0; row < matrix.length; row++) {
            // 遍历每一列，更新高度
            for(int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] == '1')
                    heights[col] += 1;
                else
                    heights[col] = 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    /**
     * leftLessMin 和 rightLessMin 记录的就是左边和右边第一次小于当前列高度的下标
     * @param heights
     * @return
     */
    private int largestRectangleArea(int[] heights) {
        if(heights.length == 0)
            return 0;
        int[] leftLessMin = new int[heights.length];
        leftLessMin[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            int l = i - 1;
            while(l >= 0 && heights[l] >= heights[i])
                l = leftLessMin[l];
            leftLessMin[i] = l;
        }

        int[] rightLessMin = new int[heights.length];
        rightLessMin[heights.length - 1] = heights.length;
        for (int i = heights.length - 2; i >= 0; i--) {
            int r = i + 1;
            while(r <= heights.length - 1 && heights[r] >= heights[i])
                r = rightLessMin[r];
            rightLessMin[i] = r;
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int area = (rightLessMin[i] - leftLessMin[i] - 1) * heights[i];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
