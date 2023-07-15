/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let l = 0, r = nums.length - 1;
    while(l < r) {
        let res = nums[l] + nums[r];
        if(res == target)
            return [nums[l], nums[r]];
        else if(res > target)
            r--;
        else
            l++;
    }
};