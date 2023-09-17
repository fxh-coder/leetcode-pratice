/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var longestOnes = function(nums, k) {
    let i = 0, j = 0, zeros = 0, maxLen = 0;

    while(j < nums.length) {
        if(nums[j] == 0)
            zeros++

        while(zeros > k) {
            if(nums[i] == 0)
                zeros--
            i++
        }
        j++
        if(j - i > maxLen)
            maxLen = j - i;
    }

    return maxLen
};