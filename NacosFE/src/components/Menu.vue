<template>
    <div>
        <el-menu :default-active="$route.path.indexOf('configComplete') != -1 ? '/index' : $route.path" class="dfa-menu" :router="true">
            <el-menu-item v-for="(item, i) in navList" :key="i" :index="item.path">
                <span slot="title">{{ item.name }} </span>
            </el-menu-item>
        </el-menu>
    </div>
</template>

<script>
export default {
    name: "Menu",
    components: {},
    data() {
        return {
            navList: [{ path: "/userList", name: "用户列表" }]
        };
    },
    methods: {}
};
</script>
<style lang="scss">
.dfa-menu {
    background-color: transparent !important;
    border: none !important;
}
.dfa-menu > li {
    height: 42px !important;
    line-height: 42px !important;
    color: #b2b2b2 !important;
    padding-left: 25px !important;
    border-left: 3px solid transparent !important;
    box-sizing: border-box !important;
}
.dfa-menu > li:hover,
.dfa-menu > li.is-active {
    color: #666 !important;
    background-color: #f2f3f7 !important;
}
</style>
