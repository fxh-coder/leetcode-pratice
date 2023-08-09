/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    let res = [];
    arr.forEach((item, index) => {
        Boolean(fn(item, index)) ? res.push(item) : -1;
    })
    return res;
};