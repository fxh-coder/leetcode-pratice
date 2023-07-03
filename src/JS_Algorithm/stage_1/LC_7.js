var reverse = function(x) {
    let res = 0;
    while(x){
        res = res * 10 + x % 10;
        if(res > Math.pow(2, 31) - 1 || res < Math.pow(-2, 31)) return 0;
        x = parseInt(x / 10);
    }
    return res;
};

/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    let str = parseInt(x.toString().split('').reverse().join(''));
    if(str> Math.pow(2,31) - 1 || -str < Math.pow(-2, 31) - 1) {
        return 0;
    }

    return x > 0 ? str : -str;

};