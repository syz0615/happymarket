// 接口地址配置信息
let host = ''
let apiUrl = ''

if (process.env.NODE_ENV === 'development') {
    // 开发环境
    // host = 'https://demo.jihainet.com'
    // apiUrl = host + '/api.html'
    host = '192.168.43.8:8080'
    apiUrl = host + '/api.html'

} else if (process.env.NODE_ENV === 'production') {
    // 生产环境
    host = window.host
    apiUrl = host + '/api.html'
}

export {
    host,
    apiUrl
}