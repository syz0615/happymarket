<template>
  <div class="checkorder">
      <div class="orderlist">
      <yd-list theme="4" v-for="(item,index) in orderlist" :key="index">
        <router-link :to="{name:'FirmOrder',query:{goodID:item.goods.goodsId,Num:item.buyCount}}">
        <yd-list-item>
          <img slot="img" v-lazy="'http://localhost:8080/image/' + item.goods.goodsImg">
          <h3 class="goodsname" slot="title">{{ item.goods.goodsName }}</h3>
          <p class="goods" slot="title">{{ item.goods.goodsTitle }}</p>
          <p class="goods" slot="title">订单编号：{{ item.orderNo }}</p>
          <yd-list-other slot="other">
            <div>
              <span class="demo-list-price"><em>¥</em>{{ item.goods.goodsPrice }}</span>
            </div>
            <div>x{{ item.buyCount }}</div>
            <div class="anniu" v-if="item.orderStatus==0">去付款</div>
            <div class="anniu" v-if="item.orderStatus==1">待收货</div>
          </yd-list-other>

        </yd-list-item>
        </router-link>
      </yd-list>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      orderlist:[]
    }
  },

  created() {
    this.getAllOrder()
  },

  methods: {
    getAllOrder(){
      this.$http.getAllOrderList({userId:this.GLOBAL.getStorage('user_token_id')})
      .then(res=>{
        this.orderlist = res.data;
        console.log(this.orderlist)
      })
    },

}

}

</script>
<style scoped>


</style>
