/**
 * @param {number[]} nums
 * @return {number}
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var longestSubarray = function(nums) {
    let left = 0, zero = 0, max = 0;
    for(let i = 0; i < nums.length; i++) {
        if(nums[i] == 0) {
            zero++;
        }
        while(zero > 1) {
            if(nums[left] == 0) {
                zero--;
            }
            left++;
        }
        max = Math.max(max, i - left + 1 - zero);
    }
    return max == nums.length ? max - 1 : max;
}
