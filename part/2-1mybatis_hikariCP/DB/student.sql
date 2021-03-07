/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : lq

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2021-03-07 14:23:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `num` varchar(9) DEFAULT NULL COMMENT '学号',
  `sname` varchar(20) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(1) DEFAULT NULL COMMENT '性别',
  `age` varchar(6) DEFAULT NULL COMMENT '年龄',
  `creTim` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
