/*
Navicat MySQL Data Transfer

Source Server         : role1
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : auth

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-10-02 12:24:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `think_auth_group`
-- ----------------------------
DROP TABLE IF EXISTS `think_auth_group`;
CREATE TABLE `think_auth_group` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `title` char(100) NOT NULL DEFAULT '',
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `rules` char(80) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of think_auth_group
-- ----------------------------
INSERT INTO `think_auth_group` VALUES ('1', '管理员', '1', '1,2,15,16,20,21,22,23,24');
INSERT INTO `think_auth_group` VALUES ('2', '编辑', '1', '1');
INSERT INTO `think_auth_group` VALUES ('3', '小组长', '1', '1,2,15,16');

-- ----------------------------
-- Table structure for `think_auth_group_access`
-- ----------------------------
DROP TABLE IF EXISTS `think_auth_group_access`;
CREATE TABLE `think_auth_group_access` (
  `uid` mediumint(8) unsigned NOT NULL,
  `group_id` mediumint(8) unsigned NOT NULL,
  UNIQUE KEY `uid_group_id` (`uid`,`group_id`),
  KEY `uid` (`uid`),
  KEY `group_id` (`group_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of think_auth_group_access
-- ----------------------------
INSERT INTO `think_auth_group_access` VALUES ('6', '1');
INSERT INTO `think_auth_group_access` VALUES ('7', '3');
INSERT INTO `think_auth_group_access` VALUES ('8', '2');
INSERT INTO `think_auth_group_access` VALUES ('9', '1');
INSERT INTO `think_auth_group_access` VALUES ('9', '2');
INSERT INTO `think_auth_group_access` VALUES ('9', '3');
INSERT INTO `think_auth_group_access` VALUES ('10', '2');
INSERT INTO `think_auth_group_access` VALUES ('10', '3');

-- ----------------------------
-- Table structure for `think_auth_rule`
-- ----------------------------
DROP TABLE IF EXISTS `think_auth_rule`;
CREATE TABLE `think_auth_rule` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `name` char(80) NOT NULL DEFAULT '',
  `title` char(20) NOT NULL DEFAULT '',
  `type` tinyint(1) NOT NULL DEFAULT '1',
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `condition` char(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of think_auth_rule
-- ----------------------------
INSERT INTO `think_auth_rule` VALUES ('1', 'Home/Index/userList', '用户列表', '1', '1', '');
INSERT INTO `think_auth_rule` VALUES ('2', 'Home/AuthInfo/addUser', '添加用户', '1', '1', '');
INSERT INTO `think_auth_rule` VALUES ('7', 'Home/AuthInfo/addRule', '添加权限', '1', '1', '');
INSERT INTO `think_auth_rule` VALUES ('15', 'Home/AuthInfo/deleteUser', '删除用户', '1', '1', '');
INSERT INTO `think_auth_rule` VALUES ('16', 'Home/AuthInfo/editUser', '修改用户', '1', '1', '');
INSERT INTO `think_auth_rule` VALUES ('17', 'Home/AuthInfo/ruleList', '权限列表', '1', '1', '');
INSERT INTO `think_auth_rule` VALUES ('18', 'Home/AuthInfo/deleteRule', '删除权限', '1', '1', '');
INSERT INTO `think_auth_rule` VALUES ('19', 'Home/AuthInfo/editRule', '修改权限', '1', '1', '');
INSERT INTO `think_auth_rule` VALUES ('20', 'Home/AuthInfo/groupList', '分组列表', '1', '1', '');
INSERT INTO `think_auth_rule` VALUES ('21', 'Home/AuthInfo/editGroupRule', '分配权限', '1', '1', '');
INSERT INTO `think_auth_rule` VALUES ('22', 'Home/AuthInfo/addGroup', '添加分组', '1', '1', '');
INSERT INTO `think_auth_rule` VALUES ('23', 'Home/AuthInfo/deleteGroup', '删除分组', '1', '1', '');
INSERT INTO `think_auth_rule` VALUES ('24', 'Home/AuthInfo/editGroup', '修改分组', '1', '1', '');

-- ----------------------------
-- Table structure for `think_user`
-- ----------------------------
DROP TABLE IF EXISTS `think_user`;
CREATE TABLE `think_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `logintime` int(10) DEFAULT NULL COMMENT '登录事件',
  `loginip` varchar(30) DEFAULT NULL COMMENT '登录ip',
  `status` tinyint(1) DEFAULT NULL COMMENT '登录状态，是否禁用，0或1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of think_user
-- ----------------------------
INSERT INTO `think_user` VALUES ('3', 'admin', '21232f297a57a5a743894a0e4a801fc3', '1506911234', '0.0.0.0', '1');
INSERT INTO `think_user` VALUES ('6', 'guanliyuan', '665b2fed1599f29554a9bd6a19c9947f', '1506915060', '0.0.0.0', '1');
INSERT INTO `think_user` VALUES ('7', 'xiaozuzhang', '53402880cb8abc4fc0f51343e8b3cf70', '1506915097', '0.0.0.0', '1');
INSERT INTO `think_user` VALUES ('8', 'bianji', '1dc49e4cc0046e1ecaafced131abd295', '1506915009', '0.0.0.0', '1');
INSERT INTO `think_user` VALUES ('9', 'jingli', '455d6883672baea065c2ef8cd1a8bd29', '1506915617', '0.0.0.0', '1');
INSERT INTO `think_user` VALUES ('10', 'zongjian', 'b9731ccd7863660c9b3c2c05b54ea3ad', '1506915772', '0.0.0.0', '1');
