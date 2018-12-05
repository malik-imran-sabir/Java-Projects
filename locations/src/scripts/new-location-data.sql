/*
SQLyog Community v12.4.3 (64 bit)
MySQL - 5.7.17-log : Database - location
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`location` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `location`;

/*Table structure for table `locationmappingdata` */

DROP TABLE IF EXISTS `locationmappingdata`;

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
  KEY `locationMappingData_fk_idx` (`locationMappingId`),
  CONSTRAINT `locationMappingData_fk` FOREIGN KEY (`locationMappingId`) REFERENCES `locationmapping` (`id`) ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

/*Data for the table `locationmappingdata` */

insert  into `locationmappingdata`(`id`,`locationMappingId`,`value`,`valueEng`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`,`status`,`locationMappingDataId`) values 
(1,1,'پاکستان','Pakistan','system','2018-01-22','system','2018-01-22','A',NULL),
(2,2,'سندھ','Sindh','system','2018-01-22','system','2018-01-22','A',1),
(3,2,'پنجاب','Punjab','system','2018-01-22','system','2018-01-22','A',1),
(4,2,'بلوچستان','Balochistan','system','2018-01-22','system','2018-01-22','A',1),
(5,2,'خیبر پختونخواہ','Khyber Pakhtoonkhuwah','system','2018-01-22','system','2018-01-22','A',1),
(6,3,'عمر کوٹ','Umarkot','system','2018-01-22','system','2018-01-22','A',2),
(7,4,'عمر کوٹ','Umarkot','system','2018-01-22','system','2018-01-22','A',6),
(8,3,'ملیر کراچی','Malir Karachi','system','2018-01-22','system','2018-01-22','A',2),
(9,3,'ٹھٹھہ ','ThaTha','system','2018-01-22','system','2018-01-22','A',2),
(10,3,'کشمور','Kashmor','system','2018-01-22','system','2018-01-22','A',2),
(11,3,'جیکب آباد','Jekab Aaabad','system','2018-01-22','system','2018-01-22','A',2),
(12,3,'شہداد کوٹ','Shahdad kot','system','2018-01-22','system','2018-01-22','A',2),
(13,3,'خیر پور میرس','Kherpur Meras','system','2018-01-22','system','2018-01-22','A',2),
(14,3,'نوشہرہ فیروز','Noshehraferoz','system','2018-01-22','system','2018-01-22','A',2),
(15,3,'سانگھڑ','Sanghar','system','2018-01-22','system','2018-01-22','A',2),
(16,3,'میرپور خاص','Meerpurkhas','system','2018-01-22','system','2018-01-22','A',2),
(17,3,'شکار پور','Shikarpur','system','2018-01-22','system','2018-01-22','A',2),
(18,4,'ملیر','Malir','system','2018-01-22','system','2018-01-22','A',8),
(19,4,'ٹھٹھہ','ThaTha','system','2018-01-22','system','2018-01-22','A',9),
(20,4,'جھرک','Jhirk','system','2018-01-22','system','2018-01-22','A',9),
(21,4,'جاتی','Jati','system','2018-01-22','system','2018-01-22','A',9),
(22,4,'کندھ کوٹ','Kandhkot','system','2018-01-22','system','2018-01-22','A',10),
(23,4,'ٹھل','Thul','system','2018-01-22','system','2018-01-22','A',11),
(24,4,'شہداد کوٹ','Shahdad kot','system','2018-01-22','system','2018-01-22','A',12),
(25,4,'ٹھری میر واہ','Thari Meerwah','system','2018-01-22','system','2018-01-22','A',13),
(26,4,'فیض گنج','Faiz ganj','system','2018-01-22','system','2018-01-22','A',13),
(27,4,'محراب پور','Mehrabpur','system','2018-01-22','system','2018-01-22','A',14),
(28,4,'سانگھڑ','Sanghar','system','2018-01-22','system','2018-01-22','A',15),
(29,4,'جھلوری','Jhalori','system','2018-01-22','system','2018-01-22','A',16),
(30,4,'شکار پور','Shikarpur','system','2018-01-22','system','2018-01-22','A',17),
(31,3,'رحیم یار خان','Raheem yar khan','system','2018-01-22','system','2018-01-22','A',3),
(32,3,'چکوال','Chakwal','system','2018-01-22','system','2018-01-22','A',3),
(33,4,'صادق آباد','Sadiqabad','system','2018-01-22','system','2018-01-22','A',31),
(34,4,'تلہ گنگ','Talagang','system','2018-01-22','system','2018-01-22','A',32),
(35,3,'جھل مگسی','Jhal Magsi','system','2018-01-22','system','2018-01-22','A',4),
(36,3,'بولان','Bolan','system','2018-01-22','system','2018-01-22','A',4),
(37,4,'گنداواہ','Gandawah','system','2018-01-22','system','2018-01-22','A',35),
(38,4,'جھل مگسی','Jhal Magsi','system','2018-01-22','system','2018-01-22','A',35),
(39,4,'بھاگ ناڑی ','Bhag Nari','system','2018-01-22','system','2018-01-22','A',36),
(40,3,'لکی مروت بنوں','Laki Marwat Bannu','system','2018-01-22','system','2018-01-22','A',5),
(41,3,'سوات','Sawat','system','2018-01-22','system','2018-01-22','A',5),
(42,4,'سرائے نورنگ','Sray Norang','system','2018-01-22','system','2018-01-22','A',40),
(43,4,'مٹہ','Matta','system','2018-01-22','system','2018-01-22','A',41),
(44,2,'شمالی علاقہ جات','Northern area','system','2018-01-22','system','2018-01-22','A',1),
(45,3,'چترال','Chitral','system','2018-01-22','system','2018-01-22','A',44),
(46,4,'چترال','Chitral','system','2018-01-22','system','2018-01-22','A',45),
(47,4,'مستوج اویر','Mastoj Oweer','system','2018-01-22','system','2018-01-22','A',45),
(48,4,'گرم چشمہ','Garam Chashma','system','2018-01-22','system','2018-01-22','A',45);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
