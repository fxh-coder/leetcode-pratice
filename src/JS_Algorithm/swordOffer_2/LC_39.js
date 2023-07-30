/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    let cnt = 1, res = nums[0];
    for(let i = 1; i < nums.length; i++) {
        if(nums[i] == res)
            cnt++;
        else {
            cnt--;
            if(cnt == 0) {
                cnt = 1;
                res = nums[i];
            }
        }
    }
    return res;
};