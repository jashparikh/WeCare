CREATE TABLE wecare.cli (

 `client_Fname` varchar(255) DEFAULT NULL,
 `client_Sname` varchar(255) DEFAULT NULL,
 `client_email` varchar(255) DEFAULT NULL,
 `client_dob` varchar(255) DEFAULT 19000101,
 `client_weight` varchar(255) DEFAULT NULL,
 `client_address_id` int(11) DEFAULT NULL,
 `client_about` varchar(255) DEFAULT NULL,
 `client_contact_no` varchar(14) DEFAULT NULL,
 `client_login_id` int(11) default NULL,
 `client_id` int(11) NOT NULL AUTO_INCREMENT,

 PRIMARY KEY (`client_id`)
 );
 
 create table wecare.address (
 `addressId` int(11) not null auto_increment,
 `addressFirstLine` varchar(255) default null,
 `addressSecondLine` varchar(255) default null,
 `city` varchar(255) default null,
 `county` varchar(255) default null,
 `eircode` varchar(255) default null,
 PRIMARY KEY (`addressId`)
 );
 
 create table wecare.CaregiverSchedule (
`shiftId` int(11) not null auto_increment,
`caregiver_id` int(11) default null,
`date` date default null,
`startTime` int(11) default 0,
`endTime` int(11) default 0,
PRIMARY KEY (`shiftId`)
 )