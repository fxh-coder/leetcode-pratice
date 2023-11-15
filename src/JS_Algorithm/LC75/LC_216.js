/**
 * @param {number} k
 * @param {number} n
 * @return {number[][]}
 */
var combinationSum3 = function(k, n) {

    let temp = [];
    let res = [];

    const dfs = (cur, n, res, k, target) => {
        if(temp.length + (n - cur + 1) < k || temp.length > k)
            return;
        if(temp.length == k  && target == 0) {
            res.push(temp.slice());
            return;
        }

        temp.push(cur);
        dfs(cur + 1, n, res, k, target - cur);

        temp.pop();
        dfs(cur + 1, n, res, k, target);

    }

    dfs(1, 9, res, k, n);
    return res;
};