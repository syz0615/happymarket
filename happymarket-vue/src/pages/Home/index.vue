<template>
  <div class="index">
    <search />
    <indexslider />
    <rollnotice />
    <indexgrids />
    <indexlisthot />
    <indexlistrec />
  </div>
</template>
<script>
import search from "@/components/shouye/Search.vue"
import indexslider from "@/components/shouye/IndexSlider.vue"
import rollnotice from "@/components/shouye/RollNotice.vue"
import indexgrids from "@/components/shouye/IndexGrids.vue"
import indexlisthot from "@/components/shouye/IndexListHot.vue"
import indexlistrec from "@/components/shouye/IndexListRec.vue"

export default {
  name: 'Home',

  data() {
    return {

    }
  },
  components: {
    search,
    indexslider,
    rollnotice,
    indexgrids,
    indexlisthot,
    indexlistrec
  }
}

</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.index {
  padding-bottom: 60px;
}

</style>
