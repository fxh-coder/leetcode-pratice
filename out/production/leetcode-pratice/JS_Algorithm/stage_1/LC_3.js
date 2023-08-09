/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let res = "";
    let max = 0;
    let j = 0,
        i = 0,
        start = 0;
    while (i < s.length) {
        if (res.indexOf(s[i]) == -1) {
            res += s[i];
            if (res.length > max) max = res.length;
            i++;
        } else {
            res = "";
            i = start + 1;
            start = i;
        }
    }
    return max;
};