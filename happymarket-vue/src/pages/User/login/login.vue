<template>
  <div class="login">
    <div class="login-img">
      <img src="@/assets/image/group10.png" />
    </div>
    <yd-tab>
      <yd-tab-panel label="账号登陆">
        <div class="login-content">
          <yd-cell-item>
            <span slot="left">手机号：</span>
            <yd-input slot="right" ref="tel" required :show-success-icon="false" regex="mobile" v-model="userPhone" placeholder="请输入手机号"></yd-input>
          </yd-cell-item>
          <yd-cell-item>
            <span slot="left">登录密码：</span>
            <yd-input slot="right" type="password" v-model="userPwd" placeholder="请输入密码"></yd-input>
          </yd-cell-item>   
        </div>
      </yd-tab-panel>
      <yd-button size="large" type="danger" @click.native="login">登录</yd-button>
      没有账号?
      <span style="color: #10aeff;" @click="toRegister">&nbsp;立即注册</span>
    </yd-tab>

  </div>
</template>

<script>

export default {
  data() {
    return {
      userPhone: '',
      userPwd: '',
    }
  },
  created() {
    if (this.GLOBAL.getStorage('user_token')) {
      this.$dialog.toast({
        mes: '你已经登录!',
        timeout: 2000,
        callback: () => {
          this.$router.go(-1)
        }
      })
    }
  },
  computed: {
    // 验证手机号
    rightMobile() {
      let res = {};
      if (!this.userPhone) {
        res.status = false;
        res.msg = '请输入手机号'
      } else if (!/^1[345678]{1}\d{9}$/gi.test(this.userPhone)) {
        res.status = false;
        res.msg = '手机号格式不正确'
      } else {
        res.status = true
      }
      return res
    }
  },
  methods: {
    // 登录
    login() {
      if (!this.rightMobile.status) {
        this.$dialog.toast({ mes: this.rightMobile.msg, timeout: 1000 })
      } else {
        if (!this.tab) {
          // 账号密码登录
          if (!this.userPwd) {
            this.$dialog.toast({ mes: '请输入密码!', timeout: 1000 })
          } else {
            let data = {              
              userPhone: this.userPhone,
              userPwd: this.userPwd
            };      
            this.$http.UserLogin(data)
              .then(res=>{
              if (res.status) {
                this.GLOBAL.setStorage('user_token', res.data);
                this.GLOBAL.setStorage('user_token_id', res.data.userId);
                this.GLOBAL.setStorage('user_token_Name', res.data.userName);
                this.redirectHandler();   //重定向到另一个页面
              } 
              })
          }
        } 
      }
    },
    // 重定向跳转 或者返回上一个页面
    redirectHandler() {
      this.$router.replace(
        this.$route.query.redirect
          ? decodeURIComponent(this.$route.query.redirect)
          : '/'
      )
    },
    // 跳转注册页面
    toRegister() {
      if (this.$route.query.redirect) {
        this.$router.replace({
          path: '/register',
          query: { redirect: decodeURIComponent(this.$route.query.redirect) }
        })
      } else {
        this.$router.replace({ path: '/register' })
      }
    },

    // 生成一个用不重复的ID
    // genNonDuplicateID() {
    //   let uid = Math.random()
    //     .toString(36)
    //     .substr(3);
    //   this.GLOBAL.setStorage('uuid', uid);
    //   return uid
    // }
  }
}
</script>

<style>
.login .login-img {
  margin: 0.5rem auto;
}
.login .login-img img {
  border-radius: 50%;
}
.login .yd-tab-panel {
  background-color: #f5f5f5;
}
.login .yd-tab-panel-item .login-content {
  background-color: #fff;
}
.login .yd-tab-nav .yd-tab-nav-item:not(:last-child):after {
  border: none;
}
.login .yd-btn-block {
  height: 0.8rem;
  width: 90%;
  margin: 0.5rem auto;
}
.wechat-login {
  width: 80%;
  height: 1rem;
  margin: 0 auto 0.5rem;
}
.wechat-login img {
  width: 100%;
  height: 100%;
}
</style>
