import java.util.ArrayList;
import java.util.List;

public class LC_permutations {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;

    /**
     * 力扣全排列
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        used = new boolean[n];
        dfs(0, nums, used, n);
        int cnt;
        for (List<Integer> tep : res) {
            cnt = 0;
            System.out.print("[");
            for (Integer num: tep) {
                cnt++;
                if(cnt != tep.size())
                    System.out.print(num + ",");
                else
                    System.out.print(num);
            }

            System.out.println("]");
        }


        return res;
    }

    private void dfs(int cur, int[] nums, boolean[] used, int n) {
        if(temp.size() == n) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!used[i]) {
                temp.add(nums[i]);
                used[i] = true;

                dfs(cur+1, nums, used, n);

                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LC_permutations lc = new LC_permutations();
        int[] nums = {1,2,3};
        lc.permute(nums);
    }

}
