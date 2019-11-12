CREATE DATABASE IF NOT EXISTS `lernia_addressbook` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `lernia_addressbook`;

CREATE TABLE IF NOT EXISTS `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `person_id` int(11) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT utc_timestamp(),
  `street` varchar(100) DEFAULT NULL,
  `areacode` varchar(20) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_address_person` (`person_id`),
  CONSTRAINT `FK_address_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) NOT NULL DEFAULT 'John',
  `last_name` varchar(100) NOT NULL DEFAULT 'Doe',
  `phone_number` varchar(50) DEFAULT '123-123-123',
  `email` varchar(100) NOT NULL DEFAULT 'john@doe.com',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
