/**
 * @param {number[]} gain
 * @return {number}
 */
var largestAltitude = function(gain) {
    let newGain = new Array(gain.length + 1).fill(0);

    for(let i = 1; i < newGain.length; i++) {
        newGain[i] = gain[i - 1] + newGain[i - 1];
    }
    return Math.max(...newGain);
};