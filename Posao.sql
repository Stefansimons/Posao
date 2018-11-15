-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: posao
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `radnik`
--

DROP TABLE IF EXISTS `radnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `radnik` (
  `idradnik` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `zeljena_plata` int(11) DEFAULT NULL,
  `godina_iskustva` int(11) NOT NULL,
  `datum_prijave` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idradnik`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `radnik`
--

LOCK TABLES `radnik` WRITE;
/*!40000 ALTER TABLE `radnik` DISABLE KEYS */;
INSERT INTO `radnik` VALUES (1,'Stefan','Simonovic',22222,1,'2018-11-15 11:45:03'),(4,'Nikola','Nikolic',60000,2,'2018-11-15 12:42:07'),(6,'Jovan','Jovanovic',366,6,'2018-11-15 12:56:06'),(7,'Filip','Filipovic',60000,2,'2018-11-15 13:01:16'),(8,'Milici','Marinkovic',60000,3,'2018-11-15 13:01:46'),(9,'Milan','MiLANOVIC',15000,5,'2018-11-15 13:55:13'),(11,'izmeniaa','asdfgh',266,7,'2018-11-15 14:38:02'),(14,'petar','petrovic',0,5,'2018-11-15 14:52:56'),(18,'Damir','Damirovic',NULL,6,'2018-11-15 21:34:05');
/*!40000 ALTER TABLE `radnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'posao'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-15 22:35:29
