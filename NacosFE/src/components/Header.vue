<template>
    <div class="dfa-wraper">
        <el-row class="dfa-logo-wraper">
            <el-col :span="12" class="dfa-logo">
                <div>
                    <span>security</span>
                </div>
            </el-col>
        </el-row>
        <!-- 弹出框 -->
        <el-dialog :title="dialogTitle" :visible.sync="dialogHeaderVisible" width="500px" center class="dfa-dialog" :before-close="cancelDialog">
            <div>
                <component :is="currentHeaderComp" ref="subInfo"></component>
            </div>
            <div slot="footer" class="dialog-footer">
                <el-button @click="cancelDialog">取 消</el-button>
                <el-button type="primary" @click="saveUserInfo">确 定</el-button>
            </div>
        </el-dialog>
        <!-- //弹出框 -->
    </div>
</template>

<script>
import ResetPassword from "@/components/ResetPassword.vue";
import request from "@/utils/request";
import { Message } from "element-ui"; // 单独引入
export default {
    name: "Header",
    components: { ResetPassword },
    data() {
        return {
            dialogHeaderVisible: false,
            currentHeaderComp: "",
            dialogTitle: ""
        };
    },
    methods: {
        // 弹出对应的窗口
        handleCommand(command) {
            if (command == "d") {
                // 退出
                this.logout();
            } else if (command == "a") {
                // 白名单
                this.dialogHeaderVisible = true;
                this.dialogTitle = "白名单";
            } else if (command == "b") {
                // 修改密码
                this.dialogHeaderVisible = true;
                this.dialogTitle = "修改密码";
                this.currentHeaderComp = "ResetPassword";
            } else if (command == "c") {
                // 安全码
                this.dialogHeaderVisible = true;
                this.dialogTitle = "安全码";
            }
        },
        // 确定, 调用子组件方法
        saveUserInfo() {
            this.$refs.subInfo.save(this.handleUserData);
        },
        handleUserData(url, data) {
            const requestUserData = (params) => request.post(url, params);
            requestUserData(data).then((res) => {
                if (res.retCode == 0) {
                    Message.success({ message: res.retMsg });
                    this.dialogHeaderVisible = false;
                    this.cancelDialog();
                }
            });
        },
        // 取消
        cancelDialog() {
            this.$refs.subInfo.resetForm();
            this.dialogHeaderVisible = false;
        },
        // logout
        logout() {
            const url = "/user/logout";
            const requestLogout = () => request.post(url);
            requestLogout().then((res) => {
                if (res.retCode == 0) {
                    console.log(res.retMsg);
                    window.location.href = "/";
                }
            });
        }
    }
};
</script>
<style lang="scss">
.dfa-wraper,
.dfa-logo-wraper .el-col,
.dfa-logo-wraper {
    height: 100%;
}
// logo
.dfa-logo {
    display: flex;
}
.dfa-logo > div {
    align-self: center;
    padding: 0 10px;
    font-size: 18px;
}
.dfa-logo > div img {
    vertical-align: middle;
    margin-right: 10px;
    margin-bottom: 5px;
}
// 右侧
.el-icon-user {
    font-size: 25px;
    color: #fff;
}
.dfa-hd-right {
    display: flex;
    justify-content: flex-end;
}
.dfa-hd-right > div {
    align-self: center;
}
.icon-user-wraper {
    display: block;
    width: 40px;
    height: 46px;
    line-height: 53px;
    text-align: center;
    cursor: pointer;
}
.dfa-dropdown-menu {
    padding: 15px 0 8px !important;
    top: 28px !important;
    width: 165px;
}
</style>
