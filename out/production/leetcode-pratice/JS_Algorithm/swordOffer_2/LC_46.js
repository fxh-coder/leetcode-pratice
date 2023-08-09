const translateNum = (num) => {
    const str = num.toString();
    const n = str.length;
  
    const memo = new Array(n);
    memo[n - 1] = 1;   // 指针临界时的子树的计算结果
    memo[n] = 1;       // 指针越界时的子树的计算结果
  
    const dfs = (str, pointer, memo) => {
      if (memo[pointer]) return memo[pointer]; // 之前存过，直接拿来用
  
      const temp = Number(str[pointer] + str[pointer + 1]);
  
      if (temp >= 10 && temp <= 25) {
        memo[pointer] = dfs(str, pointer + 1, memo) + dfs(str, pointer + 2, memo);
      } else {
        memo[pointer] = dfs(str, pointer + 1, memo);
      }
  
      return memo[pointer]; // 当前子树的计算结果向上返回
    };
  
    return dfs(str, 0, memo);
  }