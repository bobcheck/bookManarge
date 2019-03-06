-- 取消外键约束
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- 建立user表单
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `R_id` int(13) NOT NULL AUTO_INCREMENT,
  `R_Name` varchar(255) NOT NULL,
  `R_Gender` int(2) DEFAULT NULL,
  `R_Pwd` varchar(255) Not NULL,
  `R_Create` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `R_Img` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`R_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
--- 插入用户数据6条
-- ----------------------------
INSERT INTO user(R_Name, R_Pwd) VALUES ('lgy', '734190426');
INSERT INTO user(R_Name, R_Pwd) VALUES ('superliu', '734190426l');
INSERT INTO user(R_Name, R_Pwd) VALUES ('test1', '734190426l');
INSERT INTO user(R_Name, R_Pwd) VALUES ('test2', '734190426l');
INSERT INTO user(R_Name, R_Pwd) VALUES ('test3', '734190426l');
INSERT INTO user(R_Name, R_Pwd) VALUES ('test4', '734190426l');


-- ----------------------------
--- 角色表单创建sql语句
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_Id` int(13) NOT NULL AUTO_INCREMENT,
  `role_Name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `role_Desc` varchar(500) DEFAULT NULL COMMENT '角色描述',
	`create_Time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`role_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
--- 权限表单创建语句
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `P_Id` int(13) NOT NULL AUTO_INCREMENT,
  `P_Name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `P_URL` varchar(300) DEFAULT NULL COMMENT '权限URL',
	`create_Time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`P_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
--- 创建关联表单
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `uid` int(13) DEFAULT NULL COMMENT '用户ID',
  `rid` int(13) DEFAULT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `rid` int(13) DEFAULT NULL COMMENT '角色ID',
  `pid` int(13) DEFAULT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--- 插入角色数据 普通用户 教师  管理员
-- ----------------------------
INSERT INTO role(role_Name, role_Desc) VALUES ('gen_user', '普通的用户注册即可');
INSERT INTO role(role_Name, role_Desc) VALUES ('teacher', '教师用户,能够借阅更多的书籍');
INSERT INTO role(role_Name, role_Desc) VALUES ('manager', '管理员用户,只能通过后台生成用户');


-- ----------------------------
--- 插入权限数据 对应管理员的查看和管理所有用户  而普通的用户则只能修改和查看自己的数据
-- ----------------------------
INSERT INTO permission(P_Name, P_URL) VALUES ('用户管理只应该有管理员拥有,对应查看删除修改编辑其他用户', '/users/*');
INSERT INTO permission(P_Name, P_URL) VALUES ('对自己的数据进行增删改查', '/users/selfInfo');

-- ----------------------------
--- 向关联表中插入数据 对应管理员角色拥有所有的权限
-- ----------------------------
INSERT INTO `role_permission` (`rid`,`pid`) VALUES (3,1);
INSERT INTO `role_permission` (`rid`,`pid`) VALUES (3,2);


-- ----------------------------
--- 向关联表用户角色中插入数据  对应管理员角色
-- ----------------------------
INSERT INTO `user_role` (`uid`,`rid`) VALUES (1,3);

