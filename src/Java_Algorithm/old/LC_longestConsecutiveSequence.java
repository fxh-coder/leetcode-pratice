import java.util.HashSet;
import java.util.Set;

public class LC_longestConsecutiveSequence {
    /**
     * 力扣最长连续序列
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // 用set存储数组中所有数字，防止了重复数字
        for (int num: nums)
            set.add(num);

        int maxLong = 0;
        for (int num: nums) {
            // 假如当前集合中不包含当前值的前一个值，那就从当前值的下一个值
            // 开始计算最长连续序列，这个逻辑也可以反过来（不包含当前值的下
            // 一个值，那就从上一个值开始计算）
            if(!set.contains(num - 1)) {
                int cur = num, curLong = 1;

                while(set.contains(cur + 1)) {
                    cur++;
                    curLong++;
                }
                maxLong = Math.max(maxLong, curLong);
            }
        }

        return maxLong;
    }
}
