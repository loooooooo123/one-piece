/*
Navicat MySQL Data Transfer

Source Server         : huati
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : huati

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-08-01 09:19:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for huativote
-- ----------------------------
DROP TABLE IF EXISTS `huativote`;
CREATE TABLE `huativote` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id索引',
  `hid` int(20) DEFAULT NULL COMMENT '对应的话题id',
  `uid` int(20) DEFAULT NULL COMMENT '对应的用户id',
  PRIMARY KEY (`id`),
  KEY `cid` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='话题投票表';

-- ----------------------------
-- Records of huativote
-- ----------------------------
