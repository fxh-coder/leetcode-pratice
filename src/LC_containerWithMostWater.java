public class LC_containerWithMostWater {
    /**
     * 力扣盛水最多的容器
     * @param height n个高度数组
     * @return 最大水量
     */
    public int maxArea(int[] height) {
        int lIdx = 0, rIdx = height.length - 1;
        int maxArea = 0;
        while(lIdx < rIdx) {
            int curArea = Math.min(height[lIdx], height[rIdx]) * (rIdx - lIdx);
            if(maxArea < curArea)
                maxArea = curArea;
            if(height[lIdx] <= height[rIdx])
                lIdx++;
            else
                rIdx--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LC_containerWithMostWater lc = new LC_containerWithMostWater();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(lc.maxArea(height));
    }
}
