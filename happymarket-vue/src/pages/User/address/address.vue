<template>
  <div class="address">
    <yd-cell-group>
      <yd-cell-item>
        <span slot="left">姓名：</span>
        <yd-input slot="right" v-model="receiverName" max="20" placeholder="请输入姓名"></yd-input>
      </yd-cell-item>
      <yd-cell-item>
        <span slot="left">手机号：</span>
        <yd-input slot="right" v-model="receiverPhone" type="tel" ref="mobile" regex="mobile" placeholder="请输入手机号码"></yd-input>
      </yd-cell-item>
      <yd-cell-item arrow>
        <span slot="left">所在地区：</span>
        <input slot="right" type="text" @click.stop="show = true" v-model="receiverAddress" readonly placeholder="请选择收货地址">
      </yd-cell-item>
      <yd-cell-item>
        <span slot="left">详细地址：</span>
        <yd-input slot="right" v-model="receiverDetail" max="20" placeholder="请输入详细地址"></yd-input>
      </yd-cell-item>
      <yd-cell-item type="label" v-if="!addressId">
        <div slot="left">设置为默认地址：</div>
        <yd-switch slot="right" v-model="def"></yd-switch>
      </yd-cell-item>
    </yd-cell-group>
    <yd-cityselect v-model="show" :callback="result1" :items="district"></yd-cityselect>
    <yd-button size="large" type="danger" @click.native="submit">保存</yd-button>
  </div>
</template>
<script>
import District from 'ydui-district/dist/gov_province_city_area_id';
export default {
  data() {
    return {
      addressId: this.$route.query.addressId || 0,  //查看地址详情带过来的id
      receiverName: '', // 名称
      receiverPhone: '', // 手机
      show: false,
      addressId: '', // 地区id
      receiverAddress:'',  //省市县
      receiverDetail: '', // 详细地址
      area: '', // 地区信息  文档中就有定义
      isDefault : '',
      def: true, // 是否为默认
      district: District
    }
  },
 
  computed: {
    checkMobile() {
      let res = {};
      if (!this.receiverPhone) {
        res.status = false;
        res.msg = '请输入手机号'
      } else if (!(/^1[345678]{1}\d{9}$/gi.test(this.receiverPhone))) {
        res.status = false;
        res.msg = '手机号格式不正确'
      } else {
        res.status = true
      }
      return res
    }
  },
  methods: {
    result1(ret) {
      this.addressId = ret.itemValue3;
      //文档中的方法 area
      this.receiverAddress = ret.itemName1 + ' ' + ret.itemName2 + ' ' + ret.itemName3;
    },
    submit() {
      if (!this.receiverName) {
        this.$dialog.toast({ mes: '请输入名称', timeout: 1000 })
      } else if (!this.receiverPhone) {
        this.$dialog.toast({ mes: '请输入手机号', timeout: 1000 })
      } else if (!this.receiverAddress) {
        this.$dialog.toast({ mes: '请选择地区', timeout: 1000 })
      } else if (!this.checkMobile.status) {
        this.$dialog.toast({ mes: '手机号格式不正确', timeout: 1000 })
      } else if (!this.receiverDetail) {
        this.$dialog.toast({ mes: '请输入详细地址信息', timeout: 1000 })
       } 
        else { 
        // 添加
        let data = {
          receiverName: this.receiverName,
          receiverAddress:this.receiverAddress,
          receiverDetail: this.receiverDetail,
          receiverPhone: this.receiverPhone,
          addressId:this.addressId,
          userId:this.GLOBAL.getStorage('user_token_id'),
          isDefault:this.def ? 1 : 0 
        };
        this.$http.addAddress(data)
        .then(res => {
          if (res.status) {
            this.$dialog.toast({
              mes: res.msg,
              timeout: 1000,
              icon: 'success',
              callback: () => {
                this.$router.go(-1)
              }
            })
          }
        })
      }
    }
  }
}

</script>
