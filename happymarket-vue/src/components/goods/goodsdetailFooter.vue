<template>
    <div class="goodsdetailfooter">
        <div class="goodsdetailfooter-left">
            <div class="goods-cart" @click="collection" v-show="!is_fav">
                <img src="@/assets/image/star.png"/>
                <p>收藏</p>
            </div>
            <div class="goods-cart" @click="collection" v-show="is_fav">
                <img src="@/assets/image/redstar.png"/>
                <p>取消收藏</p>
            </div>
            <router-link tag="div" class="star" to="/cart">
                <img src="@/assets/image/goods-cart.png"/>
                <yd-badge type="danger" v-if="cart_nums">{{ cart_nums }}</yd-badge>
                <p>购物车</p>
            </router-link>
        </div>
        <div class="goodsdetailfooter-right">
            <div class="addtocart">
                <yd-button type="danger" @click.native="addCart">加入购物车</yd-button>
            </div>
            <div class="buynow">
                <yd-button type="danger" @click.native="buyNow">立即购买</yd-button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    props: {
        is_fav: {
            type: Boolean,
            default () {
                return false
            }
        },
        cart_nums: {
            type: Number,
            default () {
                return 0
            }
        }
    },
    methods: {
        addCart () {
            this.$emit('addCart')
        },
        buyNow () {
            this.$emit('buyNow')
        },
        collection () {
            this.$emit('collection')
        }

    }
}
</script>

<style>
</style>
