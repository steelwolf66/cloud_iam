-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 192.168.100.241    Database: ztax_cloud
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `company_id` char(32) NOT NULL,
  `company_name` varchar(100) DEFAULT NULL,
  `company_identify` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `company_type` char(1) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `create_id` char(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_id` char(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_id` char(32) DEFAULT NULL,
  `del_time` datetime DEFAULT NULL,
  `del_type` char(1) NOT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `module`
--

DROP TABLE IF EXISTS `module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `module` (
  `module_id` char(32) NOT NULL COMMENT '模块唯一标识',
  `module_name` varchar(100) NOT NULL COMMENT '模块名称',
  `module_type` char(1) NOT NULL COMMENT '模块类型',
  `module_no` int NOT NULL COMMENT '模块显示顺序',
  `url` varchar(100) NOT NULL COMMENT 'url路径',
  `deal` varchar(100) DEFAULT NULL COMMENT '特殊处理转换',
  `base_amt` decimal(18,4) NOT NULL COMMENT '基础金额',
  `period` varchar(4) NOT NULL COMMENT '周期',
  `user_number` int NOT NULL COMMENT '用户数量',
  `create_id` char(32) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_id` char(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_id` char(32) DEFAULT NULL,
  `del_time` datetime DEFAULT NULL,
  `del_type` varchar(255) NOT NULL,
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `module`
--

LOCK TABLES `module` WRITE;
/*!40000 ALTER TABLE `module` DISABLE KEYS */;
/*!40000 ALTER TABLE `module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_client_details`
--

DROP TABLE IF EXISTS `oauth_client_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(256) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int DEFAULT NULL,
  `refresh_token_validity` int DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_client_details`
--

LOCK TABLES `oauth_client_details` WRITE;
/*!40000 ALTER TABLE `oauth_client_details` DISABLE KEYS */;
INSERT INTO `oauth_client_details` VALUES ('ztax-gateway','求别改数据','123456','all','authorization_code,password,refresh_token,implicit',NULL,NULL,3600,7200,NULL,'true'),('ztax-test','求别改数据','123456','all','password,client_credentials,refresh_token,authorization_code','',NULL,3600,7200,NULL,'true');
/*!40000 ALTER TABLE `oauth_client_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(64) DEFAULT NULL COMMENT '昵称',
  `gender` tinyint(1) DEFAULT '0' COMMENT '性别',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `dept_id` int DEFAULT NULL COMMENT '部门ID',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '删除标识（0未删除 1已删除）',
  `avatar` varchar(255) DEFAULT '' COMMENT '用户头像',
  `mobile` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `status` tinyint(1) DEFAULT '0' COMMENT '用户状态（0正常 1禁用）',
  `email` varchar(128) DEFAULT NULL COMMENT '用户邮箱',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `login_name` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='用户信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'root','超级管理员',1,'$2a$10$P97nHj/AVu6JBVCxmj5qEOwsI7rUhFeyu.DrK4ER7sebzv8jp7R5S',0,0,'https://gitee.com/haoxr/image/raw/master/default/807b1042ed4c674d97bcf1f2976234d.jpg','17621590365',1,'1490493387@qq.com','2021-02-10 12:27:30','2021-02-10 12:29:21'),(2,'admin','系统管理员',1,'$2a$10$dLq3.pXNwTNqWabsRfJX4ej8Htk/vUWuHh.LvITq5BrU8u.dYvZpC',1,0,'https://gitee.com/haoxr/image/raw/master/default/807b1042ed4c674d97bcf1f2976234d.jpg','17621210366',1,'1490493387@qq.com','2019-10-10 13:41:22','2021-02-10 12:29:13');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` char(32) NOT NULL COMMENT '用户唯一标识',
  `user_code` varchar(20) DEFAULT NULL COMMENT '用户编码/手机号',
  `username` varchar(45) NOT NULL COMMENT '用户名',
  `nickname` varchar(45) DEFAULT NULL COMMENT '昵称',
  `password` varchar(100) NOT NULL COMMENT '用户密码',
  `enabled` tinyint(1) DEFAULT NULL COMMENT '是否启用',
  `status` char(1) DEFAULT NULL COMMENT '用户状态\\n',
  `user_mail` varchar(50) DEFAULT NULL COMMENT '用户邮箱',
  `user_type` char(1) DEFAULT NULL COMMENT '用户类型',
  `user_company` char(32) DEFAULT NULL COMMENT '用户企业id',
  `user_comp_name` varchar(100) DEFAULT NULL COMMENT '用户企业名称',
  `create_id` char(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` char(32) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `del_id` char(32) DEFAULT NULL COMMENT '删除人',
  `del_time` datetime DEFAULT NULL COMMENT '删除时间',
  `del_type` char(1) DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_module_rel`
--

DROP TABLE IF EXISTS `user_module_rel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_module_rel` (
  `userl_id` char(32) NOT NULL,
  `module_id` char(32) DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `user_num` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_module_rel`
--

LOCK TABLES `user_module_rel` WRITE;
/*!40000 ALTER TABLE `user_module_rel` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_module_rel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-14 18:13:28
