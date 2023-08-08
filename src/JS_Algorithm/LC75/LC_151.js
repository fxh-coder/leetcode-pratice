/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    s = s.trim()
    let res = ""
    return s.split(" ").reverse().filter(item => item != "").join(" ")
};
console.log(reverseWords("the sky  is blue "))