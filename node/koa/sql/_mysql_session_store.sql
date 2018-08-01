/*
Navicat MySQL Data Transfer

Source Server         : huati
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : huati

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-08-01 09:18:37
*/

SET FOREIGN_KEY_CHECKS=0;

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
