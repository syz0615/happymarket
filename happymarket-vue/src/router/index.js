/**
 *      path         页面路由地址
 *      navShow      是否显示页面头部
 *      tabShow      是否显示页面底部导航
 *      title        页面标题
 *      keepAlive    是否缓存页面
 */
const routers = [
    {
      path:'/',
      redirect:'/home'
    },
    {
      path:'/home',
      name:'Home',
      component: resolve => require(['@/pages/Home/index'], resolve),
      meta:{
        navShow: false,
        tabShow:true,
        keepAlive: true
      }
    },
    {
      path:'/classify',
      name:'Classify',
      component: resolve => require(['@/pages/Classify/classify'], resolve),
      meta:{
        navShow: true,
        tabShow:true,
        title: '全部分类',
        keepAlive: true
      }
    },
    {
      path:'/cart',
      name:'Cart',
      component: resolve => require(['@/pages/Cart/cart'], resolve),
      meta:{
        navShow: true,
        tabShow:false,
        title: '购物车',
        keepAlive: false,
      }
    },
    {
      path:'/user',
      name:'User',
      component: resolve => require(['@/pages/User/user'], resolve),
      meta:{
        navShow: false,
        tabShow:true,
        title: '个人中心',
        keepAlive: false
      }
    },
    {
      path:'/login',
      name:'Login',
      component: resolve => require(['@/pages/User/login/login'], resolve),
      meta:{
        navShow: true,
        tabShow:false,
        title: '登录',
        keepAlive: false
      }
    },
    {
        path: '/register',
        component: resolve => require(['@/pages/User/register/register'], resolve),
        name: 'Register',
        meta: {
            navShow: true,
            tabShow: false,
            title: '用户注册',
            keepAlive: false
        }
    },
    {
      path: '/searchpage',
      component: resolve => require(['@/pages/Home/search/searchpage'], resolve),
      name: 'SearchPage',
      meta: {
        tabShow: false,
        title: '商品搜索',
        keepAlive: false
      }
    },
    {
      path: '/goodslist',
      component: resolve => require(['@/pages/goods/goodslist'], resolve),
      name: 'GoodsList',
      meta: {
        navShow:true,
        tabShow: false,
        title: '搜索列表',
        keepAlive: false
      }
    },
    {
      path:'/coupon',
      name:'Coupon',
      component: resolve => require(['@/pages/User/coupon/coupon'], resolve),
      meta:{
        navShow:true,
        tabShow:false,
        title:'我的优惠卷',
        keepAlive:true
      }
    },
    {
      path:'/collect',
      name:'Collect',
      component: resolve => require(['@/pages/Home/collect/collect'], resolve),
      meta:{
        navShow:true,
        tabShow:false,
        title:'我的收藏',
        keepAlive:true
      }
    },
    {
      path:'/footprint',
      name:'Footprint',
      component: resolve => require(['@/pages/User/footprint/footprint'], resolve),
      meta:{
        navShow:true,
        tabShow:false,
        title:'我的足迹',
        keepAlive:true
      }
    },
    {
      path: '/notice',
      component: resolve => require(['../pages/Home/notice/notice'], resolve),
      name: 'Notice',
      meta: {
        navShow: true,
        tabShow: false,
        title: '公告详情',
        keepAlive: false
      }
    },
    {
      path: '/address',
      component: resolve => require(['../pages/User/address/address'], resolve),
      name: 'Address',
      meta: {
        navShow: true,
        tabshow: false,
        title: '地址详情',
        keepAlive: false,
        isLogin: true
      }
    }, 
    {
      path: '/addresslist',
      component: resolve => require(['../pages/User/address/addressList'], resolve),
      name: 'AddressList',
      meta: {
        navShow: true,
        tabshow: false,
        title: '地址管理',
        keepAlive: false,
        isLogin: true
      }
    },
    {
      path: '/datasettings',
      component: resolve => require(['../pages/user/settings/datasetting'], resolve),
      name: 'Setting',
      meta: {
        navShow: true,
        tabShow: false,
        title: '更多设置',
        keepAlive: false
      }
    },
    {
      path: '/goodsdetail',
      component: resolve => require(['../pages/goods/goodsdetail'], resolve),
      name: 'GoodsDetail',
      meta: {
        navShow: true,
        tabShow: false,
        title: '商品详情',
        keepAlive: false
      }
    },
    {
      path: '/allorder',
      component: resolve => require(['../pages/order/allorder'], resolve),
      name: 'AllOrder',
      meta: {
        navShow: true,
        tabShow: false,
        title: '全部订单',
        keepAlive: false
      }
    },
    {
      path: '/allafterservice',
      component: resolve => require(['../pages/order/allafterservice'], resolve),
      name: 'allAfterService',
      meta: {
        navShow: true,
        tabShow: false,
        title: '退换货',
        keepAlive: false
      }
    },
    {
      path: '/firmorder',
      component: resolve => require(['../pages/order/FirmOrder'], resolve),
      name: 'FirmOrder',
      meta: {
        navShow: true,
        tabShow: false,
        title: '支付订单',
        keepAlive: false
      }
    },
    {
      path: '/checkorder',
      component: resolve => require(['../pages/order/checkorder'], resolve),
      name: 'CheckOrder',
      meta: {
        navShow: true,
        tabShow: false,
        title: '查看订单',
        keepAlive: false
      }
    },
    {
      path: '/orderdetail',
      component: resolve => require(['../pages/order/orderdetail'], resolve),
      name: 'OrderDetail',
      meta: {
        navShow: true,
        tabShow: false,
        title: '订单详情',
        keepAlive: true
      }
    },


  ]

  export default routers




