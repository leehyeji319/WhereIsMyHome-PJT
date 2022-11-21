import Vue from 'vue'
import VueRouter from 'vue-router'
import AppMain from "@/views/AppMain";
//User
import AppUser from "@/views/AppUser";
import UserLogin from "@/components/user/UserLogin"
import UserFindPassword from "@/components/user/UserFindPassword"
import UserJoin from "@/components/user/UserJoin"

//House
import AppHouse from "@/views/AppHouse";
// import HouseInfo from "@/components/house/HouseInfo.vue"

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'main',
    component: AppMain,
  },
  {
    path: '/user',
    name: 'user',
    component: AppUser,
    children: [
      {
        path: 'login',
        name: 'Login',
        component: UserLogin
      },
      {
        path: 'password',
        name: 'FindPassword',
        component: UserFindPassword
      },
      {
        path: 'join',
        name: 'Join',
        component: UserJoin
      }
    ]
  },
  {
    path: '/house/info',
    name: 'house',
    component: AppHouse,
    // children: [
    //   {
    //     path: 'info',
    //     name: 'Info',
    //     component: HouseInf
    //   },
      
    // ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})


export default router
