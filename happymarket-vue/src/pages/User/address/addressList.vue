<template>
  <div class="orderadd-content addresslist" style="margin: auto;width: 100%;">
    <div v-if="list.length">
      <div class="orderadd" v-for="(item, index) in list" :key="index">
        <div class="orderadd-header">
          <yd-badge type="danger" v-if="item.isDefault === 1">默认地址</yd-badge>
          <yd-badge type="primary" v-else v-show="false">设为默认</yd-badge>
          <!-- @click.native="setDef(item.addressId)" -->
          <yd-button size="small" type="hollow" @click.native='remove(item.addressId)'>删除</yd-button>
        </div>
        <div class="orderadd-content" @click="showDetail(item.addressId)">
          <div class="orderadd-top">
            <span>收货人：{{ item.receiverName }}</span>
            <p>{{ item.receiverPhone }}</p>
          </div>
          <div class="orderadd-bottom">
            <p>收货地址：{{ item.receiverAddress }} {{item.receiverDetail}}</p>
            <img class="orderadd-right right-img" src="@/assets/image/user/right.png" />
          </div>
        </div>
      </div>
    </div>
    <div v-else>
      暂无收货地址
    </div>
    <yd-button size="large" @click.native="add" type="danger">新增收货地址</yd-button>
  </div>
</template>
<script>
export default {
  data() {
    return {
      list: []
    }
  },
  created() {
    this.getuserAddressList()
  },
  methods: {
    getuserAddressList() {
      let data = {
        userId: this.GLOBAL.getStorage('user_token_id')
      };
      this.$http.getAllAddress(data)
        .then(res => {
          this.list = res.data
        })
        .catch(err => {
          console.log(err);
        })
    },

    // 添加新地址
    add() {
      this.$router.push({ path: '/address' })
    },
    // 查看地址详情
    showDetail(id) {
      this.$router.push({ path: '/address', query: { addressId: id } })
    },
    // 设置默认地址  这个接口不管用 暂时不实现
    // setDef (addressId) {
    //     this.$http.defaultAddress({userId:addressId,isdefault:1})
    //     .then(res=>{
    //         if(res.status){
    //             this.$dialog.toast({
    //               mes: res.msg,
    //               timeout: 1000,
    //               icon: 'success',
    //             })
    //         }
    //     })
    // },
    // 收货地址删除
    remove(id) {
      this.$dialog.confirm({
        mes: '确认删除该收货地址?',
        opts: [{
            txt: '取消',
            color: false
          },
          {
            txt: '确定',
            color: true,
            callback: () => {
              this.$http.deleteAddress({ addressId: id })
                .then(res => {
                  if (res.status) {
                    this.$dialog.toast({ mes: res.msg, icon: 'success', timeout: 1000 })
                    this.getuserAddressList()
                  }
                })
            }
          }
        ]
      })
    }
  }
}

</script>
<style scoped>
.addresslist {
  padding-bottom: 1rem;
}

</style>
