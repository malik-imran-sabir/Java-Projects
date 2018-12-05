/*
SQLyog Community v12.4.3 (64 bit)
MySQL - 5.7.17-log : Database - user
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`user` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `user`;

/*Data for the table `attendance` */

insert  into `attendance`(`id`,`date`,`shiftId`,`classId`,`userId`,`startTime`,`endTime`,`presenceStatus`,`lessonStart`,`lessonEnd`,`createdOn`,`createdBy`,`lastUpdatedOn`,`lastUpdatedBy`,`status`) values 
(1,'2018-02-15','2','1','34','2018-02-15 19:52:00','2018-02-15 19:52:00','p',NULL,NULL,'2018-02-15',NULL,'2018-02-15',NULL,NULL),
(2,'2018-02-15','2','1','35','2018-02-15 19:52:00','2018-02-15 19:52:00','p',NULL,NULL,'2018-02-15',NULL,'2018-02-15',NULL,NULL),
(3,'2018-02-15','2','1','36','2018-02-15 19:52:00','2018-02-15 19:52:00','p',NULL,NULL,'2018-02-15',NULL,'2018-02-15',NULL,NULL),
(4,'2018-02-15','2','1','37','2018-02-15 19:52:00','2018-02-15 19:52:00','p',NULL,NULL,'2018-02-15',NULL,'2018-02-15',NULL,NULL),
(5,'2018-02-15','2','1','38','2018-02-15 19:52:00','2018-02-15 19:52:00','p',NULL,NULL,'2018-02-15',NULL,'2018-02-15',NULL,NULL),
(6,'2018-02-15','2','1','39','2018-02-15 19:52:00','2018-02-15 19:52:00','p',NULL,NULL,'2018-02-15',NULL,'2018-02-15',NULL,NULL),
(7,'2018-02-19','1','1','61','2018-02-19 11:00:00','2018-02-19 12:00:00','a',NULL,NULL,'2018-02-19',NULL,'2018-02-19',NULL,NULL),
(8,'2018-02-19','1','1','62','2018-02-19 11:00:00','2018-02-19 12:00:00','l',NULL,NULL,'2018-02-19',NULL,'2018-02-19',NULL,NULL),
(9,'2018-02-19','1','1','63','2018-02-19 11:00:00','2018-02-19 12:00:00','p',NULL,NULL,'2018-02-19',NULL,'2018-02-19',NULL,NULL),
(10,'2018-02-19','2','1','66','2018-02-19 19:00:00','2018-02-19 20:00:00','a',NULL,NULL,'2018-02-19',NULL,'2018-02-19',NULL,NULL),
(11,'2018-02-19','3','1','67','2018-02-19 21:00:00','2018-02-19 22:00:00','p',NULL,NULL,'2018-02-19',NULL,'2018-02-19',NULL,NULL),
(12,'2018-02-19','1','1','61','2018-02-20 00:27:00','2018-02-20 00:27:00','p',NULL,NULL,'2018-02-19',NULL,'2018-02-19',NULL,NULL),
(13,'2018-02-19','1','1','62','2018-02-20 00:27:00','2018-02-20 00:27:00','p',NULL,NULL,'2018-02-19',NULL,'2018-02-19',NULL,NULL),
(14,'2018-02-19','1','1','63','2018-02-20 00:27:00','2018-02-20 00:27:00','p',NULL,NULL,'2018-02-19',NULL,'2018-02-19',NULL,NULL);

/*Data for the table `authority` */

insert  into `authority`(`id`,`name`) values 
(1,'ROLE_USER'),
(2,'ROLE_ADMIN');

/*Data for the table `class` */

insert  into `class`(`id`,`name`) values 
(1,'حفظ'),
(2,'ناظرہ'),
(3,'قائدہ');

/*Data for the table `contact` */

