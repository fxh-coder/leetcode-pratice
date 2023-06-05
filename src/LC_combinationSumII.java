import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_combinationSumII {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;

    /**
     * 力扣组合总和2
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        used = new boolean[n];
        // 对数组进行排序，这样相同的数字就能够挨着，有利于判断
        Arrays.sort(candidates);

        dfs(0, candidates, n, used, target);

        return res;
    }

    private void dfs(int begin, int[] candidates, int n, boolean[] used, int target) {
        if(target < 0) return;

        if(target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = begin; i < n; i++) {
            if(!used[i]) {
                // 如果当前数和上一个相同并且上一个的used为false，这说明在当前temp中
                // 上一个数字已经使用过了，因为你在我之前，肯定是先遍历到你，才会到我
                // 然后你的used又为false，说明你已经在temp中用过了，然后换下一个数字的
                // 时候到了我，根据题目要求，不能使用
                if(i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                    continue;
                }
                // 考虑选择当前位置
                temp.add(candidates[i]);
                used[i] = true;

                dfs(i, candidates, n, used, target - candidates[i]);

                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }
}
