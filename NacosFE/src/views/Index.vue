<template>
    <div id="app">
        <el-container class="dfa-container">
            <el-header class="dfa-header">
                <!-- Header组件 -->
                <Header />
            </el-header>
            <!-- 这里要加上style=height才有滚动条 -->
            <el-container style="height: 100px">
                <el-aside class="dfa-aside">
                    <!-- Menu组件 -->
                    <Menu />
                </el-aside>
                <el-main class="dfa-main">
                    <router-view />
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>
<script>
// @ is an alias to /src
import Menu from "@/components/Menu.vue";
import Header from "@/components/Header.vue";
export default {
    name: "Index",
    components: { Menu, Header },
    data() {
        return {};
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
.dfa-aside {
    background-color: #eaedf1;
    width: 200px !important;
    color: #b2b2b2;
}
.dfa-main {
    padding: 0 !important;
}
</style>
