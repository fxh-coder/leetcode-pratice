/**
 * @param {string} digits
 * @return {string[]}
 */
//一个映射表，第二个位置是"abc“,第三个位置是"def"...
let letter_map = [
    " ",
    "*",
    "abc",
    "def",
    "ghi",
    "jkl",
    "mno",
    "pqrs",
    "tuv",
    "wxyz",
];



var letterCombinations = function (digits) {
    //注意边界条件
    if (digits == null || digits.length == 0) {
        return [];
    }
    //最终输出结果的list
    let res = [];
    iterStr(digits, "", 0, res);
    console.log(res);
    return res;
};

//递归函数
function iterStr(str, letter, index, res) {

    if (index == str.length) {
        res.push(letter);
        return;
    }

    let pos = str.charAt(index);
    let map_string = letter_map[pos];


    for (let i = 0; i < map_string.length; i++) {
        letter += map_string[i];
        iterStr(str, letter, index + 1, res);
        letter = letter.substring(0, letter.length - 1);
    }
}
