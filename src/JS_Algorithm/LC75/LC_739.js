/**
 * @param {number[]} temperatures
 * @return {number[]}
 */
const dailyTemperatures = (T) => {
    const res = new Array(T.length).fill(0);
    const stack = []
    for (let i = 0; i < T.length; i++) {
        while(stack.length > 0 && T[i] > T[stack[stack.length - 1]]) {
            res[stack[stack.length - 1]] = i - stack[stack.length - 1];
            stack.pop();
        }
        stack.push(i);
    }
    return res;
}