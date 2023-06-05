public class LC_jumpGame {
    /**
     * 力扣跳跃游戏
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        // 用max模拟当下能够跳跃的最远的位置，因为是计算位置，
        // 也就是长度，下标是从0，所以要用下标加一
        int max = nums[0] + 1;
        for (int i = 0; i < nums.length; i++) {
            // 这个判断是计算从当前位置到最大位置的过程中，看
            // 看还有没有能够走的更远的，有就更新，然后与最后
            // 一个对比
            if(i < max) {
                max = Math.max(i + nums[i] + 1, max);
                if(max >= nums.length) return true;
            }
        }
        return false;
    }
}
