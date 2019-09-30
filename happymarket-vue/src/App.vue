<template>
  <yd-layout id="app">
    <!-- <router-view /> -->
    <navbar slot="navbar" :title="$route.meta.title" v-show="$route.meta.navShow"></navbar>
    <transition name="router-fade" mode="out-in">
      <keep-alive>
        <router-view v-if="$route.meta.keepAlive && isRouterAlive" class="top"></router-view>
      </keep-alive>
    </transition>
    <transition name="router-fade" mode="out-in">
      <router-view v-if="!isRouterAlive && !$route.meta.keepAlive" class="top"></router-view>
    </transition>
    <transition name="router-fade" mode="out-in">
      <router-view v-if="isRouterAlive && !$route.meta.keepAlive" class="top"></router-view>
    </transition>
    <tabbar slot="tabbar" v-show="$route.meta.tabShow"></tabbar>
  </yd-layout>
</template>
<script>
import navbar from '@/components/NavBar/NavBar.vue'
import tabbar from '@/components/TabBar/TabBar.vue'
export default {
  name: 'App',
  data() {
    return {
      isRouterAlive:true
    }
  },
  components: {
    navbar,tabbar
  }
}

</script>
<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background-color: #F9F9F9;
}

#scrollView {
  margin-top: 0;
}

.router-fade-enter-active,
.router-fade-leave-active {
  transition: opacity .3s;
}

.router-fade-enter,
.router-fade-leave-active {
  opacity: 0;
}

</style>
