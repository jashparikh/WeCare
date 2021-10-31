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
 `AddressId` int(11) not null auto_increment,
 `AddressFirstLine` varchar(255) default null,
 `AddressSecondLine` varchar(255) default null,
 `City` varchar(255) default null,
 `County` varchar(255) default null,
 `Eircode` varchar(255) default null,
 PRIMARY KEY (`AddressId`)
 );