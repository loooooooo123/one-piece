/*
Navicat MySQL Data Transfer

Source Server         : huati
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : huati

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-08-01 09:18:52
*/

SET FOREIGN_KEY_CHECKS=0;

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
