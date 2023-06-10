package stage6_10;

public class LC_searchInRotatedSortedArrayII {
    /**
     * 力扣搜索旋转排序数组II
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 1) {
            return nums[0] == target;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // 因为里面有相同的数字，所以可能相同，如果相同，那就左右都加一，在新的区间搜索
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                ++l;
                --r;
            } else if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
