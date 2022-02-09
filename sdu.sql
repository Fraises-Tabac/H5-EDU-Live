/*
 Navicat Premium Data Transfer

 Source Server         : h5
 Source Server Type    : MySQL
 Source Server Version : 100119
 Source Host           : localhost:3306
 Source Schema         : sdu

 Target Server Type    : MySQL
 Target Server Version : 100119
 File Encoding         : 65001

 Date: 09/02/2022 17:05:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for banned
-- ----------------------------
DROP TABLE IF EXISTS `banned`;
CREATE TABLE `banned`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `course_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lecture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `depiction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pubdate` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'record',
  `video` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `duration` int(10) NOT NULL DEFAULT 0,
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 'Java基础', '马士兵', 'Java基础课，深入浅出让你21天精通Java', '2019-07-14 16:31:59', 'record', '/stat/assets/video/1.mp4', 'CS; Java', '/stat/assets/images/course/1.jpg', 9571);
INSERT INTO `course` VALUES (2, 'IOS8开发', '乔布斯', '基于swift实战UI初级课程图片展示案例', '2019-07-14 16:36:40', 'live', '', '水课', '/stat/assets/images/course/2.jpg', 9890);
INSERT INTO `course` VALUES (3, 'Oeasy', '王老师', '暂无', '2019-07-14 16:31:37', 'record', '/stat/assets/video/3.mp4', 'CS; Java', '/stat/assets/images/course/3.jpg', 10546);
INSERT INTO `course` VALUES (4, 'Cocos2Dx', '王老师', '暂无', '2019-07-14 16:36:45', 'record', '', 'CS; iOS', '/stat/assets/images/course/4.jpg', 12870);
INSERT INTO `course` VALUES (5, 'Android开发', '王老师', 'Android实战开发之数独篇', '2019-07-14 16:36:47', 'record', '', 'CS; Android', '/stat/assets/images/course/5.jpg', 8997);
INSERT INTO `course` VALUES (6, 'iOS游戏开发之愤怒的小鸟', '王老师', '经典的愤怒的小鸟开发教程！', '2019-07-14 16:36:49', 'record', '', 'CS; IOS', '/stat/assets/images/course/6.jpg', 7908);
INSERT INTO `course` VALUES (7, 'Android 4.0开发', '张蓉蓉', '手把手教你如何摸鱼', '2019-07-14 16:37:08', 'record', '', '摸鱼', '/stat/assets/images/course/7.jpg', 8919);
INSERT INTO `course` VALUES (20, ' 111', '老师', '111111', '2019-07-14 20:53:18', 'record', '/stat/assets/video/6a91f9890ef54ddd8580c9dd01e0b8e9.mp4', ' 111', '/stat/assets/images/course/78774cb2458045cb81d12c6abaa1c073.jpg', 111);
INSERT INTO `course` VALUES (21, ' 2222', '老师', '2222', '2019-07-14 20:53:50', 'live', NULL, ' 222', '/stat/assets/images/course/fe64ff82934f452e9f76e8b229b47745.jpg', 2222);

-- ----------------------------
-- Table structure for course_live
-- ----------------------------
DROP TABLE IF EXISTS `course_live`;
CREATE TABLE `course_live`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NOT NULL,
  `stream` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course_live
-- ----------------------------
INSERT INTO `course_live` VALUES (1, 2, 'stream1562829361579');
INSERT INTO `course_live` VALUES (2, 15, 'stream1563107057119');
INSERT INTO `course_live` VALUES (3, 21, 'stream1563108832876');

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam`  (
  `time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '发布考试的时间',
  `duration` int(11) NOT NULL DEFAULT 0,
  `course_id` int(11) NOT NULL DEFAULT 0,
  `solutions` blob NULL COMMENT '每题的答案',
  `picurl` blob NULL COMMENT '每题的图片地址',
  `max_score` int(11) NOT NULL DEFAULT 0,
  `subtitle_score` blob NULL,
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES ('0000-00-00 00:00:00', 0, 0, NULL, NULL, 0, NULL);
INSERT INTO `exam` VALUES ('2019-06-28 00:00:00', 60, 1, NULL, NULL, 100, NULL);
INSERT INTO `exam` VALUES ('2019-06-28 14:44:48', 60, 2, NULL, NULL, 100, NULL);
INSERT INTO `exam` VALUES ('2019-06-28 16:07:16', 60, 3, NULL, NULL, 100, NULL);
INSERT INTO `exam` VALUES ('2019-06-28 16:07:37', 60, 4, NULL, NULL, 100, NULL);
INSERT INTO `exam` VALUES ('2019-07-03 16:49:38', 5, 33, NULL, NULL, 100, NULL);
INSERT INTO `exam` VALUES ('2019-07-03 16:51:30', 1, 44, NULL, NULL, 88, NULL);

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = MyISAM CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (1);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sender_id` int(11) NOT NULL,
  `receiver_id` int(11) NOT NULL,
  `content` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'unread',
  `time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `post_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `heat` int(10) NULL DEFAULT NULL COMMENT '热度',
  `body` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `pubtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `latest_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `like` int(10) NULL DEFAULT 0,
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (1, '怎样学习java', '小可爱', 13, '大家好，我想知道怎样学习Java', '2019-07-11 12:50:58', '2019-07-11 13:38:57', 3);
INSERT INTO `post` VALUES (4, 'test', '老师', 0, 'test', '2019-07-12 20:00:01', '2019-07-12 20:00:02', 0);
INSERT INTO `post` VALUES (5, '标题', '老师', 0, '测试发帖', '2019-07-12 20:00:02', '2019-07-12 20:00:03', 0);
INSERT INTO `post` VALUES (8, 'test', '老师', 0, 'tettt', '2019-07-12 20:48:19', '2019-07-12 20:48:19', 0);
INSERT INTO `post` VALUES (9, '测试', '新用户', 0, '测试！！！', '2019-07-14 13:31:12', '2019-07-14 13:31:12', 0);
INSERT INTO `post` VALUES (10, '测试', '小可爱', 0, '这是测试', '2019-07-14 19:28:48', '2019-07-14 19:28:48', 0);
INSERT INTO `post` VALUES (15, '测试发帖', '新用户', 0, '这是一条测试', '2019-07-14 20:52:00', '2019-07-14 20:52:00', 0);

-- ----------------------------
-- Table structure for post_response
-- ----------------------------
DROP TABLE IF EXISTS `post_response`;
CREATE TABLE `post_response`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `post_id` int(11) NOT NULL,
  `res_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of post_response
-- ----------------------------
INSERT INTO `post_response` VALUES (1, 1, 10001);
INSERT INTO `post_response` VALUES (2, 1, 10002);
INSERT INTO `post_response` VALUES (3, 1, 10003);
INSERT INTO `post_response` VALUES (4, 1, 10004);
INSERT INTO `post_response` VALUES (5, 1, 10005);

-- ----------------------------
-- Table structure for response
-- ----------------------------
DROP TABLE IF EXISTS `response`;
CREATE TABLE `response`  (
  `res_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `responder` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '回复者',
  `respond_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `like` int(10) NULL DEFAULT 0,
  `p_id` int(11) NOT NULL,
  `dislike` int(11) NOT NULL,
  PRIMARY KEY (`res_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10006 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of response
-- ----------------------------
INSERT INTO `response` VALUES (10001, '王老师', '2019-07-11 13:29:12', '多看书', 0, 1, 0);
INSERT INTO `response` VALUES (10002, '乔布斯', '2019-07-11 13:29:15', '多吃苹果', 0, 1, 0);
INSERT INTO `response` VALUES (10003, '小可爱', '2019-07-11 13:29:17', '啊非常感谢！', 0, 1, 0);
INSERT INTO `response` VALUES (10004, '超帅的王子硕', '2019-07-11 13:29:18', '看视频学习', 0, 1, 0);
INSERT INTO `response` VALUES (10005, '王小硕', '2019-07-11 13:29:20', '啊Java是什么T_T', 0, 1, 0);

-- ----------------------------
-- Table structure for stu_course
-- ----------------------------
DROP TABLE IF EXISTS `stu_course`;
CREATE TABLE `stu_course`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'unread',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of stu_course
-- ----------------------------
INSERT INTO `stu_course` VALUES (2, 1, '小可爱', 'unread');
INSERT INTO `stu_course` VALUES (5, 2, '小可爱', 'unread');
INSERT INTO `stu_course` VALUES (6, 4, '小可爱', 'unread');
INSERT INTO `stu_course` VALUES (7, 5, '小可爱', 'unread');
INSERT INTO `stu_course` VALUES (8, 6, '小可爱', 'unread');
INSERT INTO `stu_course` VALUES (10, 7, '小可爱', 'unread');
INSERT INTO `stu_course` VALUES (11, 2, '小可爱', 'unread');
INSERT INTO `stu_course` VALUES (12, 1, '老师', 'unread');
INSERT INTO `stu_course` VALUES (13, 8, '小可爱', 'unread');
INSERT INTO `stu_course` VALUES (18, 3, '新用户', 'unread');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `attr` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT 'student',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mobile` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'null',
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `gender` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT 'none',
  `birthday` date NULL DEFAULT NULL,
  `profile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个人简介',
  `mail` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `mobile`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'student', '小可爱', '555555', NULL, '$2a$10$fhl81wdGeNMxSgmyfrQL9OBQofsl25xV0J92w1G7k1U9raiaNalbq', 'none', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (2, 'teacher', '老师', '666666', NULL, '$2a$10$Mp6HG0qfFNY0PUMxj9habeOTlaMYdLK86/vOBXDLcqafNQvUl.C22', 'none', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (4, 'teacher', '马士兵', '11111111111', 'Java', '123456', 'none', NULL, 'Java专业引路人', NULL, NULL, '跟我学就对了');
INSERT INTO `user` VALUES (5, 'teacher', '王老师', '11111111111', '啥都教', '123456', 'none', NULL, '我真的啥都教', NULL, NULL, '我真的什么都会');
INSERT INTO `user` VALUES (6, 'teacher', '乔布斯', '11111111111', 'IOS', '123456', 'none', NULL, 'Apple创始人', NULL, NULL, '边学边写很重要');
INSERT INTO `user` VALUES (14, 'student', '新用户', '18340018510', NULL, '$2a$10$/PalGaokCUnxFZwEc6ZV8.VlyfApkTy/jgs8RTgkukmJCSjD/jBVe', 'none', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_exam
-- ----------------------------
DROP TABLE IF EXISTS `user_exam`;
CREATE TABLE `user_exam`  (
  `course_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `answers` longblob NULL COMMENT '用户解答',
  `sub_score` blob NULL,
  `total_score` int(11) NULL DEFAULT NULL COMMENT '总分',
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_exam
-- ----------------------------
INSERT INTO `user_exam` VALUES (1, 1, NULL, NULL, 100, 1);

SET FOREIGN_KEY_CHECKS = 1;
