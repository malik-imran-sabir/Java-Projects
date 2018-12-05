-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: cifstech_org
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
-- Table structure for table `organizationnotifications`
--

DROP TABLE IF EXISTS `organizationnotifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organizationnotifications` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `notification` varchar(255) NOT NULL,
  `status` varchar(3) DEFAULT NULL,
  `createdBy` varchar(65) DEFAULT NULL,
  `createdOn` date DEFAULT NULL,
  `lastUpdatedBy` varchar(225) DEFAULT NULL,
  `lastUpdatedOn` date DEFAULT NULL,
  `expiredOn` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organizationnotifications`
--

LOCK TABLES `organizationnotifications` WRITE;
/*!40000 ALTER TABLE `organizationnotifications` DISABLE KEYS */;
INSERT INTO `organizationnotifications` VALUES (32,'new message','A','System','2018-04-09',NULL,'2018-04-09','2018-04-09'),(33,'1 New Meesage','A','System','2018-04-11',NULL,'2018-04-11','2018-04-11'),(34,'1 new message ','A','System','2018-04-11',NULL,'2018-04-11','2018-04-20'),(35,'تنظیم اطلاعات فارم','A','System','2018-04-11',NULL,'2018-04-11','2018-04-11'),(36,'تنظیم اطلاعات فارمتنظیم اطلاعات فارمتنظیم اطلاعات فارمتنظیم اطلاعات فارمتنظیم اطلاعات فارمتنظیم اطلاعات فارمتنظیم اطلاعات فارمتنظیم اطلاعات فارمتنظیم اطلاعات فارمتنظیم اطلاعات فارمتنظیم اطلاعات فارمتنظیم اطلاعات فارمتنظیم اطلاعات فارم','A','System','2018-04-11',NULL,'2018-04-11','2018-04-11');
/*!40000 ALTER TABLE `organizationnotifications` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-27 15:00:19
