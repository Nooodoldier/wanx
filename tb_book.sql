/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : wanx

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2020-04-04 16:32:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_book_bus`
-- ----------------------------
DROP TABLE IF EXISTS `tb_book_bus`;
CREATE TABLE `tb_book_bus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_id` bigint(20) DEFAULT NULL,
  `book_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_book_bus
-- ----------------------------
INSERT INTO `tb_book_bus` VALUES ('2', '2', '1');
INSERT INTO `tb_book_bus` VALUES ('3', '2', '1');
INSERT INTO `tb_book_bus` VALUES ('4', '21', '1');

-- ----------------------------
-- Table structure for `tb_book_order`
-- ----------------------------
DROP TABLE IF EXISTS `tb_book_order`;
CREATE TABLE `tb_book_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `receiver` varchar(100) DEFAULT NULL,
  `area` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `bus_id` bigint(20) DEFAULT NULL,
  `total_price` double(20,0) DEFAULT NULL,
  `order_number` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_book_order
-- ----------------------------
INSERT INTO `tb_book_order` VALUES ('1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `tb_book_order` VALUES ('2', '1', '1', '1', '1', '2', '2', '000202003190028511000001');
INSERT INTO `tb_book_order` VALUES ('3', '1', '1', '1', '1', '3', '2', '000202003190028511000002');
INSERT INTO `tb_book_order` VALUES ('4', '1', '1', '1', '1', '4', '21', '000202003190028511000003');

-- ----------------------------
-- Table structure for `tb_book_store`
-- ----------------------------
DROP TABLE IF EXISTS `tb_book_store`;
CREATE TABLE `tb_book_store` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `describe` varchar(100) DEFAULT NULL,
  `img` varchar(100) DEFAULT NULL,
  `price` double(20,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_book_store
-- ----------------------------
INSERT INTO `tb_book_store` VALUES ('1', '1', '1', '1.jpg', '1');
INSERT INTO `tb_book_store` VALUES ('2', '2', '2', '2.jpg', '2');
INSERT INTO `tb_book_store` VALUES ('3', '3', '3', '3.jpg', '3');
INSERT INTO `tb_book_store` VALUES ('4', '4', '4', '4.jpg', '4');
INSERT INTO `tb_book_store` VALUES ('5', '5', '5', '5.jpg', '5');
INSERT INTO `tb_book_store` VALUES ('6', '6', '6', '6.jpg', '6');
INSERT INTO `tb_book_store` VALUES ('7', '7', '7', '7.jpg', '7');
INSERT INTO `tb_book_store` VALUES ('8', '8', '8', '8.jpg', '8');
INSERT INTO `tb_book_store` VALUES ('9', '9', '9', '9.jpg', '9');
INSERT INTO `tb_book_store` VALUES ('10', '10', '10', '10.jpg', '10');
INSERT INTO `tb_book_store` VALUES ('11', '11', '11', '11.jpg', '11');
INSERT INTO `tb_book_store` VALUES ('12', '12', '12', '12.jpg', '12');
INSERT INTO `tb_book_store` VALUES ('13', '13', '13', '13.jpg', '13');
INSERT INTO `tb_book_store` VALUES ('14', '14', '14', '14.jpg', '14');
INSERT INTO `tb_book_store` VALUES ('15', '15', '15', '15.jpg', '15');
INSERT INTO `tb_book_store` VALUES ('16', '16', '16', '16.jpg', '16');
INSERT INTO `tb_book_store` VALUES ('17', '17', '17', '17.jpg', '17');
INSERT INTO `tb_book_store` VALUES ('18', '18', '18', '18.jpg', '18');
INSERT INTO `tb_book_store` VALUES ('19', '19', '19', '19.jpg', '19');
INSERT INTO `tb_book_store` VALUES ('20', '20', '20', '20.jpg', '20');
INSERT INTO `tb_book_store` VALUES ('21', '21', '21', '21.jpg', '21');

-- ----------------------------
-- Table structure for `tb_book_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_book_user`;
CREATE TABLE `tb_book_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_book_user
-- ----------------------------
INSERT INTO `tb_book_user` VALUES ('7', '张三男', '123456');
INSERT INTO `tb_book_user` VALUES ('14', '李强哥', '123456');
INSERT INTO `tb_book_user` VALUES ('15', '张耳顺', '123456');
INSERT INTO `tb_book_user` VALUES ('16', '李思思', '123456');
INSERT INTO `tb_book_user` VALUES ('18', '请问', '123456');
