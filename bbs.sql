/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50632
Source Host           : localhost:3306
Source Database       : bbs

Target Server Type    : MYSQL
Target Server Version : 50632
File Encoding         : 65001

Date: 2018-01-19 13:07:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `post_id` int(10) NOT NULL,
  `body` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CPID` (`post_id`),
  KEY `FK_CUID` (`user_id`),
  CONSTRAINT `FK_CPID` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_CUID` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES ('1', '1', '11', '123456', '2018-01-18 14:45:20', null);
INSERT INTO `comments` VALUES ('2', '1', '11', 'hhhhhhhhh\r\nh\r\nh\r\nh\r\nh', '2018-01-18 15:24:27', null);
INSERT INTO `comments` VALUES ('3', '1', '13', '123', '2018-01-18 17:41:31', null);
INSERT INTO `comments` VALUES ('4', '1', '13', '12312341234', '2018-01-18 17:41:50', null);
INSERT INTO `comments` VALUES ('5', '1', '13', '12312341234', '2018-01-18 17:44:12', null);
INSERT INTO `comments` VALUES ('6', '1', '13', '1231234123444\r<br />dgfdfg\r<br />sdfg哈哈2', '2018-01-18 17:48:17', null);
INSERT INTO `comments` VALUES ('7', '1', '15', '123', '2018-01-18 20:16:53', null);
INSERT INTO `comments` VALUES ('8', '1', '15', '1234', '2018-01-18 20:17:03', null);
INSERT INTO `comments` VALUES ('9', '1', '15', '123', '2018-01-18 21:48:17', null);
INSERT INTO `comments` VALUES ('10', '2', '15', '123', '2018-01-18 21:54:52', null);
INSERT INTO `comments` VALUES ('11', '2', '15', '123', '2018-01-18 21:55:44', null);
INSERT INTO `comments` VALUES ('12', '2', '15', '123\r<br />hahaha哈哈哈', '2018-01-18 21:56:44', null);
INSERT INTO `comments` VALUES ('13', '2', '15', '123', '2018-01-18 22:10:35', null);
INSERT INTO `comments` VALUES ('14', '2', '13', '55\r<br />1\r<br />1\r<br />1', '2018-01-18 22:14:13', null);
INSERT INTO `comments` VALUES ('15', '2', '13', '法国红酒小', '2018-01-18 22:15:48', null);
INSERT INTO `comments` VALUES ('16', '2', '21', '123123', '2018-01-18 22:25:19', null);
INSERT INTO `comments` VALUES ('17', '2', '21', '123555', '2018-01-18 22:59:30', null);
INSERT INTO `comments` VALUES ('18', '2', '21', '4asdf', '2018-01-18 23:32:55', null);
INSERT INTO `comments` VALUES ('19', '2', '28', '123', '2018-01-19 12:53:36', null);

-- ----------------------------
-- Table structure for posts
-- ----------------------------
DROP TABLE IF EXISTS `posts`;
CREATE TABLE `posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `section_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `body` text NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_PSID` (`section_id`),
  KEY `FK_PUID` (`user_id`),
  CONSTRAINT `FK_PSID` FOREIGN KEY (`section_id`) REFERENCES `sections` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_PUID` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of posts
