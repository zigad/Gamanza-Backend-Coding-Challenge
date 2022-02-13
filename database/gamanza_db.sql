-- MySQL dump 10.13  Distrib 8.0.28, for macos11 (x86_64)
--
-- Host: localhost    Database: gamanza
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `games`
--

DROP TABLE IF EXISTS `games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `games` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `players` varchar(255) DEFAULT NULL,
  `images` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
INSERT INTO `games` VALUES (1,'Game','Simple game','324,12431,123,441,12','[\"game/img1.jpg\", \"game//img2.jpg\"]'),(2,'Game1','Simple game 1','1,3542,143,88876','[\"/img1.jpg\", \"/img2.jpg\"]'),(3,'Game 3','Totaly Random Game 3','52345234,45234,342,123,1,34234','[img.jpg]'),(4,'Game 4','Totaly Random Game 4','33124, 21242135,5262,112,2','[img.jpg]'),(6,'Updated Game 1','Totaly  Updated Random Game 3','33124,21242135,5262,112,2','[img.jpg]'),(7,'Game','Simple game ID 7','576,1,3144,3214134,21452,345','[\"game/img5.jpg\", \"game/img28.jpg\"]'),(8,'Game','Simple game ID 77878','576,1,3144,3214134,21452,345','[\"game/img5.jpg\", \"game/img28.jpg\"]'),(9,'Game','Simple game ID 76756','576,1,3144,3214134,21452,345','[\"game/img5.jpg\", \"game/img28.jpg\"]'),(10,'Game','Simple game ID 232','576,1,3144,3214134,21452,345','[\"game/img5.jpg\", \"game/img28.jpg\"]'),(11,'Game','Simple game ID 12121','576,1,3144,3214134,21452,345','[\"game/img5.jpg\", \"game/img28.jpg\"]'),(12,'Game','Simple game ID 543','576,1,3144,3214134,21452,345','[\"game/img5.jpg\", \"game/img28.jpg\"]'),(13,'Game','Simple game ID 5646','576,1,3144,3214134,21452,345','[\"game/img5.jpg\", \"game/img28.jpg\"]'),(14,'Game','Simple game ID 8787','576,1,3144,3214134,21452,345','[\"game/img5.jpg\", \"game/img28.jpg\"]'),(15,'Game','Simple game ID 9879879','576,1,3144,3214134,21452,345','[\"game/img5.jpg\", \"game/img28.jpg\"]'),(16,'Game','Simple game ID 888','576,1,3144,3214134,21452,345','[\"game/img5.jpg\", \"game/img28.jpg\"]');
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `players` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `last_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES (1,'Žiga','Deisinger','1997-11-18'),(2,'Janez','Novak','1996-11-18'),(4,'Rok','Novakovič','1990-11-18'),(5,'Rok','Novak','1990-11-18'),(6,'Rok','Prša','1981-11-18');
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-13 23:00:01
