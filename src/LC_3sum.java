import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_3sum {
    /**
     * 力扣三数之和
     * @param nums 数组
     * @return 符合三数下标不同，相加为0的组合（不能重复）
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n =nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;

            int k = n - 1;
            int target = -nums[i];
            for (int j = i+1; j < n; j++) {
                if(j > i + 1 && nums[j] == nums[j-1])
                    continue;
                while(j < k && nums[j] + nums[k] > target)
                    k--;
                if(j == k)
                    break;

                if(nums[j] + nums[k] == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    res.add(temp);
                }
            }
        }

        return res;
    }
}
