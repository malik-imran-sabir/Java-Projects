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
-- Table structure for table `exam_questions`
--

DROP TABLE IF EXISTS `exam_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam_questions` (
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_questions`
--

LOCK TABLES `exam_questions` WRITE;
/*!40000 ALTER TABLE `exam_questions` DISABLE KEYS */;
INSERT INTO `exam_questions` VALUES (3,'استاذ کا نام',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL),(4,'متولی کا نام  ',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL),(5,'متولی کےپاس کتنےموبائل نمبرہے',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL),(6,'متولی کے موبائل نمبر ڈالیں',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL),(7,'ماہانہ رپورٹ برائے اساتذہ',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL),(8,'فارم برائے کیفیات',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL),(9,'مقامی دستخط کی صورتحال',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL),(10,'رجسٹر حاضری',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL),(11,'دو ماہی تعلیمی جائزہ',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL),(12,'مقامی کتنے افراد سے ملاقات ہوئی',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL),(13,'مقامی افراد کےنام اور نمبر بتائیں',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL),(14,'استاذ کے ساتھ کتنے افراد تعاون کرتے ہیں',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL),(15,'ٹوٹل تعاون',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL),(16,'مقدارخواندگی کی صورتحال',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL),(17,'نماز کلموں دعاؤں کی صورتحال ',1,' خراب ہے،بہت خراب ہے،بہترہے , بہت بہترہے',NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL),(18,'گروپ اور بورڈ پر پڑھانے کی صورتحال',1,' خراب ہے،بہت خراب ہے،بہترہے , بہت بہترہے',NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL),(19,'آٹھ سال سے بڑی بچیوں پر نظر',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL),(20,'رسالہ دینا',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL),(21,'ورکشاپ کا وقت بتانا',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL),(22,'تعلیمی رپورٹ',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL),(23,'تعلیم الاسلام کتنے بچوں کو پڑھائی گئی',2,NULL,NULL,NULL,'2018-01-23',NULL,'A',NULL,NULL);
/*!40000 ALTER TABLE `exam_questions` ENABLE KEYS */;
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
