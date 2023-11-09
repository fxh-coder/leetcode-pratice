/**
 * @param {character[][]} maze
 * @param {number[]} entrance
 * @return {number}
 */
var nearestExit = function(maze, entrance) {
    let dirs = [[-1, 0], [1, 0], [0, 1], [0, -1]]

    let queue = [[...entrance, 0]]

    while(queue.length > 0) {
        let [row, col, step] = queue.shift()
        for(let i = 0; i < 4; i++) {
            let [x, y] = dirs[i];
            let nx = row + x;
            let ny = col + y;

            // 这里面虽然传入的只有nx，但是nx可以是新值，也可能因为x是0保持原来的值，所以可能在
            // 新的一行，或者在本行，包含了全部的情况
            let newPos = maze[nx];
            if(newPos) {
                if(newPos[ny] == ".") {
                    if(nx == 0 || nx == maze.length - 1 || ny == 0 || ny == maze[nx].length - 1){
                        return step + 1;
                    }
                    maze[nx][ny] = "+";
                    queue.push([nx, ny, step + 1])
                }
            }
        }
        maze[row][col] = "+"
    }
    return -1;
};