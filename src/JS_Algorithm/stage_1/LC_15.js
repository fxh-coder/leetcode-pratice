/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
    let n = nums.length;
    nums.sort((a, b) => {
        return a - b;
    });
    console.log(nums);
    let res = [];

    for (let i = 0; i < n; i++) {
        if(i > 0 && nums[i] == nums[i-1])
            continue;

        let k = n - 1;
        let target = -nums[i];

        for (let j = i + 1; j < n; j++) {
            if(j > i + 1 && nums[j] == nums[j-1])
                continue;
            while(j < k && nums[j] + nums[k] > target)
                k--;
            if(j == k)
                break;

            if(nums[j] + nums[k] == target) {
                let list = [];
                list.push(nums[i]);
                list.push(nums[j]);
                list.push(nums[k]);
                res.push(list);
            }
        }
    }
    return res;
}