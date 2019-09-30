<template>
  <div class="reg">
    <div class="reg-img">
      <img src="@/assets/image/user/group14.png" />
    </div>
    <yd-cell-group>
      <yd-cell-item>
        <span slot="left">用户名：</span>
        <yd-input slot="right" required :show-success-icon="false" regex="userName" v-model="userName" placeholder="请输入用户名"></yd-input>
      </yd-cell-item>
      <yd-cell-item>
        <span slot="left">手机号：</span>
        <yd-input type="text" slot="right" ref="tel" required :show-success-icon="false" regex="mobile" placeholder="请输入手机号码" v-model="userPhone"></yd-input>
      </yd-cell-item>
      <yd-cell-item>
        <span slot="left">密码：</span>
        <yd-input slot="right" type="password" v-model="userPwd" placeholder="请输入密码"></yd-input>
      </yd-cell-item>
    </yd-cell-group>
    <yd-button size="large" type="danger" @click.native="reg">注册</yd-button>
    已有账号? <span style="color: #10aeff;" @click="toLogin">&nbsp;立即登录</span>
  </div>
</template>
<script>
export default {
  data() {
    return {
      userName:'',
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
    checkMobile() {
      let res = {};
      if (!this.userPhone) {
        res.status = false;
        res.msg = '请输入手机号'
      } else if (!(/^1[345678]{1}\d{9}$/gi.test(this.userPhone))) {
        res.status = false;
        res.msg = '手机号格式不正确'
      } else if(this.userPhone){
        this.$http.CheckPhone({userPhone:this.userPhone})
        .then(res=>{
          if(!res.status){
            res.status = false;
            res.msg = '该账号已被注册'
          }
        })
      } 
      else {
        res.status = true
      }
      return res
    },

  },
  methods: {
    reg() {
      let data = { userName:this.userName, userPhone: this.userPhone, userPwd: this.userPwd };
      if (!this.checkMobile.status) {
        this.$dialog.toast({ mes: this.checkMobile.msg, timeout: 1300 });
      } else if (!this.userPwd) {
        this.$dialog.toast({ mes: '请输入登录密码', timeout: 1300 })
      } else {
        this.$http.UserRegister(data)
          .then(res => {
            console.log(res);
            if (res.status) {
              this.$dialog.toast({
                mes: '注册成功',
                timeout: 1000,
                icon: 'success',
                callback: () => {
                  this.$router.replace('/login')
                }
              })
            }
          })
          .catch(err => {
            console.log(err)
          })
      }

    },
    // 跳转到登录
    toLogin() {
      this.$router.replace({ path: '/login' })
    },
  }
}

</script>
<style>
.reg .reg-img {
  margin: .5rem auto;
}

.reg .reg-img img {
  border-radius: 50%;
}

.reg .yd-btn-block {
  /*background-color: #ff43;*/
  height: .8rem;
  width: 90%;
  margin: .5rem auto;
}

</style>
