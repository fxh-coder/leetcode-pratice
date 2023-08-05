/**
 * @param {string} word1
 * @param {string} word2
 * @return {string}
 */
var mergeAlternately = function(word1, word2) {
    let res = "";
    let i = 0, j = 0;
    while(i < word1.length && j < word2.length) {
        res += word1.charAt(i);
        res += word2.charAt(j);
        i++;
        j++;
    }
    if(i < word1.length) {
        for(let k  = i; k < word1.length ;k++)
            res += word1.charAt(k);
    }
    if(j < word2.length) {
        for(let k  = j; k < word2.length ;k++)
            res += word2.charAt(k);
    }
    return res;
};