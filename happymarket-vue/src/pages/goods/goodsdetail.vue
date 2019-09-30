<template>
  <div class="goodsdetail">
    <div class="goodsdetail-back">
      <i class="iconfont icon-zuo" @click="goBack"></i>
    </div>

    <Slider :imgList="goodsData"></Slider>

    <GoodsTitle :product="goodsData"></GoodsTitle>
    
    <yd-tab>
      <yd-tab-panel label="图文详情">
        <ul v-html="goodsData.goodsDesc"></ul>
      </yd-tab-panel>
      <yd-tab-panel class="comment" label="买家评论">
        <ul>
          <li style="text-align: center">
            <!-- <yd-button size="small" type="hollow" color="#F00" shape="circle" v-if="load" @click.native="loadMore">加载更多评论</yd-button> -->
            <yd-button size="small" type="hollow" color="#AAA" shape="circle">没有更多评论了</yd-button>
          </li>
        </ul>
      </yd-tab-panel>
    </yd-tab>
    <div class="goodsdetailfooter">
      <div class="goodsdetailfooter-left">
        <div class="goods-cart" @click="collection" v-show="!is_fav">
          <img src="@/assets/image/star.png" />
          <p>收藏</p>
        </div>
        <div class="goods-cart" @click="collection" v-show="is_fav">
          <img src="@/assets/image/redstar.png" />
          <p>取消收藏</p>
        </div>
        <router-link tag="div" class="star" to="/cart">
          <img src="@/assets/image/goods-cart.png" />
          <yd-badge type="danger" v-if="cart_nums">{{ cart_nums }}</yd-badge>
          <p>购物车</p>
        </router-link>
      </div>
      <div class="goodsdetailfooter-right">
        <div class="addtocart">
          <yd-button type="danger" @click.native="addCart(goodsData.goodsId)">加入购物车</yd-button>
        </div>
        <div class="buynow">
          <yd-button type="danger" @click.native="buyNow">立即购买</yd-button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Slider from '../../components/goods/slider.vue'
import GoodsTitle from '../../components/goods/goodstitle.vue'
export default {
  components: {
    Slider,
    GoodsTitle,
  },

  data() {
    return {
      goods_id: this.$route.query.goods_id ? this.$route.query.goods_id : '', // vueRouter传过来的商品id
      goodsData: [], // 商品数据
      autoPlay: 3000,
      is_fav: false, // 是否收藏
      num: 1, // 购买的商品数量 默认为1
      cart_nums: 0, // 购物车数量
    }
  },

  created() {
    this.initData();
  },

  methods: {
    goBack() {
      if (window.history.length <= 1) {
        this.$router.push({ path: '/' });
        return false;
      } else {
        this.$router.go(-1);
      }
    },
    collection() {
      let data = {
        userId: this.GLOBAL.getStorage('user_token_id'),
        goodsId: this.goods_id
      }
      this.$http.addCollect(data)
        .then(res => {
          if (res.status) {
            this.is_fav = !this.is_fav;
            this.$dialog.toast({ mes: '收藏成功', timeout: 1000 })
          }
        })
        .catch(err => {
          console.log(err);
        })
    },

    initData() { //当前点击的商品ID赋值给用于请求后台的商品ID
      this.$http.goodsDetail({ goodsId: this.goods_id })
        .then(res => {
          console.log(res);
          this.goodsData = res.data;
        })
        .catch(err => {
          console.log(err);
        })
    },

    //添加物品到购物车
    addCart(index) {
      let shopcart = {
        goodsId: index,
        userId: this.GLOBAL.getStorage('user_token_id'),
        count: this.num
      };
      this.$http.addShopCart(shopcart)
        .then(res => {
          ++this.cart_nums;
          console.log(res.data);
          if (res.status) {
            this.$dialog.toast({ mes: res.msg, timeout: 1000, icon: 'success' })
          }
        })
        .catch(err => {
          console.log(err);
        })
    },

    buyNow() {
      let data = {
        userId: this.userId,
        goodsId: this.goodsId,
        addressId: this.addressId,
        buyCount: this.num
      }
      this.$http.getNoPayOrderList(data)
      if (res.status) {
        let cartIds = res.data
        this.$router.push({ path: '/firmorder', query: { cartIds } })
      }
    },

    goBack() {
      if (window.history.length <= 1) {
        this.$router.push({ path: '/' })
        return false
      } else {
        this.$router.go(-1)
      }
      // 上面都没执行就说明卡在当前页不是最后一条， histroy记录数量大于1，又没有回退记录，只能返回首页，
      // 如果上面都执行了 页面都跳走了，这个也就不用管了
    },

  }
}

</script>

<style scoped>
.slidercontent {
  height: 100%;
}

.slider-back {
  position: absolute;
  top: .2rem;
  left: .2rem;
  z-index: 1000;
  width: .5rem;
  height: .5rem;
  text-align: center;
  line-height: .5rem;
  background-color: rgba(0, 0, 0, 0.3);
  border-radius: 50%;
  display: none;
}

</style>
