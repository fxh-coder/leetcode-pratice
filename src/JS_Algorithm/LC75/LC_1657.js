/**
 * @param {string} word1
 * @param {string} word2
 * @return {boolean}
 */

var closeStrings = function (word1, word2) {
    if (word1.length !== word2.length) return false;

    let map1 = new Array(26).fill(0);
    for (let i = 0; i < word1.length; i++) {
        map1[word1[i].charCodeAt(0) - 97]++;
    }

    let map2 = new Array(26).fill(0);
    for (let i = 0; i < word2.length; i++) {
        let index = word2[i].charCodeAt(0) - 97;
        if (map1[index] === 0) return false;
        map2[index]++;
    }

    map1.sort((a, b) => a - b);
    map2.sort((a, b) => a - b);

    for (let i = 0; i < 26; i++) {
        if (map1[i] !== map2[i]) return false;
    }
    return true;
};