/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    let i = 0, j = 0, res = [];
    while(i < arr1.length && j < arr2.length) {
        if(arr1[i].id > arr2[j].id) {
            res.push(arr2[j]);
            j++;
        } else if(arr1[i].id < arr2[j].id) {
            res.push(arr1[i]);
            i++;
        } else {
            res.push({...arr1[i], ...arr2[j]});
            i++;
            j++;
        }
    }
    if(i < arr1.length) {
        for(let k = i; k < arr1.length; k++)
            res.push(arr1[k]);
    }
    if(j < arr2.length) {
        for(let k = j; k < arr2.length; k++)
            res.push(arr2[k]);
    }
    return res;
};