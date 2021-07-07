module.exports = {
    devServer: {
        hot: true,
        port: 8090,
        proxy: {
            "/": {
                //代理地址
                target: "https://mockapi.eolinker.com/MhV47AV5648d8c625cf06bfb7e4d03e4ae96643b853ef94/", //需要代理的地址
                changeOrigin: true, //是否跨域
                secure: false,
                pathRewrite: {
                    "^/": "/"
                }
            }
        },
        open: true,
        noInfo: false,
        overlay: {
            warnings: true,
            errors: true
        }
    },
    // indexPath: "login.html", //index.html的生成路径
    productionSourceMap: true, //不生成map文件
    filenameHashing: false //关闭js,css文件名哈希
};
