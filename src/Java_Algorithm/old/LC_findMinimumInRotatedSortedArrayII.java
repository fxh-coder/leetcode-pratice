package Java_Algorithm;

public class LC_findMinimumInRotatedSortedArrayII {
    /**
     * 力扣寻找旋转排序数组中的最小值 II
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            // 如果小于，说明当前这一段是升序的（最小值的右侧），那最小值应该在左侧
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                // 如果大于，说明当前这一段是降序的（最小值的左侧），那最小值应该在右侧
                low = pivot + 1;
            } else {
                // 如果相等，说明遇到了重复元素
                high -= 1;
            }
        }
        return nums[low];
    }
}
