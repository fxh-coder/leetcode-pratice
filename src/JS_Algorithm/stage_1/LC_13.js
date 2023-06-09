/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(s) {
    let res = 0;
    for (let i = 0; i < s.length; i++) {
        let curV = getValue(s[i]);
        if(i < s.length - 1 && curV < getValue(s[i+1]))
            res -= curV;
        else
            res += curV;
    }
    return res;

    function getValue(ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
};