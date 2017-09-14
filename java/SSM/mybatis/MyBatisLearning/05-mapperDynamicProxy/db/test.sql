/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3366
 Source Server Type    : MySQL
 Source Server Version : 50096
 Source Host           : localhost:3366
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50096
 File Encoding         : 65001

 Date: 07/09/2017 09:15:31
*/


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(3) NULL DEFAULT NULL,
  `score` double(255, 2) NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'InnoDB free: 4096 kB' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '张三', 24, 95.00);
INSERT INTO `student` VALUES (2, '李四', 25, 94.50);
INSERT INTO `student` VALUES (3, '王五', 23, 97.50);

SET FOREIGN_KEY_CHECKS = 1;
