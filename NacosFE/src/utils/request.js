import axios from "axios";
// import qs from "qs";
import { isPlainObject } from "./util";
import store from "../store";
import { MessageBox } from "element-ui";

function goLogin() {
    const url = window.location.href;
    localStorage.removeItem("token");
    const base_url = url.split("#")[0];
    window.location.href = `${base_url}#/login`;
}

// loading, count防止同时多个请求，执行多次loading
let loadingCount = 0;
const openLoading = (cb, url) => {
    if (url == "/processor/list") {
        return;
    }
    if (!loadingCount) {
        if (url == "/upgrade/update") {
            store.commit("setIsLoad", [true, "正在升级中，请稍候...."]);
        } else {
            store.commit("setIsLoad", [true, "正在加载中..."]);
        }
    }
    loadingCount++;
    // beforeSend
    cb && cb();
};
const closeLoading = (url) => {
    if (url == "/processor/list") {
        return;
    }
    loadingCount--;
    if (!loadingCount) {
        store.commit("setIsLoad", [false, "正在加载中..."]);
    }
};
const request = () => {
    const instance = axios.create();

    instance.interceptors.request.use(
        (config) => {
            const { params, data, method, headers, beforeSend } = config;
            if (!params) {
                config.params = {};
            }
            // beforeSend
            openLoading(beforeSend, config.url);

            // 服务端没有参数，不能返回数据, 空对象参数
            const defaultData = { params: {}, id: "" };
            // post数据config.data
            if (data && isPlainObject(data) && ["post", "put"].includes(method)) {
                config.data = data;
            } else {
                config.data = defaultData;
            }
            if (!headers) {
                config.headers = {};
            }
            config.headers["Content-Type"] = "application/json;charset=UTF-8";
            return config;
        },
        (error) => {
            Promise.reject(error);
        }
    );

    instance.interceptors.response.use(
        (response) => {
            if (typeof response.data != "string") {
                const { retCode, retMsg } = response.data;
                if (retCode != 0) {
                    // 请求失败 retCode=-1
                    MessageBox.alert(retMsg, {
                        confirmButtonText: "确定",
                        type: "error",
                        center: true
                    });
                    closeLoading(response.config.url);
                    return Promise.reject(new Error(retMsg)); // 在页面中catch
                }
                // 节点管理页面不显示loading
                closeLoading(response.config.url);
                return response.data;
            } else {
                location.reload();
            }
        },
        (error) => {
            if (error.response) {
                const { data = {}, status } = error.response;
                let message = `HTTP ERROR: ${status}`;
                if (typeof data === "string") {
                    message = data;
                } else if (typeof data === "object") {
                    message = data.message;
                }
                message.indexOf("exist") === -1 && console.log(message);
                if ([401, 403].includes(status) && ["unknown user!", "token invalid!", "token expired!"].includes(message)) {
                    goLogin();
                }
                return Promise.reject(error.response);
            }
            return Promise.reject(error);
        }
    );

    return instance;
};

export default request();
