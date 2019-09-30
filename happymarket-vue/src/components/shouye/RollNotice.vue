<template>
  <div class="roolnotice">
    <yd-rollnotice :autoplay="autoPlay" v-if="noticeList.length">
      <yd-rollnotice-item v-for="(item,index) in noticeList" :key="index" @click.native="showDetail(item.noticeId)">
        {{item.noticeTitle}}
      </yd-rollnotice-item>
    </yd-rollnotice>
  </div>
</template>

<script>
export default {
  name: 'RollNotice',
  data() {
    return {
      autoPlay: 3000,
      noticeList: []
    }
  },
  created() {
    this.$http.ShowNotice()
      .then(res => {
        this.noticeList = res.data;
      })
      .catch(err => {
        console.log(err);
      })
  },

  methods: {
    showDetail(id) {
      this.$router.push({ path: '/notice', query: { noticeId: id } })
    }
  }
}
</script>

<style scoped>
.roolnotice {
  background-color: #F2F2F2;
  padding: .2rem 0;
}

.cashPool span {
  color: #f00;
}

</style>
