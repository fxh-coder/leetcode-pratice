/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
    let minL = strs[0].length, minIdx = 0;
    for(let i = 1; i < strs.length; i++) {
        let curL = strs[i].length;
        if(curL < minL) {
            minL = curL;
            minIdx = i;
        }
    }

    let j = 0;
    let res = "";
    while(j < minL) {
        let curCh = strs[minIdx][j];
        let flag = 0;
        strs.forEach(item => {
            if(item[j] != curCh) {
                flag = 1;
            }
        })
        if(flag == 0) {
            res += curCh;
            j++;
        } else {
            break;
        }
    }
    return res;
};