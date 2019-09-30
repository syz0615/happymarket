<template>
    <div class="coupon" v-if="couponList.length">
       优惠券界面
    </div>
    <div class="data-none" v-else>
        竟然什么都没有，快去领券吧
    </div>
</template>

<script>
export default {
    data () {
        return {
            couponList: [] // 用户已领取的优惠券
        }
    }

}
</script>

<style>

</style>
