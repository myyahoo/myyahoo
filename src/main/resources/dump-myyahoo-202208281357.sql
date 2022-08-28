-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: myyahoo
-- ------------------------------------------------------
-- Server version	5.5.5-10.5.17-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `join_type` varchar(10) DEFAULT 'email' COMMENT 'email, naver,kakao',
  `user_pwd` varchar(150) DEFAULT NULL,
  `visit_cnt` int(11) DEFAULT 0,
  `mailing_tf` enum('0','1') DEFAULT '0',
  `auth_token` varchar(200) DEFAULT NULL COMMENT '메일 인증토큰 24시간 유효',
  `status` enum('y','n','m') DEFAULT NULL COMMENT 'y=>회원,n=>비회원,m=>메일인증대기',
  `wrong_passwd_cnt` smallint(5) unsigned DEFAULT 0,
  `lastdate` datetime DEFAULT NULL,
  `regdate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Users_email_IDX` (`email`) USING BTREE,
  KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (92,'jo2nyii@gmail.com','kakao',NULL,0,'1',NULL,'y',0,NULL,'2022-06-10 04:48:21'),(100,'hojoon@xportsnews.com','email','91609776c7b6192003f3ac68ae6db60a8ae0e1a34020bf3eae3a63716fd6f9a001c5a9b4f561f0484a945e97b583d7f10b19ec54091931e78f3e842b1d909f21',2,'1','','y',0,'2022-06-15 03:11:03','2022-06-15 01:32:46'),(101,'phantar@nate.com','email','0ef1589aa95f92a6c4d707a59df485f9eefd94b47bb77a23613868f011ae8e8d9dfb77df759ff303b01e7357529213629d19f45273a32df72bc5e5b5f6476cca',8,'1','','y',0,'2022-06-29 01:55:52','2022-06-16 05:40:19'),(104,'gbuy@naver.com','email','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4',9,'1','','y',0,'2022-06-29 02:16:16','2022-06-20 09:10:30'),(105,'phantar1@gmail.com','email','0ef1589aa95f92a6c4d707a59df485f9eefd94b47bb77a23613868f011ae8e8d9dfb77df759ff303b01e7357529213629d19f45273a32df72bc5e5b5f6476cca',0,'1','','y',0,NULL,'2022-06-21 12:13:12'),(106,'leechyd@hanmail.net','kakao',NULL,0,'1',NULL,'y',0,NULL,'2022-07-04 07:55:02'),(108,'dlskaghkd67@daum.net','kakao',NULL,0,'1',NULL,'y',0,NULL,'2022-07-09 23:01:42'),(109,'fzsdup5168@daum.net','email','a5df814b2635fa94e93c06534f7266ef997b296691058e40d1c790dac8dc42337ea685d912af29fc9e9395c841bb6396a2887a7171768fbb09ee9409c94eecf0',0,'1','33O77wKuStZYDXwcLGvzCuzYmO9CMPv4Pr2ACZ82qvo=','m',0,NULL,'2022-07-31 07:10:42'),(110,'linhconheo0709@gmail.com','kakao',NULL,0,'1',NULL,'y',0,NULL,'2022-08-02 18:55:47'),(111,'law8282@daum.net','kakao',NULL,0,'1',NULL,'y',0,NULL,'2022-08-03 03:22:09'),(112,'69kkl@hanmail.net','kakao',NULL,0,'1',NULL,'y',0,NULL,'2022-08-12 03:53:41'),(113,'fdsafdsafds','email',NULL,0,'0',NULL,NULL,0,NULL,NULL),(114,'fdsafdsafds','email',NULL,0,'0',NULL,NULL,0,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-28 13:57:37
