import Vue from 'vue'
import App from './App'
import routers from './router/index'
import VueRouter from 'vue-router'
import YDUI from 'vue-ydui'; 
import 'vue-ydui/dist/ydui.rem.css';
import VueLazyload from 'vue-lazyload'
import QRCode from 'qrcode'
import * as API from './api/api'
Vue.prototype.$http = API
import Common from './api/common'
Vue.prototype.GLOBAL = Common
Vue.prototype.imgPath = 'http://localhost:8080/image/'

Vue.use(VueRouter)
Vue.use(YDUI);
Vue.use(QRCode)
Vue.use(VueLazyload, {
  preLoad: 1.3,
  loading: './assets/image/loading.gif',
  attempt: 1
})

Vue.config.productionTip = false

// 先const router,然后才能在下面注入
const router = new VueRouter({
    mode: 'hash',
    routes: routers,
    scrollBehavior (to, from, savedPosition) {
        if (savedPosition) {
            return savedPosition
        }
        return { x: 0, y: 0 }
    }
})
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})




