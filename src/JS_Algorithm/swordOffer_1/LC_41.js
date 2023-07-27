
/**
 * initialize your data structure here.
 */
var MedianFinder = function () {
    this.nums = []
};

/**
 * @param {number} num
 * @return {void}
 */
MedianFinder.prototype.addNum = function (num) {
    let left = 0, right = this.nums.length - 1
    while (left <= right) {
        let mid = (left + right) >> 1
        if (this.nums[mid] < num) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    this.nums.splice(left, 0, num)
};

/**
 * @return {number}
 */
MedianFinder.prototype.findMedian = function () {
    if (this.nums.length & 1) {
        return this.nums[this.nums.length >> 1]
    } else {
        return (this.nums[this.nums.length >> 1] + this.nums[(this.nums.length >> 1) - 1]) / 2
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = new MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */