/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : bookstore

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2018-12-09 17:27:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `category_id` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '《西游记》', '吴承恩', '89', 'img/xiyouji.jpg', '我国四大名著之一', '1');
INSERT INTO `book` VALUES ('2', '《马列主义》', '马克思', '100', 'img/ma.jpg', '社会主义主要的精神支柱', '2');
INSERT INTO `book` VALUES ('3', '《穿透历史》', '田余庆', '79', 'img/history.jpg', '田余庆，北京大学历史系教授，主要研究方向为中国古代史、秦汉魏晋南北朝史。代表作为《东晋门阀政治》、《秦汉魏晋史探微》和《拓跋史探》。', '3');
INSERT INTO `book` VALUES ('4', '《自私的基因》', '理查德·道金斯', '120', 'img/self.jpg', '我们从哪里来，又将到哪里去。生命有何意义，我们该如何认知自己？这本书是实实在在的认知科学，复制、变异和淘汰简单的三种机制可以演变出所有大千世界生命现象里的林林总总。', '4');
INSERT INTO `book` VALUES ('5', '《西方战争艺术》', '阿彻琼斯', '56', 'img/bottle.jpg', '战争也是一种艺术，不单是血腥，想知道希特勒如何成为战争天才的吗？快来看这本书吧！', '5');
INSERT INTO `book` VALUES ('6', '《资本论》', '马克思', '130', 'img/ziben.jpg', '，以剩余价值为中心，对资本主义进行了彻底的批判。第一卷研究了资本的生产过程，分析了剩余价值的生产问题。第二卷在资本生产过程的基础上研究了资本的流通过程，分析了剩余价值的实现问题。第三卷讲述了资本主义生产的总过程，分别研究了资本和剩余价值的具体形式。这一卷讲述的内容达到了资本的生产过程、流通过程和分配过程的高度统一，分析了剩余价值的分配问题。', '6');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` varchar(40) NOT NULL,
  `type` varchar(100) NOT NULL,
  `category_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '古典名著', '比较古老的一类书，但比较经典');
INSERT INTO `category` VALUES ('2', '哲学', '比较抽象，不容易学懂');
INSERT INTO `category` VALUES ('3', '社会科学', '走近科学，不要迷信，你值得看一看');
INSERT INTO `category` VALUES ('4', '自然科学', '探索自然的奥秘，大自然是我们的母亲，我们要向大自然学习');
INSERT INTO `category` VALUES ('5', '军事', '了解国家动态，做军事强国，人人有责');
INSERT INTO `category` VALUES ('6', '经济', '了解生活中的经济分类');

-- ----------------------------
-- Table structure for `orderitem`
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `id` varchar(40) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `order_id` varchar(40) DEFAULT NULL,
  `book_id` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `book_id` (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('11', '23', '566', '1', '1');
INSERT INTO `orderitem` VALUES ('4db53034-c0cc-4cef-8698-085611f36268', '1', '89', '06f78edb-b4a2-4757-9ed2-7410c7b7c60d', '1');
INSERT INTO `orderitem` VALUES ('62eccb5b-2a43-439a-8fd9-3457dd983641', '1', '59', '7abc15b9-0b55-470d-9640-bc831eaf9bae', '1');
INSERT INTO `orderitem` VALUES ('93f3d752-5576-44b8-b833-215f7fa76ff4', '1', '89', 'c0b52b74-49c3-4b58-a91f-67b714319d0f', '1');
INSERT INTO `orderitem` VALUES ('d8d11ac2-314c-40ba-8d7c-883c83c17e09', '2', '178', '58b0be80-dc78-4227-870d-32813973ef6b', '1');
INSERT INTO `orderitem` VALUES ('e3d322f0-877e-4212-9d57-839610c47ed5', '1', '89', '6fdd5145-8a5b-4a54-9a35-7a46f9768df4', '1');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` varchar(40) NOT NULL,
  `ordertime` datetime NOT NULL,
  `price` double NOT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `user_id` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('06f78edb-b4a2-4757-9ed2-7410c7b7c60d', '2018-12-09 13:34:47', '89', '0', '2');
INSERT INTO `orders` VALUES ('1', '2018-12-12 09:54:19', '299', '1', '1');
INSERT INTO `orders` VALUES ('58b0be80-dc78-4227-870d-32813973ef6b', '2018-12-08 17:12:13', '178', '0', '2');
INSERT INTO `orders` VALUES ('6fdd5145-8a5b-4a54-9a35-7a46f9768df4', '2018-12-09 14:22:42', '89', '0', '2');
INSERT INTO `orders` VALUES ('7abc15b9-0b55-470d-9640-bc831eaf9bae', '2018-12-07 10:04:54', '59', '0', '1');
INSERT INTO `orders` VALUES ('c0b52b74-49c3-4b58-a91f-67b714319d0f', '2018-12-09 14:22:34', '89', '0', '2');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `phone` varchar(40) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `type` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'lisi', 'E10ADC3949BA59ABBE56E057F20F883E', '123456', '5555', '成都', null);
INSERT INTO `user` VALUES ('2', 'zhangsan', '202CB962AC59075B964B07152D234B70', '沙河', '123456@qq.com', '重庆', null);

-- ----------------------------
-- View structure for `book_category`
-- ----------------------------
DROP VIEW IF EXISTS `book_category`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `book_category` AS select `category`.`type` AS `type`,`category`.`category_description` AS `category_description`,`book`.`description` AS `description`,`book`.`image` AS `image`,`book`.`price` AS `price`,`book`.`author` AS `author`,`book`.`name` AS `name`,`book`.`id` AS `id` from (`book` join `category` on((`book`.`category_id` = `category`.`id`))) ;
