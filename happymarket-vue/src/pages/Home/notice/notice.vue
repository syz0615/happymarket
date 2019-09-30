<template>
  <div class="notice">
    <h2 class="notice-title">{{notice.noticeTitle}}</h2>
    <div class="notice-content">
      <p>{{notice.noticeDesc}}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Notice',

  data() {
    return {
      notice: []
    }
  },
  created() {
    this.$http.NoticeDetail({ noticeId: this.$route.query.noticeId })
      .then(res => {
        if (res.data) {
          this.notice = res.data;
        } else {
          this.$dialog.alert({
            mes: '该公告信息不存在',
            callback: () => {
              this.$router.go(-1);
            }
          })
        }
      })
  }
}

</script>
<style scoped>
</style>
