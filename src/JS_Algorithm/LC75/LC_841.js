/**
 * @param {number[][]} rooms
 * @return {boolean}
 */
var canVisitAllRooms = function(rooms) {
    let res = new Array(rooms.length).fill(-1);
    let stack = [];
    let flag = new Array(rooms.length).fill(false);
    flag[0] = true;

    for(let i = 0; i < rooms[0].length; i++) {
        stack.push(rooms[0][i]);
    }

    while(stack.length > 0) {
        let cur = stack.shift();
        flag[cur] = true;
        res[cur] = cur;

        for(let i = 0; i < rooms[cur].length; i++) {
            if(flag[rooms[cur][i]] == false) {
                stack.push(rooms[cur][i]);
            }
        }
    }
    for(let i = 1; i < rooms.length; i++)
        if(res[i] == -1)
            return false;

    return true;

};