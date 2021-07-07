import Vue from "vue";
import Vuex from "vuex";
import _ from "lodash";

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        configData: {
            guide: "-1"
        }, // 全部配置信息
        isLoad: false,
        loadText: "",
        nodeActive: 5, // 默认全部开启
        startCount: localStorage.getItem("count60") || 60,
        zipCount: localStorage.getItem("count360") || 360
    },
    mutations: {
        setIsLoad(state, [visible, value]) {
            state.isLoad = visible;
            state.loadText = value;
        },
        // 在app.vue异步获取数据后，赋值给configData
        setConfigAllData(state, data) {
            state.configData = data;
        },
        setConfigStepData(state, data) {
            _.assign(state.configData, data);
        },
        // 节点管理步骤条，没使用
        setNodeActive(state, num) {
            state.nodeActive = num;
        },
        setCount(state, [count, key, num]) {
            // 第二参数用数组，没有第三个参数
            let timer;
            timer = setInterval(function () {
                state[count]--;
                localStorage.setItem(key, state[count]); // 同步到localstore中
                if (state[count] <= 0) {
                    clearInterval(timer);
                    state[count] = num;
                    localStorage.setItem(key, num);
                }
            }, 1000);
        }
    },
    actions: {
        commitCount({ commit }, [count, key, num]) {
            // 第二参数用数组，没有第三个参数
            commit("setCount", [count, key, num]);
        }
    },
    modules: {}
});
