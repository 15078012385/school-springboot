/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : school_springboot

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 29/06/2022 14:50:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_admin
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin`;
CREATE TABLE `sys_admin`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `login_time` datetime NULL DEFAULT NULL COMMENT '上次登录时间',
  `avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'http://localhost:8080/images/img.png' COMMENT '头像URL',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `aphorism` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '格言',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_admin
-- ----------------------------
INSERT INTO `sys_admin` VALUES (1, 'admin', '4b1d1f4eb5af6ba088009d8835fcbd4c', '2017-10-06 02:43:28', 'http://localhost:8080/upload/7697a563f2ba4429856093488c650ac7.jpg', '(151) 100 36690', '须知少年青云志，何须人间第一人.');

-- ----------------------------
-- Table structure for sys_announcement
-- ----------------------------
DROP TABLE IF EXISTS `sys_announcement`;
CREATE TABLE `sys_announcement`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `publish_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发布时间',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 105 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_announcement
-- ----------------------------
INSERT INTO `sys_announcement` VALUES (104, '2022年-06月-29日', '完成项目~O(∩_∩)O哈哈~');

-- ----------------------------
-- Table structure for sys_class
-- ----------------------------
DROP TABLE IF EXISTS `sys_class`;
CREATE TABLE `sys_class`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '班级id',
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级名称',
  `student_count` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级人数',
  `teacher` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班主任',
  `grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属年级',
  `class_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级介绍',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `grade`(`grade` ASC) USING BTREE,
  INDEX `class_name`(`class_name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_class
-- ----------------------------
INSERT INTO `sys_class` VALUES (1, '谷粒一班', '56', '卧龙', '谷粒一年级', '除了自己，任何人都无法给你力量。没有口水与汗水，就没有成功的泪水。');
INSERT INTO `sys_class` VALUES (2, '谷粒二班', '46', '凤雏', '谷粒二年级', '此刻打盹，你将做梦；而此刻学习，你将圆梦！');
INSERT INTO `sys_class` VALUES (3, '谷粒三班', '64', '周瑜', '谷粒三年级', '祝你成功，成功之路始于脚下。');

-- ----------------------------
-- Table structure for sys_grade
-- ----------------------------
DROP TABLE IF EXISTS `sys_grade`;
CREATE TABLE `sys_grade`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '年级Id',
  `grade_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年级名称',
  `grade_teacher` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年级主任',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `grade_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年级介绍',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `grade_name`(`grade_name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_grade
-- ----------------------------
INSERT INTO `sys_grade` VALUES (1, '谷粒一年级', '疾风剑豪', '15070325485', '虽然读书也并不是唯一的出路，但高三的你一定要分清楚什么对你来说是最重要的。');
INSERT INTO `sys_grade` VALUES (2, '谷粒二年级', '狂战士', '15070325485', '同学们，努力吧！我们一定可以实现自己的梦想！');
INSERT INTO `sys_grade` VALUES (3, '谷粒三年级', '德玛西亚', '15070325485', '成功不是将来才有的，而是从决定去做的那一刻起，持续累积而成。');

