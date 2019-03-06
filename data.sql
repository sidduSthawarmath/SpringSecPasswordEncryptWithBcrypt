CREATE TABLE `app_user_details` (
  `pkId` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pkId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

INSERT INTO `app_user_details` (`pkId`,`password`,`userName`) VALUES 
 (1,'$2a$10$ysFbJ4SVJz05XPeypybnZeQt1dG0hC1AUFDRdDKXwVuqr/N8lyw2a','admin'),
 (2,'$2a$10$PtkYdyigIH5cwlhJI8GwwuhQ/1vbMpjth3bePtVlZt.nylqVydiuK','emp');

 
 
CREATE TABLE `role` (
  `pkId` int(11) NOT NULL AUTO_INCREMENT,
  `roleCode` varchar(255) DEFAULT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pkId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


INSERT INTO `role` (`pkId`,`roleCode`,`roleName`) VALUES 
 (1,'ADMIN','admin'),
 (2,'EMP','employee');



CREATE TABLE `user_role_map` (
  `pkId` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pkId`),
  KEY `FKF3248407E51C48` (`role_id`),
  KEY `FKF32484072C90FDF3` (`user_id`),
  CONSTRAINT `FKF32484072C90FDF3` FOREIGN KEY (`user_id`) REFERENCES `app_user_details` (`pkId`),
  CONSTRAINT `FKF3248407E51C48` FOREIGN KEY (`role_id`) REFERENCES `role` (`pkId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;



INSERT INTO `user_role_map` (`pkId`,`role_id`,`user_id`) VALUES 
 (1,1,1),
 (2,2,2);
