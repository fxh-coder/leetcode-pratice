/**
 * @param {number} n
 * @return {number}
 */

/**
 * @param {number} n
 * @return {number}
 */
var cuttingRope = function(n) {
    //s的初始值为n=2的情况
    let s=[1,1]
    let len=s.length
    //从3开始
    for(let i=3;i<=n;i++)
    {
        //每次都更改最前面的那个因子
        s[0]++
        //如果因子等于4就要把它分成两个值为2的因子
        if(s[0]==4)
        {
            s[0]=2
            s[++len]=2
        }
        //因为每次更改最前面的，所以要确保最前面是最小的
        s.sort((a,b)=>a-b)
    }
    //用for循环把所有的因子乘起来就是n的最大值
    for(let i=1;i<len;i++)
        s[i]=(s[i-1]*s[i])%1000000007
    return s[len-1]
};