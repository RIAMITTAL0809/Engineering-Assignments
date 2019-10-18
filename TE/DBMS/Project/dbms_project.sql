-- MySQL dump 10.13  Distrib 5.7.23, for Linux (x86_64)
--
-- Host: localhost    Database: project
-- ------------------------------------------------------
-- Server version	5.7.23-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `holiday`
--

DROP TABLE IF EXISTS `holiday`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `holiday` (
  `name` varchar(50) NOT NULL,
  `source` varchar(50) NOT NULL,
  `destination` varchar(50) NOT NULL,
  `cost` int(11) DEFAULT NULL,
  `date` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`name`,`source`,`destination`),
  CONSTRAINT `holiday_ibfk_1` FOREIGN KEY (`name`) REFERENCES `user` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `holiday`
--

LOCK TABLES `holiday` WRITE;
/*!40000 ALTER TABLE `holiday` DISABLE KEYS */;
/*!40000 ALTER TABLE `holiday` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tour`
--

DROP TABLE IF EXISTS `tour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tour` (
  `source` varchar(50) DEFAULT NULL,
  `destination` varchar(50) DEFAULT NULL,
  `distance` int(11) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `travel_by` varchar(50) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour`
--

LOCK TABLES `tour` WRITE;
/*!40000 ALTER TABLE `tour` DISABLE KEYS */;
INSERT INTO `tour` VALUES ('PUNE','MUMBAI',150,2000,'ROAD,RAIL,AIR',1),('PUNE','BENGALURU',840,4000,'ROAD,RAIL,AIR',2),('PUNE','HYDERABAD',560,3000,'ROAD,RAIL,AIR',3),('PUNE','KOLKATA',1950,5000,'RAIL,AIR',4),('PUNE','NEW DELHI',1450,5000,'RAIL,AIR',5),('PUNE','JAIPUR',1182,5000,'RAIL,AIR',6),('MUMBAI','PUNE',150,2000,'ROAD,RAIL,AIR',7),('BENGALURU','PUNE',840,4000,'ROAD,RAIL,AIR',8),('HYDERABAD','PUNE',560,3000,'ROAD,RAIL,AIR',9),('NEW DELHI','PUNE',1450,5000,'RAIL,AIR',10),('JAIPUR','PUNE',1182,5000,'RAIL,AIR',11),('MUMBAI','BENGALURU',985,3000,'ROAD,RAIL,AIR',12),('MUMBAI','HYDERABAD',710,3000,'ROAD,RAIL,AIR',13),('MUMBAI','KOLKATA',2050,5000,'RAIL,AIR',14),('MUMBAI','NEW DELHI',1410,4000,'RAIL,AIR',15),('MUMBAI','JAIPUR',1160,3000,'RAIL,AIR',16),('KOLKATA','PUNE',1950,5000,'RAIL,AIR',17),('NEW DELHI','MUMBAI',1410,4000,'RAIL,AIR',18),('NEW DELHI','JAIPUR',268,1000,'ROAD,RAIL,AIR',19),('NEW DELHI','BENGALURU',2155,4000,'RAIL,AIR',20),('NEW DELHI','HYDERABAD',1565,3500,'RAIL,AIR',21),('NEW DELHI','KOLKATA',1470,3500,'RAIL,AIR',22),('KOLKATA','BENGALURU',1860,3500,'RAIL,AIR',23),('KOLKATA','HYDERABAD',1490,3500,'RAIL,AIR',24),('KOLKATA','JAIPUR',1510,3000,'RAIL,AIR',25),('KOLKATA','MUMBAI',2050,5000,'RAIL,AIR',26),('KOLKATA','MUMBAI',1470,3500,'RAIL,AIR',27),('BENGALURU','MUMBAI',985,3000,'RAIL,AIR',28),('BENGALURU','HYDERABAD',570,1000,'ROAD,RAIL,AIR',29),('BENGALURU','NEW DELHI',2155,4000,'RAIL,AIR',30);
/*!40000 ALTER TABLE `tour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `name` varchar(50) NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`name`,`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('ANKITA','DAPOLI','823754547','ANKITANARKHEDE5077@GMAIL.COM'),('NEEV','PUNE','7709130362','NEEVMITTAL2@GMAIL.COM'),('RIA','PUNE','8237529877','MITTALRIA0809@GMAIL.COM'),('ROHIT','pune','99098765','ROHITPINGULKAR123@GMAIL.COM');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-16  2:43:20