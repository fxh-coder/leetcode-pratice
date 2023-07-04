/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function(haystack, needle) {
    let len = needle.length;
    let flag = -1;
    for(let i = 0; i <= haystack.length - len; i++) {
        let cur = haystack.slice(i, i + len);
        if(cur == needle) {
            flag = i;
            break; 
        }
    }
    return flag;
};