
/**
 * @param {number[]} a
 * @return {number[]}
 */
var constructArr = function(a) {
    const res = []
    for (let i = 0, mul = 1; i < a.length; mul *= a[i], i++) {
        res[i] = mul;
    }
    for (let i = a.length - 1, mul = 1; i >= 0; mul *= a[i], i--) {
        res[i] *= mul
    }
    return res
};