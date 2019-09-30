<template>
  <div class="datasetting">
    <yd-tab v-model="tab">
      <yd-tab-panel label="资料设置">
        <div class="datasetting-content">
          <yd-cell-group>
            <yd-cell-item>
              <img slot="icon" src="@/assets/image/user/man.png">
              <span slot="left">昵称</span>
              <input slot="right" type="text" v-model="name" placeholder="请输入昵称">
            </yd-cell-item>

            <yd-cell-item>
              <img slot="icon" src="@/assets/image/user/ic-number.png">
              <span slot="left">邮箱：</span>
              <yd-input slot="right" v-model="email" :debug="true" regex="email" placeholder="请输入邮箱地址"></yd-input>
            </yd-cell-item>

          </yd-cell-group>
        </div>
      </yd-tab-panel>
      <yd-tab-panel label="修改密码">
        <yd-cell-group>
          <yd-cell-item>
            <span slot="left">旧密码：</span>
            <yd-input slot="right" type="password" v-model="pwd" placeholder="请输入当前密码"></yd-input>
          </yd-cell-item>
          <yd-cell-item>
            <span slot="left">新密码：</span>
            <yd-input slot="right" type="password" v-model="newPwd" placeholder="请输入新密码" key="edit"></yd-input>
          </yd-cell-item>
          <yd-cell-item>
            <span slot="left">确认密码：</span>
            <yd-input slot="right" type="password" v-model="rePwd" placeholder="请输入确认密码" key="edit"></yd-input>
          </yd-cell-item>
        </yd-cell-group>
      </yd-tab-panel>
    </yd-tab>

    <yd-button-group>
      <yd-button size="large" bgcolor="#ff3b44" color="#fff" @click.native="submitHandler">确认修改</yd-button>
    </yd-button-group>
  </div>
</template>
<script>
export default {
  data() {
    return {
      tab: parseInt(this.GLOBAL.getStorage('settingTab')) || 0,
      name: '', // 名称
      email:'', //邮箱
      pwd: '', // 原始密码
      newPwd: '', // 新密码
      rePwd: '', // 确认密码
      mobile: '', // 用户手机号
      show: false,
      userInfo:[], //用户信息
    }
  },

  created() {
    // 获取用户信息
    let data = {userId:this.GLOBAL.getStorage('user_token_id')};
    this.$http.getUserInfo(data)
    .then(res=>{
      console.log(res.data)
      this.userInfo = res.data;
    })
  },
  methods: {
    // 编辑提交
    submitHandler() {
      switch (this.tab) {
        case 0:
          let data = 
            {
              userId:this.userInfo.userId,
              username:this.name,
              userEmail:this.email
            };
          this.$http.updateUserInfo(data)
          .then(res=>{
            if(res.status){
              this.GLOBAL.removeStorage('user_token_Name');
              this.GLOBAL.setStorage('user_token_Name',username);
              this.$dialog.toast({
              mes: '修改成功!',
              timeout: 2000,
            })
            }
          })
          break
        case 1:
          if (this.pwd === '') {
            this.$dialog.toast({ mes: '请输入旧密码', timeout: 1000 })
          } else if (this.newPwd === '') {
            this.$dialog.toast({ mes: '请输入新密码', timeout: 1000 })
          } else if (this.rePwd === '') {
            this.$dialog.toast({ mes: '请输入重复密码', timeout: 1000 })
          } else {
            this.$http.updateUserPwd({
              userId:this.userInfo.userId,
              userPwd: this.pwd,
              newPwd: this.newPwd,
            })
            .then(res=>{
              if(res.status){
                this.resultStatus(res);
              }            
            })
          }
          break
        default:
          break
      }
    },
    // 修改密码  返回结果统一处理
    resultStatus(res) {
      if (res.status) {
        this.$dialog.alert({
          mes: '修改成功,请重新登录',
          timeout: 1000,
          callback: () => {
            this.GLOBAL.removeStorage('settingTab')
            this.GLOBAL.removeStorage('user_token.user_token_id')
            this.GLOBAL.removeStorage('user_token.user_token_Name')
            this.GLOBAL.removeStorage('user_token')
            this.$router.push({ path: '/login' })
          }
        })
      }
    }
  },
  watch: {
    tab() {
      this.GLOBAL.setStorage('settingTab', this.tab)
      // 切换tab清空对应表单密码内容
      this.pwd = ''
      this.newPwd = ''
      this.rePwd = ''
    }
  }
}

</script>
