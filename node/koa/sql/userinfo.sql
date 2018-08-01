/*
Navicat MySQL Data Transfer

Source Server         : huati
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : huati

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-08-01 09:19:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键索引',
  `uid` int(20) DEFAULT NULL COMMENT '用户id',
  `sex` char(2) DEFAULT '2' COMMENT '姓别，1男，0女，2保密',
  `job` varchar(50) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `constellation` varchar(20) DEFAULT NULL COMMENT '星座',
  `hobby` varchar(100) DEFAULT NULL COMMENT '爱好',
  `speciality` varchar(255) DEFAULT NULL COMMENT '擅长领域，特长',
  `ideal` varchar(255) DEFAULT NULL COMMENT '理想',
  `usercover` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `updatetime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `zid` (`id`) USING BTREE COMMENT '主键索引'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of userinfo
-- ----------------------------
