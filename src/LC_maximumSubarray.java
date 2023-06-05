public class LC_maximumSubarray {
    /**
     * 力扣最大子数组和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int pre = 0, max = nums[0];
        for (int num: nums) {
            // 看当前的子数组加和和当前的数谁大，
            pre = Math.max(pre + num, num);
            max = Math.max(pre, max);
        }
        return max;
    }
}
