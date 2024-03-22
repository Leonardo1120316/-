import { path } from 'path';
//配置常量路由
export const routes = [
    {
        //登录
        path: '/login',
        component: () => import('@/views/login/index.vue'),
        name: 'login',
        meta: {
            title: '登录',
            hidden: true
        }
    },
    {
        //登录成功主页
        path: '/',
        component: () => import('@/layout/index.vue'),
        name: 'layout',
        meta: {
            title: '首页',
            hidden: false,
            icon: 'House'
        },
        redirect: 'home',
        children: [
            {
                path: '/home',
                component: () => import('@/views/home/club/index.vue'),
                meta: {
                    title: '社团信息',
                    hidden: false,
                    icon: "User"
                }
            },
            {
                path: '/activity',
                component: () => import('@/views/home/activity/index.vue'),
                meta: {
                    title: '活动信息',
                    hidden: false,
                    icon: "Connection"
                },
            },
        ]
    },
    {
        //社团管理页面
        path: '/club',
        component: () => import('@/layout/index.vue'),
        name: 'Club',
        meta: {
            title: '社团中心',
            hidden: false,
            icon: 'Lock'
        },
        redirect: '/club/user',
        children: [
            {
                path: '/club/user',
                name: 'User',
                component: () => import('@/views/club/user/index.vue'),
                meta: {
                    title: '学生管理',
                    hidden: false,
                    icon: "User"
                },
            },
            {
                path: '/club/manager',
                name: 'Manager',
                component: () => import('@/views/club/manager/index.vue'),
                meta: {
                    title: '社团管理',
                    hidden: false,
                    icon: "Connection"
                },
            },
        ]
    },
    {
        path: '/admin',
        name: 'Admin',
        component: () => import('@/layout/index.vue'),
        meta: {
            title: '管理员中心',
            hidden: false,
            icon: "Grid"
        },
        redirect: '/admin/data',
        children: [
            {
                //数据分析
                path: '/admin/data',
                component: () => import('@/views/admin/data/index.vue'),
                name: 'Data',
                meta: {
                    title: '数据中心',
                    hidden: false,
                    icon: 'Monitor'
                }
            },
            {
                //财务管理
                path: '/admin/finance',
                name: 'Finance',
                component: () => import('@/views/admin/finance/index.vue'),
                meta: {
                    title: '财务管理',
                    hidden: false,
                    icon: "Coin"
                },
            },
            {
                //活动管理
                path: '/admin/activity',
                name: 'Activity',
                component: () => import('@/views/admin/activity/index.vue'),
                meta: {
                    title: '活动管理',
                    hidden: false,
                    icon: "Basketball"
                },
            },
        ]
    },
    {
        //消息中心
        path: '/chat',
        component: () => import('@/layout/index.vue'),
        name: 'Chat',
        meta: {
            hidden: false,
        },
        children: [
            {
                //消息中心
                path: '/chat/chat',
                component: () => import('@/views/chat/index.vue'),
                name: 'Chat',
                meta: {
                    title: '消息中心',
                    hidden: false,
                    icon: 'ChatDotRound'
                },
            }
        ]
    },
    {
        //个人中心
        path: '/person',
        component: () => import('@/layout/index.vue'),
        name: 'Person',
        meta: {
            hidden: false,
        },
        children: [
            {
                //个人中心
                path: '/person/person',
                component: () => import('@/views/person/index.vue'),
                name: 'Person',
                meta: {
                    title: '个人中心',
                    hidden: false,
                    icon: 'UserFilled'
                },
            }
        ]
    },
    {
        path: '/register',
        component: () => import('@/views/register/index.vue'),
        name: 'Register',
        meta: {
            title: '注册',
            hidden: true
        },
    },
    {
        path: '/404',
        component: () => import('@/views/404/index.vue'),
        name: '404',
        meta: {
            title: '404',
            hidden: true
        },
    },
    // {
    //     path: '/:pathMatch(.*)*',
    //     redirect: '/404',
    //     name: 'Any',
    // }
]

//任意路由
export const anyRoute = {
    //任意路由
    path: '/:pathMatch(.*)*',
    redirect: '/404',
    name: 'Any',
    meta: {
        title: '任意路由',
        hidden: true,
        icon: 'DataLine',
    },
}