-- ----------------------------
INSERT INTO `posts` VALUES ('2', '1', '1', '123', '123', '2018-01-17 23:45:21', null);
INSERT INTO `posts` VALUES ('3', '1', '1', '12345', '12345\r<br />sdfg\r<br />1234', '2018-01-18 00:05:24', null);
INSERT INTO `posts` VALUES ('4', '1', '1', '12345', '12345\r\nsdfg\r\n1234\r\n45645', '2018-01-18 00:06:13', null);
INSERT INTO `posts` VALUES ('5', '1', '1', '123', '### Hello Editor.md !\r\n\r\n123\r\nasdfasd', '2018-01-18 00:14:10', null);
INSERT INTO `posts` VALUES ('6', '1', '1', '123', '123\r<br />asdf\r<br />asdf', '2018-01-18 00:25:02', null);
INSERT INTO `posts` VALUES ('10', '1', '1', '你好啊，你好你好', '<%-- Declare the core library --%>\r<br />    <%@ taglib uri=\"/WEB-INF/tld/c.tld\" prefix=\"c\" %>\r<br />    \r<br />    <c:choose>\r<br />        <c:when test=\"${empty param.name}\">\r<br />            Please enter your name.\r<br />        </c:when>\r<br />        <c:otherwise>\r<br />            Hello <b><c:out value=\"${param.name}\" /></b>!\r<br />        </c:otherwise>\r<br />    </c:choose>', '2018-01-18 01:16:19', null);
INSERT INTO `posts` VALUES ('11', '1', '1', 'Flask学习记录', '学习Flask差不多两个月了，说起来主要是为了帮忙做一个外包。整个过程就是不断调整需求，看书，查文档，实践的循环。参考书主要是安道翻译《Flask Web开发：基于Python的Web应用开发实战》。现在也是个入门级水平，对于flask request 获取参数进行一个总结。\r<br />\r<br />知识点：\r<br />\r<br />request请求总体分为两类：\r<br />\r<br />1.get请求 \r<br />\r<br />访问时会在地址栏直接显示参数不安全，且参数大小比较小。\r<br />\r<br />2.post请求 \r<br />\r<br />参数不显示在地址栏，一般用户注册、登录都通过post请求完成。\r<br />\r<br />flask获取参数方式：\r<br />\r<br />request.form.get(\"key\", type=str, default=None) 获取表单数据\r<br />\r<br />request.args.get(\"key\") 获取get请求参数\r<br />\r<br />request.values.get(\"key\") 获取所有参数\r<br />\r<br />本文主要介绍以上三种方式，其次也有获取解析json数据格式，request.get_json()，这里不进行详细介绍了。\r<br />\r<br />\r<br />\r<br />下面直接开始试验，以用户注册为例：\r<br />\r<br />需要获取四个参数：用户手机号、密码、校验密码、手机验证码\r<br />\r<br />mobile = request.form.get(\"mobile\")\r<br />\r<br />password = request.form.get(\"password\",type=str,default=None)\r<br />\r<br />password_repeat = request.form.get(\"password_repeat\",type=str,default=None)\r<br />\r<br />mobile_code = request.form.get(\"mobile_code\",type=str,default=None)', '2018-01-18 01:17:30', null);
INSERT INTO `posts` VALUES ('12', '1', '1', 'Flask学习记录', '学习Flask差不多两个月了，说起来主要是为了帮忙做一个外包。整个过程就是不断调整需求，看书，查文档，实践的循环。参考书主要是安道翻译《Flask Web开发：基于Python的Web应用开发实战》。现在也是个入门级水平，对于flask request 获取参数进行一个总结。\r<br />\r<br />知识点：\r<br />\r<br />request请求总体分为两类：\r<br />\r<br />1.get请求 \r<br />\r<br />访问时会在地址栏直接显示参数不安全，且参数大小比较小。\r<br />\r<br />2.post请求 \r<br />\r<br />参数不显示在地址栏，一般用户注册、登录都通过post请求完成。\r<br />\r<br />flask获取参数方式：\r<br />\r<br />request.form.get(\"key\", type=str, default=None) 获取表单数据\r<br />\r<br />request.args.get(\"key\") 获取get请求参数\r<br />\r<br />request.values.get(\"key\") 获取所有参数\r<br />\r<br />本文主要介绍以上三种方式，其次也有获取解析json数据格式，request.get_json()，这里不进行详细介绍了。\r<br />\r<br />\r<br />\r<br />下面直接开始试验，以用户注册为例：\r<br />\r<br />需要获取四个参数：用户手机号、密码、校验密码、手机验证码\r<br />\r<br />mobile = request.form.get(\"mobile\")\r<br />\r<br />password = request.form.get(\"password\",type=str,default=None)\r<br />\r<br />password_repeat = request.form.get(\"password_repeat\",type=str,default=None)\r<br />\r<br />mobile_code = request.form.get(\"mobile_code\",type=str,default=None)', '2018-01-18 01:42:11', null);
INSERT INTO `posts` VALUES ('13', '1', '1', 'Flask学习记录', '学习Flask差不多两个月了，说起来主要是为了帮忙做一个外包。整个过程就是不断调整需求，看书，查文档，实践的循环。参考书主要是安道翻译《Flask Web开发：基于Python的Web应用开发实战》。现在也是个入门级水平，对于flask request 获取参数进行一个总结。\r<br />\r<br />知识点：\r<br />\r<br />request请求总体分为两类：\r<br />\r<br />1.get请求 \r<br />\r<br />访问时会在地址栏直接显示参数不安全，且参数大小比较小。\r<br />\r<br />2.post请求 \r<br />\r<br />参数不显示在地址栏，一般用户注册、登录都通过post请求完成。\r<br />\r<br />flask获取参数方式：\r<br />\r<br />request.form.get(\"key\", type=str, default=None) 获取表单数据\r<br />\r<br />request.args.get(\"key\") 获取get请求参数\r<br />\r<br />request.values.get(\"key\") 获取所有参数\r<br />\r<br />本文主要介绍以上三种方式，其次也有获取解析json数据格式，request.get_json()，这里不进行详细介绍了。\r<br />\r<br />\r<br />\r<br />下面直接开始试验，以用户注册为例：\r<br />\r<br />需要获取四个参数：用户手机号、密码、校验密码、手机验证码\r<br />\r<br />mobile = request.form.get(\"mobile\")\r<br />\r<br />password = request.form.get(\"password\",type=str,default=None)\r<br />\r<br />password_repeat = request.form.get(\"password_repeat\",type=str,default=None)\r<br />\r<br />mobile_code = request.form.get(\"mobile_code\",type=str,default=None)', '2018-01-18 01:42:14', null);
INSERT INTO `posts` VALUES ('15', '1', '1', '123', '123', '2018-01-18 20:08:46', null);
INSERT INTO `posts` VALUES ('21', '1', '3', '你好，世界', '你好世界！', '2018-01-18 22:23:21', null);
INSERT INTO `posts` VALUES ('23', '2', '7', '哈哈哈', '干干干干干过过过', '2018-01-19 01:34:10', null);
INSERT INTO `posts` VALUES ('25', '2', '3', '哇，好像就要接近胜利了呢！', '好像就要接近胜利了呀！！！', '2018-01-19 02:11:38', null);
INSERT INTO `posts` VALUES ('28', '2', '1', '哇，好像就要接近胜利了呢！123', '好像就要接近胜利了呀！！！213213', '2018-01-19 02:56:06', null);

