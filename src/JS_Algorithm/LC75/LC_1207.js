/**
 * @param {number[]} arr
 * @return {boolean}
 */
var uniqueOccurrences = function(arr) {
    let prc = new Map();

    arr.forEach(num => {
        if(prc.has(num)) {
            prc.set(num, prc.get(num) + 1);
        } else {
            prc.set(num, 1);
        }
    })

    let cnt = [];
    for(let key of prc.keys()) {
        cnt.push(prc.get(key));
    }

    cnt.sort((a, b) => a - b);

    let pre = cnt[0];
    for(let i = 1; i < cnt.length; i++) {
        if(pre == cnt[i])
            return false;
        pre = cnt[i];
    }

    return true;
};