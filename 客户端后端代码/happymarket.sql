/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : happymarket

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-09-23 14:59:46
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `addressId` int(11) NOT NULL AUTO_INCREMENT,
  `receiverName` varchar(255) DEFAULT NULL COMMENT '收件人姓名',
  `receiverAddress` varchar(255) DEFAULT NULL COMMENT '用户的省市县地址信息',
  `receiverDetail` varchar(255) NOT NULL COMMENT '收件人地址(详细地址)',
  `receiverPhone` varchar(20) DEFAULT NULL COMMENT '收件人手机号码',
  `postNo` int(11) DEFAULT NULL COMMENT '邮编',
  `userId` int(11) NOT NULL COMMENT '用户id',
  `isDefault` int(1) DEFAULT NULL COMMENT '是否是默认地址，1：是，0：不是',
  PRIMARY KEY (`addressId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('1', 'jack', null, '天坛公园', '123', '123', '1', '1');
INSERT INTO `address` VALUES ('2', 'jack', null, '半壁店', '13018255291', '0', '1', null);
INSERT INTO `address` VALUES ('7', '牛魔王', '内蒙古自治区 乌海市 海南区', '哈哈哈哈哈', '15999999999', '0', '6', '0');
INSERT INTO `address` VALUES ('11', '孙悟空', '吉林省 通化市 柳河县', '李李李李', '15955555555', '0', '6', '0');
INSERT INTO `address` VALUES ('12', '猪八戒', '湖南省 湘潭市 岳塘区', 'xxxxxxx', '15955555555', '0', '6', '1');
INSERT INTO `address` VALUES ('13', '孙悟空', '河北省 秦皇岛市 北戴河区', '很骄傲家居', '15944444444', '0', '6', '0');
INSERT INTO `address` VALUES ('14', '买东西', '山西省 长治市 屯留县', 'hhhhhh', '15933333333', '0', '6', '0');
INSERT INTO `address` VALUES ('16', '大角牛', '河北省 秦皇岛市 山海关区', '海边', '13166669999', '0', '14', '1');
INSERT INTO `address` VALUES ('17', '小天梯', '山西省 长治市 襄垣县', '阳光小区', '15948481212', '0', '14', '0');
INSERT INTO `address` VALUES ('19', '哈哈哈', '河北省 邢台市 内丘县', '大街', '15945455656', '0', '14', '0');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `parentId` int(11) DEFAULT NULL,
  `categoryName` varchar(255) DEFAULT NULL COMMENT '分类名称',
  `level` int(1) DEFAULT NULL COMMENT '分类级别',
  PRIMARY KEY (`categoryId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '0', '食品类', '1');
