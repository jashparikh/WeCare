CREATE TABLE wecare.caregiver (

 `caregiver_name` varchar(255) DEFAULT NULL,
 `caregiver_experience` varchar(255) DEFAULT NULL,
 `caregiver_specialization` varchar(255) DEFAULT 19000101,
 `caregiver_about` varchar(14) DEFAULT NULL,
 `caregiver_email` varchar(14) DEFAULT NULL,
 `caregiver_review` varchar(14) DEFAULT NULL,
 `caregiver_dob` varchar(14) DEFAULT NULL,
 `caregiver_contact_no` varchar(14) DEFAULT NULL,
 `address_id` int(11) default NULL,
 `login_id` int(11) default NULL,
 `caregiver_id` int(11) NOT NULL AUTO_INCREMENT,

 PRIMARY KEY (`caregiver_id`)
 );