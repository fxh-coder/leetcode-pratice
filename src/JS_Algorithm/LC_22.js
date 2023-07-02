/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    function generateAll(len, current, pos, result) {
        if (pos == len) {
            if (valid(current)) { 
                let str = "";
                current.forEach(item => {
                    str += item;
                })
                result.push(str); 
            }
        } else {
            current[pos] = '(';
            generateAll(len, current, pos + 1, result);
            current[pos] = ')';
            generateAll(len, current, pos + 1, result);
        }
    }

    function valid(current) {
        let balance = 0;
        for (let c of current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
    let result = [];
    generateAll(2 * n, [], 0, result);

    return result;
};

