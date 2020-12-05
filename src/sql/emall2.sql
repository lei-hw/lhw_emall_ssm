/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : emall

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 30/11/2020 09:12:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admins
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admins
-- ----------------------------
INSERT INTO `admins` VALUES (1, 'admin', 'tuShOfiBrA8+br7ENrMS8A==');
INSERT INTO `admins` VALUES (2, '777', 'OkoxZRZ4yZgkgzx3IlxzKQ==');
INSERT INTO `admins` VALUES (3, '1', 'ag3OB0a0vnwiWexZ+52IfQ==');

-- ----------------------------
-- Table structure for carts
-- ----------------------------
DROP TABLE IF EXISTS `carts`;
CREATE TABLE `carts`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` int(11) NOT NULL DEFAULT 0 COMMENT '数量',
  `good_id` int(11) NOT NULL COMMENT '商品ID',
  `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '用户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '购物车' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of carts
-- ----------------------------
INSERT INTO `carts` VALUES (6, 1, 6, 3);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '介绍',
  `spec` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格',
  `price` int(11) NOT NULL DEFAULT 0 COMMENT '价格',
  `stock` int(11) NOT NULL DEFAULT 0 COMMENT '库存',
  `sales` int(11) NOT NULL DEFAULT 0 COMMENT '销量',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '详情',
  `type_id` int(11) NOT NULL DEFAULT 0 COMMENT '分类ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '../upload/1-1.jpg', '四川耙耙柑 酸甜甘香 柔嫩多汁', '皮薄易剥 肉质软嫩', '约500g', 13, 3, 8, '', 1);
INSERT INTO `goods` VALUES (2, '../upload/1-2.jpg', '红心火龙果', NULL, '750g-1kg/两个', 28, 2, 10, '', 1);
INSERT INTO `goods` VALUES (3, '../upload/1-3.jpg', '皇冠梨 松软多汁', '果肉甘甜 细腻无渣', '约500g', 9, 4, 9, '', 1);
INSERT INTO `goods` VALUES (4, '../upload/1-4.jpg', '西州蜜瓜', '果肉厚质 中心橘红', '约1kg-1.5kg 一个', 30, 6, 8, '', 1);
INSERT INTO `goods` VALUES (5, '../upload/1-5.jpg', '小台芒果 自然生长 生态种植', '皮薄核小 果肉丰厚', '约500g', 26, 0, 15, '', 1);
INSERT INTO `goods` VALUES (6, '../upload/1-6.jpg', '栖霞苹果 爽脆清甜', '肉质紧密 味道甘甜', '约550g/2个', 9, 997, 19, '', 1);
INSERT INTO `goods` VALUES (7, '../upload/1-7.jpg', '龙眼/桂圆 新鲜水果 汁多味甜', '增强记忆 消除疲劳', '约500g', 18, 10, 7, '', 1);
INSERT INTO `goods` VALUES (8, '../upload/1-8.jpg', '广西百香果 香气浓郁 甜酸可口', '果香浓郁 搭配蜂蜜更美味', '2颗/份', 5, 10, 8, '', 1);
INSERT INTO `goods` VALUES (9, '../upload/1-9.jpg', '美早樱桃 果大核小 饱满均匀', '堪比车厘子的美味', '约300g/盒', 36, 9, 10, '', 1);
INSERT INTO `goods` VALUES (10, '../upload/1-10.jpg', '智利红提 珍贵品种 品质上等', '紧实爆汁 果肉新鲜', '约500g', 18, 6, 14, '', 1);
INSERT INTO `goods` VALUES (11, '../upload/1-11.jpg', '尖椒 烧烤食材 新鲜蔬菜', '农家种植 健康饮食', '约300g', 5, 10, 0, '', 1);
INSERT INTO `goods` VALUES (12, '../upload/1-12.jpg', '荷兰瓜 生态种植 自然生长', '颜色翠绿，鲜嫩爽脆', '约300g', 5, 10, 0, '', 1);
INSERT INTO `goods` VALUES (13, '../upload/1-13.jpg', '小白菜 清脆鲜嫩 清甜回甘', '农家种植 找回儿时味道', '约500g', 10, 10, 0, '', 1);
INSERT INTO `goods` VALUES (14, '../upload/1-14.jpg', '菠菜 口感鲜嫩 入口清香', '不催熟 生长周期长', '约300g', 12, 10, 0, '', 1);
INSERT INTO `goods` VALUES (15, '../upload/2-1.jpg', '福成尚品前腱子', NULL, '1000g', 99, 10, 0, '', 2);
INSERT INTO `goods` VALUES (16, '../upload/2-2.jpg', '牦牛精肉2斤+ 牦牛肋排2斤', '自然生长', '2kg', 226, 10, 0, '', 2);
INSERT INTO `goods` VALUES (17, '../upload/2-3.jpg', '巴美草香猪后臀尖 原味原香', '精致美味，解锁味觉记忆', '约500g', 32, 10, 0, '', 2);
INSERT INTO `goods` VALUES (18, '../upload/2-4.jpg', '农畉猪肉-猪脊骨 肉厚骨细', '骨鲜髓足', '约500g', 13, 10, 0, '', 2);
INSERT INTO `goods` VALUES (19, '../upload/2-5.jpg', '一品江村黄鸡', '味道鲜美，口感软嫩弹滑', '约1kg', 46, 10, 0, '', 2);
INSERT INTO `goods` VALUES (20, '../upload/2-6.jpg', '正大单冻鸡翅根 精选种鸡', '富有弹性', '约1kg', 35, 10, 0, '', 2);
INSERT INTO `goods` VALUES (21, '../upload/3-1.jpg', '五梁红有机种植 大米', '五常市有机大米', '5kg', 68, 10, 0, '', 3);
INSERT INTO `goods` VALUES (23, '../upload/3-3.jpg', '五得利强筋雪花小麦粉', NULL, '2.5kg', 32, 10, 0, '', 3);
INSERT INTO `goods` VALUES (24, '../upload/3-4.jpg', '香满园美味富强小麦粉', NULL, '5kg', 21, 10, 0, '', 3);
INSERT INTO `goods` VALUES (25, '../upload/3-5.jpg', '老农帝国 黑豆 自然成熟', NULL, '2.5kg', 82, 10, 0, '', 3);
INSERT INTO `goods` VALUES (26, '../upload/3-6.jpg', '中畅佳禾 大麦 自然生长', NULL, '400g', 59, 10, 0, '', 3);
INSERT INTO `goods` VALUES (27, '../upload/4-1.jpg', '百威啤酒 经典灌装 小麦醇正拉罐', NULL, '500ml*3', 26, 10, 0, '', 4);
INSERT INTO `goods` VALUES (28, '../upload/4-2.jpg', 'Perrier巴黎水天然含气矿泉水 开启生活新方式', '天然气泡', '330ml', 9, 10, 0, '', 4);
INSERT INTO `goods` VALUES (30, '../upload/4-4.jpg', '北冰洋汽水', '桔汁汽水330ml', NULL, 5, 10, 0, '', 4);

