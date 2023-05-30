public class LC_TwoSum {
    /**
     * 力扣两数之和
     * @param nums 整数数组
     * @param target 整数目标
     * @return 目标数组
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        LC_TwoSum lcTwoSum = new LC_TwoSum();
        int[] res = lcTwoSum.twoSum(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }
}