-- ----------------------------
-- Table structure for sys_message
-- ----------------------------
DROP TABLE IF EXISTS `sys_message`;
CREATE TABLE `sys_message`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '留言Id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '留言用户',
  `message_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '留言内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 103 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_message
-- ----------------------------
INSERT INTO `sys_message` VALUES (1, '陶震南', 'After comparing data, the window shows the number of records that will be inserted,                 ');
INSERT INTO `sys_message` VALUES (2, 'Ng Wing Fat', 'If opportunity doesn’t knock, build a door. There is no way to happiness. Happiness is the way.');
INSERT INTO `sys_message` VALUES (3, '刘宇宁', 'To clear or reload various internal caches, flush tables, or acquire locks, control-click           ');
INSERT INTO `sys_message` VALUES (4, 'Willie Cox', 'Navicat Monitor requires a repository to store alerts and metrics for historical analysis.');
INSERT INTO `sys_message` VALUES (5, 'Kathryn Ortiz', 'I will greet this day with love in my heart. Navicat Monitor is a safe, simple and                  ');
INSERT INTO `sys_message` VALUES (6, 'Christina Edwards', 'It wasn’t raining when Noah built the ark.');
INSERT INTO `sys_message` VALUES (7, 'Mario Olson', 'The On Startup feature allows you to control what tabs appear when you launch Navicat.');
INSERT INTO `sys_message` VALUES (8, 'Sit Chiu Wai', 'After logged in the Navicat Cloud feature, the Navigation pane will be divided into                 ');
INSERT INTO `sys_message` VALUES (9, 'Wong Ching Wan', 'Actually it is just in an idea when feel oneself can achieve and cannot achieve.');
INSERT INTO `sys_message` VALUES (10, '潘云熙', 'Import Wizard allows you to import data to tables/collections from CSV, TXT, XML, DBF and more.     ');
INSERT INTO `sys_message` VALUES (102, '安妮', '嘿嘿~你很棒哦');

-- ----------------------------
-- Table structure for sys_student
-- ----------------------------
DROP TABLE IF EXISTS `sys_student`;
CREATE TABLE `sys_student`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '学生Id',
  `student_class` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属班级',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `avator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'http://localhost:8080/images/img.png' COMMENT '头像',
  `student_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '介绍',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `student_class`(`student_class` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_student
-- ----------------------------
INSERT INTO `sys_student` VALUES (1, '谷粒三班', '钟宇宁', 'http://localhost:8080/images/img.png', '207524901216', '男', '2f234a2f-6f9f-cee0-45c8-1ee9da88efda');
INSERT INTO `sys_student` VALUES (2, '谷粒二班', 'Troy Hayes', 'http://localhost:8080/images/img.png', '202131725523', '男', 'dc1252f2-9b9d-75fb-2dcc-8d6bc27f2a21');
INSERT INTO `sys_student` VALUES (3, '谷粒一班', 'Jimmy Holmes', 'http://localhost:8080/images/img.png', '202978898439', '男', '6fb86723-b785-840b-7840-685960e72770');
INSERT INTO `sys_student` VALUES (4, '谷粒三班', '范詩涵', 'http://localhost:8080/images/img.png', '205716488833', '女', 'f3e53605-dbaf-057f-03b7-59b23803773c');
INSERT INTO `sys_student` VALUES (5, '谷粒一班', '胡杰宏', 'http://localhost:8080/images/img.png', '202444688237', '男', '94f8474a-e1a9-e297-ff10-a5ffdf7b9c98');
INSERT INTO `sys_student` VALUES (6, '谷粒三班', 'Melissa Davis', 'http://localhost:8080/images/img.png', '206232499564', '女', 'a1ce3c58-69c2-2fbd-6ad6-75746f0aae54');
INSERT INTO `sys_student` VALUES (7, '谷粒三班', 'Gregory Rose', 'http://localhost:8080/images/img.png', '204918458058', '男', '226ee538-1794-439f-aee1-abdfe42122a9');
INSERT INTO `sys_student` VALUES (8, '谷粒二班', 'Ryan Price', 'http://localhost:8080/images/img.png', '205399749800', '男', 'a9083138-a652-0d22-2e61-850582064637');
INSERT INTO `sys_student` VALUES (9, '谷粒二班', 'Catherine Morales', 'http://localhost:8080/images/img.png', '202823543279', '女', '06aa2a18-b956-ca0b-fa2f-914d03e00933');
INSERT INTO `sys_student` VALUES (10, '谷粒一班', '许詩涵', 'http://localhost:8080/images/img.png', '204982221628', '女', '0f047f3f-36aa-046f-5e9d-06d055e250df');
INSERT INTO `sys_student` VALUES (11, '谷粒三班', 'Eleanor Guzman', 'http://localhost:8080/images/img.png', '200248774596', '女', 'f9f26285-d262-ff26-31b3-3914a6ff6b66');
INSERT INTO `sys_student` VALUES (12, '谷粒二班', '侯璐', 'http://localhost:8080/images/img.png', '203563414292', '女', '7eff301b-835b-93e0-10fc-f69d43bc5238');
INSERT INTO `sys_student` VALUES (13, '谷粒三班', '阎震南', 'http://localhost:8080/images/img.png', '202595723738', '男', 'eae43483-ba9e-b32a-6f11-e94381d51bbc');
INSERT INTO `sys_student` VALUES (14, '谷粒三班', 'Daniel Fox', 'http://localhost:8080/images/img.png', '207361324277', '男', '523989cd-deeb-c08f-c16d-0b08e88701ea');
INSERT INTO `sys_student` VALUES (15, '谷粒三班', 'Lillian Palmer', 'http://localhost:8080/images/img.png', '204406700076', '女', 'c00808b3-a565-9162-016e-1d9f72b29194');
INSERT INTO `sys_student` VALUES (16, '谷粒三班', 'Lawrence Martin', 'http://localhost:8080/images/img.png', '204850583330', '男', 'ec8c4ea6-49b2-0216-4c6c-513b0a570b56');
INSERT INTO `sys_student` VALUES (17, '谷粒三班', 'Aaron Simmons', 'http://localhost:8080/images/img.png', '207159604571', '男', '70b32c0b-5f14-f655-f2a1-7c297f8b658e');
INSERT INTO `sys_student` VALUES (18, '谷粒三班', 'Roger Black', 'http://localhost:8080/images/img.png', '204841626359', '男', '9cff2574-f195-8f41-6b9d-0736310398e8');
INSERT INTO `sys_student` VALUES (19, '谷粒二班', 'Andrew Mason', 'http://localhost:8080/images/img.png', '202057938611', '男', '6d5af591-6abe-cace-1080-84c4f473a2aa');
INSERT INTO `sys_student` VALUES (20, '谷粒一班', 'Wayne Crawford', 'http://localhost:8080/images/img.png', '205934225221', '男', '0a413230-ddb8-2d9b-be0f-3617c1a83889');

-- ----------------------------
-- Table structure for sys_teacher
-- ----------------------------
DROP TABLE IF EXISTS `sys_teacher`;
CREATE TABLE `sys_teacher`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '教师id',
  `teach_class` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任课班级',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师姓名',
  `avator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'http://localhost:8080/images/img.png' COMMENT '教师头像',
  `work_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工号',
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `teach_class`(`teach_class` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_teacher
-- ----------------------------
INSERT INTO `sys_teacher` VALUES (1, '谷粒一班', 'Louise Hall', 'http://localhost:8080/images/img.png', '89f69947-f921-bfed-4212-fac19a216b04', '女');
INSERT INTO `sys_teacher` VALUES (2, '谷粒三班', 'Howard Ramos', 'http://localhost:8080/images/img.png', '37644a1e-8b02-9fde-68f4-c7d693d67624', '男');
INSERT INTO `sys_teacher` VALUES (3, '谷粒三班', '郭晓明', 'http://localhost:8080/images/img.png', '0ff37b6b-831d-4fa1-9509-15e34937ece6', '男');
INSERT INTO `sys_teacher` VALUES (4, '谷粒二班', 'Tracy Rodriguez', 'http://localhost:8080/images/img.png', '219b040c-38e4-e7b2-6409-8ab1d3734b9e', '女');
INSERT INTO `sys_teacher` VALUES (5, '谷粒一班', '魏云熙', 'http://localhost:8080/images/img.png', '802fef11-713c-e350-732b-f36981a75ebe', '男');
INSERT INTO `sys_teacher` VALUES (6, '谷粒二班', 'Wayne Porter', 'http://localhost:8080/images/img.png', 'c46d366d-6ff1-b10d-0a83-ca71d0d07c4b', '男');
INSERT INTO `sys_teacher` VALUES (7, '谷粒一班', 'James Butler', 'http://localhost:8080/images/img.png', 'ddef0d5d-c64a-8ece-e225-34b7ca680834', '男');
INSERT INTO `sys_teacher` VALUES (8, '谷粒二班', '汪嘉伦', 'http://localhost:8080/images/img.png', 'bb66f84d-7664-e7d4-0d7f-c5fbc144b482', '男');
INSERT INTO `sys_teacher` VALUES (9, '谷粒一班', '郝宇宁', 'http://localhost:8080/images/img.png', '308a52f8-22cb-1639-db49-b2b0bc5d4a36', '男');
INSERT INTO `sys_teacher` VALUES (10, '谷粒三班', 'Pamela Moreno', 'http://localhost:8080/images/img.png', 'adc93057-ee9b-7f8a-9dc6-cbc547cf632a', '女');

SET FOREIGN_KEY_CHECKS = 1;
