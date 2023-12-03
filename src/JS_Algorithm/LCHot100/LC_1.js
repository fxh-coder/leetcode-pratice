/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let res = [];
    for(let i = 0; i < nums.length; i++) {
        let flag = false;
        for(let j = i + 1; j < nums.length; j++) {
            if(nums[i] + nums[j] == target) {
                res.push(i);
                res.push(j);
                flag = true;
                break;
            }
        }
        if(flag) {
            break;
        }
    }
    return res;
};