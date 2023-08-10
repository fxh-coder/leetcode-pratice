/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findMaxAverage = function(nums, k) {
    let max = 0, pre = 0;

    for(let i = 0; i < k; i++)
        pre += nums[i];

    max = pre;

    for(let i = k, j = 0; i < nums.length, j < nums.length - k; i++, j++) {
        let cur = pre - nums[j] + nums[i];

        max = Math.max(max, cur);
        pre =  cur;
    }

    return max / k;
};