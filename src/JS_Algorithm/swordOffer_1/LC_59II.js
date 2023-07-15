let MaxQueue = function () {
    this.queue = [];
    this.maxQueue = [];
};

/**
 * @return {number}
 */
MaxQueue.prototype.max_value = function () {
    return this.maxQueue.length ? this.maxQueue[0] : -1;
};

/**
 * @param {number} value
 * @return {void}
 */
MaxQueue.prototype.push_back = function (value) {
    this.queue.push(value);
    while (this.maxQueue.length && this.maxQueue[this.maxQueue.length - 1] < value) {
        this.maxQueue.pop();
    }
    this.maxQueue.push(value);
};

/**
 * @return {number}
 */
MaxQueue.prototype.pop_front = function () {
    if (!this.queue.length) {
        return -1;
    }
    const value = this.queue.shift();
    if (value === this.maxQueue[0]) {
        this.maxQueue.shift();
    }
    return value;
};

/**
 * Your MaxQueue object will be instantiated and called as such:
 * var obj = new MaxQueue()
 * var param_1 = obj.max_value()
 * obj.push_back(value)
 * var param_3 = obj.pop_front()
 */