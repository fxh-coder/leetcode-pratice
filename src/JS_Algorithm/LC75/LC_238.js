/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
    let res = []

    for(let i = 0, prc = 1; i < nums.length; prc *=nums[i], i++) {
        res[i] = prc;
    }

    for(let i = nums.length - 1, prc = 1; i >= 0; prc *= nums[i], i--) {
        res *= prc;
    }

    return res;
};