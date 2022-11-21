import Vue from 'vue'
import VueRouter from 'vue-router'
import AppMain from "@/views/AppMain";


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'main',
    component: AppMain,
  },
  // {
  //   path: '/board',
  //   name: 'board',
  //   component: AppBoard,
  // }
  // {
  //   path: '/user',
  //   name: 'user',
  //   component: AppUser,
  //   children: [
  //     {
  //       path: 'login',
  //       name: 'Login',
  //       component: UserLogin
  //     },
  //     {
  //       path: 'password',
  //       name: 'FindPassword',
  //       component: UserFindPassword
  //     },
  //     {
  //       path: 'join',
  //       name: 'Join',
  //       component: UserJoin
  //     }
  //   ]
  // },
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})


export default router