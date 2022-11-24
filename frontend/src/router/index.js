import Vue from "vue";
import VueRouter from "vue-router";
import AppHouse from "@/views/AppHouse";
// import AppBoard from "@/views/AppBoard";
import AppMain from "@/views/AppMain";


Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "main",
    component: AppMain,
  },
  // {
  //   path: "/user",
  //   name: "user",
  //   component: () => import("@/views/AppUser"),
  //   children: [
  //     {
  //       path: "/signin",
  //       name: "signin",
  //       component: () => import("@/components/user/UserLogin"),
  //     },
  //     {
  //       path: "/signup",
  //       name: "signup",
  //       component: () => import("@/components/user/UserRegister"),
  //     },

  //   ]
  // },
  {
    path: "/house",
    name: "house",
    component: AppHouse,
  },
  {
    path: "/board",
    name: "board",
    component: () => import("@/views/AppBoard"),
    redirect: "/board/list",
    children: [
      {
        path: "list",
        name: "boardlist",
        component: () => import("@/components/board/BoardList"),
      },
      {
        path: "write",
        name: "boardwrite",
        component: () => import("@/components/board/BoardWrite"),
      },
      {
        path: "view/:boardId",
        name: "boardview",
        component: () => import("@/components/board/BoardView"),
      },
      {
        path: "modify",
        name: "boardmodify",
        component: () => import("@/components/board/BoardModify"), //아직 안함
      },
      // {
      //   path: "delete/:articleno",
      //   name: "boarddelete",
      //   component: () => import("@/components/board/BoardDelete"), //안함
      // },
    ]
  },
  {
    path: "/notice",
    name: "notice",
    component: () => import("@/views/AppNotice"),
    redirect: "/notice/list",
    children: [
      {
        path: "list",
        name: "noticelist",
        component: () => import("@/components/notice/NoticeList"),
      },
      {
        path: "write",
        name: "noticewrite",
        component: () => import("@/components/notice/NoticeWrite"),
      },
      {
        path: "view/:noticeId",
        name: "noticeview",
        component: () => import("@/components/notice/NoticeView"),
      },
      {
        path: "modify",
        name: "noticemodify",
        component: () => import("@/components/notice/NoticeModify"), //아직 안함
      },
      // {
      //   path: "delete/:noticeId",
      //   name: "noticedelete",
      //   component: () => import("@/components/notice/NoticeDelete"), //안함
      // },
    ]
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
