-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ürün`
--

DROP TABLE IF EXISTS `ürün`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ürün` (
  `Barkod_id` varchar(15) NOT NULL,
  `İsim` varchar(45) DEFAULT NULL,
  `birim_fiyat` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Barkod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ürün`
--

LOCK TABLES `ürün` WRITE;
/*!40000 ALTER TABLE `ürün` DISABLE KEYS */;
INSERT INTO `ürün` VALUES ('1000','Cif 750ml','11,76'),('1001','Hamsi','9,99'),('1005','Kumaş','1,50'),('1008','Karpuz','0,75'),('1009','Perde','55,45'),('1011000','Muz İthal','10,90'),('1065','Erikli Su','0,50'),('1150','Kavurma Şahin','152,90'),('1213','Bütün Tavuk','9,45'),('1244','Sucuk Dana','99,90'),('2131','Patates','5,99'),('22455','Halı','13,50'),('3215','Çubuk Kraker','1,5'),('5646','Gazoz','4,45'),('5656','Kivi','18,50'),('65652','Portakal','5,99'),('741','Kilim','9,90'),('7894651','Peynir','24'),('963','Şampuan','35,89');
/*!40000 ALTER TABLE `ürün` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-29 23:35:41
