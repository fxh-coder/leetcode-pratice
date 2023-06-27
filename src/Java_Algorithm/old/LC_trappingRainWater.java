public class LC_trappingRainWater {
    /**
     * 力扣接雨水
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        for (int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

    public static void main(String[] args) {
        LC_trappingRainWater lc = new LC_trappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(lc.trap(height));
    }
}
