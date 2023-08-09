/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    let leftIdx = binarySearch(nums, target, true);
    let rightIdx = binarySearch(nums, target, false) - 1;
    if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
        return [leftIdx, rightIdx];
    }
    return [-1, -1];

    function binarySearch(nums, target, lower) {
        let left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            let mid = parseInt((left + right) / 2);
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
};