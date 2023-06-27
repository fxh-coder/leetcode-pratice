public class LC_firstMissingPositive {
    /**
     * 缺失的第一个正数
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 将小于等于0的数标记为 n+1
        for (int i = 0; i < n; i++) {
            if(nums[i] <= 0)
                nums[i] = n + 1;
        }

        // 将处于 1 - n 之间的数字对应的下标位置标记为该值的负数
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if(num <= n)
                nums[num - 1] = -Math.abs(nums[num - 1]);
        }

        // 如果有值大于0，说明上述的修改没有这个下标对应的值，就是这个值了
        for (int i = 0; i < n; i++) {
            if(nums[i] > 0)
                return i + 1;
        }

        // 如果上述都没有，那就是刚好包含 1 - n 所以下一个就是 n + 1
        return n + 1;
    }
}
