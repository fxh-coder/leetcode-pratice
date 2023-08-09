/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isSubsequence = function(s, t) {
    if(s.length == 0) return true;
    if(t.length == 0) {
        if(s.length == 0) return true;
        else return false;
    }
    let cnt = 0;
    for (let i = 0; i < t.length; i++) {
        if(s.charAt(cnt) == t.charAt(i)) {
            cnt++;
            if(cnt == s.length) return true;
        }
    }
    return false;
};