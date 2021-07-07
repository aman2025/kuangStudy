import _ from "lodash";

export const throttle = (fn, delay) => {
    let timer = null;
    return function (...args) {
        const context = this;
        clearTimeout(timer);
        timer = setTimeout(() => {
            fn.apply(context, args);
        }, delay);
    };
};

export const getScrollTop = () => {
    let scrollTop = 0;
    if (document.documentElement && document.documentElement.scrollTop) {
        ({ scrollTop } = document.documentElement);
    } else if (document.body) {
        ({ scrollTop } = document.body);
    }
    return scrollTop;
};

export const getLink = (link) => {
    if (`${link}`.length > 1 && /^\/[^/]/.test(`${link}`)) {
        return `${window.rootPath}${link}`;
    }
    return link;
};

export const getParameter = (search, name) => {
    const [, query = ""] = search.split("?");
    const [hit = ""] = query.split("&").filter((item) => name === item.split("=")[0]);
    const [, value = ""] = hit.split("=");
    return value;
};

export const isJsonString = (str) => {
    try {
        if (typeof JSON.parse(str) === "object") {
            return true;
        }
    } catch (e) {
        console.log(e);
    }
    return false;
};

export const generateUrl = (url, params) => {
    return [
        url,
        "?",
        Object.keys(params)
            .map((key) => [key, params[key]].join("="))
            .join("&")
    ].join("");
};

export const isPlainObject = (obj) => {
    return Object.prototype.toString.call(obj) === "[object Object]";
};

export const isFunction = (val) => val && Object.prototype.toString.call(val) === "[object Function]";

//匹配IP地址的正则表达式
export const isIP = (strIP) => {
    var re = /^(\d+)\.(\d+)\.(\d+)\.(\d+)$/g; //匹配IP地址的正则表达式
    if (re.test(strIP)) {
        if (RegExp.$1 < 256 && RegExp.$2 < 256 && RegExp.$3 < 256 && RegExp.$4 < 256) return true;
    }
    return false;
};

//检查输入字符串是否符合正整数格式
function isNum(str) {
    var regu = "^[0-9]+$";
    var re = new RegExp(regu);
    if (str.search(re) != -1) {
        return true;
    } else {
        return false;
    }
}
//检查输入对象的值是否符合端口号格式
export const isPort = (str) => {
    return isNum(_.trim(str)) && _.trim(str) < 65536;
};

// element-ui form表单校验
// ip校验
export const validateIp = (rule, value, callback) => {
    const isip = isIP(value);
    if (value === "") {
        callback(new Error("ip不能为空"));
    } else if (!isip) {
        callback(new Error("ip格式错误!"));
    } else {
        callback();
    }
};
// 端口校验
export const validatePort = (rule, value, callback) => {
    const isport = isPort(value);
    if (value === "") {
        callback(new Error("端口不能为空"));
    } else if (!isport) {
        callback(new Error("端口格式错误!"));
    } else {
        callback();
    }
};
