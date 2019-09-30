<template>
  <div>
    <div class="orderadd" v-if="Object.keys(ship).length">
      <img class="orderadd-gps" src="@/assets/image/gps.png" />
      <div class="orderadd-content" @click="showHandler">
        <div class="orderadd-top">
          <span>收货人：{{ ship.receiverName }}</span>
          <p>{{ ship.receiverPhone }}</p>
        </div>
        <div class="orderadd-bottom">
          <p>收货地址：{{ ship.receiverAddress }}{{ ship.receiverDetail }}</p>
          <img class="orderadd-right right-img" src="@/assets/image/right.png" />
        </div>
      </div>
    </div>
    <div class="orderadd" v-else>
      <yd-button size="small" type="danger" style="position: relative;left: 50%;transform: translateX(-50%);" @click.native="newShipAdd">新增收货地址</yd-button>
    </div>
    <yd-popup v-model="openWindow" position="bottom" width="20%" height="60%">
      <div class="orderadd-content">
        <div v-if="shipList.length">
          <div style="margin-top: 20px; text-align: left;" v-for="(item, index) in shipList" :key="index" @click="shipHandler(index)">
            <div class="orderadd-top">
              <yd-badge type="primary" v-if="item.isDefault === 1">默认</yd-badge>
              <span>收货人：{{ item.receiverName }}</span>
              <p>{{ item.receiverPhone }}</p>
            </div>
            <div class="orderadd-bottom">
              <p>收货地址：{{ item.receiverAddress }}{{ item.receiverDetail }}</p>
              <img class="orderadd-right right-img" src="@/assets/image/right.png" />
            </div>
          </div>
        </div>
        <yd-button size="small" type="danger" style="margin-top: 20px" @click.native="newShipAdd">新增收货地址</yd-button>
      </div>
    </yd-popup>
  </div>
</template>
<script>
export default {
  data() {
    return {
      openWindow: false,
      shipList: []
    }
  },
  props: {
    // 用户选中||默认收货地址
    ship: {
      type: [Array, Object],
      default () {
        return []
      }
    }
  },
  methods: {
    // 获取用户的收货地址列表
    showHandler() {
      this.openWindow = true;
      this.$http.getAllAddress({ userId: this.GLOBAL.getStorage('user_token_id') })
        .then(res => {
          this.shipList = res.data
        })
    },
    //选择地址
    shipHandler(index) {
      this.openWindow = false
      this.$emit('shipHandler', this.shipList[index])
    },
    //新增地址
    newShipAdd() {
      this.$router.push({ path: '/address' })
    }

  }
}

</script>
<style>
.orderadd>button {
  margin-top: 0;
  font-size: .26rem;
}

</style>
