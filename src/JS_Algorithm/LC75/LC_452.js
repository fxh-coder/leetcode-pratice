/**
 * @param {number[][]} points
 * @return {number}
 */
var findMinArrowShots = function(points) {
    points.sort((o1, o2) => {
        if(o1[1] < o2[1])
            return -1;
        else if(o1[1] == o2[1]) {
            if(o1[0] < o2[0])
                return -1;
            else if(o1[0] == o2[0])
                return 0;
            else
                return 1;
        } else
            return 1;
    });

    let res = 1, idx = points[0][1];

    for (let i = 1; i < points.length; i++) {
        let left = points[i][0], right = points[i][1];
        if(!(idx >= left && idx <= right)) {
            res++;
            idx = right;
        }
    }
    return res;
};