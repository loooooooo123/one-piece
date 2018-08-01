/*
Navicat MySQL Data Transfer

Source Server         : huati
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : huati

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-08-01 09:19:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '索引id',
  `username` varchar(10) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `registerdate` datetime DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('10', '小熊', 'f4c11333d4971955866cbcbc25359bf3', '2018-06-24 20:09:16');