insert  into `contact`(`id`,`contact`,`contactTypeId`,`userId`,`status`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`) values 
(1,'03312842909',1,51,NULL,NULL,'2018-01-24',NULL,'2018-01-24'),
(2,'03002557896',2,51,NULL,NULL,'2018-01-24',NULL,'2018-01-24'),
(3,'03002557896',3,51,NULL,NULL,'2018-01-24',NULL,'2018-01-24'),
(4,'03312842909',1,52,NULL,NULL,'2018-01-24',NULL,'2018-01-24'),
(5,'03002557896',2,52,NULL,NULL,'2018-01-24',NULL,'2018-01-24'),
(6,'03002557896',3,52,NULL,NULL,'2018-01-24',NULL,'2018-01-24'),
(7,'03312842909',1,53,NULL,NULL,'2018-01-24',NULL,'2018-01-24'),
(8,'03002557896',2,53,NULL,NULL,'2018-01-24',NULL,'2018-01-24'),
(9,'03002557896',3,53,NULL,NULL,'2018-01-24',NULL,'2018-01-24'),
(10,'03312842909',1,54,NULL,NULL,'2018-01-24',NULL,'2018-01-24'),
(11,'03002557896',2,54,NULL,NULL,'2018-01-24',NULL,'2018-01-24'),
(12,'03002557896',3,54,NULL,NULL,'2018-01-24',NULL,'2018-01-24'),
(13,'03312842909',1,59,NULL,NULL,'2018-01-24',NULL,'2018-01-24'),
(14,'03312842909',1,60,NULL,NULL,'2018-01-24',NULL,'2018-01-24'),
(15,'03312842909',1,61,NULL,NULL,'2018-01-24',NULL,'2018-01-24'),
(16,'03312842909',1,62,NULL,NULL,'2018-01-24',NULL,'2018-01-24'),
(17,'03002557896',2,62,NULL,NULL,'2018-01-24',NULL,'2018-01-24'),
(18,'03002557896',3,62,NULL,NULL,'2018-01-24',NULL,'2018-01-24'),
(19,'03312842909',1,67,NULL,NULL,'2018-01-24',NULL,'2018-01-24'),
(20,'03002557896',2,67,NULL,NULL,'2018-01-24',NULL,'2018-01-24'),
(21,'03002557896',3,67,NULL,NULL,'2018-01-24',NULL,'2018-01-24'),
(22,'03312842909',1,68,NULL,NULL,'2018-01-24',NULL,'2018-01-24'),
(23,'03312842909',1,69,NULL,NULL,'2018-01-24',NULL,'2018-01-24'),
(24,'ok',1,70,NULL,NULL,'2018-01-25',NULL,'2018-01-25'),
(25,'asdas',1,71,NULL,NULL,'2018-01-25',NULL,'2018-01-25'),
(26,'',1,72,NULL,NULL,'2018-01-25',NULL,'2018-01-25'),
(27,'',1,73,NULL,NULL,'2018-01-25',NULL,'2018-01-25'),
(28,'',1,74,NULL,NULL,'2018-01-25',NULL,'2018-01-25'),
(29,'',1,75,NULL,NULL,'2018-01-25',NULL,'2018-01-25'),
(30,'',1,76,NULL,NULL,'2018-01-25',NULL,'2018-01-25'),
(31,'',1,77,NULL,NULL,'2018-01-26',NULL,'2018-01-26'),
(41,'0300315588575',1,82,NULL,NULL,'2018-01-26',NULL,'2018-01-26'),
(42,'0300315588575',2,82,NULL,NULL,'2018-01-26',NULL,'2018-01-26'),
(43,'0300315588575',3,82,NULL,NULL,'2018-01-26',NULL,'2018-01-26'),
(44,'03003158573',1,83,NULL,NULL,'2018-01-29',NULL,'2018-01-29'),
(45,'03003158573',2,83,NULL,NULL,'2018-01-29',NULL,'2018-01-29'),
(46,'03003158573',3,83,NULL,NULL,'2018-01-29',NULL,'2018-01-29'),
(47,'03003255857',1,84,NULL,NULL,'2018-01-29',NULL,'2018-01-29'),
(53,'455046866859',1,86,NULL,NULL,'2018-01-29',NULL,'2018-01-29'),
(54,'455046866859',2,86,NULL,NULL,'2018-01-29',NULL,'2018-01-29'),
(55,'455046866859',3,86,NULL,NULL,'2018-01-29',NULL,'2018-01-29'),
(56,'03003158573',1,87,NULL,NULL,'2018-01-29',NULL,'2018-01-29'),
(57,'03003158573',2,87,NULL,NULL,'2018-01-29',NULL,'2018-01-29'),
(58,'03003158573',3,87,NULL,NULL,'2018-01-29',NULL,'2018-01-29');

/*Data for the table `contacttype` */

insert  into `contacttype`(`id`,`name`,`status`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`) values 
(1,'contact-1','A',NULL,NULL,NULL,NULL),
(2,'contact-2','A',NULL,NULL,NULL,NULL),
(3,'contact-3','A',NULL,NULL,NULL,NULL),
(4,'address','A',NULL,NULL,NULL,NULL),
(5,'fax','A',NULL,NULL,NULL,NULL),
(6,'telephone','A',NULL,NULL,NULL,NULL),
(7,'email','A',NULL,NULL,NULL,NULL);

