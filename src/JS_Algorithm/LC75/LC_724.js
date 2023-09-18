/**
 * @param {number[]} nums
 * @return {number}
 */
var pivotIndex = function(nums) {
    let i = 0, n = nums.length;

    while(i < n) {
        let leftSum = 0, rightSum = 0;

        for(let left = 0; left < i; left++) {
            leftSum += nums[left];
        }

        for(let right = i + 1; right < n; right++) {
            rightSum += nums[right];
        }

        if(leftSum == rightSum)
            return i;

        i++;
    }

    return -1;

};