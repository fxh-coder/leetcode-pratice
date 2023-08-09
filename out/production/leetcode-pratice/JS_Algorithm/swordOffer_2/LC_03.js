/**
 * @param {number[]} nums
 * @return {number}
 */
var findRepeatNumber = function(nums) {
    nums.sort();
    for(let i = 0; i < nums.length; i++) {
        if(i > 0 && nums[i] == nums[i - 1]) {
            return nums[i];
        }
    }
};