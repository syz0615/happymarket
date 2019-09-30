<template>
  <div class="user">
    <userheader />
    <yd-cell-group>
      <yd-cell-item arrow>
        <img slot="icon" src="@/assets/image/user/orderform.png">
        <span slot="left">我的订单</span>
        <router-link slot="right" tag="span" to="/checkorder">查看全部订单</router-link>
      </yd-cell-item>
      <yd-grids-group :rows="4">
        <yd-grids-item :link="{path: '/allorder', query: {tab: 1}}" >
          <yd-badge slot="else" bgcolor="#fc0000" v-if="orderNum[1]">{{orderNum[1]}}</yd-badge>
          <img slot="icon" src="@/assets/image/user/unpaid.png" />
          <span slot="text">待付款</span>
        </yd-grids-item>
        <yd-grids-item :link="{path:'/allorder',query:{tab:2}}">
          <yd-badge slot="else" bgcolor="#fc0000" v-if="orderNum[2]">{{orderNum[2]}}</yd-badge>
          <img slot="icon" src="@/assets/image/user/pendingdelivery.png" />
          <span slot="text">待发货</span>
        </yd-grids-item>
        <yd-grids-item :link="{path:'/allorder',query:{tab:3}}">
          <yd-badge slot="else" bgcolor="#fc0000" v-if="orderNum[2]"> {{orderNum3}} </yd-badge>
          <img slot="icon" src="@/assets/image/user/shipped.png" />
          <span slot="text">待收货</span>
        </yd-grids-item>
        <yd-grids-item link="/allafterservice">
          <img slot="icon" src="@/assets/image/user/returns.png" />
          <span slot="text">退换货</span>
        </yd-grids-item>
      </yd-grids-group>
    </yd-cell-group>
    <yd-cell-group>
      <yd-cell-item href="/coupon" type="link">
        <img slot="icon" src="@/assets/image/user/coupon.png">
        <span slot="left">我的优惠券</span>
      </yd-cell-item>
      <yd-cell-item href="/cart" type="link">
        <img slot="icon" src="@/assets/image/user/member-cart.png">
        <span slot="left">我的购物车</span>
      </yd-cell-item>
    </yd-cell-group>

    <yd-cell-group>
 
      <yd-cell-item href="/footprint" type="link">
        <img slot="icon" src="@/assets/image/user/footer.png">
        <span slot="left">我的足迹</span>
      </yd-cell-item>
      <yd-cell-item href="/addresslist" type="link">
        <img slot="icon" src="@/assets/image/user/me-ic-site.png">
        <span slot="left">收货地址</span>
      </yd-cell-item>
    </yd-cell-group>

    <yd-cell-group>
      <yd-cell-item href="/datasettings" type="link">
        <img slot="icon" src="@/assets/image/user/set.png">
        <span slot="left">设置</span>
      </yd-cell-item>
    </yd-cell-group>
   
  </div>
</template>
<script>
import userheader from '@/components/UserHead/UserHeader.vue'
export default {
  name: 'User',
  components: {
    userheader
  },

  data() {
    return {
      user: [],
      orderNum: [],
    }
  }
}

</script>
<style scoped>
.user {
  padding-bottom: 1rem;
}

.user .yd-btn-block {
  height: .8rem;
}

.user .yd-cell-item:not(:last-child):after {
  border-bottom: 1px solid #e9e9e9;
}

</style>
