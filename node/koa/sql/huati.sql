/*
Navicat MySQL Data Transfer

Source Server         : huati
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : huati

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-08-01 09:18:23
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

-- ----------------------------
-- Table structure for huaticontent
-- ----------------------------
DROP TABLE IF EXISTS `huaticontent`;
CREATE TABLE `huaticontent` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `uid` int(20) DEFAULT NULL COMMENT '发布的用户id',
  `title` varchar(60) DEFAULT NULL COMMENT '话题标题',
  `description` varchar(255) DEFAULT NULL COMMENT '引言',
  `con` varchar(255) DEFAULT NULL COMMENT '正文',
  `cover` varchar(255) DEFAULT NULL COMMENT '封面图',
  `support` int(20) DEFAULT '0' COMMENT '支持人数',
  `opposition` int(20) DEFAULT '0' COMMENT '反对人数',
  `updatetime` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  KEY `ids` (`id`) USING BTREE COMMENT '主键索引'
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='话题内容表';

-- ----------------------------
-- Records of huaticontent
-- ----------------------------
INSERT INTO `huaticontent` VALUES ('13', '10', '第一篇话题', '第一篇话题第一篇话题', '<p>第一篇话题第一篇话题第一篇话题</p>', 'uploads\\huati\\b07b1e10aaa12.jpg', '0', '0', null);
INSERT INTO `huaticontent` VALUES ('14', '10', '反对发射点发生', '反对发射点发生反对发射点发生', '<p>反对发射点发生<span style=\"line-height: 1.5;\">反对发射点发生</span><span style=\"line-height: 1.5;\">反对发射点发生</span></p>', 'uploads\\huati\\0d79a1dac4a8a.png', '0', '0', null);
INSERT INTO `huaticontent` VALUES ('15', '10', '反对法士大夫', '犯得上发射点发达发达是法大师傅打法', '<p>反对防守打法</p>', 'uploads\\huati\\c8c15c9d34a57.jpg', '0', '0', null);
INSERT INTO `huaticontent` VALUES ('16', '10', '反对发射点', '范德萨范德萨发达发达是法大师傅大师傅', '<p>反对防守打法打算</p>', 'uploads\\huati\\b48b34b7d0f2c.jpg', '0', '0', null);
INSERT INTO `huaticontent` VALUES ('17', '10', '11111112313131', '111111123131311111111231313111111112313131', '<p>11111112313131<span style=\"line-height: 28px;\">11111112313131</span></p><spanmicrosoft yahei\',=\"\" simhei,=\"\" 宋体,=\"\" sans-serif;=\"\" font-size:=\"\" 18px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 27px', 'uploads\\huati\\6243af0d85d23.jpg', '0', '0', null);
INSERT INTO `huaticontent` VALUES ('18', '10', '332424242', '332424242332424242', '<p>332424242<span style=\"line-height: 1.5;\">332424242</span><span style=\"line-height: 1.5;\">332424242</span></p>', 'uploads\\huati\\f12cdf15d1a99.jpg', '0', '0', null);
INSERT INTO `huaticontent` VALUES ('19', '10', '反对法士大夫大师傅大势', '反对法士大夫大师傅大势反对法士大夫大师傅大势', '<p>反对法士大夫大师傅大势<span style=\"line-height: 1.5;\">反对法士大夫大师傅大势</span><span style=\"line-height: 1.5;\">反对法士大夫大师傅大势</span><span style=\"line-height: 1.5;\">反对法士大夫大师傅大势</span></p>', 'uploads\\huati\\026d270ed6f89.jpg', '0', '0', null);
INSERT INTO `huaticontent` VALUES ('20', '10', '范德萨富士达', '范德萨富士达范德萨富士达', '<p>范德萨富士达<span style=\"line-height: 1.5;\">范德萨富士达</span><span style=\"line-height: 1.5;\">范德萨富士达</span></p>', 'uploads\\huati\\ee7c15db69476.jpg', '0', '0', null);
INSERT INTO `huaticontent` VALUES ('21', '10', '夫人通过改变风格', '夫人通过改变风格', '<p>夫人通过改变风格<span style=\"line-height: 1.5;\">夫人通过改变风格</span></p>', 'uploads\\huati\\5e85583f78c4e.jpg', '0', '0', null);
INSERT INTO `huaticontent` VALUES ('22', '10', '非热热热', '非热热热非热热热', '<p>非热热热<span style=\"line-height: 1.5;\">非热热热</span><span style=\"line-height: 1.5;\">非热热热</span></p>', 'uploads\\huati\\a52c687c17507.jpg', '0', '0', null);
INSERT INTO `huaticontent` VALUES ('23', '10', '二恶英一个', '二恶英一个二恶英一个', '<p>二恶英一个</p>', 'uploads\\huati\\dfdb9f4450a25.jpg', '0', '0', null);
INSERT INTO `huaticontent` VALUES ('24', '10', '反对防守打法大发大水发射点发', '反对防守打法大发大水发射点发反对防守打法大发大水发射点发反对防守打法大发大水发射点发', '<p>反对防守打法大发大水发射点发<span style=\"line-height: 1.5;\">反对防守打法大发大水发射点发</span><span style=\"line-height: 1.5;\">反对防守打法大发大水发射点发</span><span style=\"line-height: 1.5;\">反对防守打法大发大水发射点发</span></p>', 'uploads\\huati\\69de1c9aafc93.jpg', '0', '0', null);
INSERT INTO `huaticontent` VALUES ('25', '10', 'fdfweewff放大发', 'fdfweewff放大发fdfweewff放大发fdfweewff放大发', '<p>fdfweewff放大发<span style=\"line-height: 1.5;\">fdfweewff放大发</span><span style=\"line-height: 1.5;\">fdfweewff放大发</span><span style=\"line-height: 1.5;\">fdfweewff放大发</span><span style=\"line-height: 1.5;\">fdfweewff放大发</span></p>', 'uploads\\huati\\f16d929250749.jpg', '0', '0', null);

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

-- ----------------------------
-- Table structure for _mysql_session_store
-- ----------------------------
DROP TABLE IF EXISTS `_mysql_session_store`;
CREATE TABLE `_mysql_session_store` (
  `id` varchar(255) NOT NULL,
  `expires` bigint(20) DEFAULT NULL,
  `data` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _mysql_session_store
-- ----------------------------
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:04F-zelbGpxOgB2xl95dzBjqiJxMYfa6', '1529841804393', '{\"codeval\":\"9433\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:2cEInqXqI7AuVW3lC0D5QofZO8VVvMVv', '1529899330131', '{\"codeval\":\"4718\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:6fECXQdPQDvpSRDNureiZfLEKfJML0yq', '1529842456667', '{\"codeval\":\"7954\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:9wYxndQSR7Yldt8R8tz-b9z-yeuHEWU3', '1529841772999', '{\"codeval\":\"9106\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:B5OTH0h4hWl4SAai7QERpKtFHzObV3CM', '1529841803072', '{\"codeval\":\"2310\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:BEs0Cc1Nxo8CbLJ_UEua0PLWRgoH8v_O', '1530083241439', '{\"codeval\":\"3840\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:bT0A-zso1Fw7xoNvPfNlXmt-jGFX_26W', '1529841144239', '{\"codeval\":\"5062\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:CTh46qr5zsXNX7suWNurvq1C-gFnnZEM', '1529899270416', '{\"codeval\":\"3936\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:eOzuJYU6LgnZZQMFM_68LiTk4P4zgqQK', '1529842138123', '{\"codeval\":\"8455\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:FPiAC51avv5LfuepPjAr_0OO2vkAeBuH', '1529841801352', '{\"codeval\":\"6517\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:grY5CZpA7sMc9eL5KHLu3qD4zqe39nlu', '1529841140785', '{\"codeval\":\"9851\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:GsIgpq9FrLpwAUVMX_sAeCKGlKnO77rH', '1530082906936', '{\"codeval\":\"1171\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:HQxow5Hxl-iFpBFvpFMVDHjXDgQk3LhQ', '1529841782893', '{\"codeval\":\"0055\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:ib59DLaSKPfcKFo72xakr925fOgRRiro', '1529899332839', '{\"codeval\":\"7634\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:IKd7YUhNcJrp4sYQok60H0NZoWpef3GM', '1529842062534', '{\"codeval\":\"4915\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:kva1xn-9WcmMg2IkAeTkeKCWzDL9u_wk', '1529899293515', '{\"codeval\":\"9194\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:L-aSthk_QV3Q2icshYkYhdzEFiMV0hqK', '1529841184812', '{\"codeval\":\"2471\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:lrxPh_3K9AphR21l1tTJFzYu48S551Ao', '1529842054179', '{\"codeval\":\"0770\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:nxp-N8XAjtBT0Ub0PJM5RRu5_sstcD_p', '1529841890875', '{\"codeval\":\"2905\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:N_HUOJmdG89mHuzQ4AUVuwr3kJTje2EE', '1529841015153', '{\"codeval\":\"0357\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:oV1BDYRetkozdb9mZXl8ksA0kgVAX_B7', '1529840837562', '{\"codeval\":\"4122\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:QpCMDfF3H27zWNq81B2_J5duLRvVlVwD', '1529840995400', '{\"codeval\":\"3225\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:SgHlsuvTOojHOFDGHQKnZpRjOHJzljye', '1529841792446', '{\"codeval\":\"9701\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:t1hzXVY0w3QfD2-XhpMitefcqHx5ymJB', '1529841899391', '{\"codeval\":\"8183\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:uBtNMRkTHXG3Q_N2uV1SbIB4MJGYzDyj', '1530083242486', '{\"codeval\":\"2428\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:uJVIkYw-ASn8OeuHTwuhoDFVEFp7w44q', '1529841784174', '{\"codeval\":\"0678\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:VP844TQaQER-Hwm5Luf2JWzdIz-H87k2', '1529841885693', '{\"codeval\":\"2745\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:vz92Momn7bXK7qhxtbATta-Lh2wlHgzg', '1529841159127', '{\"codeval\":\"8105\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:WaYxC6tcfMaJJ7l5MribSpZkjEVv3D06', '1529842118749', '{\"codeval\":\"9565\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:wbTBy36zKR6KufcKueVFgFtHeMzc3Jib', '1529842782721', '{\"codeval\":\"0274\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:X4Eu8z-dkdOhIk_f13f2hxrEbB94ivJi', '1529900207336', '{\"codeval\":\"0870\"}');
INSERT INTO `_mysql_session_store` VALUES ('SESSION_ID:_jiVcDc4icf17vTAVEmtfNghRUGSuBln', '1529841795620', '{\"codeval\":\"9035\"}');
