<template>
  <div class="indexlisthot">
    <div class="indexlistheader">
      <img src="@/assets/image/hot.png" />
      <h3>店铺热卖</h3>
    </div>
    <yd-list theme="2" slot="list">  <!--   -->
      <yd-list-item v-for="(item, key) in hotGoods" :key="key" type="link" :href="{path:'goodsdetail',query:{goods_id:item.goodsId}}">
        <img class="goods-imgs" slot="img" v-lazy= "'http://localhost:8080/image/' + item.goodsImg">
        <span slot="title">{{item.goodsName}}</span>
        <yd-list-other slot="other">
          <div>
            <span class='demo-list-price'><em>¥</em>{{item.goodsPrice}}</span>
            <!--<span class='demo-list-del-price'>¥{{item.w_price}}</span>-->
          </div>
          <div><button class="indexlist-cart"><img src="@/assets/image/cart.png" /></button></div>
        </yd-list-other>
      </yd-list-item>
    </yd-list>
  </div>
</template>

<script>
export default {
  data() {
    return {
      hotGoods: [],
    }
  },
   created(){
     this.$http.getgoodHot()
     .then(res=>{
      this.hotGoods = res.data
     })
     .catch(err=>{
      console.log(err)
     })

  }

}

</script>

<style scoped>

</style>
