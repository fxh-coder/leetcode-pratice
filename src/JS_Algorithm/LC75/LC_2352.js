var equalPairs = function(grid) {
    const n = grid.length;
    const cnt = {};

    for (const row of grid) {
        const rowStr = row.toString();
        // 用行的内容为下标计数
        cnt[rowStr] = (cnt[rowStr] || 0) + 1;
    }

    let res = 0;
    for (let j = 0; j < n; j++) {
        const arr = [];
        for (let i = 0; i < n; i++) {
            // 将每一列的内容进行整合，注意下标，这里计算的是每一列
            arr.push(grid[i][j]);
        }
        const arrStr = arr.toString();
        // 如果以列的内容为下标，能够在刚才以行内容为下标的数组中找到相同的内容，说明相同，加一
        if (cnt[arrStr]) {
            res += cnt[arrStr];
        }
    }

    return res;
};