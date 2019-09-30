<template>
  <div class="collect">
    <yd-infinitescroll>
      <ul slot="list" v-if="list.length">
        <li class="list-item" data-type="0" v-for="(item, index) in list" :key="index">
          <div class="list-box" style="padding: .15rem;" @click="showDetail(item.goods.goodsId)">
            <div v-if="item.goods">
              <img slot="img" :src="'http://localhost:8080/image/' + item.goods.goodsImg" class="goodsimg">
              <div class="list-body">
                <h3 class="goodsname" slot="title">{{ item.goods.goodsName }}</h3>
                <div class="btn-numbox">
                  <div>
                    <span class="demo-list-price"><em>¥</em>{{ item.goods.goodsPrice }}</span>
                  </div>
                </div>
                <div slot="other">
                  <div>
                    <span class="time">{{ item.goods.addTime }}</span>
                  </div>
                </div>
                <img class="right-img" slot="other" src="@/assets/image/right.png" />
              </div>
            </div>
          </div>
          <div class="delete" @click="deleteItem(item.collectId)">取消收藏</div>
        </li>
      </ul>
    </yd-infinitescroll>
  </div>
</template>
<script>
export default {
  data() {
    return {
      list: [] // 获取我的关注列表
    }
  },
  created() {
    this.goodsCollectionList()
  },
  methods: {
    showDetail(goodsId) {
      this.$router.push({ path: '/goodsdetail', query: { goods_id: goodsId } })
    },
    goodsCollectionList() {
      this.$http.allCollect({
          userId: this.GLOBAL.getStorage('user_token_id')
        })
        .then(res => {
          console.log(res.data);
          this.list = res.data;
        })
    },


    // 删除
    deleteItem(index) {
      this.$http.deleteCollect({ collectId: index })
        .then(res => {
          if (res.status) {
            this.$dialog.toast({ mes: '删除成功', timeout: 1000, icon: 'success' });
            this.goodsCollectionList();
          }
        })
    }
  }
}

</script>
