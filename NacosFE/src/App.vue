<template>
    <div id="app">
        <Loading :show="$store.state.isLoad" :txt="$store.state.loadText" />
        <router-view />
    </div>
</template>
<script>
// @ is an alias to /src
import Loading from "@/components/Loading.vue";
import request from "@/utils/request";
export default {
    name: "App",
    components: {
        Loading
    },
    data() {
        return {};
    },
    mounted() {
        // 获取配置信息
        const url = "/config/info";
        const requestAllConfigData = () => request.post(url);
        requestAllConfigData().then((res) => {
            if (res.retCode == -1) {
                alert("获取配置信息失败，请刷新页面！"); // todo:“开始配置”禁用， 并提示
                return;
            }
            const data = res.result.rows[0];
            console.log(data);
            this.$store.commit("setConfigAllData", data);
        });
        this.loadInitCount("startCount", "count60", 60);
        this.loadInitCount("zipCount", "count360", 360);
    },
    methods: {
        // 立即生效：加载定时器，先从localstore中读取
        loadInitCount(count, key, total) {
            let startCount = localStorage.getItem(key);
            if (startCount == undefined) {
                localStorage.setItem(key, total);
            }
            if (startCount > 0 && startCount < total) {
                // localstore中count的小于10，已经在倒计时，突然刷新页面，继续触发setStartCount
                this.$store.dispatch("commitCount", [count, key, total]);
            }
        }
    }
};
</script>
<style lang="scss">
html,
body {
    height: 100%;
    margin: 0;
    padding: 0;
}
#app {
    height: 100%;
}
.dfa-container {
    height: 100%;
}
.dfa-header {
    position: relative;
    width: 100%;
    color: #fff;
    background: #0a75ff;
    z-index: 9999 !important;
    color: #fff;
    background: #252a2f;
    padding: 0 !important;
    height: 48px !important;
}
.dfa-aside {
    background-color: #eaedf1;
    width: 200px !important;
    color: #b2b2b2;
}
.dfa-main {
    padding: 0 !important;
}
</style>
