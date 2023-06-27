public class LC_singleNumber {
    /**
     * 力扣只出现一次的数字（不看答案，不知道用异或操作）
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;

        for (int num: nums)
            res ^= num;

        return res;
    }
}
