<template>
    <div class="goodstitle">
        <div class="goodsheader">
            <div class="goodsheader-left">
                <p>{{ product.goodsTitle }}</p>
                <h3 class="goodsname">{{ product.goodsName }}</h3>
            </div>
        </div>
        <div class="price-salesvolume">
            <div class="price">
                <h2>￥{{ product.goodsPrice }}</h2>
            </div>
            <div class="salesvolume">
                <p>库存：{{ product.goodsStock }}</p>
            </div>
        </div>

    </div>
</template>

<script>
export default {
    props: {
        config: 'config',
        product: {
            type: [Object, Array],
            default () {
                return {}
            }
        }
    },
    data () {
        return {

        }
    }

}
</script>
