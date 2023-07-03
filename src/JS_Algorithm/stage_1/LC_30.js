/**
 * @param {string} s
 * @param {string[]} words
 * @return {number[]}
 */
var findSubstring = function(s, words) {
    let totalLen = words.length, len = words[0].length;
    let slen = totalLen * len;
    let res = [];
     
    for(let i = 0; i <= s.length - slen; i++) {
        let cur = s.slice(i, i + slen);
        let map = new Map();
        words.forEach(item => {
            if(map.has(item)) {
                map.set(item, map.get(item)+1);
            } else {
                map.set(item, 1);
            }
        })
        console.log(cur);
        let cnt = 0;
        for(let j = 0; j <= cur.length - len; j = j + len) {
            let subCur = cur.slice(j, j + len);
            console.log(subCur);
            if(map.has(subCur) && map.get(subCur) > 0) {
                console.log("ok");
                map.set(subCur, map.get(subCur) - 1);
                cnt++;
            } else {
                console.log("ok1");
                break;
            }
        }
        if(cnt == totalLen) {
            res.push(i);
        }
    }
    return res;
};  

console.log(findSubstring("wordgoodgoodgoodbestword", ["word","good","best","word"]))