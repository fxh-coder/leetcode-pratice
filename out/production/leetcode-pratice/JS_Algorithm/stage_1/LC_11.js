/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    let lIdx = 0, rIdx = height.length - 1;
    let maxArea = 0;
    while(lIdx < rIdx) {
        let curArea = Math.min(height[lIdx], height[rIdx]) * (rIdx - lIdx);
        if(maxArea < curArea)
            maxArea = curArea;
        if(height[lIdx] < height[rIdx])
            lIdx++;
        else
            rIdx--;
    }
    return maxArea;
};