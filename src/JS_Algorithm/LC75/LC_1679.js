/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maxOperations = function(nums, k) {
    nums.sort((a, b) => a - b);

    let left = 0, right = nums.length - 1, res = 0;

    while(left < right) {
        let cur = nums[left] + nums[right];

        if(cur > k) {
            right--;
        } else if(cur < k) {
            left++;
        } else{
            res++;
            left++;
            right--;
        }
    }

    return res;
};