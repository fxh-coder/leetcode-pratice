/**
 * @param {string} s
 * @return {string[]}
 */
var permutation = function(s) {
    s = Array.from(s).sort();
    let n = s.length;
    let res = [];
    let temp = [];
    let used = new Array(n).fill(false);

     
    const dfs = (s, cur, n, temp, res, used) => {
        if(temp.length == n) {
            res.push(temp.join(""));
            return;
        }

        for(let i = 0; i < n; i ++) {
            if(used[i] || (i > 0 && !used[i - 1] && s[i] == s[i - 1]))
                continue; 
            temp.push(s[i]);
            used[i] = true;

            dfs(s, cur+1, n, temp, res, used);

            used[i] = false;

            temp.pop();
            
        }
    }

    dfs(s, 0, n, temp, res, used);
    return res;
};