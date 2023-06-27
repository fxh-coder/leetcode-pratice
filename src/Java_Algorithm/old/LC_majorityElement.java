import java.util.HashMap;
import java.util.Map;

public class LC_majorityElement {
    /**
     * 力扣多数元素
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for(int num: nums) {
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        for(Integer key: map.keySet()) {
            if(map.get(key) > nums.length / 2) {
                res = key;
                break;
            }
        }

        return res;
    }

    // 如果数量不过半，肯定会减为0，所以最后不为0的那个数，就是多数元素
    public int majorityElement2(int[] nums) {
        int curNum = nums[0];
        int cnt = 1;

        for (int i = 1; i < nums.length; i++) {
            if(curNum == nums[i])
                cnt++;
            else {
                if(cnt > 0)
                    cnt--;
                else {
                    curNum = nums[i];
                    cnt = 1;
                }
            }
        }

        return curNum;
    }
}
