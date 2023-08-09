/**
 * @param {number} target
 * @return {number[][]}
 */
var findContinuousSequence = function(target) {
    let sum = 1   //窗口数组的和
    let list =[1] //窗口
    let returnList =[]
    for(let i = 2 ; i<= Math.ceil(target/2) ; i++) {
        sum+=i
        list.push(i)  //每次循环，都将当前的数加入滑动窗口中
        while(sum>target){
            sum-=list.shift()  //移除前面较小的数
        }
        if(sum==target){
            returnList.push(list.slice(0))   //slice深拷贝
        }
    }
    return returnList
};
