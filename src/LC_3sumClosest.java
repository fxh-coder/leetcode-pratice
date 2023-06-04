import java.util.Arrays;

public class LC_3sumClosest {
    /**
     * 力扣最接近的三数之和
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int n =nums.length;
        Arrays.sort(nums);
        int best = 10000000;

        for (int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;

            int k = n - 1, j = i + 1;

            while( j < k){
                if(j > i + 1 && nums[j] == nums[j-1])
                    j++;

                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }

                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }

                if(j < k && sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return best;
    }

    public static void main(String[] args) {
        LC_3sumClosest lc = new LC_3sumClosest();
        int[] nums = {1,1,1,1};
        int target = 4;
        System.out.println(lc.threeSumClosest(nums, target));
    }
}
