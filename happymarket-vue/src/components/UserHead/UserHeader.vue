<template>
  <div class="userheader">
    <div class="userimg">
      <div class="headerimg">
        <img src="@/assets/image/user/man.png" />
        <p v-if="this.GLOBAL.getStorage('user_token_Name') ? true:false">用户名:{{this.GLOBAL.getStorage('user_token_Name')}}</p>
        <router-link :to="{name:'Login'}">
          <p v-if="this.GLOBAL.getStorage('user_token_id') ? false:true">登录/注册</p>
        </router-link>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {

    }
  },
  methods: {
    setting() {
      this.$router.push({ path: '/setting' })
    },
    // 头像上传
    upload(e) {
      this.$emit('upload', e)
    }
  }
}

</script>
<style scoped>
.topcolor {
  width: 100%;
  height: 1.5rem;
  background-color: rgb(253, 83, 83);
}

.userimg {
  width: 100%;
  height: 3rem;
  background-color: #ff6633;
  background-size: 100% 100%;
  background-repeat: no-repeat;
  position: relative;
}

.headerimg {
  width: 2.5rem;
  height: 2.5rem;
  margin: 0 auto;
  color: #fff;
  font-size: .3rem;
}

.headerimg img {
  margin-top: .5rem;
  width: 1.5rem;
  height: 1.5rem;
  border-radius: 50%;
}

.headerimg input {
  position: absolute;
  top: 40%;
  transform: translateY(-50%);
  width: 1.5rem;
  height: 1.5rem;
  border-radius: 50%;
  opacity: 0;
  z-index: 5;
}

</style>
