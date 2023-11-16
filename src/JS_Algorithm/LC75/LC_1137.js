/**
 * @param {number} n
 * @return {number}
 */
var tribonacci = function(n) {
    if(n == 0) return 0;
    if(n < 3) return 1;

    let a = 0, b = 1, c = 1, cnt = 3, res = 0;

    while(cnt <= n) {
        res = a + b + c;
        a = b;
        b = c;
        c = res;
        cnt++;
    }

    return res;
};