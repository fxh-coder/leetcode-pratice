/**
 * @param {number} n
 * @return {number[]}
 */
var countBits = function(n) {
    let result = new Array(n+1);
    result[0] = 0;
    for(let i = 1; i <= n; i++)
    {
        if(i % 2 == 1)
        {
            result[i] = result[i-1] + 1;
        }
        else
        {
            result[i] = result[i/2];
        }
    }

    return result;
};