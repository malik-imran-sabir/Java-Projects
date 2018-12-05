/*
SQLyog Community v12.4.3 (64 bit)
MySQL - 5.7.17-log : Database - org
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`org` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `org`;

/*Table structure for table `organization` */

DROP TABLE IF EXISTS `organization`;

CREATE TABLE `organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdOn` date NOT NULL,
  `lastUpdatedBy` varchar(255) DEFAULT NULL,
  `lastUpdatedOn` date NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


/*Table structure for table `organizationbranch` */

DROP TABLE IF EXISTS `organizationbranch`;

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
  PRIMARY KEY (`id`),
  KEY `FKcem0dxdv9fk1fum4ohlje7miy` (`organizationId`),
  CONSTRAINT `FKcem0dxdv9fk1fum4ohlje7miy` FOREIGN KEY (`organizationId`) REFERENCES `organization` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table `organizationbranch` */


/*Table structure for table `organizationbranchuser` */

DROP TABLE IF EXISTS `organizationbranchuser`;

CREATE TABLE `organizationbranchuser` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdOn` date NOT NULL,
  `lastUpdatedBy` varchar(255) DEFAULT NULL,
  `lastUpdatedOn` date NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `organizationBranchId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKakcp4s0sypbsap886l95bpn49` (`organizationBranchId`),
  CONSTRAINT `FKakcp4s0sypbsap886l95bpn49` FOREIGN KEY (`organizationBranchId`) REFERENCES `organizationbranch` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `organizationbranchuser` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
