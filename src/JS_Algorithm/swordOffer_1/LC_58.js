/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    s = s.trim();

    let res = s.split(" ");
    res = res.filter(item => item != "");
    return res.reverse().join(" ");
};
console.log(reverseWords("a good   example"));