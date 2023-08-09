/**
 * @param {string} s
 * @return {character}
 */
var firstUniqChar = function(s) {
    if(s.length == 0)
        return ' ';
    let res = new Map();
    for(let i = 0; i < s.length; i++) {
        if(res.has(s[i])) {
            res.set(s[i], res.get(s[i]) + 1);
        } else {
            res.set(s[i], 1);
        }
    }
    let flag = false, ans;
    for (let key of res.keys()) {
        if(res.get(key) == 1) {
            flag = true;
            ans = key;
            break;
        }
    }
    return flag ? ans : " ";
}