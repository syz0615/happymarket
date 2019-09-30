// 设置localStorage
function setStorage(name, content) {
    if (!name) return
    if (typeof content !== 'string') {
        content = JSON.stringify(content);
    }
    window.localStorage.setItem(name, content);
}

// 获取localStorage
function getStorage(name) {
    if (!name) return
    return window.localStorage.getItem(name);
}

// 删除localStorage
function removeStorage(name) {
    if (!name) return
    window.localStorage.removeItem(name);
}

// 把obj对象里的值覆盖到newobj里面
function deepCopy(newobj, obj) {
    if (typeof obj !== 'object') {
        return obj
    }
    for (let attr in obj) {
        let a = {}
        if (newobj[attr]) {
            a = newobj[attr]
        }
        newobj[attr] = deepCopy(a, obj[attr])
    }
    return newobj
}

// 当出错的时候，显示错误信息，并且跳转
function errorToShow(msg = '出错了，请重试', time = 1000) {
    _this.$dialog.toast({
        mes: msg,
        timeout: time
    })
}
// 操作成功后，的提示信息
function successToShow(msg = '保存成功', callback) {
    wx.showToast({
        title: msg,
        icon: 'success',
        duration: 1000
    })
    if (callback) {
        setTimeout(function() {
            callback()
        }, 500)
    }
}

// 货币格式化
// function formatMoney(number, places, symbol, thousand, decimal) {
//     number = number || 0
//     places = !isNaN((places = Math.abs(places))) ? places : 2
//     symbol = symbol !== undefined ? symbol : '￥'
//     thousand = thousand || ','
//     decimal = decimal || '.'
//     let negative = number < 0 ? '-' : ''
//     let i = parseInt((number = Math.abs(+number || 0).toFixed(places)), 10) + ''
//     let j = i.length > 3 ? i.length % 3 : 0
//     return (
//         symbol +
//         negative +
//         (j ? i.substr(0, j) + thousand : '') +
//         i.substr(j).replace(/(\d{3})(?=\d)/g, '$1' + thousand) +
//         (places
//             ? decimal +
//               Math.abs(number - i)
//                   .toFixed(places)
//                   .slice(2)
//             : '')
//     )
// }

export default {
    setStorage: setStorage,
    getStorage: getStorage,
    removeStorage: removeStorage,
    deepCopy: deepCopy,
}
