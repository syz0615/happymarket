<template>
  <div class="slider" ref="slider">
    <yd-slider ref="slidercontent" class="slidercontent" :autoplay="autoplay" v-if="sliderList.length">
      <yd-slider-item v-for="(item,key) in sliderList" :key="key" :href="{path:'goodsdetail',query:{goods_id:item.goodsId}}">
        <img v-lazy="'http://localhost:8080/image/' + item.goodsImg">
      </yd-slider-item>

    </yd-slider>
    <div class="slider-back"></div>
  </div>
</template>
<script>
export default {

  data() {
    return {
      autoplay: 3000,
      sliderList:[]
    }
  },

  created(){
    this.$http.shouyeSlide()
      .then(res=>{
        console.log(res.data);
        this.sliderList = res.data
      })
      .catch(err=>{
        console.log(err)
      })
    
  },
}

</script>
<style scoped>

.slidercontent {
  height: 100%;
  min-height: 4rem;
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