-- ----------------------------
-- Table structure for sections
-- ----------------------------
DROP TABLE IF EXISTS `sections`;
CREATE TABLE `sections` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `manager_id` int(11) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SM_ID` (`manager_id`),
  CONSTRAINT `FK_SM_ID` FOREIGN KEY (`manager_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sections
-- ----------------------------
INSERT INTO `sections` VALUES ('1', '校园生活', '1', null);
INSERT INTO `sections` VALUES ('3', '日常琐事', '1', null);
INSERT INTO `sections` VALUES ('4', '音乐快车', '1', null);
INSERT INTO `sections` VALUES ('5', '那些事儿', '1', null);
INSERT INTO `sections` VALUES ('6', '幽默乐园', '1', null);
INSERT INTO `sections` VALUES ('7', '科技活动', '1', '1');
INSERT INTO `sections` VALUES ('8', '你问我答', '1', '1');
INSERT INTO `sections` VALUES ('9', '美食美味', '1', '3');
INSERT INTO `sections` VALUES ('10', '告白墙', '1', '3');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'Test', '123@123.com', '123', '123.png', '2018-01-17 22:16:00', '2018-01-17 22:16:03');
INSERT INTO `users` VALUES ('2', '123', '123@123.com', '202cb962ac59075b964b07152d234b70', null, null, null);
INSERT INTO `users` VALUES ('3', 'HoHoibin', 'hhb_1997@126.com', '994224ef696b01d0e30b2ba901a9338e', null, null, null);
