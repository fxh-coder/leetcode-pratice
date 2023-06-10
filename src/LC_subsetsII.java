package stage6_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_subsetsII {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    /**
     * 力扣子集II
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return res;
    }

    public void dfs(boolean flag, int cur, int[] nums) {
        if (cur == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        dfs(false, cur + 1, nums);

        if(!flag && cur > 0 && nums[cur] == nums[cur - 1])
            return;

        temp.add(nums[cur]);
        dfs(true, cur + 1, nums);
        temp.remove(temp.size() - 1);

    }
}
