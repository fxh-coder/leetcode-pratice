/**
 * @param {number} n
 * @param {number} m
 * @return {number}
 */
var lastRemaining = function(n, m) {
    const dfs = (n, m) => {
        if(n == 1)
            return 0;
        let x = dfs(n - 1, m);
        return (m + x) % n;
    }

    return dfs(n, m);
};