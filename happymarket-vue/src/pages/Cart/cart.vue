<template>
  <div class="cart">
    <div class="cartlist" v-if="list.length">
      <ul color="#ff3b44">
        <li class="list-item" :val="item.shopcartId" v-for="(item, index) in list" :key="index" >
          <div class="list-box" style="padding: .15rem;position: relative;">
            <div class="check-box">
                <input type="checkbox" @click="radioHandler(index)" class="input_check" name="box" :id="item.shopcartId" :value="item.shopcartId" v-model="item.isDefault">
                <label :for="item.shopcartId"></label>
            </div>
            <img :src=" 'http://localhost:8080/image/'+item.goods.goodsImg" class="goodsimg" @click="showDetail(item.goods.goodsId)">
            <div class="list-body">
              <h3 class="goodsname" @click="showDetail(item.goods.goodsId)">{{item.goods.goodsName}}</h3>
              <p class="standard" @click="showDetail(item.goods.goodsId)">{{item.goods.goodsTitle}}</p>
              <ul class="btn-numbox">
                <p class="price" @click="showDetail(item.goods.goodsId)">￥{{item.goods.goodsPrice}}</p>
                <li class="spinner">
                  <ul class="count">
                    <li @click="minus(item.shopcartId,item.count)">
                      <button id="num-jian" class="num-jian">-</button>
                    </li>
                    <li><input type="text" class="input-num" id="input-num" v-model="item.count"></li>
                    <li @click="add(item.shopcartId)">
                      <button id="num-jia" class="num-jia">+</button>
                    </li>
                  </ul>
                </li>
              </ul>
              <div>
              </div>
            </div>
          </div>
          <div class="delete" @click="deleteItem(item.shopcartId)" :data-index="index">删除</div>
        </li>
      </ul>
    </div>
    <div class="cartlist data-none" v-else>空空如也,快去挑选喜欢的商品吧~</div>
    <div class="cartfooter">
      <div class="cartfooter-left">
        <div class="cartfooter-left-price">
          <p>合计:<span class="price">￥{{this.total||0}}</span></p>
          <p class="anootation">不包含运费</p>
        </div>
      </div>
      <div class="cartfooter-btn">
        <yd-button type="danger" @click.native="balance()" v-if="canBuy">去结算</yd-button>
        <yd-button type="disabled" disabled v-else>去结算</yd-button>
      </div>
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
      list: [], //购物车商品列表
      total: '', // 商品总金额
      goodsId:'',  //商品Id
      shopcartId:'',
    }
  },

  created() {
    this.getShopCart()
  },

  computed: {
    canBuy() {
      let ids = [];
      this.list.forEach(item => {
        if (item.isDefault) {
          ids.push(item.shopcartId)
        }
      })
      if (ids.length) {
        return true;
      } else {
        return false;
      }
    },

  },
  methods: {
    getShopCart() {
      //获得购物车列表
      let data = { userId: this.GLOBAL.getStorage('user_token_id') };
      this.$http.ShopCart(data)
        .then(res => {
          console.log(res.data);
          this.list = res.data;      
        })
        .catch(err => {
          console.log(err);
        })
    },
    //删除商品某一项
    deleteItem(index) {
      let data = { shopcartId: index };
      this.$http.deleteShopCart(data)
        .then(res => {
          if (res.status) {
            this.$dialog.toast({
              mes: '删除成功',
              timeout: 2000,
            })
            this.getShopCart()
          }
        })

    },

    radioHandler(index) {
      this.list[index].isDefault = !this.list[index].isDefault;
      this.total = 0;
      for(let i=0;i<this.list.length;i++){
        if(this.list[i].isDefault === true){
          this.total = this.total + this.list[i].count * this.list[i].goods.goodsPrice;
          console.log(this.total)
        }
      } 
    },

    showDetail(goodsId) {
      this.$router.push({ path: '/goodsdetail', query: { goods_id: goodsId } })
    },
    minus(shopcartId,num) {
      if(num <= 1){
        this.$dialog.confirm({
          mes: '确定删除此商品',
          opts: [
              {
                  txt: '确定',
                  color: true,
                  callback: () => {
                    this.deleteItem(shopcartId);
                  }
              },
              {
                  txt: '取消',
                  color: false,
                  callback: () => {
                      this.add(shopcartId);
                  }
              }
          ]
      });
      }
      let data = {
        shopcartId:shopcartId,
        count:-1
      };
      this.$http.countShopCart(data)
      .then(res=>{
        console.log(res);
        this.getShopCart();
      })
      .catch(err=>{
        console.log(err);
      })

    },
    //商品增加
    add(shopcartId) {
      let data = {
        shopcartId:shopcartId,
        count:1
      }; 
      this.$http.countShopCart(data)
      .then(res=>{
        this.getShopCart();
      })
      .catch(err=>{
        console.log(err);
      })     
    },

    //去结算
    balance() {
        let ids;
        let num;
        for(let i=0;i<this.list.length;i++){
          if(this.list[i].isDefault === true){
            ids = this.list[i].goods.goodsId;
            num = this.list[i].count;
          }
        }
        this.$router.push({path: '/firmorder', query: {goodID: ids, Num: num}})
        // let ids = [];
        // let num = [];
        // this.list.forEach(item => {
        //   if (item.isDefault) {
        //       ids.push(item.goods.goodsId);
        //       num.push(item.count);
        //   }
        // })
        // console.log(ids);
        // console.log(num);
        // this.$router.push({path: '/firmorder', query: {goodID: ids, Num: num}})
       
     
    },
  }

}

</script>
<style scoped>

.check-box{
  float: left;
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  height: 100%;
  padding: 0 .1rem;
}
.input_check{
  display: none;
}
.input_check + label {
  width: 20px;
  height: 20px;
}
.input_check:checked + label:before {
  top: 4px;
  left: 4px;
  width: 20px;
  height: 20px;
}
.input_check+label {
  background-color: #FFF;
  border: 1px solid #ccc;
  padding: 9px;
  border-radius: 1000px;
  display: inline-block;
  position: relative;
  top: 50%;
  transform: translateY(-50%);
}
.input_check:checked+label {
  background-color: #ECF2F7;
  border: 1px solid #F43530;
  color: #243441
}

.input_check:checked+label:before {
  content: ' ';
  border-radius: 100px;
  position: absolute;
  background: #F43530;
  display: none;
  top: 3px;
  left: 3px;
  width: 12px;
  height: 12px
}

.input_check:checked+label:before {
  content: ' ';
  display: block
}
.cartfooter-left .check-box span{
  float: right;
  margin-left: .2rem;
  position: relative;
  top: 50%;
  transform: translateY(-50%);
}
.not-click {
  background-color: #eee;
  color: #999 !important;
}
.goods-tip{
  margin-top: .1rem;
}
.goods-tip>div{
  display: inline-block;
  margin-bottom: .1rem;
  margin-left: .1rem;
}
</style>
