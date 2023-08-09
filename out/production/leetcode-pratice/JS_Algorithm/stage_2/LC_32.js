/**
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function(s) {
    if(s.length == 0) return 0;

    let stack = [];
    stack.push(-1);

    let i = 0, n = s.length, max= 0;
    while(i < n) {
        if(s[i] == '(') {
            stack.push(i);
        } else {
            stack.pop();
            if(stack.length == 0) {
                stack.push(i);
            } else {
                max = Math.max(max, i - stack[stack.length - 1]);
            }
        }
        i++;
    }
    return max;
};

console.log(longestValidParentheses(")()())"));