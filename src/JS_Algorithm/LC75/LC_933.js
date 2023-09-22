var RecentCounter = function() {
    this.cnt = [];
};

/**
 * @param {number} t
 * @return {number}
 */
RecentCounter.prototype.ping = function(t) {
    this.cnt.push(t);
    while(this.cnt[0] < t - 3000)
        this.cnt.shift();
    return this.cnt.length;
};

/**
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = new RecentCounter()
 * var param_1 = obj.ping(t)
 */