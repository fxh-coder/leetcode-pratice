/**
 * @param {string} s
 * @return {number}
 */
var myAtoi = function(s) {
    s = s.trim();
    if (s.length == 0) return 0;
    if (!(s[0] >= '0' && s[0] <= '9') && s[0] != '-' && s[0] != '+')
        return 0;

    let ans = 0;
    let neg = 0;
    if (s[0] == '-') {
        neg = 1;
    }

    let i = !(s[0] >= '0' && s[0] <= '9') ? 1 : 0;
    while (i < s.length && (s[i] >= '0' && s[i] <= '9')) {
        ans = ans * 10 + (s[i++] - '0');
        if (neg == 0 && ans > Math.pow(2, 31) - 1) {
            ans = Math.pow(2, 31) - 1;
            break;
        }
        if (neg == 1 && ans >  Math.pow(2, 31)) {
            ans =  Math.pow(2, 31);
            break;
        }
    }
    if(neg == 1) {
        return -ans;
    } else {
        return ans;
    }
};