/**
 * @param {string} senate
 * @return {string}
 */
var predictPartyVictory = function(senate) {
    const n = senate.length;
    const radiant = [], dire = [];

    for (const [i, ch] of Array.from(senate).entries()) {
        // 存储 i 是为了区分前后
        if (ch === 'R') {
            radiant.push(i);
        } else {
            dire.push(i);
        }
    }

    while (radiant.length && dire.length) {
        // 小于的话说明R方在D方前面，先使用权力
        if (radiant[0] < dire[0]) {
            radiant.push(radiant[0] + n);
        } else {
            dire.push(dire[0] + n);
        }
        radiant.shift();
        dire.shift();
    }
    return radiant.length ? "Radiant" : "Dire";
};