INSERT INTO `category` VALUES ('2', '1', '饮料', '2');
INSERT INTO `category` VALUES ('3', '1', '休闲膨化', '2');
INSERT INTO `category` VALUES ('4', '1', '酒香烟', '2');
INSERT INTO `category` VALUES ('5', '1', '冲饮', '2');
INSERT INTO `category` VALUES ('6', '1', '调料类', '2');
INSERT INTO `category` VALUES ('7', '1', '饼干', '2');
INSERT INTO `category` VALUES ('8', '1', '糕点', '2');
INSERT INTO `category` VALUES ('9', '1', '果脯蜜饯', '2');
INSERT INTO `category` VALUES ('10', '1', '米面油', '2');
INSERT INTO `category` VALUES ('11', '1', '糖果', '2');
INSERT INTO `category` VALUES ('12', '1', '滋补品', '2');
INSERT INTO `category` VALUES ('13', '1', '南北干货', '2');
INSERT INTO `category` VALUES ('14', '0', '生鲜类', '1');
INSERT INTO `category` VALUES ('15', '14', '火腿肠类', '2');
INSERT INTO `category` VALUES ('16', '14', '乳制品', '2');
INSERT INTO `category` VALUES ('17', '14', '冷冻冷藏', '2');
INSERT INTO `category` VALUES ('18', '14', '蔬菜', '2');
INSERT INTO `category` VALUES ('19', '14', '肉', '2');
INSERT INTO `category` VALUES ('20', '14', '水产', '2');
INSERT INTO `category` VALUES ('21', '14', '熟食', '2');
INSERT INTO `category` VALUES ('22', '14', '杂粮', '2');
INSERT INTO `category` VALUES ('23', '0', '洗化类', '1');
INSERT INTO `category` VALUES ('24', '23', '洗发水', '2');
INSERT INTO `category` VALUES ('25', '23', '沐浴露', '2');
INSERT INTO `category` VALUES ('26', '23', '香皂洗手液', '2');
INSERT INTO `category` VALUES ('27', '23', '牙刷牙膏', '2');
INSERT INTO `category` VALUES ('28', '23', '化妆洁面', '2');
INSERT INTO `category` VALUES ('29', '23', '家庭清洁', '2');
INSERT INTO `category` VALUES ('30', '23', '纸巾类', '2');
INSERT INTO `category` VALUES ('31', '0', '家用百货', '1');
INSERT INTO `category` VALUES ('32', '31', '杯子', '2');
INSERT INTO `category` VALUES ('33', '31', '餐桌用品', '2');
INSERT INTO `category` VALUES ('34', '31', '厨房用具', '2');
INSERT INTO `category` VALUES ('35', '31', '日用杂品', '2');
INSERT INTO `category` VALUES ('36', '31', '小百货', '2');
INSERT INTO `category` VALUES ('37', '0', '家电', '1');
INSERT INTO `category` VALUES ('38', '37', '小家电', '2');
INSERT INTO `category` VALUES ('39', '37', '照明器材', '2');
INSERT INTO `category` VALUES ('40', '37', '通讯器材', '2');
INSERT INTO `category` VALUES ('41', '37', '五金', '2');
INSERT INTO `category` VALUES ('42', '37', '不锈钢', '2');
INSERT INTO `category` VALUES ('43', '0', '家纺类', '1');
INSERT INTO `category` VALUES ('44', '43', '毛巾', '2');
INSERT INTO `category` VALUES ('45', '43', '内衣袜子', '2');
INSERT INTO `category` VALUES ('46', '43', '服装', '2');
INSERT INTO `category` VALUES ('47', '43', '床上用品', '2');
INSERT INTO `category` VALUES ('48', '43', '鞋', '2');
INSERT INTO `category` VALUES ('49', '43', '服饰配件', '2');
INSERT INTO `category` VALUES ('50', '0', '文体箱包', '1');
INSERT INTO `category` VALUES ('51', '50', '办公用品', '2');
INSERT INTO `category` VALUES ('52', '50', '体育用品', '2');
INSERT INTO `category` VALUES ('53', '50', '玩具', '2');
INSERT INTO `category` VALUES ('54', '50', '箱包皮具', '2');
INSERT INTO `category` VALUES ('55', '50', '音像制品', '2');
INSERT INTO `category` VALUES ('56', '50', '图书类', '2');
INSERT INTO `category` VALUES ('57', '50', '钟表类', '2');

-- ----------------------------
-- Table structure for `collect`
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `collectId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `goodsId` int(11) DEFAULT NULL,
  `collectTime` datetime DEFAULT NULL COMMENT '收藏时间',
  `collectPrice` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`collectId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES ('21', '14', '2', '2019-09-21 20:12:36', null);
INSERT INTO `collect` VALUES ('22', '14', '7', '2019-09-22 23:37:55', null);
INSERT INTO `collect` VALUES ('24', '14', '2', '2019-09-22 23:54:48', null);

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsId` int(11) NOT NULL AUTO_INCREMENT,
  `goodsName` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `goodsTitle` varchar(255) DEFAULT NULL COMMENT '商品标题',
  `goodsPrice` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `goodsImg` varchar(255) DEFAULT NULL COMMENT '商品图片',
  `goodsDesc` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `goodsDescImg` varchar(255) DEFAULT NULL COMMENT '商品描述图片',
  `goodsStock` int(10) DEFAULT NULL COMMENT '商品库存，-1表示没有限制',
  `categoryId` int(11) DEFAULT NULL COMMENT '分类id',
  `addTime` datetime DEFAULT NULL COMMENT '商品加入时间',
  `sellTime` datetime DEFAULT NULL COMMENT '商品开卖时间',
  PRIMARY KEY (`goodsId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', 'vivo手机', 'vivo XPlayer 5', '1999.00', '1568464789271.jpg', '一个十分十分好用的手机', '', '97', '40', '2019-09-15 15:06:23', null);
