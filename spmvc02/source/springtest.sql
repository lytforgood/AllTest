/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : springtest

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2016-03-03 17:21:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `uname` varchar(50) DEFAULT NULL,
  `utype` varchar(50) DEFAULT NULL,
  `urole` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'qqq', 'qqq', 'qqw', 'qw', '1');
INSERT INTO `user` VALUES ('2', 'www', 'www', 'wqe', 'qwe', '1');
INSERT INTO `user` VALUES ('3', '1222', '121', '121', '1212', '1');
INSERT INTO `user` VALUES ('4', 'ewrwer', 'werwer', 'werwer', 'werwer', '1');
INSERT INTO `user` VALUES ('5', 'rwtwetr', 'qwerqwe', 'qweqe', 'qweqwe', '1');
INSERT INTO `user` VALUES ('6', 'werewr', 'qwerqr', 'qweqwe', 'qweqweqw', '1');
INSERT INTO `user` VALUES ('7', 'werwer', 'werwer', 'werwer', 'werwerew', '1');
INSERT INTO `user` VALUES ('8', 'www阿萨德', '111', 'eee权威', 'qqwe', '1');
