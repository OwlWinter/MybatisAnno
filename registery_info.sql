/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : school

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 09/05/2020 15:02:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for registery_info
-- ----------------------------
DROP TABLE IF EXISTS `registery_info`;
CREATE TABLE `registery_info`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `student_id` bigint(20) NOT NULL COMMENT '学号',
  `student_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `qq_num` bigint(20) NOT NULL COMMENT 'QQ号',
  `major_subject` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '学习方向',
  `graduated_school` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '毕业院校',
  `daily_report` tinytext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '日报链接',
  `slogan` tinytext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '目标',
  `brother` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '师兄姓名',
  `come_from` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '户籍所在地',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uniq_student_id`(`student_id`) USING BTREE,
  INDEX `idx_student_name`(`student_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30000522 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
