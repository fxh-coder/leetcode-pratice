/**
 * @param {string} str1
 * @param {string} str2
 * @return {string}
 */
var gcdOfStrings = function(str1, str2) {
    let len1 = str1.length, len2 = str2.length;

    // 使用长度除以截取的长度，看看可以循环几次，每次添加截取的字符串，如果最后和
    // 原字符串相等，那就是该字符串的公因子
    const check = (t, s) => {
        let lenx = s.length / t.length;
        let ans = "";
        for (let i = 1; i <= lenx; ++i) {
            ans += t;
        }
        return ans == s;
    }

    // 以长度短的为准
    for (let i = Math.min(len1, len2); i >= 1; --i) {
        // 必须要能除尽，否则不能循环构成，也就不是公因子
        if (len1 % i == 0 && len2 % i == 0) {
            // 截取
            let X = str1.substring(0, i);
            if (check(X, str1) && check(X, str2)) {
                return X;
            }
        }
    }
    return "";

};