/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number[]}
 */
var getLeastNumbers = function(arr, k) {
    arr.sort((a, b) => a - b);
    let res = [];
    for(let i = 0; i < k; i++) {
        res.push(arr[i]);
    }
    return res;
};