/*Data for the table `otheruserfields` */

insert  into `otheruserfields`(`id`,`name`,`value`,`usertypeid`,`userId`,`status`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`) values 
(1,'madarsaId','3',1,1,'A',NULL,'2018-01-17',NULL,'2018-01-24'),
(2,'fathernic','4550960967615',4,54,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(3,'address','پتا',4,54,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(4,'locationId','18',4,54,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(5,'teacherId','3',4,54,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(6,'shiftId','1',4,54,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(7,'classId','1',4,54,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(8,'fathernic','laptop',4,59,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(9,'address','address',4,59,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(10,'locationId','7',4,59,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(11,'teacherId','3',4,59,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(12,'shiftId','1',4,59,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(13,'classId','2',4,59,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(14,'fathernic','laptop',4,60,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(15,'address','address',4,60,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(16,'locationId','7',4,60,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(17,'teacherId','3',4,60,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(18,'shiftId','1',4,60,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(19,'classId','2',4,60,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(20,'fathernic','laptop',4,61,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(21,'address','address',4,61,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(22,'locationId','7',4,61,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(23,'teacherId','3',4,61,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(24,'shiftId','1',4,61,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(25,'classId','2',4,61,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(26,'fathernic','4550960967615',4,62,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(27,'address','پتا',4,62,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(28,'locationId','18',4,62,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(29,'teacherId','3',4,62,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(30,'shiftId','1',4,62,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(31,'classId','1',4,62,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(32,'fathernic','4550960967615',4,67,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(33,'address','پتا',4,67,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(34,'locationId','18',4,67,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(35,'teacherId','3',4,67,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(36,'shiftId','1',4,67,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(37,'classId','1',4,67,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(38,'fathernic','laptop',4,68,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(39,'address','address',4,68,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(40,'locationId','7',4,68,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(41,'teacherId','3',4,68,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(42,'shiftId','1',4,68,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(43,'classId','2',4,68,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(44,'fathernic','123456789',4,69,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(45,'address','address',4,69,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(46,'locationId','7',4,69,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(47,'teacherId','3',4,69,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(48,'shiftId','1',4,69,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(49,'classId','1',4,69,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(50,'fathernic','4550960967615',4,63,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(52,'locationId','18',4,63,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(53,'teacherId','3',4,63,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(54,'shiftId','1',4,63,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(55,'classId','1',4,63,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(56,'fathernic','4550960967615',4,64,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(57,'address','پتا',4,64,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(58,'locationId','18',4,64,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(59,'teacherId','3',4,64,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(60,'shiftId','1',4,64,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(61,'classId','1',4,64,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(62,'fathernic','4550960967615',4,65,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(63,'address','پتا',4,65,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(64,'locationId','18',4,65,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(65,'teacherId','3',4,65,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(66,'shiftId','1',4,65,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(67,'classId','1',4,65,'A',NULL,'2018-01-24',NULL,'2018-01-24'),
(68,'fathernic','okokoko',4,70,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(69,'address','ok',4,70,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(70,'locationId','7',4,70,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(71,'teacherId','3',4,70,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(72,'shiftId','2',4,70,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(73,'classId','3',4,70,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(74,'fathernic','sham',4,71,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(75,'address','adres',4,71,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(76,'locationId','7',4,71,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(77,'teacherId','3',4,71,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(78,'shiftId','3',4,71,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(79,'classId','2',4,71,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(80,'fathernic','laptop',4,72,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(81,'address','address',4,72,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(82,'locationId','19',4,72,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(83,'teacherId','3',4,72,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(84,'shiftId','1',4,72,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(85,'classId','2',4,72,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(86,'fathernic','laptop',4,73,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(87,'address','address',4,73,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(88,'locationId','7',4,73,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(89,'teacherId','3',4,73,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(90,'shiftId','1',4,73,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(91,'classId','2',4,73,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(92,'fathernic','laptop',4,74,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(93,'address','address',4,74,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(94,'locationId','7',4,74,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(95,'teacherId','3',4,74,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(96,'shiftId','1',4,74,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(97,'classId','2',4,74,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(98,'fathernic','laptop',4,75,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(99,'address','address',4,75,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(100,'locationId','7',4,75,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(101,'teacherId','3',4,75,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(102,'shiftId','1',4,75,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(103,'classId','2',4,75,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(104,'fathernic','laptop',4,76,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(105,'address','address',4,76,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(106,'locationId','7',4,76,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(107,'teacherId','3',4,76,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(108,'shiftId','1',4,76,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(109,'classId','2',4,76,'A',NULL,'2018-01-25',NULL,'2018-01-25'),
(110,'fathernic','laptop',4,77,'A',NULL,'2018-01-26',NULL,'2018-01-26'),
(111,'address','address',4,77,'A',NULL,'2018-01-26',NULL,'2018-01-26'),
(112,'locationId','7',4,77,'A',NULL,'2018-01-26',NULL,'2018-01-26'),
(113,'teacherId','3',4,77,'A',NULL,'2018-01-26',NULL,'2018-01-26'),
(114,'shiftId','1',4,77,'A',NULL,'2018-01-26',NULL,'2018-01-26'),
(115,'classId','2',4,77,'A',NULL,'2018-01-26',NULL,'2018-01-26'),
(122,'fathernic','455046866859',4,86,'A',NULL,'2018-01-29',NULL,'2018-01-29'),
(123,'address','455046866859',4,86,'A',NULL,'2018-01-29',NULL,'2018-01-29'),
(124,'locationId','',4,86,'A',NULL,'2018-01-29',NULL,'2018-01-29'),
(125,'teacherId','3',4,86,'A',NULL,'2018-01-29',NULL,'2018-01-29'),
(126,'shiftId','1',4,86,'A',NULL,'2018-01-29',NULL,'2018-01-29'),
(127,'classId','1',4,86,'A',NULL,'2018-01-29',NULL,'2018-01-29');

/*Data for the table `shift` */

insert  into `shift`(`id`,`name`) values 
(1,'صبح'),
(2,'دوپہر'),
(3,'شام');

/*Data for the table `teacher_student` */

insert  into `teacher_student`(`id`,`studentId`,`teacherId`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`,`status`) values 
(1,61,3,NULL,'2018-02-19',NULL,'2018-02-19','A'),
(2,62,3,NULL,'2018-02-19',NULL,'2018-02-19','A'),
(3,63,3,NULL,'2018-02-19',NULL,'2018-02-19','A'),
(4,66,3,NULL,'2018-02-19',NULL,'2018-02-19','A'),
(5,67,3,NULL,'2018-02-19',NULL,'2018-02-19','A'),
(6,68,0,NULL,'2018-02-20',NULL,'2018-02-20','A'),
(7,69,0,NULL,'2018-02-20',NULL,'2018-02-20','A'),
(8,70,0,NULL,'2018-02-20',NULL,'2018-02-20','A'),
(9,71,0,NULL,'2018-02-20',NULL,'2018-02-20','A'),
(10,72,0,NULL,'2018-02-20',NULL,'2018-02-20','A');

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`dob`,`doj`,`fatherName`,`image`,`last_password_reset_date`,`location`,`madarsaId`,`nic`,`password`,`userTypeId`,`username`,`enabled`,`createdOn`,`createdBy`,`lastUpdatedOn`,`lastUpdatedBy`,`status`) values 
(1,'khalid','2018-02-06','2018-02-06','test','\\image-dir\\KXRZFLI3ZH.jpeg','2018-02-06 22:33:07','18',0,NULL,'$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra','1','khalid',1,'2018-02-23',NULL,'2018-02-23',NULL,NULL),
(3,'Test User','2018-02-07','2018-02-07','Habibullah','\\image-dir\\3JDU5C53HO.jpeg','2018-02-07 14:17:21','16',2,'12525','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra','2','TestTeacher',1,'2018-02-08',NULL,'2018-02-08',NULL,'A'),
(5,'Test Nigran','2018-02-14','2018-02-08','test Walid','\\image-dir\\5QX5VH5W3B.jpeg',NULL,'18',2,'458585858555555','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra','3','khalid-habib',1,'2018-02-07',NULL,'2018-02-07',NULL,'A'),
(8,'Markaz Member 1','2018-02-08','2018-02-08','Markaz member father','\\image-dir\\TBLEZNMRLM.jpeg',NULL,'18',0,'458585858555555','$2a$10$aGFfbPQJS3zR5.00bjLRQu5YtrsWFB10qIqetTyY7EOJPXTwUwXcK','3','a',1,'2018-02-08',NULL,'2018-02-08',NULL,'A'),
(61,'Test abc12','2018-02-07','2018-02-07','test1222',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,1,'2018-02-22',NULL,'2018-02-22',NULL,NULL),
(62,'JAVA','2018-02-19','2018-02-19','JAVA',NULL,NULL,'7',2,NULL,'','4',NULL,1,'2018-02-19',NULL,'2018-02-19',NULL,NULL),
(63,'Sham','2018-02-19','2018-02-19','SHAM',NULL,NULL,'7',2,NULL,'','4',NULL,1,'2018-02-19',NULL,'2018-02-19',NULL,NULL),
(64,'morning','2018-02-19','2018-02-19','SHAM',NULL,NULL,'7',0,NULL,NULL,'4',NULL,1,'2018-02-19',NULL,'2018-02-19',NULL,NULL),
(65,'morning','2018-02-19','2018-02-19','SHAM',NULL,NULL,'7',0,NULL,NULL,'4',NULL,1,'2018-02-19',NULL,'2018-02-19',NULL,NULL),
(66,'zohaib','2018-02-24','2018-02-15','aziz',NULL,NULL,'19',2,NULL,'','4',NULL,1,'2018-02-19',NULL,'2018-02-19',NULL,NULL),
(67,'asad','2018-02-19','2018-02-03','abdullah',NULL,NULL,'22',2,NULL,'','4',NULL,1,'2018-02-19',NULL,'2018-02-19',NULL,NULL),
(68,'Test','2018-02-20','2018-02-20',NULL,'\\image-dir\\1H6YJEZZLG.jpeg',NULL,'7',0,NULL,'',NULL,NULL,1,'2018-02-20',NULL,'2018-02-20',NULL,NULL),
(69,'Test','2018-02-20','2018-02-20',NULL,'\\image-dir\\1BZOLDC44C.jpeg',NULL,'7',0,NULL,'',NULL,NULL,1,'2018-02-20',NULL,'2018-02-20',NULL,NULL),
(70,'Test','2018-02-20','2018-02-20',NULL,'\\image-dir\\QJUOYEHV3U.jpeg',NULL,'7',0,NULL,'',NULL,NULL,1,'2018-02-20',NULL,'2018-02-20',NULL,NULL),
(71,'Test','2018-02-20','2018-02-20',NULL,'\\image-dir\\B79CQ8D7OJ.jpeg',NULL,'7',0,NULL,'',NULL,NULL,1,'2018-02-20',NULL,'2018-02-20',NULL,NULL),
(72,'Test','2018-02-20','2018-02-20',NULL,'\\image-dir\\IEH354XY8M.jpeg',NULL,'7',0,NULL,'',NULL,NULL,1,'2018-02-20',NULL,'2018-02-20',NULL,NULL);

