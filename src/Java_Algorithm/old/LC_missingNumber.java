import java.util.Arrays;

public class LC_missingNumber {
    /**
     * 力扣丢失的数字
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }
}
