/**
 * @param {number} n
 * @return {number}
 */
var numWays = function(n) {
    if(n < 2) return 1;

    let f1 = 1;
    let f2 = 1;
    let res = 2;
    for (let i = 2; i < n; i++) {
        
        f1 = f2;
        f2 = res;
        res = (f1 + f2) % 1000000007;

    }

    return res;
};