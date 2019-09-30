<template>
  <div class="searchpage">
    <div class="searchpage-header">
      <div class="search-input">
        <i class="search-icon"></i>
        <input v-model="search" type="text" placeholder="搜索商品" @keyup.enter="submitHandler" />
      </div>
      <button class="searchimg" @click="submitHandler"><img src="@/assets/image/search.png" /></button>
    </div>
    <div class="searchpage-body">
      <div class="" v-for="(item, index) in history" :key="index" @click="buttonSearch(item)">
        {{ item }}
      </div>
    </div>
    <div class="clear-history">
      <yd-button size="large" type="hollow" v-if="is_clear" @click.native="remove">清除历史记录</yd-button>
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
      search: '',
      history: [], // 搜索历史本地存储
      is_clear: false,
      searchgoods: [],
      key: ''
    }
  },
  mounted() {
    let localSearch = this.getlocalSearch()
    if (localSearch) {
      this.history = localSearch.split(',')
      this.is_clear = true
    }
  },
  methods: {
    // 提交搜索
    submitHandler() {
      if (!this.search && this.search === '') {
        return false
      } else {
        this.setLocalSearch(this.search)
        this.$router.push({ path: '/goodslist', query: { key: this.search } })

      }
    },
    // 设置搜索缓存本地
    setLocalSearch(key) {
      let keys = this.GLOBAL.getStorage('key')
      if (!keys) {
        this.GLOBAL.setStorage('key', key)
      } else {
        if (keys.indexOf(key) === -1) {
          this.GLOBAL.setStorage('key', key + ',' + keys)
        }
      }
    },
    // 获取本地缓存
    getlocalSearch() {
      return this.GLOBAL.getStorage('key')
    },
    // 点击搜索记录搜索
    buttonSearch(val) {
      this.search = val
      this.submitHandler()
    },
    // 清除搜索缓存
    remove() {
      this.is_clear = false
      this.GLOBAL.removeStorage('key')
      this.history = []
    }
  }
}

</script>

<style scoped>
.searchpage {
  overflow: hidden;
}

.searchpage .search-input {
  position: relative;
}

.searchpage .search-input i {
  position: absolute;
  top: .32rem;
  left: .4rem;
  z-index: 1000;
}

.searchpage .search-input .search-icon:after {
  font-size: .35rem;
}

.searchpage .search-input input {
  height: .7rem;
  width: 85%;
  border: none;
  background-color: #fff;
  border-radius: 2rem;
  position: absolute;
  top: .15rem;
  left: .2rem;
  opacity: .7;
  padding: 0 .7rem;
}

.searchpage-body {
  margin-top: 1rem;
}

</style>
