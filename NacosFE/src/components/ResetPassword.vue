<template>
    <div class="dfa-dialog-wraper">
        <el-form ref="resetPasswordForm" :model="resetPasswordForm" :rules="rules" label-width="100px">
            <el-form-item label="旧密码" prop="oldpd">
                <el-input v-model="resetPasswordForm.oldpd" type="password"></el-input>
            </el-form-item>
            <el-form-item label="新密码" prop="pd">
                <el-input v-model="resetPasswordForm.pd" type="password"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="newpd">
                <el-input v-model="resetPasswordForm.newpd" type="password"></el-input>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
export default {
    name: "ResetPassword",
    components: {},
    data() {
        // 旧密码校验
        var validateOldpd = (rule, value, callback) => {
            if (value === "") {
                callback(new Error("请输入旧密码"));
            } else {
                callback();
            }
        };
        var validatePd = (rule, value, callback) => {
            if (value === "") {
                callback(new Error("请输入新密码"));
            } else {
                if (this.resetPasswordForm.newpd !== "") {
                    this.$refs.resetPasswordForm.validateField("newpd");
                }
                callback();
            }
        };
        var validateNewpd = (rule, value, callback) => {
            if (value === "") {
                callback(new Error("请确认密码"));
            } else if (value !== this.resetPasswordForm.pd) {
                callback(new Error("两次输入密码不一致!"));
            } else {
                callback();
            }
        };
        // 返回数据
        return {
            resetPasswordForm: {
                oldpd: "",
                pd: "",
                newpd: ""
            },
            rules: {
                oldpd: [{ validator: validateOldpd, trigger: "blur" }],
                pd: [{ validator: validatePd, trigger: "blur" }],
                newpd: [{ validator: validateNewpd, trigger: "blur" }]
            }
        };
    },
    methods: {
        // 保存,ok
        save(cb) {
            const sm3 = require("sm-crypto").sm3; // sm3加密
            this.$refs["resetPasswordForm"].validate((valid) => {
                if (valid) {
                    const url = "/user/pd/update";
                    const data = { id: "", params: { oldpd: "", pd: "", newpd: "" } };
                    data["params"]["oldpd"] = sm3(this.resetPasswordForm.oldpd);
                    data["params"]["pd"] = sm3(this.resetPasswordForm.pd);
                    data["params"]["newpd"] = sm3(this.resetPasswordForm.newpd);
                    cb && cb(url, data);
                } else {
                    console.log("error submit!!");
                    return false;
                }
            });
        },
        // 取消
        resetForm() {
            this.$refs["resetPasswordForm"].resetFields();
        }
    }
};
</script>
<style lang="scss"></style>
