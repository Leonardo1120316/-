/*
 Navicat Premium Data Transfer

 Source Server         : 123
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : clubmanagesystem

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 22/03/2024 17:13:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `manageid` bigint(20) DEFAULT 2,
  `activityname` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `avatarUrl` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `student` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '参加活动的用户',
  `email` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `activityStatus` int(11) DEFAULT 0,
  `createTime` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `isDelete` tinyint(4) NOT NULL DEFAULT 0,
  `introduce` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '活动介绍',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '活动' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES (1, 1, '街舞', NULL, NULL, '12312z@qq.com', 0, '2024-03-06 12:22:03', '2024-03-06 12:22:03', 0, '来一场吉他的盛宴');
INSERT INTO `activity` VALUES (2, 2, '街舞', NULL, NULL, '12312z@qq.com', 0, '2024-03-06 13:24:05', '2024-03-06 13:24:05', 1, NULL);
INSERT INTO `activity` VALUES (3, 2, '湖滨路演', NULL, NULL, '12312z@qq.com', 0, '2024-03-06 13:24:17', '2024-03-06 13:24:17', 0, NULL);
INSERT INTO `activity` VALUES (4, 2, '读书会', NULL, NULL, '12312z@qq.com', 0, '2024-03-06 13:24:33', '2024-03-06 13:24:33', 0, NULL);

-- ----------------------------
-- Table structure for club
-- ----------------------------
DROP TABLE IF EXISTS `club`;
CREATE TABLE `club`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `manageid` bigint(20) DEFAULT 2,
  `clubname` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `avatarUrl` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `student` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '社团包含的用户',
  `email` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `clubStatus` int(11) DEFAULT 0,
  `createTime` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `isDelete` tinyint(4) NOT NULL DEFAULT 0,
  `introduce` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '社团介绍',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '社团' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of club
-- ----------------------------
INSERT INTO `club` VALUES (1, 2, '吉他GuitarClub', NULL, NULL, 'guitarClub@qq.com', 1, '2024-03-05 16:11:17', '2024-03-05 16:11:17', 0, NULL);
INSERT INTO `club` VALUES (2, 2, '舞蹈社Dancing', NULL, NULL, '121312@qq.com', 1, '2024-03-05 16:44:32', '2024-03-05 16:44:32', 0, NULL);
INSERT INTO `club` VALUES (3, 2, 'IT技术宅', NULL, NULL, '123@qq.com', 0, '2024-03-06 11:43:09', '2024-03-06 11:43:09', 0, NULL);

-- ----------------------------
-- Table structure for finance
-- ----------------------------
DROP TABLE IF EXISTS `finance`;
CREATE TABLE `finance`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `manageid` bigint(20) DEFAULT 2,
  `financename` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `avatarUrl` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `manage` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '财务负责人',
  `email` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `financeStatus` int(11) DEFAULT 0,
  `createTime` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `isDelete` tinyint(4) NOT NULL DEFAULT 0,
  `introduce` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '财务详情介绍',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '活动' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of finance
-- ----------------------------
INSERT INTO `finance` VALUES (1, 1, '路演财务支出', NULL, '吉他社长_lu', '233874598@qq.com', 0, '2024-03-06 12:34:06', '2024-03-06 12:34:06', 0, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `userAccount` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `avatarUrl` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT 'https://b0.bdstatic.com/a367e9334848fe281131e135610ccaa4.jpg@h_1280',
  `gender` tinyint(4) DEFAULT NULL,
  `userPassword` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `club` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户加入的社团列表-管理的社团列表',
  `phone` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `userStatus` int(11) DEFAULT 0,
  `createTime` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime(0) DEFAULT CURRENT_TIMESTAMP,
  `isDelete` tinyint(4) NOT NULL DEFAULT 0,
  `userRole` int(11) NOT NULL DEFAULT 0,
  `introduce` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户兴趣介绍',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, 'momo', 'admin', 'https://b0.bdstatic.com/a367e9334848fe281131e135610ccaa4.jpg@h_1280', 1, '6f8b92cb210c64a7b56b6de6ba3315f5', NULL, '1883212343', 'momo@qq.com', 0, '2024-03-01 11:36:52', '2024-03-01 11:36:52', 0, 1, '这个人很懒');
INSERT INTO `user` VALUES (4, 'tata', 'Alice', 'https://b0.bdstatic.com/a367e9334848fe281131e135610ccaa4.jpg@h_1280', NULL, '6f8b92cb210c64a7b56b6de6ba3315f5', NULL, '12134123', '213123', 0, '2024-03-01 14:54:03', '2024-03-01 14:54:03', 1, 0, NULL);
INSERT INTO `user` VALUES (5, 'foly', 'Tancy', 'https://b0.bdstatic.com/a367e9334848fe281131e135610ccaa4.jpg@h_1280', NULL, '6f8b92cb210c64a7b56b6de6ba3315f5', NULL, '', '', 0, '2024-03-01 14:57:45', '2024-03-01 14:57:45', 0, 0, NULL);
INSERT INTO `user` VALUES (6, 'kiroLoya', 'Kevin', 'https://b0.bdstatic.com/a367e9334848fe281131e135610ccaa4.jpg@h_1280', NULL, '6f8b92cb210c64a7b56b6de6ba3315f5', NULL, '', '', 0, '2024-03-04 13:05:49', '2024-03-04 13:05:49', 0, 2, NULL);
INSERT INTO `user` VALUES (7, 'kikyaya', 'kikyaya', 'https://b0.bdstatic.com/a367e9334848fe281131e135610ccaa4.jpg@h_1280', 0, '6f8b92cb210c64a7b56b6de6ba3315f5', NULL, '12234', '123123', 0, '2024-03-06 11:11:10', '2024-03-06 11:11:10', 0, 0, NULL);
INSERT INTO `user` VALUES (8, 'qweq', 'qweq', 'https://b0.bdstatic.com/a367e9334848fe281131e135610ccaa4.jpg@h_1280', 0, '6f8b92cb210c64a7b56b6de6ba3315f5', NULL, 'wqeqe', 'qweqeq', 0, '2024-03-06 14:02:51', '2024-03-06 14:02:51', 0, 0, NULL);

SET FOREIGN_KEY_CHECKS = 1;
