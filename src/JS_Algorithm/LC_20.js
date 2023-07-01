/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    if(s.length % 2 == 1) return false;

    let stack = [];
    for (let i = 0; i < s.length; i++) {
        let c = s.charAt(i);
        if (c == '(' || c == '[' || c == '{') {
            stack.push(c);
        } else if (stack.length != 0) {
            let c1 = stack.pop();

            if(c == ')' && c1 != '(') return false;
            else if(c == ']' && c1 != '[') return false;
            else if(c == '}' && c1 != '{') return false;
        } else {
            return false;
        }
    }

    return stack.length == 0;
};