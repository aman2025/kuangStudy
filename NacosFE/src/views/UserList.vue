<template>
    <div class="dfa-main-container">
        <div class="dfa-title">用户列表</div>
        <div>
            <el-table :data="tableData" :border="true" class="dfa-table" style="width: 100%" header-cell-class-name="dfa-table-header-cell" cell-class-name="dfa-table-cell">
                <el-table-column prop="nodeip" label="名称" width="230"> </el-table-column>
                <el-table-column prop="operate" label="操作">
                    <template slot-scope="scope">
                        <el-button @click.native.prevent="" type="text" size="small" @click="upgrade(scope.row.nodeid, scope.row.appname)" v-if="scope.row.newversion && scope.row.version != scope.row.newversion"> 删除 </el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
    </div>
</template>

<script>
import request from "@/utils/request";
import { Message } from "element-ui"; // 单独引入
export default {
    name: "UserList",
    components: {},
    data() {
        return {
            tableData: []
        };
    },
    mounted() {
        this.getVersionList();
    },
    methods: {
        // 获取应用列表
        getVersionList() {
            const url = "/upgrade/version/list";
            const requestVersionList = () => request.post(url);
            requestVersionList().then((res) => {
                this.tableData = res.result.rows;
            });
        },
        // 升级
        upgrade(nodeid, appname) {
            const url = "/upgrade/update";
            const data = {
                params: {
                    nodeid,
                    appname
                },
                id: ""
            };
            const requestUpdate = (opts) => request.post(url, opts);
            requestUpdate(data).then((res) => {
                if (res.retCode == 0) {
                    Message.success({ message: res.retMsg });
                    this.getVersionList();
                }
            });
        }
    }
};
</script>
<style lang="scss"></style>
