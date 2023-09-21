/**
 * @param {number[]} asteroids
 * @return {number[]}
 */
var asteroidCollision = function(asteroids) {
    let res = [];

    let i = 0;
    while(i < asteroids.length) {
        let flag = true;
        while(flag && asteroids[i] < 0 && res.length > 0 && res[res.length - 1] > 0) {
            flag = res[res.length-1] < -asteroids[i];
            if(res[res.length -1] <= -asteroids[i]) {
                res.pop();
            }
        }
        if(flag)
            res.push(asteroids[i]);
        i++;
    }

    return res;
};