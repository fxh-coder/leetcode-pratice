/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    let max = 0;
    for(let i = 0; i < prices.length; i++) {
        for(let j = i + 1; j < prices.length; j++) {
            let cur = prices[j] - prices[i];
            max = Math.max(max, cur);
        }
    }
    return max;
};