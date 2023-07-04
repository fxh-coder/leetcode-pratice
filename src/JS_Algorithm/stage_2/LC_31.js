/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
// 参考例子：8、3、4、2、6、7、5
var nextPermutation = function(nums) {
    // 因为要求下一个排列，那么至少是两个数换位置
    let i = nums.length - 2;
    // 从后往前找到第一次前一个数小于后一个数的位置，也就是找到降序终结的第一个位置
    while( i >= 0 && nums[i] >= nums[i + 1]) {
        i--;
    }

    if(i >= 0) {
        let j = nums.length - 1;
        // 找到降序终结位置的数比哪一个数小，然后交换位置
        while (j >= 0 && nums[i] >= nums[j]) {
            j--;
        }
        swap(nums, i, j);
    }
    // 交换后，由于降序排列终结位置替换为了第一个大于该位置的数，那么该位置之后的位置就是降序
    // 排列的，然后将他们变为升序，那就是下一个排列了（降序排列对打，升序排列的值最小）
    reverse(nums, i + 1);

    function swap(nums, i, j) {
        let temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    function reverse(nums, start) {
        let left = start, right = nums.length - 1;
        while(left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
};