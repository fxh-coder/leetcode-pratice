var minNumber = function(nums) {
    // return nums.sort((a,b)=>(""+a+b)-(""+b+a)).join("");
    const len = nums.length;
    for(let i = 0; i < len; i++){
        for(let j = i+1; j < len; j++){
            if(""+nums[i]+nums[j]-(""+nums[j]+nums[i])>0) [nums[i],nums[j]] = [nums[j],nums[i]]
        }
    }
    return nums.join("")
};
