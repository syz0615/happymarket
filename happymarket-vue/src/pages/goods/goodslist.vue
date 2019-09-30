<template>
  <div class="goodslist">
    <yd-infinitescroll class="itemgoodslist">
      <yd-list theme="4" slot="list">
        <yd-list-item v-for="(item, index) in searchgoods" :key="index" type="link" :href="{path:'goodsdetail',query:{goods_id:item.goodsId}}">

          <img slot='img' :src='item.goodsImg'>
          <span slot='title'>{{item.goodsName}}</span>
          <yd-list-other slot='other'>
            <div>
              <span class='demo-list-price'><em>¥</em>{{item.goodsPrice}}</span>
            </div>
          </yd-list-other>
        </yd-list-item>
      </yd-list>
    </yd-infinitescroll>
  </div>
</template>
<script>

export default {
  data() {
    return {
      keywords: this.$route.query.key ? this.$route.query.key : '', // 搜索条件
      
      searchgoods: [],
    }

  },

  created() {
    this.getGoods()
  },

  methods: {
    getGoods() {
      let data = { key: this.keywords };
      this.$http.SearchGoods(data)
        .then(res => {
          console.log(res);
          this.searchgoods = res.data;
        })
        .catch(err => {
          console.log(err);
        })
    }
  }
}

</script>
