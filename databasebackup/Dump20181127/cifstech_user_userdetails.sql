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
-- Table structure for table `userdetails`
--

DROP TABLE IF EXISTS `userdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userdetails` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `fathernic` varchar(225) DEFAULT NULL,
  `address` varchar(225) DEFAULT NULL,
  `tempaddress` varchar(225) DEFAULT NULL,
  `permaddress` varchar(225) DEFAULT NULL,
  `locationId` varchar(225) DEFAULT NULL,
  `teacherId` varchar(20) DEFAULT NULL,
  `shiftId` varchar(20) DEFAULT NULL,
  `classId` varchar(20) DEFAULT NULL,
  `easyaccounttitle` varchar(225) DEFAULT NULL,
  `emobilenumber` varchar(225) DEFAULT NULL,
  `enic` varchar(225) DEFAULT NULL,
  `benefitamount` varchar(12) DEFAULT NULL,
  `salary` varchar(12) DEFAULT NULL,
  `madarsaId` varchar(20) DEFAULT NULL,
  `contact1` varchar(20) DEFAULT NULL,
  `contact2` varchar(20) DEFAULT NULL,
  `contact3` varchar(20) DEFAULT NULL,
  `maritalStatus` tinyint(4) DEFAULT NULL,
  `qualification` varchar(225) DEFAULT NULL,
  `extraQualification` varchar(225) DEFAULT NULL,
  `modernQualification` varchar(225) DEFAULT NULL,
  `lastAttendedMadarsa` varchar(225) DEFAULT NULL,
  `lastQualificationDate` date DEFAULT NULL,
  `otherMadarsas` varchar(225) DEFAULT NULL,
  `createdBy` varchar(225) DEFAULT NULL,
  `createdOn` date DEFAULT NULL,
  `lastUpdatedBy` varchar(225) DEFAULT NULL,
  `lastUpdatedOn` date DEFAULT NULL,
  `status` varchar(225) DEFAULT NULL,
  `guardianname` varchar(120) DEFAULT NULL,
  `guardiannic` varchar(120) DEFAULT NULL,
  `guardianrelation` varchar(120) DEFAULT NULL,
  `gardiannumber` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=142 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdetails`
--

LOCK TABLES `userdetails` WRITE;
/*!40000 ALTER TABLE `userdetails` DISABLE KEYS */;
INSERT INTO `userdetails` VALUES (1,1,NULL,NULL,'90990 3434 arzi',' 8788 334 must','18',NULL,NULL,NULL,'333333','343434343','334343434',NULL,NULL,NULL,'454','767','565',0,'',NULL,NULL,NULL,NULL,NULL,NULL,'2018-02-23',NULL,'2018-02-23',NULL,NULL,NULL,NULL,NULL),(90,5,NULL,NULL,'test','add','66',NULL,NULL,NULL,'','','','','',NULL,'03','0300','0300325585',0,'','',NULL,'',NULL,NULL,'Zuhaib','2018-02-01','Zuhaib','2018-02-01','A',NULL,NULL,NULL,NULL),(106,90,NULL,'','asdsa','','',NULL,NULL,NULL,'','asdas','2111111111111','','',NULL,'asda','asdaskhalid-habib','asdas',0,',,','',NULL,'',NULL,NULL,NULL,'2018-03-12',NULL,'2018-03-12','A',NULL,NULL,NULL,NULL),(120,104,NULL,NULL,'sdf','dfd','49',NULL,NULL,NULL,'','','','4343','4544',NULL,'03312842909','0995','26',0,',,','324',NULL,'33','2018-04-20',NULL,NULL,'2018-03-26',NULL,'2018-03-26','A',NULL,NULL,NULL,NULL),(127,111,NULL,NULL,'','','',NULL,NULL,NULL,'','','','5000','3000',NULL,'','','',0,',,','',NULL,'ter',NULL,NULL,NULL,'2018-03-30',NULL,'2018-03-30','A',NULL,NULL,NULL,NULL),(128,112,'',NULL,NULL,'','',NULL,'1','1',NULL,NULL,NULL,NULL,NULL,'2','','','',0,'',NULL,NULL,NULL,NULL,NULL,NULL,'2018-04-05',NULL,'2018-04-05','A','','','',NULL),(129,113,NULL,NULL,'okkkkkkkkkk','tt are a dfs','40',NULL,NULL,NULL,'','03452139691','4220145672341','3000','2000','2','0300','0345','0333',0,'حفظ','iui','','uyuu','2018-04-19','',NULL,'2018-04-05',NULL,'2018-04-05',NULL,NULL,NULL,NULL,NULL),(130,114,'1111111111111','sadas',NULL,NULL,'6','113','1','1',NULL,NULL,NULL,NULL,NULL,'2',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-04-06',NULL,'2018-04-06','A','adsdas','1111111111111','assda',NULL),(131,115,'2222222222222',NULL,NULL,'yerrrrr','9','113','2','2',NULL,NULL,NULL,NULL,NULL,'2',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-04-06',NULL,'2018-04-06',NULL,'کاشف','4220137205461','چاچا','66666666456456'),(132,116,NULL,NULL,'','','62',NULL,NULL,NULL,'','','',NULL,NULL,NULL,'','','',0,'',NULL,NULL,NULL,NULL,NULL,NULL,'2018-04-06',NULL,'2018-04-06','A',NULL,NULL,NULL,NULL),(133,117,'',NULL,NULL,'','6','113','1','1',NULL,NULL,NULL,NULL,NULL,'2','','','',0,', , ',NULL,NULL,NULL,NULL,NULL,NULL,'2018-04-06',NULL,'2018-04-06','A','','','',NULL),(134,118,NULL,NULL,'','','76',NULL,NULL,NULL,'','','',NULL,NULL,NULL,'','','',0,'',NULL,NULL,NULL,NULL,NULL,NULL,'2018-04-09',NULL,'2018-04-09','A',NULL,NULL,NULL,NULL),(135,119,'2222222222222',NULL,NULL,'asdas','36','113','2','1',NULL,NULL,NULL,'','','2','','','',0,'','',NULL,'',NULL,NULL,NULL,'2018-04-23',NULL,'2018-04-23','A','asdas','2222222222222','asdas','723273'),(136,120,'1111111111111',NULL,NULL,'asd','35','113','3','1',NULL,NULL,NULL,NULL,NULL,'2',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-04-23',NULL,'2018-04-23','A','asda','1111111111111','asdas','273273273'),(137,121,'1111111111111',NULL,NULL,'ko','36','113','3','2',NULL,NULL,NULL,NULL,NULL,'2',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-04-23',NULL,'2018-04-23','A','ko','1111111111111','ok','56'),(138,122,'1111111111111',NULL,NULL,'qhshsshs','36','113','2','2',NULL,NULL,NULL,NULL,NULL,'2',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-04-23',NULL,'2018-04-23','A','hsshs','6666666666666','hssh','33'),(139,123,'',NULL,'','','39','113','1','1','','','','','',NULL,'','','',0,'','',NULL,'',NULL,NULL,NULL,'2018-06-05',NULL,'2018-06-05','A','','','',''),(140,124,'',NULL,'','','38','113','1','1','','','','','',NULL,'','','',0,'','',NULL,'',NULL,NULL,NULL,'2018-06-05',NULL,'2018-06-05','A','','','',''),(141,125,NULL,NULL,NULL,'','29',NULL,NULL,NULL,'Zohaib','03452139691','4220136302615','4000','3000',NULL,'0344-1133558','0333-2537864','3',0,',,,','کوئی نہیں',NULL,'کراچی','2018-06-05',NULL,NULL,'2018-06-05',NULL,'2018-06-05',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `userdetails` ENABLE KEYS */;
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
