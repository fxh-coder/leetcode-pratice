/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function(num) {
    let thousands = ["", "M", "MM", "MMM"];
    let hundreds  = ["", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"];
    let tens      = ["", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"];
    let ones      = ["", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"];

    let res = [];
    res.push(thousands[Math.floor(num / 1000)]);
    res.push(hundreds[Math.floor(num % 1000 / 100)]);
    res.push(tens[Math.floor(num % 100 / 10)]);
    res.push(ones[num % 10]);

    return res.join('');
};