<template>
  <yd-navbar slot="navbar" :title="title">
    <div slot="left" @click="back">
      <yd-navbar-back-icon></yd-navbar-back-icon>
    </div>
  </yd-navbar>
</template>
<script>
export default {
  props: ['title'],

  methods: {
    back() {
      if (window.history.length <= 1) {
        this.$router.push({ path: '/' })
        return false
      } else {
        this.$router.go(-1)
      }
    }
  }
}

</script>
<style scoped>
</style>
