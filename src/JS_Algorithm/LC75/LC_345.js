/**
 * @param {string} s
 * @return {string}
 */
var reverseVowels = function(s) {
    const isVowel = (ch) => {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    } 

    let n = s.length;
    let str = Array.from(s)
    let i = 0, j = n - 1;

    while (i < j) {
        while (i < n && !isVowel(str[i])) {
            ++i;
        }
        while (j > 0 && !isVowel(str[j])) {
            --j;
        }
        
        if (i < j) { 
            const temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            ++i;
            --j; 
        }
    }
    return str.join("");
};

console.log(reverseVowels("hello"))