/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : 106.14.199.35:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 13/05/2020 18:30:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(100) DEFAULT NULL COMMENT '书籍名称',
  `author` varchar(10) DEFAULT NULL COMMENT '书籍作者',
  `publisher` varchar(100) DEFAULT NULL COMMENT '书籍出版社',
  `no` varchar(255) DEFAULT NULL COMMENT '书籍编号',
  `amount` varchar(255) DEFAULT NULL COMMENT '书籍金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='书籍表';

-- ----------------------------
-- Records of books
-- ----------------------------
BEGIN;
INSERT INTO `books` VALUES (1, 'JAVA从入门到放弃', '佚名', '佚名', 'NO1212', '99');
INSERT INTO `books` VALUES (2, 'Python从放弃到坚放弃', '佚名', '佚名', 'NO1234', '50');
COMMIT;

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `books_id` bigint(20) DEFAULT NULL COMMENT '书籍ID',
  `status` tinyint(1) DEFAULT NULL COMMENT '借阅状态',
  PRIMARY KEY (`id`),
  KEY `user_out` (`user_id`),
  KEY `books_out` (`books_id`),
  CONSTRAINT `books_out` FOREIGN KEY (`books_id`) REFERENCES `books` (`id`),
  CONSTRAINT `user_out` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='书籍借阅表';

-- ----------------------------
-- Records of borrow
-- ----------------------------
BEGIN;
INSERT INTO `borrow` VALUES (1, 1, 2, 0);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(20) DEFAULT NULL COMMENT '用户名称',
  `id_card` varchar(18) DEFAULT NULL COMMENT '身份证',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT=' 用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '依韵', '430523200012122530', '2000-12-12 18:21:52', '男');
COMMIT;

-- ----------------------------
-- Procedure structure for my_insert
-- ----------------------------
DROP PROCEDURE IF EXISTS `my_insert`;
delimiter ;;
CREATE PROCEDURE `my_insert`()
BEGIN
   DECLARE n int DEFAULT 1;
        loopname:LOOP
            INSERT INTO `logs1`(`logtype`,`logurl`,`logip`,`logdz`,`ladduser` ,`lfadduser`,`laddtime`,`htmlname`) VALUES ( 2, '/index', '0:0:0:0:0:0:0:1', null, null, 'null', '2018-05-03 14:02:42', '首页');
            SET n=n+1;
        IF n=10000000 THEN
            LEAVE loopname;
        END IF;
        END LOOP loopname;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
