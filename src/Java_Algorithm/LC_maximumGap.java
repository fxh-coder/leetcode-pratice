package Java_Algorithm;

import java.util.Arrays;

public class LC_maximumGap {
    /**
     * 力扣最大间距
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        int len = nums.length, max = Integer.MIN_VALUE;
        if(len < 2)return 0;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            int t = nums[i]-nums[i-1];
            max = Math.max(max,t);
        }
        return max;
    }
}
