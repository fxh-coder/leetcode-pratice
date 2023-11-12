/**
 * @param {number[]} spells
 * @param {number[]} potions
 * @param {number} success
 * @return {number[]}
 */
var successfulPairs = function(spells, potions, success) {
    potions.sort((a, b) => a - b);

    let res = [];

    for(let i = 0; i < spells.length; i++) {
        let cur = spells[i];
        let left = 0, right = potions.length - 1;

        while(left <= right) {
            let mid = Math.floor(left + (right - left) / 2);
            if(cur * potions[mid] >= success) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        res.push(potions.length - left);
    }

    return res;
};