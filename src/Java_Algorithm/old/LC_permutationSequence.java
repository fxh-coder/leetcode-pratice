package stage6_10;

import java.util.ArrayList;
import java.util.List;

public class LC_permutationSequence {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    boolean[] used;

    /**
     * 力扣排列序列（可以通过所有的测试用例，但是最后显示超时）
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        used = new boolean[n];
        dfs(0, nums, used, n);

        String s = "";
        for (int i = 0; i < n; i++) {
            s = s + res.get(k-1).get(i);
        }
        return s;
    }

    public void dfs(int cur, int[] nums, boolean[] used, int k) {

        // 记录合法的答案
        if (temp.size() == k) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = 0; i < k; i++) {
            if (!used[i]) {
                // 考虑选择当前位置
                temp.add(nums[i]);
                used[i] = true;

                dfs(cur + 1, nums, used, k);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    /**
     * 力扣排列序列（这个是利用的下一个拍列的那个方法，就是变成下k-1个拍列就好了，因为起初的就算一个）
     * @param n
     * @param k
     * @return
     */
    public String getPermutation2(int n, int k) {
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = i + 1;

        for(int cnt = 0; cnt < k - 1; cnt++) {
            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            if (i >= 0) {
                int j = nums.length - 1;
                while (j >= 0 && nums[i] >= nums[j]) {
                    j--;
                }
                swap(nums, i, j);
            }
            reverse(nums, i + 1);
        }

        String res = "";
        for(int i = 0; i < n; i++)
            res += nums[i];

        return res;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
