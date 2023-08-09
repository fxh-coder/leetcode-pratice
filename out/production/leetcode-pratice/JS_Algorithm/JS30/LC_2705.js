var compactObject = function(obj) {
    if (obj == null || typeof obj !== 'object') {
        return obj;
    }
    let res;
    if (Array.isArray(obj)) {
        res = [];
        for (let it of obj) {
            const val = compactObject(it);
            if (val) res.push(val);
        }
    } else {
        res = {};
        const keys = Object.keys(obj);
        for (let key of keys) {
            const val = compactObject(obj[key]);
            if (val) res[key] = val;
        }
    }
    return res;
};