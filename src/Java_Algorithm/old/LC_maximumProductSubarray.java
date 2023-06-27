public class LC_maximumProductSubarray {
    /**
     * 力扣乘积最大子数组
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            // 这个交换保证了出现偶数次负数的时候，imax存储的仍然是最大连续乘积
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            // imax里面存储的是到这个数之前的乘积最大子数组的积
            imax = Math.max(imax*nums[i], nums[i]);
            // imin里面保存的要么是1（nums[i]是正数时），要么是与负数相乘后的最小值
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }
}
