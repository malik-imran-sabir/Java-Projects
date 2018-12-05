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
-- Table structure for table `otheruserfields`
--

DROP TABLE IF EXISTS `otheruserfields`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `otheruserfields` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(225) DEFAULT NULL,
  `value` varchar(225) DEFAULT NULL,
  `usertypeid` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdOn` date DEFAULT NULL,
  `lastUpdatedBy` varchar(255) DEFAULT NULL,
  `lastUpdatedOn` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `otheruserfields`
--

LOCK TABLES `otheruserfields` WRITE;
/*!40000 ALTER TABLE `otheruserfields` DISABLE KEYS */;
INSERT INTO `otheruserfields` VALUES (1,'madarsaId','3',1,1,'A',NULL,'2018-01-17',NULL,'2018-01-24'),(2,'fathernic','4550960967615',4,54,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(3,'address','پتا',4,54,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(4,'locationId','18',4,54,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(5,'teacherId','3',4,54,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(6,'shiftId','1',4,54,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(7,'classId','1',4,54,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(8,'fathernic','laptop',4,59,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(9,'address','address',4,59,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(10,'locationId','7',4,59,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(11,'teacherId','3',4,59,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(12,'shiftId','1',4,59,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(13,'classId','2',4,59,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(14,'fathernic','laptop',4,60,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(15,'address','address',4,60,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(16,'locationId','7',4,60,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(17,'teacherId','3',4,60,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(18,'shiftId','1',4,60,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(19,'classId','2',4,60,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(20,'fathernic','laptop',4,61,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(21,'address','address',4,61,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(22,'locationId','7',4,61,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(23,'teacherId','3',4,61,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(24,'shiftId','1',4,61,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(25,'classId','2',4,61,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(26,'fathernic','4550960967615',4,62,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(27,'address','پتا',4,62,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(28,'locationId','18',4,62,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(29,'teacherId','3',4,62,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(30,'shiftId','1',4,62,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(31,'classId','1',4,62,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(32,'fathernic','4550960967615',4,67,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(33,'address','پتا',4,67,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(34,'locationId','18',4,67,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(35,'teacherId','3',4,67,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(36,'shiftId','1',4,67,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(37,'classId','1',4,67,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(38,'fathernic','laptop',4,68,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(39,'address','address',4,68,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(40,'locationId','7',4,68,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(41,'teacherId','3',4,68,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(42,'shiftId','1',4,68,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(43,'classId','2',4,68,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(44,'fathernic','123456789',4,69,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(45,'address','address',4,69,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(46,'locationId','7',4,69,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(47,'teacherId','3',4,69,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(48,'shiftId','1',4,69,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(49,'classId','1',4,69,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(50,'fathernic','4550960967615',4,63,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(52,'locationId','18',4,63,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(53,'teacherId','3',4,63,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(54,'shiftId','1',4,63,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(55,'classId','1',4,63,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(56,'fathernic','4550960967615',4,64,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(57,'address','پتا',4,64,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(58,'locationId','18',4,64,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(59,'teacherId','3',4,64,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(60,'shiftId','1',4,64,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(61,'classId','1',4,64,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(62,'fathernic','4550960967615',4,65,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(63,'address','پتا',4,65,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(64,'locationId','18',4,65,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(65,'teacherId','3',4,65,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(66,'shiftId','1',4,65,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(67,'classId','1',4,65,'A',NULL,'2018-01-24',NULL,'2018-01-24'),(68,'fathernic','okokoko',4,70,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(69,'address','ok',4,70,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(70,'locationId','7',4,70,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(71,'teacherId','3',4,70,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(72,'shiftId','2',4,70,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(73,'classId','3',4,70,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(74,'fathernic','sham',4,71,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(75,'address','adres',4,71,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(76,'locationId','7',4,71,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(77,'teacherId','3',4,71,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(78,'shiftId','3',4,71,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(79,'classId','2',4,71,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(80,'fathernic','laptop',4,72,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(81,'address','address',4,72,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(82,'locationId','19',4,72,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(83,'teacherId','3',4,72,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(84,'shiftId','1',4,72,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(85,'classId','2',4,72,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(86,'fathernic','laptop',4,73,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(87,'address','address',4,73,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(88,'locationId','7',4,73,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(89,'teacherId','3',4,73,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(90,'shiftId','1',4,73,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(91,'classId','2',4,73,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(92,'fathernic','laptop',4,74,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(93,'address','address',4,74,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(94,'locationId','7',4,74,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(95,'teacherId','3',4,74,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(96,'shiftId','1',4,74,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(97,'classId','2',4,74,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(98,'fathernic','laptop',4,75,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(99,'address','address',4,75,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(100,'locationId','7',4,75,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(101,'teacherId','3',4,75,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(102,'shiftId','1',4,75,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(103,'classId','2',4,75,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(104,'fathernic','laptop',4,76,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(105,'address','address',4,76,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(106,'locationId','7',4,76,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(107,'teacherId','3',4,76,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(108,'shiftId','1',4,76,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(109,'classId','2',4,76,'A',NULL,'2018-01-25',NULL,'2018-01-25'),(110,'fathernic','laptop',4,77,'A',NULL,'2018-01-26',NULL,'2018-01-26'),(111,'address','address',4,77,'A',NULL,'2018-01-26',NULL,'2018-01-26'),(112,'locationId','7',4,77,'A',NULL,'2018-01-26',NULL,'2018-01-26'),(113,'teacherId','3',4,77,'A',NULL,'2018-01-26',NULL,'2018-01-26'),(114,'shiftId','1',4,77,'A',NULL,'2018-01-26',NULL,'2018-01-26'),(115,'classId','2',4,77,'A',NULL,'2018-01-26',NULL,'2018-01-26'),(122,'fathernic','455046866859',4,86,'A',NULL,'2018-01-29',NULL,'2018-01-29'),(123,'address','455046866859',4,86,'A',NULL,'2018-01-29',NULL,'2018-01-29'),(124,'locationId','',4,86,'A',NULL,'2018-01-29',NULL,'2018-01-29'),(125,'teacherId','3',4,86,'A',NULL,'2018-01-29',NULL,'2018-01-29'),(126,'shiftId','1',4,86,'A',NULL,'2018-01-29',NULL,'2018-01-29'),(127,'classId','1',4,86,'A',NULL,'2018-01-29',NULL,'2018-01-29');
/*!40000 ALTER TABLE `otheruserfields` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-27 15:00:18
