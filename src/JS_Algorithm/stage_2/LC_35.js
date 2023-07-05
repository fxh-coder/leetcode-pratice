/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function(nums, target) {
    let len = nums.length;
    // 特殊判断
    if (nums[len - 1] < target) {
        return len;
    }

    // 程序走到这里一定有 nums[len - 1] >= target，插入位置在区间 [0..len - 1]
    let left = 0;
    let right = len - 1;
    while (left < right) {
        // 防止left+right越界
        let mid = parseInt(left + (right - left) / 2);
        if (nums[mid] < target){
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return left;
};