<template>
  <div class="firmdrder">
    <orderadd :ship="morendizhi" @shipHander="shipHander"></orderadd>
    <div class="orderlist">
      <!-- 本应该用v-for遍历商品，但只能购买一件，目前给他写死 -->
      <yd-list theme="4" v-if="this.orderinfo">
        <yd-list-item @click="showDetail(this.orderinfo.goods.goodsId)">
          <img slot="img" :src="'http://localhost:8080/image/' + this.orderinfo.goods.goodsImg">
          <h3 class="goodsname" slot="title">{{ this.orderinfo.goods.goodsName }}</h3>
          <p class="goods" slot="title">{{ this.orderinfo.goods.goodsTitle }}</p>
          <yd-list-other slot="other">
            <div>
              <span class="demo-list-price"><em>¥</em>{{ this.orderinfo.goods.goodsPrice }}</span>
            </div>
            <div>x{{ this.orderinfo.buyCount }}</div>
          </yd-list-other>
        </yd-list-item>
      </yd-list>
    </div>

    <div class="orderfooter">
      <div class="orderfooter-left">
        <p>需付：</p><span>￥{{ this.orderinfo.payPrice }}</span>
      </div>
      <div class="orderfooter-right">
        <yd-button type="danger" @click.native="payment">立即支付</yd-button>
      </div>
    </div>
  </div>
</template>
<script>
import orderadd from '../../components/order/OrderAdd'
import Vue from 'vue'
export default {
  components: {
    orderadd,
  },
  data() {
    return {
      morendizhi: {}, //获取用户默认地址
      orderinfo: '', //订单信息，包括商品，用户，地址，设置为空防止异步加载报字段未定义
      products:[], //商品信息
      codes:'',
      params: {
        addressId: '', //OrderAdd组件中传过来的id
      }
    }
  },

  created() {
    this.getAddress();
  },

  methods: {
    //获取默认地址
    getAddress() {
      let data = { userId: this.GLOBAL.getStorage('user_token_id') };
      this.$http.defaultAddress(data)
        .then(res => {
          this.morendizhi = res.data;
          this.params.addressId = res.data.addressId;
              this.getGoods();
        })
    },

    //获取要购买的商品信息
    getGoods() {
      let data = {
        userId: this.GLOBAL.getStorage('user_token_id'),
        goodsId: this.$route.query.goodID,
        buyCount: this.$route.query.Num,
        addressId: this.morendizhi.addressId,
      };
      this.$http.getNoPayOrderList(data)
        .then(res => {
          if(res.status){
           this.orderinfo = res.data;
           this.products = res.data.goods;
           console.log('订单信息', this.orderinfo);           
          }

        })
        .catch(err => {
          console.log(err);
        })
    },

    //用户选中的收货地址
    shipHander(val) {
      this.morendizhi = val;
      this.morendizhi.addressId = val.addressId;
      this.params.addressId = val.addressId;
      console.log(val);
      console.log(this.params.addressId);
    },
    //查看商品详情
    showDetail(goodsId) {
      this.$router.push({ path: '/goodsdetail', query: { goods_id: goodsId } })
    },

    payment() {
      let data = { orderId: this.orderinfo.orderId };
      console.log(this.orderinfo.orderId);
      this.$http.GoodsPay(data)
        .then(res => {
          if(res.status){
            this.$dialog.toast({mes: '支付成功', icon: 'success', timeout: 1000});
          }
          this.$router.push({path:'orderdetail',query:{order_id:this.orderinfo.orderId}})
        })

    },


  }
}

</script>
<style scoped>

</style>
