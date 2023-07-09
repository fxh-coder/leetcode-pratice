/**
 * @param {Function} fn
 * @return {Array}
 */
Array.prototype.groupBy = function(fn) {
    let res = new Map();
    let prc;
    this.forEach(item => {
        let curKey = fn(item);
        console.log(curKey);
        if(res.has(curKey)) {
            console.log("ok1");
            res.get(curKey).push(item);
            console.log(res);
        } else {
            console.log("ok2");
            prc = [];
            prc.push(item);
            res.set(curKey, prc);
            console.log(res);
        }
    })
    const ans = {}
    for (let [key, val] of map) {
        ans[key] = val
    }
    return ans 
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */
console.log([{"id":"1"},{"id":"1"},{"id":"2"}].groupBy(function (item) { return item.id; }));