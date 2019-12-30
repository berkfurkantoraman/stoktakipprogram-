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
-- Table structure for table `ürün_stok`
--

DROP TABLE IF EXISTS `ürün_stok`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ürün_stok` (
  `Barkod_id` varchar(15) NOT NULL,
  `depo_tipi` varchar(45) DEFAULT NULL,
  `mevcut_stok` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Barkod_id`),
  CONSTRAINT `for_k` FOREIGN KEY (`Barkod_id`) REFERENCES `ürün` (`Barkod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ürün_stok`
--

LOCK TABLES `ürün_stok` WRITE;
/*!40000 ALTER TABLE `ürün_stok` DISABLE KEYS */;
INSERT INTO `ürün_stok` VALUES ('1000','Adet','450'),('1001','Kilogram','322'),('1005','Metre^2','745'),('1008','Kilogram','1500'),('1009','Metre','295'),('1011000','Kilogram','55'),('1065','Litre','1500'),('1150','Kilogram','400'),('1213','Adet','85'),('1244','Kilogram','325'),('2131','Kilogram','950'),('22455','Metre^2','41'),('3215','Adet','175'),('5646','Adet','40'),('5656','Kilogram','9'),('65652','Kilogram','87'),('741','Metre^2','19'),('7894651','Kilogram','98'),('963','Litre','87');
/*!40000 ALTER TABLE `ürün_stok` ENABLE KEYS */;
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
