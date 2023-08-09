/**
 * @param {number} n
 * @return {number[]}
 */
var printNumbers = function(n) {
    const len = Math.pow(10, n) - 1;
    let dp = new Array(len).fill(1);
    for (let i = 1; i < len; i++) dp[i] += dp[i - 1];
    return dp;
};