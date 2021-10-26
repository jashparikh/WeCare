CREATE TABLE wecare.query (
`query_id` int(10) NOT NULL AUTO_INCREMENT,
`query_description` varchar(1000) DEFAULT NULL,
  `query_answered` Boolean,
  `client_id` int(10),
  `caregiver_id` int(10),
  `manager_id` int(10),
  PRIMARY KEY (`query_id`)
);

CREATE TABLE wecare.appointments (
`appointment_id` int(10) NOT NULL AUTO_INCREMENT,
`appointment_date` varchar(50) DEFAULT NULL,
  `appointment_frequency` varchar (10) default NULL,
  `appointment_length` varchar (10) default NULL,
  `appointment_duration` varchar (10) default NULL,
  `client_id` int(10),
  `caregiver_id` int(10),
  `manager_id` int(10),
  PRIMARY KEY (`appointment_id`)
);