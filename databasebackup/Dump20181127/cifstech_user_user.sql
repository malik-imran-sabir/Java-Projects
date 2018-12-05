-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: cifstech_user
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `doj` date DEFAULT NULL,
  `fatherName` varchar(255) DEFAULT NULL,
  `image` varchar(5000) DEFAULT NULL,
  `last_password_reset_date` datetime DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `madarsaId` bigint(20) DEFAULT NULL,
  `nic` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `userTypeId` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `createdOn` date DEFAULT NULL,
  `createdBy` varchar(225) DEFAULT NULL,
  `lastUpdatedOn` date DEFAULT NULL,
  `lastUpdatedBy` varchar(225) DEFAULT NULL,
  `status` varchar(225) DEFAULT NULL,
  `passwordSalt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'KHALID TEST 1','2010-02-17','2013-02-03','KHALID TEST 3','\\image-dir\\RPBJ5FC8Y9.jpeg','2018-02-06 22:33:07','18',0,'444444444','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra','1','khalid',1,'2018-02-23',NULL,'2018-02-23',NULL,'A',NULL),(5,'ٹیسٹ صارف','2018-02-14','2018-02-08','ٹیسٹ صارف','\\image-dir\\DCMCF3RYQC.jpeg',NULL,'66',0,'777','$2a$10$pcl5ttMdUzIFTZwpise0qeppq0CrZiL0lNy5JVG5KbvCWZPiRl5lC','3','khalid-habib',1,'2018-02-07',NULL,'2018-02-07',NULL,'A','Xuq6t7Fr/Dg='),(90,'alkesh2','2018-03-12','2018-03-12','','\\image-dir\\N3V6NY52V2.jpeg',NULL,'',0,NULL,'$2a$10$RRymtfZfTe/LItImXGGnlOLK2C41gssXl1JcUfi.uXlRSw0lFO4vW','1','nigran',1,'2018-03-12',NULL,'2018-03-12',NULL,'A','Xuq6t7Fr/Dg='),(104,'nigran','2018-03-26','2018-03-26','f nigran','\\image-dir\\X2WCNYUBS3.jpeg',NULL,'49',0,'34','','1','nigrann',1,'2018-03-26',NULL,'2018-03-26',NULL,'A',''),(111,'jawad',NULL,NULL,'siddiqui','\\image-dir\\HAYUL95U1R.jpeg',NULL,'',0,'4534555','','1','jawad',1,'2018-03-30',NULL,'2018-03-30',NULL,'A',''),(112,'Student 1',NULL,NULL,'','\\image-dir\\QKX6JJXI7X.jpeg',NULL,'',2,NULL,'','4',NULL,1,'2018-04-05',NULL,'2018-04-05',NULL,'A',NULL),(113,'Teacher 1 ','2018-04-18','2018-04-10','abc','\\image-dir\\LUC1IP9UWV.jpeg',NULL,'40',2,'123123','$2a$10$CyEKOWK1WOXPKPxrdZDNi.UwmiGhwk.j3ljxIWHL3S54z8Yj5ZeTq','2','teacher',1,'2018-04-05',NULL,'2018-04-05',NULL,'A','Xuq6t7Fr/Dg='),(114,'alkeshhh','2018-04-06','2018-04-06','fnam','\\image-dir\\61P92Y9KCU.jpeg',NULL,'6',2,NULL,'$2a$10$OxIgRb6t78q/dB.i1sNJZe9xZeDYtJUZpnrlMyrm.cIx.wok3ZR.S','1','alkesh',1,'2018-04-06',NULL,'2018-04-06',NULL,'A',NULL),(115,'عثمان','2018-04-01','2018-04-09','سعید','\\image-dir\\3VSN0GCTEJ.jpeg',NULL,'9',2,NULL,'','4',NULL,1,'2018-04-06',NULL,'2018-04-06',NULL,NULL,''),(116,'234234',NULL,NULL,'','undefined',NULL,'62',0,'234234','$2a$10$0rwzPu7qzbXWt8S/LoqR..jJD4QnZw8wv6J.LQslwCzgLXpbqV4i.','1','234234',1,'2018-04-06',NULL,'2018-04-06',NULL,'A',NULL),(117,'ter',NULL,NULL,'','\\image-dir\\NRF5L2LWGN.jpeg',NULL,'6',2,NULL,'','4',NULL,1,'2018-04-06',NULL,'2018-04-06',NULL,'A',NULL),(118,'member 2',NULL,NULL,'','\\image-dir\\VXK7YPWAXK.jpeg',NULL,'76',0,'2342342343','$2a$10$17Cc.SjgLqRwkVbg/brsruFjEjlT5UhnkSFm1X1R34SEFOigXVWry','3','member',1,'2018-04-09',NULL,'2018-04-09',NULL,'A',NULL),(119,'dashhh','2018-04-23','2018-04-23','newp','\\image-dir\\LRSFFVIVTG.jpeg',NULL,'36',2,NULL,'','4',NULL,1,'2018-04-23',NULL,'2018-04-23',NULL,'A',''),(120,'jawad new','2018-04-23','2018-04-23','asdas','\\image-dir\\VWC96FQV17.jpeg',NULL,'35',2,NULL,'','4',NULL,1,'2018-04-23',NULL,'2018-04-23',NULL,'A',''),(121,'ok','2018-04-23','2018-04-23','ok','\\image-dir\\G6TFZT3KDF.jpeg',NULL,'36',2,NULL,'','4',NULL,1,'2018-04-23',NULL,'2018-04-23',NULL,'A',''),(122,'baj','2018-04-23','2018-04-24','hsg','\\image-dir\\17P0K1UA38.jpeg',NULL,'36',2,NULL,'','4',NULL,1,'2018-04-23',NULL,'2018-04-23',NULL,'A',''),(123,'taba',NULL,NULL,'','\\image-dir\\EIAH9ISIDV.jpeg',NULL,'39',0,'123','$2a$10$CmIBe31Vkmoz22C03SdZYeBcJ4DqpC6doIWggWTiX6pf6LqAakhLG','1','taba',1,'2018-06-05',NULL,'2018-06-05',NULL,'A','Xuq6t7Fr/Dg='),(124,'234',NULL,NULL,'','\\image-dir\\B7CPUXQ2X4.jpeg',NULL,'38',0,'234','$2a$10$tS8ze5H0YzY67PYz6jiuee4QZUMkN6CCnJoeeGav/YJyPu6rZoDBG','1','tbb',1,'2018-06-05',NULL,'2018-06-05',NULL,'A','cYGgyuvlQYE='),(125,'زوہیب','1986-10-08','2018-06-05','عزیز','\\image-dir\\P3628W380V.jpeg',NULL,'29',0,'4220136302615','$2a$10$hNYT/xAH.VUy8l5l0SjTWupLuyo4VpKzOS5bKHc7izSo4Qm1ZmZ12','1','z',1,'2018-06-05',NULL,'2018-06-05',NULL,NULL,'lrGYIDEnxgM=');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-27 15:00:16
