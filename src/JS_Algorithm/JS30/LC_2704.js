/**
 * @param {string} val
 * @return {Object}
 */
var expect = function(val) {

    return {
        toBe: function (m) {
            if(val === m) {
                return true;
            } else {
                throw "Not Equal";
            }
        },
        notToBe: function (n) {
            if(val === n) {
                throw "Equal";
            } else {
                return true;
            }
        }
    }
};

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */