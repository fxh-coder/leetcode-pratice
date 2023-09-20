/**
 * @param {string} s
 * @return {string}
 */
var removeStars = function(s) {
    let stack = [];

    for(let i = 0; i < s.length; i++) {
        if(s[i] != "*") {
            stack.push(s[i]);
        } else {
            if(stack.length > 0)
                stack.pop();
        }
    }

    let res = "";

    stack.forEach(c => {
        res += c;
    })

    return res;

};