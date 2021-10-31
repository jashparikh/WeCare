CREATE TABLE wecare.Caregiver (
`caregiver_id` int(10) NOT NULL AUTO_INCREMENT,
`caregiver_name` varchar(20) DEFAULT NULL,
`caregiver_experience` varchar(20) DEFAULT NULL,
`caregiver_specialization` varchar(20) DEFAULT NULL,
`caregiver_about` varchar(2000) DEFAULT NULL,
`caregiver_email` varchar(100) DEFAULT NULL,
`caregiver_review` varchar(4000) DEFAULT NULL,
`caregiver_dob` varchar(20) DEFAULT NULL,
`caregiver_contact_no` varchar(20)  unique,
`address_id` int(10)  ,
`login_id` int(10),
PRIMARY KEY (`caregiver_id`)
);