/*
SQLyog v10.2 
MySQL - 5.5.19 : Database - zdy_chat
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`zdy_chat` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `zdy_chat`;

/*Table structure for table `data_parameter` */

DROP TABLE IF EXISTS `data_parameter`;

CREATE TABLE `data_parameter` (
  `data_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_code` varchar(30) DEFAULT NULL,
  `data_value` varchar(100) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `create_user` bigint(20) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `oper_user` bigint(20) DEFAULT NULL,
  `oper_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`data_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `data_parameter` */

/*Table structure for table `dic_value` */

DROP TABLE IF EXISTS `dic_value`;

CREATE TABLE `dic_value` (
  `dic_value_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典值主键',
  `value_name` varchar(50) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '名称',
  `value_code` varchar(20) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT 'code',
  `dic_id` bigint(20) DEFAULT NULL COMMENT '字典表主键',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `alive_flag` int(4) DEFAULT NULL COMMENT '是否有效 1有效 0 无效',
  PRIMARY KEY (`dic_value_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_estonian_ci;

/*Data for the table `dic_value` */

/*Table structure for table `dictionary` */

DROP TABLE IF EXISTS `dictionary`;

CREATE TABLE `dictionary` (
  `dictionary_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据字典书剑',
  `dic_name` varchar(30) DEFAULT NULL COMMENT '名称',
  `dic_code` varchar(50) DEFAULT NULL COMMENT '字典code 创建后不能修改',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `alive_flag` int(4) DEFAULT '1' COMMENT '是否有效 1有效 0无效',
  PRIMARY KEY (`dictionary_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `dictionary` */

insert  into `dictionary`(`dictionary_id`,`dic_name`,`dic_code`,`create_user`,`create_time`,`alive_flag`) values (4,'测试呢001','test001','1',1464357347785,1),(5,'测试呢002','test002','1',1464357393428,0),(6,'teg001','teg002','1',1464357405675,0),(7,'0011','1212','1',1464357438083,1),(8,'2333','333','1',1464357464730,1),(9,'22','嗯嗯','1',1464357488540,1),(10,'2防守打法的','sdf','1',1464357576267,1),(11,'2防守打法的','sdf','1',1464357606846,1),(12,'双方的发生的','都是','1',1464357657519,1),(13,'嗯嗯','二','1',1464357710718,1),(14,'嗯嗯','二','1',1464357715078,1),(15,'','','1',1464359181192,1),(16,'曲儿','请问','1',1464360479684,1),(17,'cwefr','13','1',1464408424628,1),(18,'cwefr','1333','1',1464408443981,1),(19,'231','23333333333','1',1464409744945,1);

/*Table structure for table `file_info` */

DROP TABLE IF EXISTS `file_info`;

CREATE TABLE `file_info` (
  `file_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `file_url` varchar(200) NOT NULL COMMENT 'url',
  `file_name` varchar(200) DEFAULT NULL COMMENT '文件名 uuid',
  `upload_code` varchar(32) DEFAULT NULL COMMENT '文件code',
  `create_user` bigint(20) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `alive_flag` int(1) DEFAULT NULL COMMENT '0 无效 1有效',
  `oper_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`file_id`,`file_url`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `file_info` */

/*Table structure for table `friend` */

DROP TABLE IF EXISTS `friend`;

CREATE TABLE `friend` (
  `friend_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `a_user_id` varchar(20) DEFAULT NULL,
  `b_user_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`friend_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `friend` */

/*Table structure for table `tbl_menu` */

DROP TABLE IF EXISTS `tbl_menu`;

CREATE TABLE `tbl_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu_name` varchar(20) DEFAULT NULL COMMENT '菜单名',
  `menu_url` varchar(100) DEFAULT NULL COMMENT '菜单链接地址',
  `parent_id` varchar(20) DEFAULT NULL COMMENT '父级菜单id',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `menu_rank` int(2) DEFAULT NULL COMMENT '菜单级别',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `alive_flag` int(4) DEFAULT '0' COMMENT '是否有效 1有效 0 无效',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_menu` */

insert  into `tbl_menu`(`menu_id`,`menu_name`,`menu_url`,`parent_id`,`remark`,`menu_rank`,`create_user`,`create_time`,`alive_flag`) values (2,'菜单管理','admin/menumgr/tomenumgrpage','3','菜单管理',2,1,1464419519957,1),(3,'网站管理','admin/switch/witemgr','','网站管理',1,1,1464422392418,1),(9,'数据字典','admin/dictionary/dictionarypage','3','数据字典',2,1,1464428199810,1),(12,'首页','admin/index','3','admin/index',2,1,1464430031221,1),(13,'角色管理','admin/role/toRolePage','3','角色管理',2,1,1464700527772,1);

/*Table structure for table `tbl_menuinfo` */

DROP TABLE IF EXISTS `tbl_menuinfo`;

CREATE TABLE `tbl_menuinfo` (
  `minfo_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(20) DEFAULT NULL,
  `menu_url` varchar(100) DEFAULT NULL,
  `parent_id` varchar(20) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `menu_rank` int(2) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` bigint(20) DEFAULT NULL,
  `alive_flag` int(11) DEFAULT '0' COMMENT '1有效 0无效',
  `menu_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`minfo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_menuinfo` */

/*Table structure for table `tbl_role` */

DROP TABLE IF EXISTS `tbl_role`;

CREATE TABLE `tbl_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `create_user` varchar(20) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `alive_flag` int(4) DEFAULT NULL COMMENT '1 有效 0无效',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_role` */

/*Table structure for table `tbl_user` */

DROP TABLE IF EXISTS `tbl_user`;

CREATE TABLE `tbl_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(20) DEFAULT NULL COMMENT '用户名',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `nickname` varchar(100) DEFAULT NULL COMMENT '昵称',
  `age` int(4) DEFAULT NULL COMMENT '年龄',
  `sex` int(1) DEFAULT NULL COMMENT '性别 0男 1女',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `role_id` bigint(20) DEFAULT NULL,
  `validaty` int(11) DEFAULT '1' COMMENT '审核状态 1通过 0待审核 2审核不通过',
  `oper_user` varchar(20) DEFAULT NULL COMMENT '操作人',
  `oper_time` bigint(20) DEFAULT NULL COMMENT '操作时间',
  `user_type` int(1) DEFAULT '2' COMMENT '用户类型 1，管理员，2用户 3子账号',
  `head_pic` int(1) DEFAULT '1',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_user` */

insert  into `tbl_user`(`user_id`,`user_name`,`email`,`nickname`,`age`,`sex`,`phone`,`password`,`role_id`,`validaty`,`oper_user`,`oper_time`,`user_type`,`head_pic`) values (1,'administ','1293361401@qq.com','管理员',22,1,NULL,'b02cc2d04642f89d04eab5dbd7c4e1822e2e2377161e2909',NULL,1,NULL,NULL,1,2),(2,'zdy001','1234192931@qq.com','张三001',22,1,NULL,'b02cc2d04642f89d04eab5dbd7c4e1822e2e2377161e2909',NULL,1,NULL,1466391395036,1,3),(4,'zdy002','123841@qq.com','张三002',22,1,NULL,'b02cc2d04642f89d04eab5dbd7c4e1822e2e2377161e2909',NULL,1,NULL,1466391526444,1,4),(5,'zdy003',NULL,'张三003',NULL,NULL,NULL,'b02cc2d04642f89d04eab5dbd7c4e1822e2e2377161e2909',NULL,1,NULL,NULL,2,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
