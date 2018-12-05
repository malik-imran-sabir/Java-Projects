/*
SQLyog Community v12.4.3 (64 bit)
MySQL - 5.7.17-log : Database - reportsdata
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`reportsdata` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `reportsdata`;

/*Table structure for table `form` */

DROP TABLE IF EXISTS `form`;

CREATE TABLE `form` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `formName` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `form` */

insert  into `form`(`id`,`formName`) values 
(1,'فارم برائےکیفیات قرآنی مراکز');

/*Table structure for table `form_questions` */

DROP TABLE IF EXISTS `form_questions`;

CREATE TABLE `form_questions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `formId` bigint(20) DEFAULT NULL,
  `questionId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `form_questions` */

insert  into `form_questions`(`id`,`formId`,`questionId`) values 
(1,1,1),
(2,1,2),
(3,1,3),
(4,1,4),
(5,1,5),
(6,1,6),
(7,1,7),
(8,1,8),
(9,1,9),
(10,1,10),
(11,1,11),
(12,1,12),
(13,1,13),
(14,1,14),
(15,1,15),
(16,1,16);

/*Table structure for table `madarsa_form` */

DROP TABLE IF EXISTS `madarsa_form`;

CREATE TABLE `madarsa_form` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `madarsaId` bigint(20) DEFAULT NULL,
  `formId` bigint(20) DEFAULT NULL,
  `createdOn` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `madarsa_form` */

insert  into `madarsa_form`(`id`,`madarsaId`,`formId`,`createdOn`) values 
(1,NULL,NULL,NULL);

/*Table structure for table `question_answers` */

DROP TABLE IF EXISTS `question_answers`;

CREATE TABLE `question_answers` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `questionId` bigint(20) DEFAULT NULL,
  `answer` varchar(225) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `createdOn` date DEFAULT NULL,
  `createdBy` varchar(225) DEFAULT NULL,
  `lastUpdatedOn` date DEFAULT NULL,
  `lastUpdatedBy` varchar(225) DEFAULT NULL,
  `status` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `question_answers` */

insert  into `question_answers`(`id`,`questionId`,`answer`,`userId`,`createdOn`,`createdBy`,`lastUpdatedOn`,`lastUpdatedBy`,`status`) values 
(2,1,'yes',1,'2018-01-26',NULL,'2018-01-26',NULL,'A'),
(3,1,'yes',1,'2018-01-26',NULL,'2018-01-26',NULL,'A'),
(4,1,'yes',1,'2018-01-26',NULL,'2018-01-26',NULL,'A');

/*Table structure for table `questions` */

DROP TABLE IF EXISTS `questions`;

CREATE TABLE `questions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `question` varchar(225) DEFAULT NULL,
  `type` bigint(20) DEFAULT NULL,
  `option` varchar(225) DEFAULT NULL,
  `createdOn` date DEFAULT NULL,
  `lastUpdatedOn` date DEFAULT NULL,
  `Status` varchar(225) DEFAULT NULL,
  `createdBy` varchar(225) DEFAULT NULL,
  `lastUpdatedBy` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `questions` */

insert  into `questions`(`id`,`question`,`type`,`option`,`createdOn`,`lastUpdatedOn`,`Status`,`createdBy`,`lastUpdatedBy`) values 
(1,'آج کی تاریخ',2,NULL,'2018-01-23',NULL,'A',NULL,NULL),
(2,'مرکز کا نام',2,NULL,'2018-01-23',NULL,'A',NULL,NULL),
(3,'اس ماہ استاذ کی چھٹیوں کی تعداد',2,NULL,'2018-01-23',NULL,'A',NULL,NULL),
(4,'   بچوں کی کل تعداد',2,NULL,'2018-01-23',NULL,'A',NULL,NULL),
(5,' فی الوقت حاضری',2,NULL,'2018-01-23',NULL,'A',NULL,NULL),
(6,'کل وقتی بچوں کی کل تعداد',2,NULL,'2018-01-23',NULL,'A',NULL,NULL),
(7,'بچوں کی پڑھائی کی کیفیت',1,' خراب ہے،بہت خراب ہے،بہترہے , بہت بہترہے','2018-01-23',NULL,'A',NULL,NULL),
(8,'بچوں کے لباس کی کیفیت کیسی ہے',1,' خراب ہے،بہت خراب ہے،بہترہے , بہت بہترہے','2018-01-23',NULL,'A',NULL,NULL),
(9,'کتنے بچوں یا بچیوں نے ٹوپیاں یادوپٹے نہیں پہن رکھے',2,NULL,'2018-01-23',NULL,'A',NULL,NULL),
(10,'کتنے بچوں کے ناخن صاف یا کٹے ہوئے نہیں ہیں',2,NULL,'2018-01-23',NULL,'A',NULL,NULL),
(11,'کیا درسگاہ میں تپائیاں وغیرہ ترتیب سے رکھی ہوئی ہیں',1,'ہاں،نہیں','2018-01-23',NULL,'A',NULL,NULL),
(12,'درسگاہ کی صفائی کی نوعیت کیا ہے',1,' خراب ہے،بہت خراب ہے،بہترہے , بہت بہترہے','2018-01-23',NULL,'A',NULL,NULL),
(13,'کیا مرکز میں بورڈ کااستعمال ہو رہا ہے',1,'ہاں،نہیں','2018-01-23',NULL,'A',NULL,NULL),
(14,'کیا بچوں کے قاعدوں پر ٹرسٹ کے اسٹیکرز چسپاں ہیں',1,'ہاں،نہیں','2018-01-23',NULL,'A',NULL,NULL),
(15,'علاقے کے کن افراد سے ملاقات ہوئی اور انکے تاثرات',2,NULL,'2018-01-23',NULL,'A',NULL,NULL),
(16,'مرکز کےحوالےسےنگران کی رائے',2,NULL,'2018-01-23',NULL,'A',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
