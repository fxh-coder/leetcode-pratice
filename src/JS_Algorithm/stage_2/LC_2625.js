/**
 * @param {any[]} arr
 * @param {number} depth
 * @return {any[]}
 */
var flat = function (arr, n) {
    let res = [];
    arr.forEach((item, index) => {
        res = res.concat(dfs(item, 0, n));
        console.log(`当前是${index}个位置：`, res);
    })
    return res;
    
    function dfs(arr, curN, n) {
        if(curN >= n) return arr;
        
        if(Array.isArray(arr)) {
            let res = [];
            arr.forEach(item => {
               res.push(dfs(item, curN+1, n));
            })
            console.log("dfs", res);
            return res;
        } else {
            console.log("ok", arr);
            return arr;
        }
        
    }
};

let arr = [[1, 2, 3], [4, 5, 6], [7, 8, [9, 10, 11], 12], [13, 14, 15]];
flat(arr, 2);