-- ----------------------------
-- Table structure for items
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `price` int(11) NOT NULL DEFAULT 0 COMMENT '购买时价格',
  `amount` int(11) NOT NULL DEFAULT 0 COMMENT '购买数量',
  `order_id` int(11) NOT NULL DEFAULT 0 COMMENT '订单ID',
  `good_id` int(11) NOT NULL DEFAULT 0 COMMENT '商品ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单项' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of items
-- ----------------------------
INSERT INTO `items` VALUES (1, 26, 1, 1, 5);
INSERT INTO `items` VALUES (2, 30, 1, 1, 4);
INSERT INTO `items` VALUES (3, 13, 1, 1, 1);
INSERT INTO `items` VALUES (4, 23, 1, 2, 29);
INSERT INTO `items` VALUES (5, 12, 2, 3, 32);
INSERT INTO `items` VALUES (6, 9, 2, 4, 6);
INSERT INTO `items` VALUES (7, 26, 1, 4, 5);
INSERT INTO `items` VALUES (8, 9, 4, 5, 6);
INSERT INTO `items` VALUES (9, 26, 3, 6, 5);
INSERT INTO `items` VALUES (10, 18, 1, 6, 10);
INSERT INTO `items` VALUES (11, 9, 3, 6, 3);
INSERT INTO `items` VALUES (12, 9, 1, 6, 6);
INSERT INTO `items` VALUES (13, 9, 1, 7, 6);
INSERT INTO `items` VALUES (14, 9, 1, 8, 6);
INSERT INTO `items` VALUES (15, 9, 1, 9, 6);
INSERT INTO `items` VALUES (16, 26, 1, 10, 5);
INSERT INTO `items` VALUES (17, 30, 1, 11, 4);
INSERT INTO `items` VALUES (18, 9, 1, 12, 3);
INSERT INTO `items` VALUES (19, 28, 1, 13, 2);
INSERT INTO `items` VALUES (20, 13, 1, 14, 1);
INSERT INTO `items` VALUES (21, 13, 3, 15, 1);
INSERT INTO `items` VALUES (22, 9, 1, 16, 3);
INSERT INTO `items` VALUES (23, 28, 1, 16, 2);
INSERT INTO `items` VALUES (24, 18, 1, 16, 10);
INSERT INTO `items` VALUES (25, 26, 1, 17, 5);
INSERT INTO `items` VALUES (26, 26, 1, 18, 5);
INSERT INTO `items` VALUES (27, 26, 1, 19, 5);
INSERT INTO `items` VALUES (28, 9, 1, 20, 3);
INSERT INTO `items` VALUES (29, 28, 1, 20, 2);
INSERT INTO `items` VALUES (30, 13, 1, 20, 1);
INSERT INTO `items` VALUES (31, 26, 1, 21, 5);
INSERT INTO `items` VALUES (32, 28, 3, 22, 2);
INSERT INTO `items` VALUES (33, 36, 1, 23, 9);
INSERT INTO `items` VALUES (34, 13, 1, 24, 1);
INSERT INTO `items` VALUES (35, 28, 1, 25, 2);
INSERT INTO `items` VALUES (36, 18, 1, 26, 10);
INSERT INTO `items` VALUES (37, 28, 1, 26, 2);
INSERT INTO `items` VALUES (38, 30, 1, 27, 4);
INSERT INTO `items` VALUES (39, 30, 1, 28, 4);
INSERT INTO `items` VALUES (40, 18, 1, 29, 10);
INSERT INTO `items` VALUES (41, 9, 1, 29, 6);
INSERT INTO `items` VALUES (42, 9, 1, 30, 6);
INSERT INTO `items` VALUES (43, 9, 1, 31, 6);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `total` int(11) NOT NULL DEFAULT 0 COMMENT '订单金额',
  `amount` int(11) NOT NULL DEFAULT 0 COMMENT '商品总数',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '订单状态(1未付款/2已付款/3已发货/4已完成)',
  `paytype` tinyint(4) NOT NULL DEFAULT 0 COMMENT '支付方式 (1微信/2支付宝)',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货电话',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址',
  `systime` datetime NULL DEFAULT NULL COMMENT '下单时间',
  `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '下单用户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, 69, 3, 2, 1, '七哥宝宝宝宝宝宝宝', '123456789', '上海浦东新区', '2020-04-19 00:07:48', 1);
INSERT INTO `orders` VALUES (2, 23, 1, 4, 2, '七哥宝宝宝宝宝宝宝', '123456789', '上海浦东新区', '2020-05-25 15:54:33', 1);
INSERT INTO `orders` VALUES (3, 24, 1, 2, 1, '七哥宝宝宝宝宝宝宝', '123456789', '上海浦东新区', '2020-05-25 16:22:39', 1);
INSERT INTO `orders` VALUES (4, 44, 2, 2, 1, '张三', '13311112222', 'aaa', '2020-05-29 10:38:19', 5);
INSERT INTO `orders` VALUES (5, 36, 1, 4, 2, '七哥宝宝宝宝宝宝宝', '123456789', '上海浦东新区', '2020-05-29 14:13:39', 1);
INSERT INTO `orders` VALUES (6, 132, 4, 2, 1, '七哥宝宝宝宝宝宝宝', '123456789', '上海浦东新区', '2020-09-08 11:57:57', 1);
INSERT INTO `orders` VALUES (7, 9, 1, 4, 1, '七哥宝宝宝宝宝宝宝', '123456789', '上海浦东新区', '2020-09-10 11:17:12', 1);
INSERT INTO `orders` VALUES (8, 9, 1, 4, 1, '七哥宝宝宝宝宝宝宝', '123456789', '上海浦东新区', '2020-09-14 10:07:39', 1);
INSERT INTO `orders` VALUES (9, 9, 1, 1, 0, NULL, NULL, NULL, '2020-09-14 10:36:46', 1);
INSERT INTO `orders` VALUES (10, 26, 1, 2, 2, '七哥宝宝宝宝宝宝宝', '123456789', '上海浦东新区', '2020-09-14 10:57:16', 1);
INSERT INTO `orders` VALUES (11, 30, 1, 1, 0, NULL, NULL, NULL, '2020-09-14 11:05:02', 1);
INSERT INTO `orders` VALUES (12, 9, 1, 1, 0, NULL, NULL, NULL, '2020-09-14 11:20:42', 1);
INSERT INTO `orders` VALUES (13, 28, 1, 4, 2, '七哥宝宝宝宝宝宝宝', '123456789', '上海浦东新区', '2020-09-14 14:36:28', 1);
INSERT INTO `orders` VALUES (14, 13, 1, 4, 1, '七哥宝宝宝宝宝宝宝', '123456789', '上海浦东新区', '2020-09-15 10:52:20', 1);
INSERT INTO `orders` VALUES (15, 39, 1, 2, 1, '1', '10086', '1', '2020-09-16 09:13:55', 6);
INSERT INTO `orders` VALUES (16, 55, 3, 4, 1, '七哥宝宝宝宝宝宝宝', '123456789', '上海浦东新区11', '2020-09-23 11:44:36', 1);
INSERT INTO `orders` VALUES (17, 26, 1, 2, 1, '七哥宝宝宝宝宝宝宝', '123456789', '上海浦东新区11', '2020-09-27 16:03:30', 1);
INSERT INTO `orders` VALUES (18, 26, 1, 1, 0, NULL, NULL, NULL, '2020-09-29 10:15:38', 1);
INSERT INTO `orders` VALUES (19, 26, 1, 1, 0, NULL, NULL, NULL, '2020-10-12 09:17:50', 1);
INSERT INTO `orders` VALUES (20, 50, 3, 1, 0, NULL, NULL, NULL, '2020-10-12 09:18:40', 1);
INSERT INTO `orders` VALUES (21, 26, 1, 1, 0, NULL, NULL, NULL, '2020-10-12 10:46:49', 1);
INSERT INTO `orders` VALUES (22, 84, 1, 1, 0, NULL, NULL, NULL, '2020-10-12 11:25:46', 1);
INSERT INTO `orders` VALUES (23, 36, 1, 1, 0, NULL, NULL, NULL, '2020-10-13 18:33:00', 1);
INSERT INTO `orders` VALUES (24, 13, 1, 1, 0, NULL, NULL, NULL, '2020-10-13 18:34:02', 1);
INSERT INTO `orders` VALUES (25, 28, 1, 1, 0, NULL, NULL, NULL, '2020-10-13 19:12:39', 1);
INSERT INTO `orders` VALUES (26, 46, 2, 1, 0, NULL, NULL, NULL, '2020-10-13 19:14:15', 1);
INSERT INTO `orders` VALUES (27, 30, 1, 3, 1, '七哥宝宝宝宝宝宝宝', '123456789', '上海浦东新区11', '2020-10-14 13:57:10', 1);
INSERT INTO `orders` VALUES (28, 30, 1, 1, 0, NULL, NULL, NULL, '2020-10-14 14:58:54', 1);
INSERT INTO `orders` VALUES (29, 9, 1, 2, 1, '七哥宝宝宝宝宝宝宝', '123456789', '上海浦东新区11', '2020-11-27 16:42:48', 1);
INSERT INTO `orders` VALUES (30, 9, 1, 1, 0, NULL, NULL, NULL, '2020-11-27 16:55:45', 1);
INSERT INTO `orders` VALUES (31, 9, 1, 3, 1, '七哥宝宝宝宝宝宝宝', '123456789', '上海浦东新区11', '2020-11-27 19:55:18', 1);

-- ----------------------------
-- Table structure for tops
-- ----------------------------
DROP TABLE IF EXISTS `tops`;
CREATE TABLE `tops`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '推荐类型(1今日推荐)',
  `good_id` int(11) NOT NULL DEFAULT 0 COMMENT '商品ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '推荐商品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tops
-- ----------------------------
INSERT INTO `tops` VALUES (1, 1, 1);
INSERT INTO `tops` VALUES (2, 1, 2);
INSERT INTO `tops` VALUES (3, 1, 3);
INSERT INTO `tops` VALUES (4, 1, 4);
INSERT INTO `tops` VALUES (5, 1, 5);
INSERT INTO `tops` VALUES (6, 1, 6);

-- ----------------------------
-- Table structure for types
-- ----------------------------
DROP TABLE IF EXISTS `types`;
CREATE TABLE `types`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `num` int(11) NULL DEFAULT 0 COMMENT '排序号 (从小到大)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of types
-- ----------------------------
INSERT INTO `types` VALUES (1, '生态果蔬', 1);
INSERT INTO `types` VALUES (2, '肉禽蛋奶', 2);
INSERT INTO `types` VALUES (3, '米面粮油', 3);
INSERT INTO `types` VALUES (4, '休闲零食', 4);
INSERT INTO `types` VALUES (5, '饮料酒水-测试', -1);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货电话',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'user', 'tuShOfiBrA8+br7ENrMS8A==', '七哥宝宝宝宝宝宝宝', '123456789', '上海浦东新区11');
INSERT INTO `users` VALUES (2, '77', 'h1OIcgSG6ZNcQ+5L4t4e1A==', '小宝宝', '12315', '黑龙江漠河');
INSERT INTO `users` VALUES (3, '88', 'tuShOfiBrA8+br7ENrMS8A==', '大宝贝', '10010', '海南西沙群岛');
INSERT INTO `users` VALUES (4, '99', 'cMdK4vKHu03eruGlpzU4VQ==', '哈哈哈', '10086', '新疆阿拉善');
INSERT INTO `users` VALUES (5, 'zhangsan', 'HAMVRZRssPCADKqGjGWJtQ==', '张三', '13311112222', 'aaa');
INSERT INTO `users` VALUES (6, '1', 'iUOoOdMAl7FsB1Kig37hmg==', '1', '10086', '1');
INSERT INTO `users` VALUES (7, '2', '2', '2', '2', '2');
INSERT INTO `users` VALUES (8, '3', '3', '3', '3', '3');

SET FOREIGN_KEY_CHECKS = 1;
