/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var maxVowels = function(s, k) {
    let vowel_count = 0;
    let vowel = ["a", "e", "i", "o", "u"];

    let n = s.length;
    for (let i = 0; i < k; ++i) {
        if(vowel.includes(s.charAt(i)))
            vowel_count++;
    }
    let ans = vowel_count;
    for (let i = k; i < n; ++i) {
        if(vowel.includes(s.charAt(i)))
            vowel_count++;
        if(vowel.includes(s.charAt(i - k)))
            vowel_count--;
        ans = Math.max(ans, vowel_count);
    }
    return ans;

};