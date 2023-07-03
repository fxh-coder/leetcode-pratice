/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function(nums, target) {
    let n =nums.length;
    nums.sort((a, b) => {
        return a - b;
    })
    let best = 10000000; 

    for (let i = 0; i < n; i++) {
        if(i > 0 && nums[i] == nums[i-1])
            continue;
        
        let k = n - 1, j = i + 1;
        while(j < k) {
           
            if(j > i + 1 && nums[j] == nums[j-1])
                j++;

            let sum = nums[i] + nums[j] + nums[k];
             if (sum == target) {
                return target;
            }

            if (Math.abs(sum - target) < Math.abs(best - target)) {
                best = sum;
            } 

            if(sum > target)
                k--;
            else 
                j++;

            
        }
    }

    return best;
};