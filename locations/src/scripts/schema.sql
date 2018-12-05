-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema location
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema location
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `location` DEFAULT CHARACTER SET utf8 ;
USE `location` ;

-- -----------------------------------------------------
-- Table `location`.`locationmapping`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `location`.`locationmapping` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `parentLocationId` BIGINT(20) NOT NULL,
  `createdBy` VARCHAR(255) NULL DEFAULT NULL,
  `createdOn` DATE NOT NULL,
  `lastUpdatedBy` VARCHAR(255) NULL DEFAULT NULL,
  `lastUpdatedOn` DATE NOT NULL,
  `status` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `location`.`locationmappingdata`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `location`.`locationmappingdata` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `locationMappingId` BIGINT(20) NOT NULL,
  `value` VARCHAR(255) NULL DEFAULT NULL,
  `createdBy` VARCHAR(255) NULL DEFAULT NULL,
  `createdOn` DATE NOT NULL,
  `lastUpdatedBy` VARCHAR(255) NULL DEFAULT NULL,
  `lastUpdatedOn` DATE NOT NULL,
  `status` VARCHAR(255) NULL DEFAULT NULL,
  `locationMappingDataId` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `locationMappingData_fk_idx` (`locationMappingId` ASC),
  CONSTRAINT `locationMappingData_fk`
    FOREIGN KEY (`locationMappingId`)
    REFERENCES `location`.`locationmapping` (`id`)
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