INSERT INTO `goods` VALUES ('2', '卫生纸', '维达卫生纸', '15.00', 'zzz.jpg', '一款十分柔软的卫生纸', null, '61', '30', '2019-09-15 15:06:26', null);
INSERT INTO `goods` VALUES ('3', '洗发水', '防脱洗发水', '6.00', 'fhtoxifauv.jpg', '也许会防脱的假洗发水', null, '90', '24', '2019-09-15 15:06:28', null);
INSERT INTO `goods` VALUES ('4', '葡萄干', '新疆葡萄干', '12.00', 'putkgj.jpg', '正宗新疆葡萄干，假一陪亿', null, '47', '9', '2019-09-15 15:09:37', null);
INSERT INTO `goods` VALUES ('5', '指甲钳', '不锈钢指甲钳', '2.50', 'vijwqm.jpg', '一般的指甲钳，没什么特殊的', null, '100', '35', '2019-09-15 15:11:43', null);
INSERT INTO `goods` VALUES ('6', '雷碧', '雪碧的盗版：雷碧', '2.90', 'lzbi.jpg', '这是盗版，不好喝。喝了会生病', null, '46', '2', '2019-09-18 21:43:13', null);
INSERT INTO `goods` VALUES ('7', '三只松鼠', '棒棒脆，嘎嘎好吃', '38.00', 'sanzhi.jpg', '双十一促销，机不可失，失不再来，活动仅限今天', null, '0', '2', '2019-09-20 14:34:16', null);
INSERT INTO `goods` VALUES ('8', '铲子', '不锈钢锅铲', '29.00', '铲子.jpg', '厨房必备', null, '1082', '34', '2019-09-20 14:41:28', null);

