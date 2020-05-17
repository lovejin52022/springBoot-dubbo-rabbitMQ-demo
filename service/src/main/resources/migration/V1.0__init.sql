SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `age` int(11) DEFAULT NULL,
    `address` varchar(255) DEFAULT NULL,
    `class_id` bigint(20) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `class_id` (`class_id`),
    CONSTRAINT `class_id` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '张三', '23', '湖南衡阳', '1');
INSERT INTO `t_user` VALUES ('2', '历史', '89', '上海浦东', '2');
INSERT INTO `t_user` VALUES ('3', '王力宏', '35', '中国台湾', '3');
INSERT INTO `t_user` VALUES ('4', 'admin', '99', '中国北京', '4');