/*Data for the table `user_authority` */

insert  into `user_authority`(`id`,`user_id`,`authority_id`,`createdOn`,`createdBy`,`lastUpdatedBy`,`lastUpdatedOn`,`status`) values 
(1,1,1,'2018-02-12',NULL,NULL,'2018-02-12','A');

/*Data for the table `userdetails` */

insert  into `userdetails`(`id`,`userId`,`fathernic`,`address`,`tempaddress`,`permaddress`,`locationId`,`teacherId`,`shiftId`,`classId`,`easyaccounttitle`,`emobilenumber`,`enic`,`benefitamount`,`salary`,`madarsaId`,`contact1`,`contact2`,`contact3`,`maritalStatus`,`qualification`,`extraQualification`,`modernQualification`,`lastAttendedMadarsa`,`lastQualificationDate`,`otherMadarsas`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`,`status`) values 
(1,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','03003255555585','0300325585','0300325585',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-02-23',NULL,'2018-02-23',NULL),
(3,3,NULL,'test address','test','add','18',NULL,NULL,NULL,'test','0355225225','033002252552','1000','1000','2','0300325585','0300325585','0300325585',1,'Matric','Intermediat','abc','Madarsa','2018-02-01','oth','Zuhaib','2018-02-01','Zuhaib','2018-02-01','A'),
(44,30,'alkesh','address',NULL,NULL,NULL,'3','3','2',NULL,NULL,NULL,NULL,NULL,'3','03',NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-02-12',NULL,'2018-02-12',NULL),
(52,29,'SQA','SQA',NULL,NULL,NULL,'3','1','1',NULL,NULL,NULL,NULL,NULL,'2',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-02-15',NULL,'2018-02-15',NULL),
(58,47,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'03312842909','','',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-02-16',NULL,'2018-02-16',NULL),
(72,62,'1234567894561','JAVA',NULL,NULL,NULL,'3','1','1',NULL,NULL,NULL,NULL,NULL,'2',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-02-19',NULL,'2018-02-19',NULL),
(73,63,'1234567894561','adddress',NULL,NULL,NULL,'3','1','1',NULL,NULL,NULL,NULL,NULL,'2',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-02-19',NULL,'2018-02-19',NULL),
(76,66,'4220135622715','sjsbsbshshsh',NULL,NULL,NULL,'3','2','3',NULL,NULL,NULL,NULL,NULL,'2',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-02-19',NULL,'2018-02-19',NULL),
(77,67,'4221063453792','test',NULL,NULL,NULL,'3','3','2',NULL,NULL,NULL,NULL,NULL,'2',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-02-19',NULL,'2018-02-19',NULL),
(78,68,'1234567897894','Address',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-02-20',NULL,'2018-02-20',NULL),
(79,69,'1234567897894','Address',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-02-20',NULL,'2018-02-20',NULL),
(80,70,'1234567897894','Address',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-02-20',NULL,'2018-02-20',NULL),
(81,71,'1234567897894','Address',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-02-20',NULL,'2018-02-20',NULL),
(82,72,'1234567897894','Address',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-02-20',NULL,'2018-02-20',NULL),
(89,61,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'03312842909','03312842909','03312842909',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-02-22',NULL,'2018-02-22',NULL);

/*Data for the table `usertype` */

insert  into `usertype`(`id`,`name`,`status`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`) values 
(1,'نگران','A',NULL,NULL,NULL,NULL),
(2,'استاذ','A',NULL,NULL,NULL,NULL),
(3,'مرکز میمبر','A',NULL,NULL,NULL,NULL),
(4,'طالب علم','A',NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
