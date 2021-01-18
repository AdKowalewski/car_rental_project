CREATE DATABASE  IF NOT EXISTS `car_rental_project` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `car_rental_project`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: car_rental_project
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `creation_date` date DEFAULT NULL,
  `modification_date` date DEFAULT NULL,
  `version` bigint NOT NULL,
  `city` varchar(100) NOT NULL,
  `house_number` varchar(100) NOT NULL,
  `local_number` varchar(100) DEFAULT NULL,
  `street` varchar(100) NOT NULL,
  `zip_code` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `creation_date` date DEFAULT NULL,
  `modification_date` date DEFAULT NULL,
  `version` bigint NOT NULL,
  `body_type` varchar(50) NOT NULL,
  `brand` varchar(50) NOT NULL,
  `color` varchar(50) NOT NULL,
  `daily_fee` int NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `engine_capacity` double NOT NULL,
  `fuel_type` varchar(255) NOT NULL,
  `has_ac` bit(1) NOT NULL,
  `horse_power` int NOT NULL,
  `is_manual` bit(1) NOT NULL,
  `mileage` int NOT NULL,
  `model` varchar(50) NOT NULL,
  `number_of_doors` int NOT NULL,
  `number_of_seats` int NOT NULL,
  `registration_number` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `year` int NOT NULL,
  `department_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbr1okm0p10pjybl697sl0b36q` (`department_id`),
  CONSTRAINT `FKbr1okm0p10pjybl697sl0b36q` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `creation_date` date DEFAULT NULL,
  `modification_date` date DEFAULT NULL,
  `version` bigint NOT NULL,
  `email` varchar(50) NOT NULL UNIQUE,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL,
  `user_type` varchar(255) NOT NULL,
  `document_num` varchar(255) NULL,
  `id_document_enum` varchar(255) NULL,
  `address_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKglkhkmh2vyn790ijs6hiqqpi` (`address_id`),
  CONSTRAINT `FKglkhkmh2vyn790ijs6hiqqpi` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `creation_date` date DEFAULT NULL,
  `modification_date` date DEFAULT NULL,
  `version` bigint NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone_number` varchar(100) NOT NULL,
  `address_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7jumubp4ks3jmgkvxuglx3x6x` (`address_id`),
  CONSTRAINT `FK7jumubp4ks3jmgkvxuglx3x6x` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `photo`
--

DROP TABLE IF EXISTS `photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `photo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `url` LONGTEXT NOT NULL,
  `car_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa8cqhuyx228468h5sqxo5dht5` (`car_id`),
  CONSTRAINT `FKa8cqhuyx228468h5sqxo5dht5` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photo`
--

LOCK TABLES `photo` WRITE;
/*!40000 ALTER TABLE `photo` DISABLE KEYS */;
/*!40000 ALTER TABLE `photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `creation_date` date DEFAULT NULL,
  `modification_date` date DEFAULT NULL,
  `version` bigint NOT NULL,
  `receive_description` varchar(255) DEFAULT NULL,
  `rent_date` datetime NOT NULL,
  `rent_description` varchar(255) DEFAULT NULL,
  `reservation_status` varchar(255) NOT NULL,
  `return_date` datetime NOT NULL,
  `total_cost` decimal(19,2) NOT NULL,
  `car_id` bigint NOT NULL,
  `customer_id` bigint NOT NULL,
  `from_department_id` bigint DEFAULT NULL,
  `to_department_id` bigint DEFAULT NULL,
  `receive_worker_id` bigint DEFAULT NULL,
  `rent_worker_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgkmbspv7rljixxoxo1af80lpp` (`car_id`),
  KEY `FK41v6ueo0hiran65w8y1cta2c2` (`customer_id`),
  KEY `FKt4ix359wirsopgnsfs659eu5k` (`from_department_id`),
  KEY `FK5q1allc4luafy0fik7k0k8a2y` (`to_department_id`),
  KEY `FKn2urj8ngrh4n4c6e7yf39bshe` (`receive_worker_id`),
  KEY `FK4ej9sf2u4ntfm9w5yelsm9g54` (`rent_worker_id`),
  CONSTRAINT `FK41v6ueo0hiran65w8y1cta2c2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FK4ej9sf2u4ntfm9w5yelsm9g54` FOREIGN KEY (`rent_worker_id`) REFERENCES `worker` (`id`),
  CONSTRAINT `FK5q1allc4luafy0fik7k0k8a2y` FOREIGN KEY (`to_department_id`) REFERENCES `department` (`id`),
  CONSTRAINT `FKgkmbspv7rljixxoxo1af80lpp` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`),
  CONSTRAINT `FKn2urj8ngrh4n4c6e7yf39bshe` FOREIGN KEY (`receive_worker_id`) REFERENCES `worker` (`id`),
  CONSTRAINT `FKt4ix359wirsopgnsfs659eu5k` FOREIGN KEY (`from_department_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worker`
--

DROP TABLE IF EXISTS `worker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `worker` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `creation_date` date DEFAULT NULL,
  `modification_date` date DEFAULT NULL,
  `version` bigint NOT NULL,
  `email` varchar(50) NOT NULL UNIQUE,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL,
  `user_type` varchar(255) NOT NULL,
  `hire_date` datetime NOT NULL,
  `address_id` bigint DEFAULT NULL,
  `department_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm60iyfk5jne6qi8gwgp74e493` (`address_id`),
  KEY `FKbrvrkgp08rv8dw9msd556xwdg` (`department_id`),
  CONSTRAINT `FKbrvrkgp08rv8dw9msd556xwdg` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  CONSTRAINT `FKm60iyfk5jne6qi8gwgp74e493` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worker`
--

LOCK TABLES `worker` WRITE;
/*!40000 ALTER TABLE `worker` DISABLE KEYS */;
/*!40000 ALTER TABLE `worker` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-03 18:58:49