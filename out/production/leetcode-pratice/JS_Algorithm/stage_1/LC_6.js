/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function(s, numRows) {
    if(numRows == 1 || numRows > s.length)
        return s;

    let prc = new Array(s.length);
    for (let i = 0; i < numRows; i++) {
        prc[i] = "";
    }

    let row = 0, idx = 0, n = s.length;
    while(idx < n) {
        // 对于每次从第一行到numRows行的循环
        while(row < numRows && idx < n) {
            prc[row] += s[idx++];
            row++;
        }

        if(idx == n)
            break;

        // 将下标回退，本来就是要回退到最后一行的前一个
        // 最后又加了一次才退出循环，所以减2
        row -= 2;
        while(row >= 0 && idx < n) {
            prc[row] += s[idx++];
            row--;
        }

        // 将下标回退，本来就是要回退到第一行的后一个
        // 最后又减了一次才退出循环，所以加2
        row += 2;

    }

    let res = "";
    for (let i = 0; i < numRows; i++) {
        res += prc[i];
    }
    return res;
};