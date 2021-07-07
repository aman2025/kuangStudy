import Vue from "vue";
import VueRouter from "vue-router";
import Index from "../views/Index.vue";

Vue.use(VueRouter);
const routes = [
    { path: "/", redirect: "/index" }, // 路由重定向
    {
        path: "/index",
        name: "index",
        component: Index,
        children: [
            {
                path: "/userList",
                name: "userList",
                component: () => import("../views/UserList.vue")
            }
        ]
    },
    {
        path: "/login",
        name: "login",
        component: () => import("../views/Login.vue")
    }
];

const router = new VueRouter({
    routes
});

export default router;
