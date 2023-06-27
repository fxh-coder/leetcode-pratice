import java.util.HashMap;
import java.util.Map;

public class LC_containsDuplicate {
    /**
     * 力扣存在重复元素
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }
}
