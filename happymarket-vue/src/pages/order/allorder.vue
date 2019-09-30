<template>
  <div class="ordertab">
    <yd-tab v-model="intTab">
      <yd-tab-panel v-for="(tab,index) in items" :key=index :label="tab.label">

      <div class="order-content" v-for="(item, key) in tab.list" :key="key" slot="list">
          <!-- <div class="order-content-header">
            <p class="header-left">订单号：{{ item.orderId }}</p>
            <p class="header-right" v-if="item.status === 1&&item.orderStatus === 0 ">待付款</p>
          </div> -->
          <!-- 加载的内容 -->
          <yd-list theme="4">            
            <yd-list-item v-for="(goods, key) in item.items" :key="key"> 
              <img slot="img" v-lazy="goods.goodsImg">              
              <h3 class="goodsname" slot="title">{{ goods.goods.goodsName }}</h3>
              <p class="goods" slot="title">{{ goods.goods.goodsTitle }}</p>
              <yd-list-other slot="other">
                <div>
                  <span class="demo-list-price"><em>¥</em>{{ goods.goods.goodsPrice }}</span>
                </div>
                <div>x{{ goods.buyCount }}</div>
              </yd-list-other>
            </yd-list-item>
          </yd-list>
          <!--  <div class="order-content-footer">
              <div class="footer-top">
                <p class="footer-top-left">共计 {{ item.buyCount }} 件商品</p>
                <p class="footer-top-right">合计：¥{{ item.payPrice }}</p>
              </div>
              <div class="footer-bottom" v-if="item.orderStatus === 0 ">
                <yd-button type="hollow" shape="circle" class="left-btn" @click.native="showDetail(item.orderId)">查看</yd-button>
                <yd-button type="hollow" shape="circle" class="right-btn" @click.native="pay(item.orderId)">立即付款</yd-button>
              </div>
            </div> -->
        </div>
      </yd-tab-panel>
      <yd-backtop></yd-backtop>
    </yd-tab>
  </div>
</template>
<script>
export default {
  data() {
    return {
      intTab: this.$route.query.tab ? parseInt(this.$route.query.tab) : 0,
      page: 1, //滚动加载用
      pageSize: 5, //滚动加载用
      items: [{
          label: '全部',
          list: [],
          page: 1,
          status: 0
        },
        {
          label: '待付款',
          list: [],
          page: 1,
          status: 1
        },
        {
          label: '待发货',
          list: [],
          page: 1,
          status: 2
        },
        {
          label: '待收货',
          list: [],
          page: 1,
          status: 3
        },
        {
          label: '待评价',
          list: [],
          page: 1,
          status: 4
        }
      ],

    }
  },

  created() {

  },

  methods: {

  },


}

</script>
<style scoped>
.express-info {
  background-color: #fff;
  position: relative;
}

.express-num {
  position: fixed;
  top: -1px;
  background-color: #e5e5e5;
  width: 100%;
  height: .8rem;
  line-height: .8rem;
  z-index: 10086;
}

.express-info .yd-timeline {
  margin-top: calc(.5rem - 1px);
  font-size: .1rem;
}

</style>
