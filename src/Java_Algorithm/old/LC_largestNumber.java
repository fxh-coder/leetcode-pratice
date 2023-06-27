package Java_Algorithm;

import java.util.Arrays;

public class LC_largestNumber {
    /**
     * 力扣最大数
     */
    public String largestNumber(int[] nums) {
        int n = nums.length;
        // 转换成包装类型，以便传入Comparator对象，使用自定义的比较方式（lambda表达式）
        Integer[] numsArr = new Integer[n];

        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            // 因为需要组合前后，所以排在x前面的数，肯定比他大一个位置（值的长度大一）
            while(sx <= x)
                sx *= 10;
            // 因为需要组合前后，所以排在y前面的数，肯定比他大一个位置（值的长度大一）
            while(sy <= y)
                sy *= 10;
            // 两种排列，一种使用负数形式加和，一种使用正数加和，以两者和的结果的正负
            // 来判断谁在前面值更大（注意：传入参数是x在前，所以第一种应该是x在前）
            return (int) (-sy * x - y + sx * y + x);
        });

        if(numsArr[0] == 0) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        for (int num: numsArr)
            res.append(num);

        return res.toString();
    }
}
