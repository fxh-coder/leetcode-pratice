/**
 * @param {number} n
 * @return {number}
 */
var findNthDigit = function(n) {
    let d = 1, count = 9;
    while (n > d * count) {
        n -= d * count;
        d++;
        count *= 10;
    }
    // 下标是从零开始计算
    const index = n - 1;
    // while的退出是到达某一位数的数时小于，比如是四位数，所以d就是4，所以起始位置就是1000
    const start = Math.floor(Math.pow(10, d - 1));
    // 得出具体是哪一个数字
    const num = start + Math.floor(index / d);
    // 得出在该数字中第几位
    const digitIndex = index % d;
    // 上述判断出该数字是d-1位的，然后在该数字中又是digitIndex位，所以先除在取余就得到当前的数字了
    const digit = Math.floor(num / Math.floor(Math.pow(10, d - digitIndex - 1))) % 10;
    return digit;
};