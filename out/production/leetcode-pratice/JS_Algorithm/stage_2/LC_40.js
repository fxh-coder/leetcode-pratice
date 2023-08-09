/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function(candidates, target) {
    candidates.sort((a, b) => {
        return a - b;
    })
    let temp = [], res = [], used = [];

    let n = candidates.length;
    dfs(0, candidates, n, target, used);
    return res;


    function dfs(begin, candidates, n, target, used) {
        if (target < 0) return;
        // 记录合法的答案
        if (target == 0) {
            res.push(temp);
            return;
        }
        for(let i = begin; i < n; i++) {
            if(!used[i]) {
                if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                    continue;
                }
                // 考虑选择当前位置
                temp.push(candidates[i]);
                used[i] = true;

                dfs(i + 1, candidates, n, target - candidates[i], used);

                temp = temp.slice(0, temp.length - 1);

                used[i] = false;
            }
        }
    }
};