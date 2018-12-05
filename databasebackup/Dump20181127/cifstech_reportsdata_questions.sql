-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: cifstech_reportsdata
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
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `question` varchar(225) DEFAULT NULL,
  `type` bigint(20) DEFAULT NULL,
  `option` varchar(225) DEFAULT NULL,
  `madarsaId` bigint(20) DEFAULT NULL,
  `vistedOn` date DEFAULT NULL,
  `createdOn` date DEFAULT NULL,
  `lastUpdatedOn` date DEFAULT NULL,
  `Status` varchar(225) DEFAULT NULL,
  `createdBy` varchar(225) DEFAULT NULL,
  `lastUpdatedBy` varchar(225) DEFAULT NULL,
  `formId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (3,'اس ماہ استاذ کی چھٹیوں کی تعداد',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL,NULL),(4,'بچوں کی کل تعداد',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL,NULL),(5,' فی الوقت حاضری',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL,NULL),(6,'کل وقتی بچوں کی کل تعداد',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL,NULL),(7,'بچوں کی پڑھائی کی کیفیت',1,' خراب ہے،بہت خراب ہے،بہترہے , بہت بہترہے',NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL,NULL),(8,'بچوں کے لباس کی کیفیت کیسی ہے',1,' خراب ہے،بہت خراب ہے،بہترہے , بہت بہترہے',NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL,NULL),(9,'کتنے بچوں یا بچیوں نے ٹوپیاں یادوپٹے نہیں پہن رکھے',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL,NULL),(10,'کتنے بچوں کے ناخن صاف یا کٹے ہوئے نہیں ہیں',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL,NULL),(11,'کیا درسگاہ میں تپائیاں وغیرہ ترتیب سے رکھی ہوئی ہیں',1,'ہاں،نہیں',NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL,NULL),(12,'درسگاہ کی صفائی کی نوعیت کیا ہے',1,' خراب ہے،بہت خراب ہے،بہترہے , بہت بہترہے',NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL,NULL),(13,'کیا مرکز میں بورڈ کااستعمال ہو رہا ہے',1,'ہاں،نہیں',NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL,NULL),(14,'کیا بچوں کے قاعدوں پر ٹرسٹ کے اسٹیکرز چسپاں ہیں',1,'ہاں،نہیں',NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL,NULL),(15,'علاقے کے کن افراد سے ملاقات ہوئی اور انکے تاثرات',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL,NULL),(16,'مرکز کےحوالےسےنگران کی رائے',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL,NULL);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-27 15:00:20
