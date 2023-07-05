/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let n = nums.length;

    if(n == 1) {
        return nums[0] == target ? 0 : -1;
    }

    let left = 0, right = n - 1;
    while(left <= right) {
        let mid = parseInt((right + left) / 2);

        if(nums[mid] == target)
            return mid;

        // 0 - mid 升序
        if(nums[0] < nums[mid]) {
            if (nums[0] <= target && target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        } else {
            // 降序
            if (nums[mid] < target && target <= nums[n - 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
    }
    return -1;
};