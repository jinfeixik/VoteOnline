/*
Navicat MySQL Data Transfer

Source Server         : conn
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : vote

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2019-08-28 11:49:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for vote_item
-- ----------------------------
DROP TABLE IF EXISTS `vote_item`;
CREATE TABLE `vote_item` (
  `VI_ID` int(11) NOT NULL AUTO_INCREMENT,
  `VO_ID` int(11) NOT NULL,
  `VS_ID` int(11) NOT NULL,
  `VU_USER_ID` int(11) NOT NULL,
  PRIMARY KEY (`VI_ID`),
  KEY `aavoid` (`VO_ID`),
  KEY `bsid` (`VS_ID`),
  KEY `cvuuserid` (`VU_USER_ID`),
  CONSTRAINT `aavoid` FOREIGN KEY (`VO_ID`) REFERENCES `vote_option` (`VO_ID`),
  CONSTRAINT `bsid` FOREIGN KEY (`VS_ID`) REFERENCES `vote_subject` (`VS_ID`),
  CONSTRAINT `cvuuserid` FOREIGN KEY (`VU_USER_ID`) REFERENCES `vote_user` (`VU_USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote_item
-- ----------------------------
INSERT INTO `vote_item` VALUES ('89', '262', '97', '5');
INSERT INTO `vote_item` VALUES ('90', '262', '97', '5');
INSERT INTO `vote_item` VALUES ('94', '265', '98', '9');
INSERT INTO `vote_item` VALUES ('95', '266', '98', '9');
INSERT INTO `vote_item` VALUES ('96', '266', '98', '9');
INSERT INTO `vote_item` VALUES ('97', '267', '98', '9');
INSERT INTO `vote_item` VALUES ('119', '267', '98', '6');
INSERT INTO `vote_item` VALUES ('120', '268', '98', '6');
INSERT INTO `vote_item` VALUES ('125', '329', '113', '5');
INSERT INTO `vote_item` VALUES ('126', '329', '113', '5');
INSERT INTO `vote_item` VALUES ('127', '264', '98', '5');
INSERT INTO `vote_item` VALUES ('134', '261', '97', '5');
INSERT INTO `vote_item` VALUES ('135', '260', '97', '5');
INSERT INTO `vote_item` VALUES ('136', '259', '97', '5');
INSERT INTO `vote_item` VALUES ('137', '261', '97', '5');
INSERT INTO `vote_item` VALUES ('140', '262', '97', '5');
INSERT INTO `vote_item` VALUES ('141', '265', '98', '5');
INSERT INTO `vote_item` VALUES ('142', '266', '98', '5');
INSERT INTO `vote_item` VALUES ('143', '265', '98', '5');
INSERT INTO `vote_item` VALUES ('144', '266', '98', '5');
INSERT INTO `vote_item` VALUES ('145', '331', '113', '6');
INSERT INTO `vote_item` VALUES ('149', '264', '98', '6');
INSERT INTO `vote_item` VALUES ('150', '265', '98', '6');
INSERT INTO `vote_item` VALUES ('151', '331', '113', '6');
INSERT INTO `vote_item` VALUES ('152', '331', '113', '6');
INSERT INTO `vote_item` VALUES ('153', '331', '113', '6');
INSERT INTO `vote_item` VALUES ('156', '261', '97', '5');
INSERT INTO `vote_item` VALUES ('157', '266', '98', '5');
INSERT INTO `vote_item` VALUES ('158', '267', '98', '5');
INSERT INTO `vote_item` VALUES ('159', '331', '113', '5');
INSERT INTO `vote_item` VALUES ('169', '267', '98', '9');
INSERT INTO `vote_item` VALUES ('170', '268', '98', '9');
INSERT INTO `vote_item` VALUES ('175', '330', '113', '10');
INSERT INTO `vote_item` VALUES ('186', '262', '97', '18');
INSERT INTO `vote_item` VALUES ('187', '262', '97', '18');
INSERT INTO `vote_item` VALUES ('188', '366', '121', '18');
INSERT INTO `vote_item` VALUES ('189', '265', '98', '18');
INSERT INTO `vote_item` VALUES ('190', '266', '98', '18');
INSERT INTO `vote_item` VALUES ('191', '265', '98', '18');
INSERT INTO `vote_item` VALUES ('192', '266', '98', '18');
INSERT INTO `vote_item` VALUES ('193', '365', '121', '5');
INSERT INTO `vote_item` VALUES ('194', '259', '97', '13');
INSERT INTO `vote_item` VALUES ('195', '367', '122', '13');
INSERT INTO `vote_item` VALUES ('196', '368', '122', '13');
INSERT INTO `vote_item` VALUES ('197', '267', '98', '20');
INSERT INTO `vote_item` VALUES ('198', '268', '98', '20');
INSERT INTO `vote_item` VALUES ('199', '364', '121', '20');
INSERT INTO `vote_item` VALUES ('200', '347', '117', '5');
INSERT INTO `vote_item` VALUES ('201', '347', '117', '5');
INSERT INTO `vote_item` VALUES ('202', '347', '117', '5');
INSERT INTO `vote_item` VALUES ('203', '347', '117', '5');
INSERT INTO `vote_item` VALUES ('204', '347', '117', '5');
INSERT INTO `vote_item` VALUES ('205', '347', '117', '5');
INSERT INTO `vote_item` VALUES ('206', '347', '117', '5');
INSERT INTO `vote_item` VALUES ('207', '347', '117', '5');
INSERT INTO `vote_item` VALUES ('208', '347', '117', '5');
INSERT INTO `vote_item` VALUES ('209', '347', '117', '5');
INSERT INTO `vote_item` VALUES ('210', '347', '117', '5');
INSERT INTO `vote_item` VALUES ('211', '347', '117', '5');
INSERT INTO `vote_item` VALUES ('212', '359', '120', '5');
INSERT INTO `vote_item` VALUES ('213', '376', '124', '8');
INSERT INTO `vote_item` VALUES ('214', '377', '124', '8');
INSERT INTO `vote_item` VALUES ('215', '367', '122', '5');
INSERT INTO `vote_item` VALUES ('216', '368', '122', '5');
INSERT INTO `vote_item` VALUES ('217', '388', '127', '5');
INSERT INTO `vote_item` VALUES ('218', '259', '97', '7');
INSERT INTO `vote_item` VALUES ('220', '375', '124', '5');
INSERT INTO `vote_item` VALUES ('221', '376', '124', '5');
INSERT INTO `vote_item` VALUES ('222', '383', '126', '5');

-- ----------------------------
-- Table structure for vote_option
-- ----------------------------
DROP TABLE IF EXISTS `vote_option`;
CREATE TABLE `vote_option` (
  `VO_ID` int(11) NOT NULL AUTO_INCREMENT,
  `VO_OPTION` varchar(100) DEFAULT NULL,
  `VS_ID` int(11) DEFAULT NULL,
  `VO_ORDER` int(11) DEFAULT NULL,
  PRIMARY KEY (`VO_ID`),
  KEY `VO_OPTION` (`VO_OPTION`),
  KEY `vsid` (`VS_ID`),
  CONSTRAINT `vsid` FOREIGN KEY (`VS_ID`) REFERENCES `vote_subject` (`VS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=404 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote_option
-- ----------------------------
INSERT INTO `vote_option` VALUES ('259', '游泳', '97', '1');
INSERT INTO `vote_option` VALUES ('260', '爬山', '97', '2');
INSERT INTO `vote_option` VALUES ('261', '骑车', '97', '3');
INSERT INTO `vote_option` VALUES ('262', '篮球', '97', '4');
INSERT INTO `vote_option` VALUES ('263', '远足', '97', '5');
INSERT INTO `vote_option` VALUES ('264', '小猫', '98', '1');
INSERT INTO `vote_option` VALUES ('265', '小狗', '98', '2');
INSERT INTO `vote_option` VALUES ('266', '小猪', '98', '3');
INSERT INTO `vote_option` VALUES ('267', '小鸟', '98', '4');
INSERT INTO `vote_option` VALUES ('268', '小马', '98', '5');
INSERT INTO `vote_option` VALUES ('329', '包子', '113', '1');
INSERT INTO `vote_option` VALUES ('330', '馒头', '113', '2');
INSERT INTO `vote_option` VALUES ('331', '油条', '113', '3');
INSERT INTO `vote_option` VALUES ('332', '米粥', '113', '4');
INSERT INTO `vote_option` VALUES ('345', 'a', '117', '1');
INSERT INTO `vote_option` VALUES ('346', 'b', '117', '2');
INSERT INTO `vote_option` VALUES ('347', 'c', '117', '3');
INSERT INTO `vote_option` VALUES ('348', 'd', '117', '4');
INSERT INTO `vote_option` VALUES ('359', 'a', '120', '1');
INSERT INTO `vote_option` VALUES ('360', 'c', '120', '2');
INSERT INTO `vote_option` VALUES ('361', 'd', '120', '3');
INSERT INTO `vote_option` VALUES ('362', 'f', '120', '4');
INSERT INTO `vote_option` VALUES ('363', 'javase', '121', '1');
INSERT INTO `vote_option` VALUES ('364', 'c', '121', '2');
INSERT INTO `vote_option` VALUES ('365', 'python', '121', '3');
INSERT INTO `vote_option` VALUES ('366', 'javaee', '121', '4');
INSERT INTO `vote_option` VALUES ('367', '一步', '122', '1');
INSERT INTO `vote_option` VALUES ('368', '两步', '122', '2');
INSERT INTO `vote_option` VALUES ('369', '三步', '122', '3');
INSERT INTO `vote_option` VALUES ('374', '香蕉', '124', '1');
INSERT INTO `vote_option` VALUES ('375', '苹果', '124', '2');
INSERT INTO `vote_option` VALUES ('376', '芒果', '124', '3');
INSERT INTO `vote_option` VALUES ('377', '火龙果', '124', '4');
INSERT INTO `vote_option` VALUES ('378', '骑车', '125', '1');
INSERT INTO `vote_option` VALUES ('379', '游泳', '125', '2');
INSERT INTO `vote_option` VALUES ('380', '学习', '125', '3');
INSERT INTO `vote_option` VALUES ('381', '打游戏', '125', '4');
INSERT INTO `vote_option` VALUES ('382', '中山', '126', '1');
INSERT INTO `vote_option` VALUES ('383', '广州', '126', '2');
INSERT INTO `vote_option` VALUES ('384', '长沙', '126', '3');
INSERT INTO `vote_option` VALUES ('385', '华硕', '127', '1');
INSERT INTO `vote_option` VALUES ('386', '苹果', '127', '2');
INSERT INTO `vote_option` VALUES ('387', '戴尔', '127', '3');
INSERT INTO `vote_option` VALUES ('388', '联想', '127', '4');
INSERT INTO `vote_option` VALUES ('389', '逃跑', '128', '1');
INSERT INTO `vote_option` VALUES ('390', '呆住', '128', '2');
INSERT INTO `vote_option` VALUES ('391', '抓住它', '128', '3');
INSERT INTO `vote_option` VALUES ('392', '脉动', '129', '1');
INSERT INTO `vote_option` VALUES ('393', '果缤纷', '129', '2');
INSERT INTO `vote_option` VALUES ('394', '椰子汁', '129', '3');
INSERT INTO `vote_option` VALUES ('395', '雪碧', '129', '4');
INSERT INTO `vote_option` VALUES ('396', 'e', '130', '1');
INSERT INTO `vote_option` VALUES ('397', 'e', '130', '2');
INSERT INTO `vote_option` VALUES ('398', 'r', '130', '3');
INSERT INTO `vote_option` VALUES ('399', 't', '130', '4');
INSERT INTO `vote_option` VALUES ('400', '苹果sad', '131', '1');
INSERT INTO `vote_option` VALUES ('401', '华为', '131', '2');
INSERT INTO `vote_option` VALUES ('402', '小米', '131', '3');
INSERT INTO `vote_option` VALUES ('403', '联想', '131', '4');

-- ----------------------------
-- Table structure for vote_subject
-- ----------------------------
DROP TABLE IF EXISTS `vote_subject`;
CREATE TABLE `vote_subject` (
  `VS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `VS_TITLE` varchar(200) NOT NULL,
  `VS_TYPE` int(11) NOT NULL,
  `VU_USER_NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`VS_ID`),
  KEY `vuname` (`VU_USER_NAME`),
  CONSTRAINT `vuname` FOREIGN KEY (`VU_USER_NAME`) REFERENCES `vote_user` (`VU_USER_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote_subject
-- ----------------------------
INSERT INTO `vote_subject` VALUES ('97', '户外运动我选？', '1', '123');
INSERT INTO `vote_subject` VALUES ('98', '喜欢什么动物？', '2', '567');
INSERT INTO `vote_subject` VALUES ('113', '早餐吃啥？', '1', 'luoye');
INSERT INTO `vote_subject` VALUES ('117', 'abcd', '1', '2345');
INSERT INTO `vote_subject` VALUES ('120', 'asdf', '1', '138');
INSERT INTO `vote_subject` VALUES ('121', '哪种语言好用', '1', '1314');
INSERT INTO `vote_subject` VALUES ('122', '把大象装进冰箱需要几步？', '2', 'rox');
INSERT INTO `vote_subject` VALUES ('124', '喜欢什么水果', '2', 'rox');
INSERT INTO `vote_subject` VALUES ('125', '周末去哪儿玩', '1', 'rox');
INSERT INTO `vote_subject` VALUES ('126', '实训基地去哪个', '1', 'qst260696');
INSERT INTO `vote_subject` VALUES ('127', '电脑品牌选什么？', '1', '234');
INSERT INTO `vote_subject` VALUES ('128', '看到蛇会选择？', '1', '222');
INSERT INTO `vote_subject` VALUES ('129', '饮料哪个最好喝', '2', '234');
INSERT INTO `vote_subject` VALUES ('130', 'uhji', '2', '234');
INSERT INTO `vote_subject` VALUES ('131', '喜欢什么手机', '2', '234');

-- ----------------------------
-- Table structure for vote_user
-- ----------------------------
DROP TABLE IF EXISTS `vote_user`;
CREATE TABLE `vote_user` (
  `VU_USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `VU_USER_NAME` varchar(20) NOT NULL,
  `VU_PASSWORD` varchar(20) NOT NULL,
  `VU_STATUS` varchar(20) NOT NULL,
  `VU_VERSION` int(11) NOT NULL,
  PRIMARY KEY (`VU_USER_ID`,`VU_USER_NAME`),
  KEY `VU_USER_ID` (`VU_USER_ID`),
  KEY `VU_USER_NAME` (`VU_USER_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote_user
-- ----------------------------
INSERT INTO `vote_user` VALUES ('5', '234', '234', '2', '1');
INSERT INTO `vote_user` VALUES ('6', '123', '123', '1', '1');
INSERT INTO `vote_user` VALUES ('7', '111', '111', '1', '2');
INSERT INTO `vote_user` VALUES ('8', '222', '222', '1', '1');
INSERT INTO `vote_user` VALUES ('9', '567', '567', '2', '1');
INSERT INTO `vote_user` VALUES ('10', '138', '138', '2', '1');
INSERT INTO `vote_user` VALUES ('12', 'luoye', '158', '2', '1');
INSERT INTO `vote_user` VALUES ('13', 'rox', 'ytg', '1', '2');
INSERT INTO `vote_user` VALUES ('16', '2345', '123', '2', '1');
INSERT INTO `vote_user` VALUES ('17', '2575', '2606', '1', '2');
INSERT INTO `vote_user` VALUES ('18', '1314', '1314', '2', '1');
INSERT INTO `vote_user` VALUES ('19', '147', '147', '1', '2');
INSERT INTO `vote_user` VALUES ('20', 'qst260696', 'qstt', '1', '1');
INSERT INTO `vote_user` VALUES ('21', 'qst2575', '2575', '2', '1');
INSERT INTO `vote_user` VALUES ('22', 'qst2575', '2575', '2', '1');
INSERT INTO `vote_user` VALUES ('23', 'qst2575', '2575', '2', '1');
INSERT INTO `vote_user` VALUES ('24', 'qst2575', '2575', '2', '1');
INSERT INTO `vote_user` VALUES ('25', 'qst2575', '2575', '2', '1');
INSERT INTO `vote_user` VALUES ('26', '123333', '123333', '1', '1');
INSERT INTO `vote_user` VALUES ('27', '234sdsa', '234', '2', '1');
INSERT INTO `vote_user` VALUES ('28', 'qst2575', 'qst2575', '1', '2');
INSERT INTO `vote_user` VALUES ('29', '14457', '14457', '2', '1');
INSERT INTO `vote_user` VALUES ('30', '152', '152', '2', '1');
INSERT INTO `vote_user` VALUES ('31', '145', '145', '1', '2');
INSERT INTO `vote_user` VALUES ('32', '4567', '123', '2', '1');
SET FOREIGN_KEY_CHECKS=1;
