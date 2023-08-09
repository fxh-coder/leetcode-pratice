var CQueue = function() {
    this.inStack = [];
    this.outStack = [];
};

CQueue.prototype.appendTail = function(value) {
    this.inStack.push(value);
};

CQueue.prototype.deleteHead = function() {
    if(this.outStack.length > 0) {
        return this.outStack.pop();
    } else {
        while (this.inStack.length) {
            this.outStack.push(this.inStack.pop());
        }
        return this.outStack.length > 0 ? this.outStack.pop() : -1;
    }
};