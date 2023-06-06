import java.util.ArrayList;
import java.util.List;

public class LC_subsets {
    /**
     * 力扣子集
     */
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return res;
    }

    public void dfs(int cur, int[] nums) {
        // 和之前的排列组合不同的是，那些每一个结果的长度都要和给定的数组
        // 长度相同，这个不需要，只要次数对就可以，中间可能有从temp中去除的
        if (cur == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        temp.add(nums[cur]);
        dfs(cur + 1, nums);
        temp.remove(temp.size() - 1);
        dfs(cur + 1, nums);
    }
}
