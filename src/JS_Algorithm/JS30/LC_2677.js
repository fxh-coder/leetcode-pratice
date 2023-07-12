/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array[]}
 */
var chunk = function(arr, size) {
    if(arr.length == 0)
        return [];
    let res = [];
    if(size >= arr.length) {
        res.push(arr);
        return res;
    }
    let prc = [], cnt = 0;;
    for(let i = 0; i < arr.length; i++) {
        if(cnt == size) {
            res.push(prc);
            prc = [];
            cnt = 0;
        }
        prc.push(arr[i]);
        cnt++;

    }
    if(prc.length > 0)
        res.push(prc);
    return res;
};