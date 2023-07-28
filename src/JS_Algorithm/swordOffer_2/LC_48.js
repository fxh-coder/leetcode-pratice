/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let str = "", maxNum = 0;
     
     for (let i = 0; i < s.length; i++) {
          
         let idx = str.indexOf(s[i]);
         if (idx != -1) {
             str = str.substr(idx+1) + s[i];
         } else {
             str += s[i]
             maxNum = maxNum > str.length ? maxNum : str.length;
         }
         
     } 
     return maxNum;
 };