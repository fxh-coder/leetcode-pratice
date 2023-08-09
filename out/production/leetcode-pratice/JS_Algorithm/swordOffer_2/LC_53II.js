/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function(nums) {
    let n = nums.length;
    let prc = new Array(n).fill(0);
    for(let i = 0; i < n; i++) {
        prc[nums[i]] = n;
    }
    let flag = -1;
    for(let i = 0; i < n; i++) {
        if(prc[i] < n) {
            flag = i;
            break;
        }
    }
    return flag == -1 ? n : flag;
};