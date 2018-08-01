/*
Navicat MySQL Data Transfer

Source Server         : huati
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : huati

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-08-01 09:18:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for huaticomment
-- ----------------------------
DROP TABLE IF EXISTS `huaticomment`;
CREATE TABLE `huaticomment` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id索引',
  `uid` int(20) DEFAULT NULL COMMENT '对应用户id',
  `hid` int(20) DEFAULT NULL COMMENT '对应话题id',
  `con` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `type` char(2) DEFAULT NULL COMMENT '支持或反对，Y或N',
  `commenttime` datetime DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`),
  KEY `hid` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of huaticomment
-- ----------------------------
