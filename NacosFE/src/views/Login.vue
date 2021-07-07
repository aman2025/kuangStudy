<template>
    <div class="dfa-login">
        <div class="login-panel">
            <el-form ref="loginForm" :model="loginForm" :rules="baseRules" label-width="32px">
                <el-form-item label="" prop="username">
                    <el-input v-model="loginForm.username" size="medium" placeholder="请输入用户名"></el-input>
                </el-form-item>
                <el-form-item label="" prop="password">
                    <el-input v-model="loginForm.password" type="password" size="medium" placeholder="请输入密码"></el-input>
                </el-form-item>

                <el-form-item label="">
                    <el-button type="primary" @click="login('loginForm')" size="medium" class="login-btn">登录</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
import request from "../utils/request";
import { Message } from "element-ui"; // 单独引入
export default {
    name: "Login",
    components: {},
    data() {
        return {
            loginForm: {
                username: "",
                password: ""
            },
            baseRules: {
                username: [{ required: true, message: "用户名不能为空" }],
                password: [{ required: true, message: "密码不能为空" }]
            }
        };
    },
    methods: {
        // 登录
        login(formName) {
            const url = "/user/auth";
            const params = {
                username: this.loginForm.username,
                password: this.loginForm.password
            };
            const requestLogin = (data) => request.post(url, data);
            // 校验
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    requestLogin(params).then((res) => {
                        if (res.retCode == 0) {
                            this.$router.push("/index");
                        } else {
                            Message.error({ message: "用户名或密码错误" });
                        }
                    });
                } else {
                    console.log("error submit!!");
                    return false;
                }
            });
        }
    }
};
</script>
<style lang="scss">
.dfa-login {
    height: 100%;
    color: #fff;
}
.dfa-login .login-wrap {
    height: 100%;
    position: relative;
}
.dfa-login .login-dotLight {
    position: absolute;
    top: 20%;
    left: 0;
    width: 80%;
    height: 80%;
    background-image: radial-gradient(rgba(255, 255, 255, 0.36), rgba(255, 255, 255, 0));
    opacity: 0.5;
    filter: blur(32px);
    z-index: 0;
    border-radius: 50%;
}
.dfa-login .login-logo {
    position: absolute;
    top: 80px;
    left: 90px;
    height: 70px;
    width: 480px;
    display: flex;
}
.dfa-login .login-logo i {
    display: block;
    width: 145px;
    height: 69px;
    background-repeat: no-repeat;
    background-size: 100%;
}
.dfa-login .login-logo::after {
    position: absolute;
    top: 5px;
    left: 160px;
    content: "";
    display: block;
    height: 59px;
    width: 1.2px;
    overflow: hidden;
    background-color: #fff;
    opacity: 0.6;
}
.dfa-login .login-logo span {
    letter-spacing: 3px;
    font-size: 28px;
    padding: 2px 0 0 36px;
}
.dfa-login .login-logo span em {
    letter-spacing: 1px;
    display: block;
    font-size: 14px;
    opacity: 0.5;
    font-style: normal;
}
.dfa-login .login-panel {
    width: 480px;
    height: 335px;
    background-color: #fff;
    border-bottom-left-radius: 5px;
    border-bottom-right-radius: 5px;
    padding: 35px 55px 35px 25px;
    box-sizing: border-box;
}
.dfa-login .login-panel .login-panel-title {
    font-size: 24px;
    color: #51565d !important;
    font-weight: bold;
    padding: 0 0 23px 32px;
}
.dfa-login .login-panel .login-btn {
    width: 100%;
    margin-top: 5px;
}
.dfa-login .login-panel .auth-code {
    position: absolute;
    top: 3px;
    right: 6px;
    width: 98px;
    height: 29px;
    background-color: #eee;
    text-align: center;
    overflow: hidden;
    z-index: 99999;
}
.dfa-login .login-panel .auth-code img {
    max-width: 105%;
    margin-top: -1px;
}
</style>
