import java.util.ArrayList;
import java.util.List;

public class LC_combinationSum {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    /**
     * 力扣组合总和
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        dfs(0, candidates, n, target);
        return res;
    }

    public void dfs(int begin, int[] candidates, int n, int target) {
        if (target < 0) return;
        // 记录合法的答案
        if (target == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = begin; i < n; i++) {
            // 考虑选择当前位置
            temp.add(candidates[i]);

            dfs(i, candidates, n, target - candidates[i]);

            temp.remove(temp.size() - 1);
        }
    }
}
