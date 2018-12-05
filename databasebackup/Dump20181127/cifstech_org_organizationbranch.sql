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
-- Table structure for table `organizationbranch`
--

DROP TABLE IF EXISTS `organizationbranch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organizationbranch` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `lat` varchar(255) DEFAULT NULL,
  `lng` varchar(255) DEFAULT NULL,
  `nigranid` bigint(20) DEFAULT NULL,
  `image` varchar(225) DEFAULT NULL,
  `locationLabel` varchar(500) DEFAULT NULL,
  `areaHeadName` varchar(225) DEFAULT NULL,
  `firstWitnessName` varchar(225) DEFAULT NULL,
  `firstWitnessPhone` varchar(225) DEFAULT NULL,
  `secondWitnessName` varchar(225) DEFAULT NULL,
  `secondWitnessPhone` varchar(225) DEFAULT NULL,
  `sponsoredAmount` varchar(20) DEFAULT NULL,
  `isSchoolExists` varchar(225) DEFAULT NULL,
  `areaPopulation` varchar(225) DEFAULT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdOn` date NOT NULL,
  `lastUpdatedBy` varchar(255) DEFAULT NULL,
  `lastUpdatedOn` date NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `organizationId` bigint(20) DEFAULT NULL,
  `madarsacode` varchar(60) DEFAULT NULL,
  `madarsastartedfrom` date DEFAULT NULL,
  `sarbrahmobilenumber` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcem0dxdv9fk1fum4ohlje7miy` (`organizationId`),
  CONSTRAINT `FKcem0dxdv9fk1fum4ohlje7miy` FOREIGN KEY (`organizationId`) REFERENCES `organization` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organizationbranch`
--

LOCK TABLES `organizationbranch` WRITE;
/*!40000 ALTER TABLE `organizationbranch` DISABLE KEYS */;
INSERT INTO `organizationbranch` VALUES (2,'بشیر بن سعدرضی اللہ عنہ','49','32.923792','72.414939',1,'\\image-dir\\ZM0E920YXZ.jpeg','','','','','','','',NULL,'1',NULL,'2018-04-10',NULL,'2018-04-10','A',NULL,'A2342','2018-04-10','234234'),(3,'سعاد بن زریق رضی اللہ عنہ','50','32.910890','72.418716',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','55','2018-01-19',NULL,'2018-01-19','A',NULL,NULL,'2018-01-19',NULL),(4,'ثعلبہ بن حاطب','51','33.038399','72.024386',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','55','2018-01-19',NULL,'2018-01-19','A',NULL,NULL,'2018-01-19',NULL),(5,'سراقہ بن عمرو','52','32.917016','72.390443',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','55','2018-01-19',NULL,'2018-01-19','A',NULL,NULL,'2018-01-19',NULL),(6,'سلمۃ بن اکوع','53','32.941184','72.421331',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','55','2018-01-19',NULL,'2018-01-19','A',NULL,NULL,'2018-01-19',NULL),(7,'عمرو بن ثعلبہ','54','32.930666','72.427682',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','55','2018-01-19',NULL,'2018-01-19','A',NULL,NULL,'2018-01-19',NULL),(8,'حنظلۃ بن ربیعہ رضی اللہ عنہ','55','32.923606','72.430343',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','55','2018-01-19',NULL,'2018-01-19','A',NULL,NULL,'2018-01-19',NULL),(9,'حنظلہ بن ابی عامر رضی اللہ عنہ','56','32.930882','72.420043',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','55','2018-01-19',NULL,'2018-01-19','A',NULL,NULL,'2018-01-19',NULL),(10,'طارق بن شہاب','57','32.931315','72.405881',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','55','2018-01-19',NULL,'2018-01-19','A',NULL,NULL,'2018-01-19',NULL),(11,'عکاشہ  بن محصن','58','32.911357','72.418927',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','55','2018-01-19',NULL,'2018-01-19','A',NULL,NULL,'2018-01-19',NULL),(12,'حرام بن ملحان','59','32.921301','72.415923',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','55','2018-01-19',NULL,'2018-01-19','A',NULL,NULL,'2018-01-19',NULL),(13,'عبد اللہ بن النعمان','60','32.918635','72.427768',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','55','2018-01-19',NULL,'2018-01-19','A',NULL,NULL,'2018-01-19',NULL),(14,'حنظلۃ بن ابی عامر','61','32.925912','72.382793',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','55','2018-01-19',NULL,'2018-01-19','A',NULL,NULL,'2018-01-19',NULL),(15,'علاء بن حضرمی','62','32.918707','72.392320',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','55','2018-01-19',NULL,'2018-01-19','A',NULL,NULL,'2018-01-19',NULL),(16,'حرام بن ملحان','62','32.926632','72.416009',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','55','2018-01-19',NULL,'2018-01-19','A',NULL,NULL,'2018-01-19',NULL);
/*!40000 ALTER TABLE `organizationbranch` ENABLE KEYS */;
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
