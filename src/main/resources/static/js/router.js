import Vue from 'vue'
import VueRouter from 'vue-router'
// import MessagesList from 'pages/MessageList.vue'
import Home from 'pages/home.vue'
import Message2 from 'pages/Message2.vue'


// import Auth from 'pages/Auth.vue'
// import Profile from 'pages/Profile.vue'
// import Subscriptions from 'pages/Subscriptions.vue'

Vue.use(VueRouter)

const routes = [
    // { path: '/', component: MessagesList },
    { path: '/home', component: Home},
    { path: '/message2', component: Message2},

    // { path: '/auth', component: Auth },
    // { path: '/user/:id?', component: Profile },
    // { path: '/subscriptions/:id', component: Subscriptions },
    // { path: '*', component: MessagesList },
]

export default new VueRouter({
    mode: 'history',
    routes
})
