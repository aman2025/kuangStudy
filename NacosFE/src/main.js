import Vue from "vue";
// eslint-disable-next-line prettier/prettier
import { 
    Dialog,
    Footer,
    Input,
    FormItem,
    Form,
    Step,
    Steps,
    Alert,
    Table,
    TableColumn,
    Menu,
    MenuItem,
    Dropdown,
    DropdownMenu,
    DropdownItem,
    Row,
    Col,
    Button,
    Option,
    Select,
    Container,
    Header,
    Aside,
    Main,
    Pagination
} from "element-ui";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import "./assets/style/element-variables.scss";

//element-ui表单校验
import { validateIp, validatePort } from "@/utils/util";
Vue.prototype.$validateIp = validateIp;
Vue.prototype.$validatePort = validatePort;

// element组件按需引入
Vue.prototype.$ELEMENT = { size: "small", zIndex: 3000 };

Vue.use(Pagination);
Vue.use(Dialog);
Vue.use(Footer);
Vue.use(Input);
Vue.use(FormItem);
Vue.use(Form);
Vue.use(Step);
Vue.use(Steps);
Vue.use(Alert);
Vue.use(Table);
Vue.use(TableColumn);
Vue.use(Menu);
Vue.use(MenuItem);
Vue.use(Dropdown);
Vue.use(DropdownMenu);
Vue.use(DropdownItem);
Vue.use(Row);
Vue.use(Col);
Vue.use(Button);
Vue.use(Option);
Vue.use(Select);
Vue.use(Container);
Vue.use(Aside);
Vue.use(Main);
Vue.use(Header);

Vue.config.productionTip = false;
new Vue({
    router,
    store,
    render: (h) => h(App)
}).$mount("#app");
