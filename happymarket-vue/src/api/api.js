import request from './request'

const searchgoods = '/goods/search'; //搜索
export function SearchGoods(query) {
  return request({
    url: searchgoods,
    method: 'get',
    params:query
  })
}

const lunbotu = '/goods/carousel'; //轮播图
export function shouyeSlide() {
  return request({
    url: lunbotu,
    method: 'get'
  })
}

const shownotice = '/notice/all'; //展示通知
export function ShowNotice() {
  return request({
    url: shownotice,
    method: 'get'
  })
}

const noticedetail = '/notice/detail'; //通知详情
export function NoticeDetail(query) {
  return request({
    url: noticedetail,
    method: 'get',
    params:query
  })
}

const getgoodhoturl = '/goods/hotgoods'; //获得首页热卖数据
export function getgoodHot() {
  return request({
    url: getgoodhoturl,
    method: 'get'
  })
}

const getgoodrecurl = '/goods/newgoods';  //获得首页推荐商品
export function getgoodRec(){
 return request({
    url: getgoodhoturl,
    method: 'get'
  })   
}

const addcollect = '/collect/add';  //添加收藏商品
export function addCollect(data){
 return request({
    url: addcollect,
    method: 'post',
    data
  })   
}

const deletecollect='/collect/delete'; //删除收藏
export function deleteCollect(query) {
  return request({
    url: deletecollect,
    method: 'get',
    params:query
  })
}

const allcollect='/collect/all'; //获得所有收藏商品收藏
export function allCollect(query) {
  return request({
    url: allcollect,
    method: 'get',
    params:query
  })
}

const GoodsDetail='/goods/detail'; //获得商品的详情
export function goodsDetail(query) {
  return request({
    url: GoodsDetail,
    method: 'get',
    params: query
  })
}



const categoryfirst ='/category/first'; //获得分类一级nav
export function CategoryFirstNav() {
  return request({
    url: categoryfirst,
    method: 'get'
  })
}

const categorysecond ='/category/second'; //获得分类二级nav
export function CategorySecondNav(query) {
  return request({
    url: categorysecond,
    method: 'get',
    params:query
  })
}

const getcategorygoods ='/category/goods'; //获取分类商品
export function getCategoryGoods(query) {
  return request({
    url: getcategorygoods,
    method: 'get',
    params: query
  })
}


// const AuthReset='wx/auth/reset'; //账号密码重置
const userregister='/user/regist'; //账号注册
export function UserRegister(data) {
  return request({
    url: userregister,
    method: 'post',
    data    
  })
}

const userLogin='/user/login'; //账号登录
export function UserLogin(data) {
  return request({
    url: userLogin,
    method: 'post',
    data    
  })
}
const checkphone='/user/checkphone'; //检测账号是否存在
export function CheckPhone(query) {
  return request({
    url: checkphone,
    method: 'get',
    params:query    
  })
}


const getallorderlist='/order/all'; //获取全部订单
export function getAllOrderList(query) {
  return request({
    url: getallorderlist,
    method: 'get',
    params: query   
  })
}

const getnopayorderlist='/order/add'; //下单 未付款
export function getNoPayOrderList(data) {
  return request({
    url: getnopayorderlist,
    method: 'post',
    data  
  })
}

const goodspay='/order/pay'; //商品支付
export function GoodsPay(query) {
  return request({
    url: goodspay,
    method: 'get',
    params: query   
  })
}

const orderdetail='/order/getorder'; //商品支付成功后跳到商品详情
export function getorderdetail(query) {
  return request({
    url: orderdetail,
    method: 'get',
    params: query   
  })
}

const shopcart='/shopcart/all'; //获取购物车数据
export function ShopCart(query) {
  return request({
    url: shopcart,
    method: 'get',
    params: query   
  })
}

const addshopcart='/shopcart/add'; //加入物品到购物车
export function addShopCart(data) {
  return request({
    url: addshopcart,
    method: 'post',
    data   
  })
}

const countshopcart='/shopcart/count'; //减少/增加 购物车内某一商品的数量 
export function countShopCart(query) {
  return request({
    url: countshopcart,
    method: 'get',
    params:query   
  })
}

const deleteshopcart='/shopcart/delete'; //删除购物车某一项
export function deleteShopCart(query) {
  return request({
    url: deleteshopcart,
    method: 'get',
    params: query   
  })
}


const addaddress='/address/add'; //添加收货地址
export function addAddress(data) {
  return request({
    url: addaddress,
    method: 'post',
    data  
  })
}
const updataaddress='/address/change'; //更改收货地址
export function updataAddress(query) {
  return request({
    url: updataaddress,
    method: 'get',
    params: query   
  })
}

const getalladdress='/address/all'; //获取用户所有地址
export function getAllAddress(query) {
  return request({
    url: getalladdress,
    method: 'get',
    params: query
  })
}

const deleteaddress='/address/delete'; //删除用户地址
export function deleteAddress(query) {
  return request({
    url: deleteaddress,
    method: 'get',
    params: query
  })
}

const defaulteaddress='/address/default'; //设置默认地址
export function defaultAddress(query) {
  return request({
    url: defaulteaddress,
    method: 'get',
    params: query
  })
}

const getuserinfo='/user/getuser'; //获得用户信息
export function getUserInfo(query) {
  return request({
    url: getuserinfo,
    method: 'get',
    params: query
  })
}

const updateuserinfo='/user/changeinfo'; //更改用户信息
export function updateUserInfo(data) {
  return request({
    url: updateuserinfo,
    method: 'post',
    data
  })
}

const updateuserpwd='/user/password'; //修改账户密码
export function updateUserPwd(data) {
  return request({
    url: updateuserpwd,
    method: 'post',
    data
  })
}


