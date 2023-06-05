import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC_mergeIntervals {
    /**
     * 力扣合并区间
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        // 利用区间的左边值进行排序，这样能否合并取决于前一个的右边值和当前左边值的大小
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0], right = intervals[i][1];
            // 1、如果是第一个或者当前区间的左边值大于结果中最后一个区间的右边值
            // 那就是没有办法合并，所以将当前的这个区间加入即可
            // 2、否则的话就是不是第一个区间，当前区间的左边值不大于结果中最后
            // 一个区间的右边值，那就是可以进行合并，那就判断谁的右边值更大
            if(res.size() == 0 || res.get(res.size() - 1)[1] < left)
                res.add(new int[]{left, right});
            else
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], right);
        }
        return res.toArray(new int[res.size()][]);
    }
}
