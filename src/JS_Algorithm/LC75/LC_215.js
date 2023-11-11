/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function(nums, k) {
    let heapSize = nums.length;
    // 构建大顶堆
    buildMaxHeap(nums, heapSize)

    // 进行下沉：就是将最大元素与最后一个元素交换
    for(let i = nums.length - 1; i >= nums.length - k + 1; i--) {
        swap(nums, 0, i);
        --heapSize;
        // 交换之后，最大元素不在参与堆的调整，所以重新调整堆
        maxHeapify(nums, 0, heapSize);
    }
    return nums[0];

    function buildMaxHeap(nums, heapSize) {
        // 从下往上构建，从第一个非叶子节点开始
        for(let i = Math.floor(heapSize / 2) - 1; i >= 0; i--) {
            maxHeapify(nums, i, heapSize)
        }
    }

    function maxHeapify(nums, i, heapSize) {
        let l = i * 2 + 1;
        let r = i * 2 + 2;
        let largest = i;
        if(l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if(r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }

        if(largest != i) {
            swap(nums, i, largest);
            // 调整下面的非叶子节点
            maxHeapify(nums, largest, heapSize);
        }
    }

    function swap(a, i, j) {
        let temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
};