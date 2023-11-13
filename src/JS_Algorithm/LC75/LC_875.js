/**
 * @param {number[]} piles
 * @param {number} h
 * @return {number}
 */
var minEatingSpeed = function(piles, h) {
    const getTime = (piles, speed) => {
        let time = 0;
        for(const pile of piles) {
            const curTime = Math.ceil(pile / speed);
            time += curTime;
        }
        return time;
    }

    let low = 1, high = 0;

    high = Math.max(...piles);

    let res = high;

    while(low < high) {
        const speed = Math.floor((high - low) / 2) + low;
        const time = getTime(piles, speed);
        if(time <= h) {
            res = speed;
            high = speed;
        } else {
            low = speed + 1;
        }
    }
    return res;
};