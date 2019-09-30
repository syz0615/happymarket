<template>
  <div class="classify">
    <div class="firstnav">
      <ul>
        <li :class="{firstactive:changeFNav == index}" v-for="(item,index) in firstNav" @click="change(index);categorySecondNav(item.categoryId)">{{item.categoryName}}</li>
      </ul>
    </div>
    <div class="secondnav">
      <nav>
        <p :class="{secondactive:changeactive==index}" v-for="(item,index) in secondNav" @click="toggle(index); getClassifyGoods(item.categoryId)">{{ item.categoryName }}</p>
      </nav>
    </div>
    <div class="goodsshow">
      <ul>
        <li v-for="(item,index) in classifyGoods">
          <router-link :to="{name:'GoodsDetail',query:{goods_id:item.goodsId}}">
            <van-card num="1" :price="item.goodsPrice" :desc="item.goodsTitle" :title="item.goodsName" :thumb="'http://localhost:8080/image/'+item.goodsImg" />
          </router-link>
        </li>
      </ul>
    </div>
  </div>
</template>
<script>
import Card from 'vant/lib/Card';
import 'vant/lib/Card/style';
export default {
  components: {
    [Card.name]: Card
  },
  data() {
    return {
      changeFNav: 0, //初始默认一级分类选中
      changeactive: 0, //初始默认二级个分类选中
      firstNav: [], //一级分类
      secondNav: [], //二级分类
      classifyGoods: [] //分类商品
    }
  },

  created() {
    this.CategoryFirstNav();
    this.categorySecondNav();
    this.getClassifyGoods();
  },

  methods: {
    change(index) {
      this.changeFNav = index;
    },
    toggle(index) {
      this.changeactive = index;
    },

    //获取一级菜单
    CategoryFirstNav() {
      this.$http.CategoryFirstNav()
        .then(res => {
          console.log(res.data);
          this.firstNav = res.data;
        })
        .catch(err => {
          console.log(err)
        })
    },
    //获取二级菜单
    categorySecondNav(index) {
      let data = {
        parentId: index
      };
      this.$http.CategorySecondNav(data)
        .then(res => {
          console.log(res.data);
          this.secondNav = res.data;
        })
        .catch(err => {
          console.log(err)
        })
    },
    //获取二级分类下的商品
    getClassifyGoods(index) {
      let data = {
        categoryId: index
      };
      this.$http.getCategoryGoods(data)
        .then(res => {
          console.log(res.data);
          this.classifyGoods = res.data;
        })
        .catch(err => {
          console.log(err);
        })
    },
  },
}

</script>
<style scoped>
.firstnav {
  width: 1.6rem;
  height: 100%;
  background-color: pink;
  position: relative;
}

.firstnav ul {
  list-style: none;
}

.firstnav ul li {
  width: 1.6rem;
  height: 0.9rem;
  background-color: #FFF;
  font-size: 0.3rem;
  line-height: 0.9rem;
}

/*选中后一级导航字体加粗*/
.firstactive {
  font-weight: 700;
}

.secondnav {
  width: 79%;
  height: 0.7rem;
  overflow: hidden;
  position: absolute;
  top: 0;
  right: 0;
}

.secondnav nav {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: middle;
  -ms-flex-align: middle;
  align-items: middle;
  overflow: auto;
  /*能够水平拉伸*/
}

.secondnav p {
  font-size: 14px;
  flex-shrink: 0;
  /*汉字水平*/
  padding: 8px;

}

.secondnav p.secondactive {
  color: red;
}

.goodsshow {
  width: 79%;
  overflow: hidden;
  position: absolute;
  top: 0.7rem;
  right: 0;
}

.goodsshow ul {
  list-style: none;
}

</style>
