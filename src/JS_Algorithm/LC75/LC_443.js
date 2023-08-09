/**
 * @param {character[]} chars
 * @return {number}
 */
var compress = function(chars) {
    const n = chars.length;
    let write = 0, left = 0;
    for (let read = 0; read < n; read++) {
        if (read === n - 1 || chars[read] !== chars[read + 1]) {
            chars[write++] = chars[read];
            // 记录相同字符的总长度
            let num = read - left + 1;
            // 如果长度比1大，那就需要填写具体的长度值
            if (num > 1) {
                // 记录的就是开始填数字时的下标
                const anchor = write;
                // 这里的填入相当于是从个位数字填的，所以后面需要反转
                while (num > 0) {
                    chars[write++] = '' + num % 10;
                    num = Math.floor(num / 10);
                }
                // 反转数字部分
                reverse(chars, anchor, write - 1);
            }
            // 更新左边界，用来计算下一个不同字符的长度
            left = read + 1;
        }
    }
    return write;
};

const reverse = (chars, left, right) => {
    // 反转采用的是双子针
    while (left < right) {
        const temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
        left++;
        right--;
    }
}
