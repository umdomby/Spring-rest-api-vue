import Vue from 'vue'
// import VueResource from 'vue-resource'
import 'api/resource'
import App from 'pages/App.vue'
import router from "./router";

// Vue.use(VueResource)

new Vue({
    el: '#app',
    router,
    render: a => a(App)
})
