-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: cifstech_location
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
-- Table structure for table `locationmappingdata`
--

DROP TABLE IF EXISTS `locationmappingdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locationmappingdata` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `locationMappingId` bigint(20) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  `valueEng` varchar(225) DEFAULT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdOn` date NOT NULL,
  `lastUpdatedBy` varchar(255) DEFAULT NULL,
  `lastUpdatedOn` date NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `locationMappingDataId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `locationMappingData_uq_id` (`value`,`locationMappingId`) USING BTREE,
  KEY `locationMappingData_fk_idx` (`locationMappingId`),
  CONSTRAINT `locationMappingData_fk` FOREIGN KEY (`locationMappingId`) REFERENCES `locationmapping` (`id`) ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locationmappingdata`
--

LOCK TABLES `locationmappingdata` WRITE;
/*!40000 ALTER TABLE `locationmappingdata` DISABLE KEYS */;
INSERT INTO `locationmappingdata` VALUES (1,1,'پاکستان','Pakistan','system','2018-01-22','system','2018-01-22','A',0),(2,2,'سندھ','Sindh','system','2018-01-22','system','2018-01-22','A',1),(3,2,'پنجاب','Punjab','system','2018-01-22','system','2018-01-22','A',1),(4,2,'بلوچستان','Balochistan','system','2018-01-22','system','2018-01-22','A',1),(5,2,'خیبر پختونخواہ','Khyber Pakhtoonkhuwah','system','2018-01-22','system','2018-01-22','A',1),(6,3,'عمر کوٹ','Umarkot','system','2018-01-22','system','2018-01-22','A',2),(8,3,'ملیر کراچی','Malir Karachi','system','2018-01-22','system','2018-01-22','A',2),(9,3,'ٹھٹھہ ','ThaTha','system','2018-01-22','system','2018-01-22','A',2),(10,3,'کشمور','Kashmor','system','2018-01-22','system','2018-01-22','A',2),(11,3,'جیکب آباد','Jekab Aaabad','system','2018-01-22','system','2018-01-22','A',2),(12,3,'شہداد کوٹ','Shahdad kot','system','2018-01-22','system','2018-01-22','A',2),(13,3,'خیر پور میرس','Kherpur Meras','system','2018-01-22','system','2018-01-22','A',2),(14,3,'نوشہرہ فیروز','Noshehraferoz','system','2018-01-22','system','2018-01-22','A',2),(15,3,'سانگھڑ','Sanghar','system','2018-01-22','system','2018-01-22','A',2),(16,3,'میرپور خاص','Meerpurkhas','system','2018-01-22','system','2018-01-22','A',2),(17,3,'شکار پور','Shikarpur','system','2018-01-22','system','2018-01-22','A',2),(18,4,'ملیر','Malir','system','2018-01-22','system','2018-01-22','A',8),(19,4,'ٹھٹھہ','ThaTha','system','2018-01-22','system','2018-01-22','A',9),(20,4,'جھرک','Jhirk','system','2018-01-22','system','2018-01-22','A',9),(21,4,'جاتی','Jati','system','2018-01-22','system','2018-01-22','A',9),(22,4,'کندھ کوٹ','Kandhkot','system','2018-01-22','system','2018-01-22','A',10),(23,4,'ٹھل','Thul','system','2018-01-22','system','2018-01-22','A',11),(24,4,'شہداد کوٹ','Shahdad kot','system','2018-01-22','system','2018-01-22','A',12),(25,4,'ٹھری میر واہ','Thari Meerwah','system','2018-01-22','system','2018-01-22','A',13),(26,4,'فیض گنج','Faiz ganj','system','2018-01-22','system','2018-01-22','A',13),(27,4,'محراب پور','Mehrabpur','system','2018-01-22','system','2018-01-22','A',14),(29,4,'جھلوری','Jhalori','system','2018-01-22','system','2018-01-22','A',16),(30,4,'شکار پور','Shikarpur','system','2018-01-22','system','2018-01-22','A',17),(31,3,'رحیم یار خان','Raheem yar khan','system','2018-01-22','system','2018-01-22','A',3),(32,3,'چکوال','Chakwal','system','2018-01-22','system','2018-01-22','A',3),(33,4,'صادق آباد','Sadiqabad','system','2018-01-22','system','2018-01-22','A',31),(34,4,'تلہ گنگ','Talagang','system','2018-01-22','system','2018-01-22','A',32),(35,3,'جھل مگسی','Jhal Magsi','system','2018-01-22','system','2018-01-22','A',4),(36,3,'بولان','Bolan','system','2018-01-22','system','2018-01-22','A',4),(37,4,'گنداواہ','Gandawah','system','2018-01-22','system','2018-01-22','A',35),(38,4,'جھل مگسی','Jhal Magsi','system','2018-01-22','system','2018-01-22','A',35),(39,4,'بھاگ ناڑی ','Bhag Nari','system','2018-01-22','system','2018-01-22','A',36),(40,3,'لکی مروت بنوں','Laki Marwat Bannu','system','2018-01-22','system','2018-01-22','A',5),(41,3,'سوات','Sawat','system','2018-01-22','system','2018-01-22','A',5),(42,4,'سرائے نورنگ','Sray Norang','system','2018-01-22','system','2018-01-22','A',40),(43,4,'مٹہ','Matta','system','2018-01-22','system','2018-01-22','A',41),(44,2,'شمالی علاقہ جات','Northern area','system','2018-01-22','system','2018-01-22','A',1),(45,3,'چترال','Chitral','system','2018-01-22','system','2018-01-22','A',44),(46,4,'چترال','Chitral','system','2018-01-22','system','2018-01-22','A',45),(47,4,'مستوج اویر','Mastoj Oweer','system','2018-01-22','system','2018-01-22','A',45),(48,4,'گرم چشمہ','Garam Chashma','system','2018-01-22','system','2018-01-22','A',45),(49,5,'گاؤں ڈھولی','Gao Dholi','system','2018-01-22','system','2018-01-22','A',34),(50,5,'گاؤں ٹھٹھی شریف','Gao Thatti Sharif','system','2018-01-22','system','2018-01-22','A',34),(51,5,'محمد آباد','Muhammad Aabad','system','2018-01-22','system','2018-01-22','A',34),(52,5,'گاؤں ونہار','Gao Nihar','system','2018-01-22','system','2018-01-22','A',34),(53,5,'گاؤں ڈھوگ سون ','Gao Dhogsoon','system','2018-01-22','system','2018-01-22','A',34),(54,5,'ڈھولی سٹی ','Dholi Satti','system','2018-01-22','system','2018-01-22','A',34),(55,5,'ڈھوگ پیڑا ','Dhog perra','system','2018-01-22','system','2018-01-22','A',34),(56,5,'وادی سون ','Wadisoon','system','2018-01-22','system','2018-01-22','A',34),(57,5,'ڈھلی شریف','Dhali sharif','system','2018-01-22','system','2018-01-22','A',34),(58,5,'گاؤں دندا شاہ بلاول','Gao Danda shah bilawal','system','2018-01-22','system','2018-01-22','A',34),(59,5,'گاؤں فتح شاہ','Gao Fateeh Shah','system','2018-01-22','system','2018-01-22','A',34),(60,5,'ڈھوگ فقیرا','Dhog Faqeera','system','2018-01-22','system','2018-01-22','A',34),(61,5,'ڈھوگ پھلاڑی ','Dhog Phelarri','system','2018-01-22','system','2018-01-22','A',34),(62,5,'گاؤں نکہ کہوٹ','Gao Nakka Kahot','system','2018-01-22','system','2018-01-22','A',34),(63,5,'گاؤں جھامڑا ','Gao Jhamrra','system','2018-01-22','system','2018-01-22','A',34),(64,5,'گاؤں دابڑ','Gao Daharr','system','2018-01-22','system','2018-01-22','A',34),(65,5,'گاؤں چھپڑ','Gao Chapparr','system','2018-01-22','system','2018-01-22','A',34),(66,5,'ماڈل کالونی','Model Colony','System','2018-02-13','System','2018-02-13','A',18);
/*!40000 ALTER TABLE `locationmappingdata` ENABLE KEYS */;
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
