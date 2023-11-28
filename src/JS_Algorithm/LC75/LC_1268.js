/**
 * @param {string[]} products
 * @param {string} searchWord
 * @return {string[][]}
 */
var suggestedProducts = function (products, searchWord) {
    let res = [];
    products.sort();
    for (let i = 0, len = searchWord.length; i < len; ++i) {
        let temp = [];
        products.forEach(product => {
            if (product[i] === searchWord[i]) {
                temp.push(product)
            }
        })
        products = temp;
        res.push(products.length > 3 ? products.slice(0, 3) : products);
    }
    return res;
};
