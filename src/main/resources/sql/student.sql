SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class_info
-- ----------------------------
DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `class_Name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of class_info
-- ----------------------------
BEGIN;
INSERT INTO `class_info` (`id`, `class_Name`) VALUES (1, '1901');
INSERT INTO `class_info` (`id`, `class_Name`) VALUES (2, '1902');
INSERT INTO `class_info` (`id`, `class_Name`) VALUES (3, '1903');
INSERT INTO `class_info` (`id`, `class_Name`) VALUES (4, '1904');
INSERT INTO `class_info` (`id`, `class_Name`) VALUES (5, '1905');
COMMIT;

-- ----------------------------
-- Table structure for major_info
-- ----------------------------
DROP TABLE IF EXISTS `major_info`;
CREATE TABLE `major_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `major_Name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of major_info
-- ----------------------------
BEGIN;
INSERT INTO `major_info` (`id`, `major_Name`) VALUES (1, '计科');
INSERT INTO `major_info` (`id`, `major_Name`) VALUES (2, '软工');
INSERT INTO `major_info` (`id`, `major_Name`) VALUES (3, '人工智能');
COMMIT;

-- ----------------------------
-- Table structure for manager_info
-- ----------------------------
DROP TABLE IF EXISTS `manager_info`;
CREATE TABLE `manager_info` (
  `mg_Id` int NOT NULL AUTO_INCREMENT,
  `mg_Name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mg_Password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`mg_Id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of manager_info
-- ----------------------------
BEGIN;
INSERT INTO `manager_info` (`mg_Id`, `mg_Name`, `mg_Password`) VALUES (1, 'root', 'root');
COMMIT;

-- ----------------------------
-- Table structure for student_info
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `stu_Id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stu_Name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stu_Gender` int NOT NULL,
  `stu_Age` int NOT NULL,
  `class_No` int NOT NULL,
  `stu_Major` int NOT NULL,
  PRIMARY KEY (`id`,`stu_Id`) USING BTREE,
  KEY `class_No` (`class_No`),
  KEY `stu_Major` (`stu_Major`),
  CONSTRAINT `student_info_ibfk_1` FOREIGN KEY (`class_No`) REFERENCES `class_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `student_info_ibfk_2` FOREIGN KEY (`stu_Major`) REFERENCES `major_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=1012 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of student_info
-- ----------------------------
BEGIN;
INSERT INTO `student_info` (`id`, `stu_Id`, `stu_Name`, `stu_Gender`, `stu_Age`, `class_No`, `stu_Major`) VALUES (1001, '20212160A0101', '宋江', 0, 21, 1, 1);
INSERT INTO `student_info` (`id`, `stu_Id`, `stu_Name`, `stu_Gender`, `stu_Age`, `class_No`, `stu_Major`) VALUES (1003, '20212160A0103', '吴用', 0, 20, 1, 2);
INSERT INTO `student_info` (`id`, `stu_Id`, `stu_Name`, `stu_Gender`, `stu_Age`, `class_No`, `stu_Major`) VALUES (1004, '20212160A0201', '公孙胜', 1, 20, 2, 3);
INSERT INTO `student_info` (`id`, `stu_Id`, `stu_Name`, `stu_Gender`, `stu_Age`, `class_No`, `stu_Major`) VALUES (1005, '20212160A0202', '关胜', 1, 22, 2, 2);
INSERT INTO `student_info` (`id`, `stu_Id`, `stu_Name`, `stu_Gender`, `stu_Age`, `class_No`, `stu_Major`) VALUES (1006, '20212160A0102', '卢俊义', 1, 20, 1, 3);
INSERT INTO `student_info` (`id`, `stu_Id`, `stu_Name`, `stu_Gender`, `stu_Age`, `class_No`, `stu_Major`) VALUES (1007, '20212160A0203', '林冲', 1, 20, 2, 1);
INSERT INTO `student_info` (`id`, `stu_Id`, `stu_Name`, `stu_Gender`, `stu_Age`, `class_No`, `stu_Major`) VALUES (1008, '20212160A0301', '秦明', 0, 21, 3, 1);
INSERT INTO `student_info` (`id`, `stu_Id`, `stu_Name`, `stu_Gender`, `stu_Age`, `class_No`, `stu_Major`) VALUES (1009, '20212160A0302', '呼延灼', 1, 22, 3, 3);
INSERT INTO `student_info` (`id`, `stu_Id`, `stu_Name`, `stu_Gender`, `stu_Age`, `class_No`, `stu_Major`) VALUES (1010, '20212160A0303', '花荣', 0, 21, 3, 2);
INSERT INTO `student_info` (`id`, `stu_Id`, `stu_Name`, `stu_Gender`, `stu_Age`, `class_No`, `stu_Major`) VALUES (1011, '20212160A0401', '柴进', 1, 20, 4, 3);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
