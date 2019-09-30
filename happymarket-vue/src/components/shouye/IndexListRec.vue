<template>
  <transition name="fade">
    <div class="indexlistrec">
      <div class="indexlistheader">
        <img src="@/assets/image/seller.png" />
        <h3>店铺推荐</h3>
      </div>
      <yd-list theme="2" slot="list">
        <yd-list-item v-for="(item,key) in recGoods" :key="key" type="link" :href="{path:'goodsdetail',query:{goods_id:item.goodsId}}">
          <img class="goods-imgs" slot="img" v-lazy="'http://localhost:8080/image/'+item.goodsImg">
          <span slot="title">{{ item.goodsTitle }}</span>
          <yd-list-other slot="other">
            <div>
              <span class='demo-list-price'><em>¥</em>{{item.goodsPrice}}</span>
            </div>
            <div><button class="indexlist-cart"><img src="@/assets/image/cart.png" /></button></div>
          </yd-list-other>
        </yd-list-item>
      </yd-list>
    </div>
  </transition>
</template>
<script>
export default {
  data() {
    return {
      recGoods: []
    }
  },
  created () {
      this.$http.getgoodRec()
      .then(res=>{
        this.recGoods = res.data;
      })
      .catch(err=>{
        console.log(err)
      })
  }
}

</script>
<style>
.fade-enter-active,
.fade-leave-active {
  transition: opacity .5s;
}

.fade-enter,
.fade-leave-to
{
  opacity: 0;
}

</style>
