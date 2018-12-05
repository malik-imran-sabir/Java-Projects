INSERT INTO `location`.`locationmapping` (`id`,`name`,`parentLocationId`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`,`status`) VALUES (1,'Country',0,'system',now(),'system',now(),'A');
INSERT INTO `location`.`locationmapping` (`id`,`name`,`parentLocationId`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`,`status`) VALUES (2,'Province',last_insert_id(),'system',now(),'system',now(),'A');
INSERT INTO `location`.`locationmapping` (`id`,`name`,`parentLocationId`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`,`status`) VALUES (3,'Disctrict',last_insert_id(),'system',now(),'system',now(),'A');
INSERT INTO `location`.`locationmapping` (`id`,`name`,`parentLocationId`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`,`status`) VALUES (4,'Tehsil',last_insert_id(),'system',now(),'system',now(),'A');
INSERT INTO `location`.`locationmapping` (`id`,`name`,`parentLocationId`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`,`status`) VALUES (5,'Area',last_insert_id(),'system',now(),'system',now(),'A');

#Country
INSERT INTO `location`.`locationmappingdata`(`id`,`locationMappingId`,`value`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`,`status`) VALUES(1,1,'Pakistan','system',now(),'system',now(),'A');
#Province
INSERT INTO `location`.`locationmappingdata`(`id`, `locationMappingId`,`locationMappingDataId`,`value`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`,`status`) VALUES(2,2,1,'Sindh','system',now(),'system',now(),'A');
INSERT INTO `location`.`locationmappingdata`(`id`,`locationMappingId`,`locationMappingDataId`,`value`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`,`status`) VALUES(3,2,1,'Punjab','system',now(),'system',now(),'A');
INSERT INTO `location`.`locationmappingdata`(`id`,`locationMappingId`,`locationMappingDataId`,`value`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`,`status`) VALUES(4,2,1,'Balochistan','system',now(),'system',now(),'A');
INSERT INTO `location`.`locationmappingdata`(`id`,`locationMappingId`,`locationMappingDataId`,`value`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`,`status`) VALUES(5,2,1,'Khyber Pakhtoonkhuwah','system',now(),'system',now(),'A');
#District
INSERT INTO `location`.`locationmappingdata`(`id`,`locationMappingId`,`locationMappingDataId`,`value`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`,`status`) VALUES(6,3,2,'Karachi Central Disctict','system',now(),'system',now(),'A');
INSERT INTO `location`.`locationmappingdata`(`id`,`locationMappingId`,`locationMappingDataId`,`value`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`,`status`) VALUES(7,3,2,'Karachi East District','system',now(),'system',now(),'A');
INSERT INTO `location`.`locationmappingdata`(`id`,`locationMappingId`,`locationMappingDataId`,`value`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`,`status`) VALUES(8,3,2,'Karachi South District','system',now(),'system',now(),'A');
INSERT INTO `location`.`locationmappingdata`(`id`,`locationMappingId`,`locationMappingDataId`,`value`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`,`status`) VALUES(9,3,2,'Karachi West District','system',now(),'system',now(),'A');
INSERT INTO `location`.`locationmappingdata`(`id`,`locationMappingId`,`locationMappingDataId`,`value`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`,`status`) VALUES(10,3,2,'Karachi Korangi District','system',now(),'system',now(),'A');
INSERT INTO `location`.`locationmappingdata`(`id`,`locationMappingId`,`locationMappingDataId`,`value`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`,`status`) VALUES(11,3,2,'Karachi Malir District','system',now(),'system',now(),'A');
INSERT INTO `location`.`locationmappingdata`(`id`,`locationMappingId`,`locationMappingDataId`,`value`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`,`status`) VALUES(12,3,3,'Bahawalpur Disctrict','system',now(),'system',now(),'A');
INSERT INTO `location`.`locationmappingdata`(`id`,`locationMappingId`,`locationMappingDataId`,`value`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`,`status`) VALUES(13,3,3,'Lahore Disctrict','system',now(),'system',now(),'A');

#Tehsil
INSERT INTO `location`.`locationmappingdata`(`id`,`locationMappingId`,`locationMappingDataId`,`value`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`,`status`) VALUES(14,4,12,'Bahawalpur Tehsil','system',now(),'system',now(),'A');

#Area
INSERT INTO `location`.`locationmappingdata`(`id`,`locationMappingId`,`locationMappingDataId`,`value`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`,`status`) VALUES(15,5,14,'Bahawalpur Area','system',now(),'system',now(),'A');
INSERT INTO `location`.`locationmappingdata`(`id`,`locationMappingId`,`locationMappingDataId`,`value`,`createdBy`,`createdOn`,`lastUpdatedBy`,`lastUpdatedOn`,`status`) VALUES(16,5,6,'Karachi Central Area','system',now(),'system',now(),'A');