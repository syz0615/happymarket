<template>
  <div class="orderdetail">
     <!-- 地址信息 -->
    <div class="orderadd" v-if="orderinfo.address">
      <img class="orderadd-gps" src="@/assets/image/gps.png" />
      <div class="orderadd-content">
        <div class="orderadd-top">
          <span>收货人：{{ this.orderinfo.address.receiverName }}</span>
          <p>{{ this.orderinfo.address.receiverPhone }}</p>
        </div>
        <div class="orderadd-bottom">
          <p>收货地址：{{ this.orderinfo.address.receiverAddress }}{{ this.orderinfo.address.receiverDetail }}</p>
          <img class="orderadd-right right-img" src="@/assets/image/right.png" />
        </div>
      </div>
    </div>
    <!-- 商品信息 -->
    <div class="orderlist">
      <yd-list theme="4" v-if="this.orderinfo.goods">
      	<router-link :to="{name:'GoodsDetail',query:{goods_id:this.orderinfo.goods.goodsId}}">
        <yd-list-item>
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
        </router-link>
      </yd-list>
    </div>
    <!-- 订单编号等信息 -->
    <div class="order">
      <p align="left">订单编号:{{this.orderinfo.orderNo}}</p>
      <p align="left">订单创建时间:{{this.orderinfo.createTime}}</p>
      <p align="left">订单状态:{{this.orderinfo.createTime}}</p>
      <p align="left" style="color:red">订单金额:￥{{this.orderinfo.payPrice}}</p>
      <p align="left" v-if="this.orderinfo.orderStatus==1">已付款</p>
      <p align="left" v-if="this.orderinfo.orderStatus==0">待付款</p>
    </div>
  </div>
</template>
<script>
export default {

  data() {
    return {
      orderinfo: '',
    }
  },

  created() {
    if (!this.$route.query.order_id) {
      this.$dialog.alert({
        mes: '订单参数丢失',
        callback: () => {
          this.$router.go(-1)
        }
      })
    }
    this.getorderinfo();
  },

  methods: {
    getorderinfo() {
      this.$http.getorderdetail({ orderId: this.$route.query.order_id })
        .then(res => {
          this.orderinfo = res.data;
          console.log('订单信息', this.orderinfo)
        })
    }

  }
}

</script>
<style scoped>
.order {
	background-color: #F9F9F9;
	margin-bottom: .3rem;
}

</style>
