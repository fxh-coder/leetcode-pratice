/**
 * @param {number[][]} isConnected
 * @return {number}
 */
var findCircleNum = function(isConnected) {
    const cities = isConnected.length;
    const visited = new Set();
    let res = 0;

    const dfs = (isConnected, visited, cities, i) => {
        for(let j = 0; j < cities; j++) {
            if(isConnected[i][j] == 1 && !visited.has(j)) {
                visited.add(j);
                dfs(isConnected, visited, cities, j);
            }
        }
    }

    for(let i = 0; i < cities; i++) {
        if(!visited.has(i)){
            dfs(isConnected, visited, cities, i);
            res++;
        }
    }

    return res;

};