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
-- Table structure for table `examsdata`
--

DROP TABLE IF EXISTS `examsdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `examsdata` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `examtype` varchar(25) DEFAULT NULL,
  `examyear` int(11) DEFAULT NULL,
  `studentId` int(11) DEFAULT NULL,
  `madarsaId` int(11) DEFAULT NULL,
  `examdate` date DEFAULT NULL,
  `theoryNumbers` double(11,0) DEFAULT NULL,
  `duaNumbers` double(11,0) DEFAULT NULL,
  `namazNumbers` double(11,0) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `comments` varchar(225) DEFAULT NULL,
  `createdOn` date DEFAULT NULL,
  `lastUpdatedBy` varchar(225) DEFAULT NULL,
  `lastUpdatedOn` date DEFAULT NULL,
  `uniquekeyname` varchar(255) DEFAULT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL,
  `totaltheorynumbers` double(10,0) DEFAULT '100',
  `totalnazranumbers` double(10,0) DEFAULT '50',
  `studentname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examsdata`
--

LOCK TABLES `examsdata` WRITE;
/*!40000 ALTER TABLE `examsdata` DISABLE KEYS */;
INSERT INTO `examsdata` VALUES (37,'1',2018,112,2,NULL,1,2,3,1,NULL,'2018-04-04',NULL,'2018-04-04','1522856955312',NULL,NULL,100,50,NULL),(38,'2',2018,112,2,NULL,4,5,6,1,NULL,'2018-04-04',NULL,'2018-04-04','1522856955312',NULL,NULL,100,50,NULL),(39,'3',2018,112,2,NULL,7,8,9,1,NULL,'2018-04-04',NULL,'2018-04-04','1522856955312',NULL,NULL,100,50,NULL),(58,'2',2018,112,2,NULL,0,0,11,1,NULL,'2018-04-05',NULL,'2018-04-05','1522937297544',NULL,NULL,0,0,NULL),(59,'4',2018,112,2,NULL,0,0,1,1,NULL,'2018-04-05',NULL,'2018-04-05','1522937321119',NULL,NULL,0,0,NULL),(60,'1',2018,112,2,NULL,55,8,10,1,NULL,'2018-04-05',NULL,'2018-04-05','1522937349768',NULL,NULL,0,0,NULL),(61,'5',2018,112,2,NULL,0,0,55,1,NULL,'2018-04-05',NULL,'2018-04-05','1522941948203',NULL,NULL,0,0,NULL),(62,'1',2018,112,2,NULL,2,3,1,1,NULL,'2018-04-06',NULL,'2018-04-06','1523019129106',NULL,NULL,0,0,NULL),(63,'2',2018,112,2,NULL,0,2,1,1,NULL,'2018-04-06',NULL,'2018-04-06','1523019196496',NULL,NULL,0,0,NULL),(64,'2',2018,112,2,NULL,0,2,1,1,NULL,'2018-04-06',NULL,'2018-04-06','1523019212518',NULL,NULL,0,0,NULL),(65,'1',2018,112,2,NULL,4,4,10,1,NULL,'2018-04-06',NULL,'2018-04-06','1523029244207',NULL,NULL,0,0,NULL),(66,'1',2018,115,2,NULL,22,33,66,1,NULL,'2018-04-06',NULL,'2018-04-06','1523029244207',NULL,NULL,0,0,NULL),(67,'1',2018,117,2,NULL,2,5,9,1,NULL,'2018-04-06',NULL,'2018-04-06','1523029244207',NULL,NULL,0,0,NULL),(68,'1',2018,112,2,NULL,2,2,1,1,NULL,'2018-04-06',NULL,'2018-04-06','1523034083519',NULL,NULL,0,0,NULL),(69,'1',2018,115,2,NULL,1,1,1,1,NULL,'2018-04-06',NULL,'2018-04-06','1523034083519',NULL,NULL,0,0,NULL),(70,'1',2018,117,2,NULL,1,1,1,1,NULL,'2018-04-06',NULL,'2018-04-06','1523034083519',NULL,NULL,0,0,NULL),(71,'1',2018,112,2,NULL,2,3,14,1,NULL,'2018-04-06',NULL,'2018-04-06','1523034321924',NULL,NULL,0,0,NULL),(72,'1',2018,115,2,NULL,5,6,9,1,NULL,'2018-04-06',NULL,'2018-04-06','1523034321924',NULL,NULL,0,0,NULL),(73,'1',2018,117,2,NULL,8,9,78,1,NULL,'2018-04-06',NULL,'2018-04-06','1523034321924',NULL,NULL,0,0,NULL),(74,'1',2018,112,2,NULL,1,2,3,1,NULL,'2018-04-06',NULL,'2018-04-06','1523034602266',NULL,NULL,0,0,NULL),(75,'1',2018,115,2,NULL,4,5,6,1,NULL,'2018-04-06',NULL,'2018-04-06','1523034602266',NULL,NULL,0,0,NULL),(76,'1',2018,117,2,NULL,87,9,7,1,NULL,'2018-04-06',NULL,'2018-04-06','1523034602266',NULL,NULL,0,0,NULL),(77,'2',2018,112,2,NULL,10,11,12,1,NULL,'2018-04-09',NULL,'2018-04-09','1523280449152',NULL,NULL,0,0,NULL),(78,'2',2018,115,2,NULL,13,14,15,1,NULL,'2018-04-09',NULL,'2018-04-09','1523280449152',NULL,NULL,0,0,NULL),(79,'2',2018,117,2,NULL,16,17,18,1,NULL,'2018-04-09',NULL,'2018-04-09','1523280449152',NULL,NULL,0,0,NULL),(80,'1',2018,112,2,NULL,50,10,12,1,NULL,'2018-04-11',NULL,'2018-04-11','1523452086281',NULL,NULL,0,0,NULL),(81,'1',2018,115,2,NULL,0,5,5,1,NULL,'2018-04-11',NULL,'2018-04-11','1523452086281',NULL,NULL,0,0,NULL),(82,'1',2018,117,2,NULL,3,2,1,1,NULL,'2018-04-11',NULL,'2018-04-11','1523452086281',NULL,NULL,0,0,NULL);
/*!40000 ALTER TABLE `examsdata` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-27 15:00:17
