import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_permutationsII {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    boolean[] used;

    /**
     * 力扣全排列II
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        used= new boolean[n];
        dfs(0, nums, used, n);
        return res;
    }

    public void dfs(int cur, int[] nums, boolean[] used, int k) {

        // 记录合法的答案
        if (temp.size() == k) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = 0; i < k; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }

            // 考虑选择当前位置
            temp.add(nums[i]);
            used[i] = true;

            dfs(cur + 1, nums, used, k);
            used[i] = false;
            temp.remove(temp.size() - 1);

        }
    }
}
