/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[][]}
 */
var findDifference = function(nums1, nums2) {
    let set1 = new Set(nums1), set2 = new Set(nums2)
    let ans = []
    let arr1 = [], arr2 = []
    for (let item of nums1) {
        if (!set2.has(item)) {
            arr1.push(item)
        }
    }
    ans.push([...new Set(arr1)])
    for (let item of nums2) {
        if (!set1.has(item)) {
            arr2.push(item)
        }
    }
    ans.push([...new Set(arr2)])
    return ans
};
