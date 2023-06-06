import java.util.ArrayDeque;
import java.util.Deque;

public class LC_largestRectangleInHistogram {
    /**
     * 力扣柱状图中最大的矩形（会超时）
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if(len == 0)
            return 0;

        int res = 0;
        for (int i = 0; i < len; i++) {
            int left = i;
            int curHeight = heights[i];
            while(left > 0 && heights[left - 1] >= curHeight)
                left--;

            int right = i;
            while(right < len - 1 && heights[right + 1] >= curHeight)
                right++;

            int width = right - left + 1;
            res = Math.max(res, width * curHeight);
        }
        return res;
    }

    public int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return heights[0];
        }

        int res = 0;

        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>(len);
        // 先放入哨兵，在循环里就不用做非空判断
        stack.addLast(0);

        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return res;
    }
}
