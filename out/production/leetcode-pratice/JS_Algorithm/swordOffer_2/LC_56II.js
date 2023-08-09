/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    let prc = new Map(), res = [];

    nums.forEach(item => {
        prc.has(item) ? prc.set(item, prc.get(item) + 1) : prc.set(item, 1);
    })

    for(let key of prc.keys()) {
        if(prc.get(key) == 1)
            res.push(key);
    }

    return res;
};