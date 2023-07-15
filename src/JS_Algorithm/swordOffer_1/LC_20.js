/**
 * @param {string} s
 * @return {boolean}
 */
var isNumber = function (s) {
    let eFlag = false, dotFlag = false, numFlag = false;
    let i, len;
    s = s.trim();
    len = s.length;
    for(i = 0; i < len; i++) {

        if(s[i] >= "0" && s[i] <= "9") {
            numFlag = true;
        } else if(s[i] == "." && eFlag == false && dotFlag == false) {
            dotFlag = true;
        } else if(s[i].toLowerCase() === "e" && eFlag == false && numFlag == true) {

            eFlag = true;
            numFlag = false;
        }else if((s[i] === '+' || s[i] === '-') && (i === 0 || s[i - 1].toLowerCase() == "e")) {

        } else {
            return false;
        }
    }
    return numFlag;
};