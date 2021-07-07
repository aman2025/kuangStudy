<template>
    <div class="dfa-loading" v-show="show">
        <div>
            <i class="dfa-icon-load"></i>
            {{ txt }}
        </div>
    </div>
</template>

<script>
export default {
    name: "Loading",
    components: {},
    props: ["show", "txt"],
    data() {
        return {};
    },
    methods: {}
};
</script>
<style lang="scss">
.dfa-loading {
    position: fixed;
    z-index: 9999999;
    top: 48px;
    left: 0;
    bottom: 0;
    right: 0;
    background: rgba(255, 255, 255, 0.5);
    display: flex;
    justify-content: center;
}
.dfa-loading > div {
    align-self: center;
    margin-top: -200px;
}
.dfa-icon-load {
    display: block;
    width: 50px;
    height: 50px;
    background-image: url(../assets/images/loading.gif);
    background-size: 50%;
    background-repeat: no-repeat;
    background-position: center center;
    padding: 0 10px;
    margin: 0 auto;
}
</style>
