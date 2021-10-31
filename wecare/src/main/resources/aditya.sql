CREATE SCHEMA wecare;
CREATE TABLE wecare.cust (
  `customer_name` varchar(255) DEFAULT NULL,
  `customer_city` varchar(255) DEFAULT NULL,
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`customer_id`)
);

CREATE TABLE wecare.login (
`login_id` int(10) NOT NULL AUTO_INCREMENT,
`username` varchar(50) DEFAULT NULL,
  `password` varchar (50) default NULL,
  `is_locked` varchar (10) default NULL,
  PRIMARY KEY (`login_id`)
);