-- ----------------------------
-- Table structure for `notice`
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `noticeId` int(11) NOT NULL,
  `noticeTitle` varchar(255) DEFAULT NULL COMMENT '公告标题',
  `noticeDesc` text COMMENT '公告内容',
  `level` int(1) DEFAULT NULL COMMENT '公告等级',
  PRIMARY KEY (`noticeId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', '全体通知:请注意', '各位同志：这是一条全体的测试通知。/n/n/n/n管理员：小刘', '0');
INSERT INTO `notice` VALUES ('2', '平台公告说明', '本项目为测试项目，目前只实现了基本功能，还需要完善很多很容', '0');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `orderNo` varchar(255) DEFAULT NULL COMMENT '订单号',
  `userId` int(11) DEFAULT NULL COMMENT '用户id',
  `goodsId` int(11) DEFAULT NULL COMMENT '商品id',
  `addressId` int(11) DEFAULT NULL COMMENT '收货地址id',
  `buyCount` int(255) DEFAULT NULL COMMENT '购买的数量',
  `orderStatus` int(10) DEFAULT NULL COMMENT '订单状态 0未支付，1已支付，2取消',
  `payPrice` decimal(10,2) DEFAULT NULL COMMENT '订单价格',
  `createTime` date DEFAULT NULL COMMENT '创建时间',
  `payTime` date DEFAULT NULL COMMENT '支付时间',
  `alipayNo` varchar(255) DEFAULT NULL COMMENT '支付宝交易号',
  PRIMARY KEY (`orderId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('6', '15684471799801', '1', '1', '2', '3', '1', '3.00', '2019-09-14', '2019-09-14', null);
INSERT INTO `order` VALUES ('7', '15684495394561', '1', '2', '2', '3', '0', '6.00', '2019-09-14', null, null);
INSERT INTO `order` VALUES ('8', '15684496821021', '1', '2', '2', '3', '0', '6.00', '2019-09-14', null, null);
INSERT INTO `order` VALUES ('10', '15686121883411', '1', '4', '2', '3', '0', '6.00', '2019-09-16', null, null);
INSERT INTO `order` VALUES ('16', '156912424636714', '14', '7', '0', '3', '0', '114.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('20', '156912546580414', '14', '8', '0', '1', '0', '29.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('23', '156912609644614', '14', '8', '0', '1', '0', '29.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('78', '156914740828614', '14', '8', '0', '1', '0', '29.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('87', '156915853717714', '14', '7', '0', '3', '0', '114.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('88', '156915953397914', '14', '8', '0', '1', '0', '29.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('89', '156915974336614', '14', '8', '0', '1', '0', '29.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('90', '156915979333014', '14', '8', '0', '1', '0', '29.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('91', '156915993742114', '14', '8', '0', '1', '0', '29.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('92', '156915999017414', '14', '8', '0', '1', '0', '29.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('93', '156916008229714', '14', '8', '0', '1', '0', '29.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('94', '156916012519514', '14', '8', '0', '1', '0', '29.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('95', '156916019425914', '14', '2', '0', '1', '0', '15.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('96', '156916021908514', '14', '8', '0', '1', '0', '29.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('97', '156916028581814', '14', '2', '0', '1', '0', '15.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('98', '156916053460214', '14', '2', '0', '1', '0', '15.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('99', '156916054190314', '14', '2', '0', '1', '0', '15.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('100', '156916055224414', '14', '8', '0', '1', '0', '29.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('101', '156916056354814', '14', '2', '0', '1', '0', '15.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('102', '156916059581014', '14', '2', '0', '1', '1', '15.00', '2019-09-22', '2019-09-22', null);
INSERT INTO `order` VALUES ('103', '156916084683614', '14', '2', '0', '1', '0', '15.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('104', '156916103486514', '14', '2', '0', '1', '0', '15.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('105', '156916234487614', '14', '2', '0', '1', '1', '15.00', '2019-09-22', '2019-09-22', null);
INSERT INTO `order` VALUES ('106', '156916240924114', '14', '2', '0', '1', '1', '15.00', '2019-09-22', '2019-09-22', null);
INSERT INTO `order` VALUES ('107', '156916244317514', '14', '2', '0', '1', '1', '15.00', '2019-09-22', '2019-09-22', null);
INSERT INTO `order` VALUES ('108', '156916350258014', '14', '2', '0', '1', '1', '15.00', '2019-09-22', '2019-09-22', null);
INSERT INTO `order` VALUES ('109', '156916415800914', '14', '2', '0', '1', '0', '15.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('110', '156916416518314', '14', '8', '0', '1', '1', '29.00', '2019-09-22', '2019-09-22', null);
INSERT INTO `order` VALUES ('111', '156916450818514', '14', '8', '16', '1', '1', '29.00', '2019-09-22', '2019-09-22', null);
INSERT INTO `order` VALUES ('112', '156916613158514', '14', '8', '16', '1', '0', '29.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('113', '156916615337814', '14', '8', '16', '1', '0', '29.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('114', '156916656772814', '14', '8', '16', '1', '0', '29.00', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('115', '156916662088314', '14', '6', '16', '2', '1', '5.80', '2019-09-22', '2019-09-22', null);
INSERT INTO `order` VALUES ('116', '156916663266414', '14', '6', '16', '2', '0', '5.80', '2019-09-22', null, null);
INSERT INTO `order` VALUES ('117', '156916718917914', '14', '7', '16', '1', '1', '38.00', '2019-09-22', '2019-09-22', null);
INSERT INTO `order` VALUES ('118', '156916732427614', '14', '7', '16', '1', '0', '38.00', '2019-09-22', null, null);

-- ----------------------------
-- Table structure for `shopcart`
-- ----------------------------
DROP TABLE IF EXISTS `shopcart`;
CREATE TABLE `shopcart` (
  `shopcartId` int(11) NOT NULL AUTO_INCREMENT,
  `goodsId` int(11) DEFAULT NULL COMMENT '商品Id',
  `userId` int(11) DEFAULT NULL COMMENT '用户Id',
  `addTime` datetime DEFAULT NULL COMMENT '加入时间',
  `count` int(10) DEFAULT NULL COMMENT '数量',
  `addPrice` decimal(10,2) DEFAULT NULL COMMENT '加入时商品单价',
  `isDefault` int(1) DEFAULT NULL,
  PRIMARY KEY (`shopcartId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of shopcart
-- ----------------------------
INSERT INTO `shopcart` VALUES ('1', '1', '1', '2019-09-14 15:51:15', '12', '1.00', null);
INSERT INTO `shopcart` VALUES ('13', '2', '6', '2019-09-20 08:46:57', '2', '2.00', null);
INSERT INTO `shopcart` VALUES ('17', '8', '14', '2019-09-20 15:40:28', '1', '29.00', null);
INSERT INTO `shopcart` VALUES ('20', '7', '14', '2019-09-22 23:45:06', '1', '38.00', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL COMMENT '用户名',
  `userPwd` varchar(20) DEFAULT NULL COMMENT '密码',
  `userEmail` varchar(50) DEFAULT NULL COMMENT '用户邮箱',
  `userPhone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `userPicture` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `lastLoginTime` datetime DEFAULT NULL COMMENT '上次登陆时间',
  `registTime` datetime DEFAULT NULL COMMENT '注册时间',
  `level` int(2) DEFAULT NULL COMMENT '0:买家 1:商家',
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Jack', '123', '1343826127@qq.com', '123', '1568464789271.jpg', null, null, '0');
INSERT INTO `user` VALUES ('2', 'Bob', '123', null, '13018205089', null, null, '2019-09-14 16:39:04', '0');
INSERT INTO `user` VALUES ('3', 'Alice', '123', null, '13018255291', null, null, '2019-09-14 16:37:40', '0');
INSERT INTO `user` VALUES ('5', 'hahaha', '123456', '123456@qq.com', '15111111111', null, null, '2019-09-16 19:33:56', '0');
INSERT INTO `user` VALUES ('6', '牛魔王', '123456', null, '15999999999', null, null, '2019-09-16 20:23:39', '0');
INSERT INTO `user` VALUES ('14', '大角牛', '123456', '182@qq.com', '13166669999', null, null, '2019-09-20 15:23:14', '0');
