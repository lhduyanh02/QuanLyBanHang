CREATE DATABASE  IF NOT EXISTS `htql_banhang` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `htql_banhang`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 115.74.233.26    Database: htql_banhang
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `activity_log`
--

DROP TABLE IF EXISTS `activity_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user` varchar(15) NOT NULL,
  `action` varchar(255) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `TK_Log_idx` (`user`),
  CONSTRAINT `TK_Log` FOREIGN KEY (`user`) REFERENCES `taikhoan` (`usname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=384 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_log`
--

LOCK TABLES `activity_log` WRITE;
/*!40000 ALTER TABLE `activity_log` DISABLE KEYS */;
INSERT INTO `activity_log` VALUES (1,'2024-04-05 15:38:31','a','Đăng nhập','sign in into systemnbadkjfja as dasjdias ha hduaduah  huhuh osdhaosd oas dao doa doda doias doas'),(2,'2024-04-05 16:24:51','admin','Đăng nhập','đăng nhập thành công'),(3,'2024-04-05 17:38:08','admin','Đăng nhập','Đăng nhập thành công'),(4,'2024-04-05 17:38:44','admin','Đăng xuất','Đăng xuất thành công'),(5,'2024-04-05 17:38:48','admin','Đăng nhập','Đăng nhập thành công'),(6,'2024-04-05 17:39:27','admin','Đăng nhập','Đăng nhập không thành công'),(7,'2024-04-05 17:39:30','admin','Đăng nhập','Đăng nhập không thành công'),(8,'2024-04-05 17:39:33','admin','Đăng nhập','Đăng nhập không thành công'),(9,'2024-04-05 17:39:36','admin','Đăng nhập','Đăng nhập thành công'),(10,'2024-04-05 17:39:57','admin','Đăng xuất','Đăng xuất thành công'),(11,'2024-04-05 17:41:06','x','Đăng nhập','Đăng nhập thành công'),(12,'2024-04-05 17:42:15','x','Đăng xuất','Đăng xuất thành công'),(13,'2024-04-05 17:42:46','admin','Đăng nhập','Đăng nhập thành công'),(14,'2024-04-05 17:43:07','admin','Đăng xuất','Đăng xuất thành công'),(15,'2024-04-05 17:44:52','admin','Đăng nhập','Đăng nhập thành công'),(16,'2024-04-05 17:45:23','admin','Đăng xuất','Đăng xuất thành công'),(17,'2024-04-05 17:45:35','admin','Đăng xuất','Đăng xuất thành công'),(18,'2024-04-05 17:46:28','admin','Đăng nhập','Đăng nhập thành công'),(19,'2024-04-05 17:46:41','admin','Đăng xuất','Đăng xuất thành công'),(20,'2024-04-05 17:47:12','admin','Đăng nhập','Đăng nhập thành công'),(21,'2024-04-05 17:47:22','admin','Đăng xuất','Đăng xuất thành công'),(22,'2024-04-05 17:49:43','x','Đăng nhập','Đăng nhập thành công'),(23,'2024-04-05 17:50:02','x','Đăng xuất','Đăng xuất thành công'),(24,'2024-04-05 17:50:42','admin','Đăng nhập','Đăng nhập thành công'),(25,'2024-04-05 17:51:13','admin','Đăng xuất','Đăng xuất thành công'),(26,'2024-04-05 17:53:27','x','Đăng nhập','Đăng nhập thành công'),(27,'2024-04-05 17:54:00','x','Đăng xuất','Đăng xuất thành công'),(28,'2024-04-05 18:55:37','x','Đăng nhập','Đăng nhập thành công'),(29,'2024-04-05 18:56:57','x','Thêm bàn','Thêm bàn mới với tên: bàn mới'),(30,'2024-04-05 18:57:13','x','Thêm bàn','Thêm bàn mới với mã: MaMoi, tên: MaBan Mới'),(31,'2024-04-05 18:58:26','x','Đăng xuất','Đăng xuất thành công'),(32,'2024-04-06 00:53:42','admin','Đăng nhập','Đăng nhập thành công'),(33,'2024-04-06 00:55:17','admin','Đăng nhập','Đăng nhập thành công'),(34,'2024-04-06 00:55:26','admin','Đăng xuất','Đăng xuất thành công'),(35,'2024-04-06 00:56:01','admin','Đăng nhập','Đăng nhập thành công'),(36,'2024-04-06 00:56:33','admin','Đăng xuất','Đăng xuất thành công'),(37,'2024-04-06 00:57:22','x','Đăng nhập','Đăng nhập thành công'),(38,'2024-04-06 00:58:00','x','Đăng xuất','Đăng xuất thành công'),(39,'2024-04-06 01:00:37','x','Đăng nhập','Đăng nhập thành công'),(40,'2024-04-06 01:00:55','x','Đăng xuất','Đăng xuất thành công'),(41,'2024-04-06 01:05:16','x','Đăng nhập','Đăng nhập thành công'),(42,'2024-04-06 01:06:35','x','Đăng xuất','Đăng xuất thành công'),(43,'2024-04-06 01:08:49','x','Đăng nhập','Đăng nhập thành công'),(44,'2024-04-06 01:10:58','x','Đăng xuất','Đăng xuất thành công'),(45,'2024-04-06 01:11:08','x','Đăng nhập','Đăng nhập thành công'),(46,'2024-04-06 01:14:05','x','Đăng xuất','Đăng xuất thành công'),(47,'2024-04-06 01:14:14','x','Đăng nhập','Đăng nhập thành công'),(48,'2024-04-06 01:18:27','x','Đăng xuất','Đăng xuất thành công'),(49,'2024-04-06 01:18:31','x','Đăng nhập','Đăng nhập thành công'),(50,'2024-04-06 01:20:05','x','Đăng nhập','Đăng nhập thành công'),(51,'2024-04-06 01:20:23','x','Đăng xuất','Đăng xuất thành công'),(52,'2024-04-06 01:22:39','x','Đăng nhập','Đăng nhập thành công'),(53,'2024-04-06 01:24:04','x','Đăng xuất','Đăng xuất thành công'),(54,'2024-04-06 01:24:07','x','Đăng xuất','Đăng xuất thành công'),(55,'2024-04-06 01:24:37','x','Đăng nhập','Đăng nhập thành công'),(56,'2024-04-06 01:24:47','x','Tài khoản','Đổi mật khẩu tài khoản: x.'),(57,'2024-04-06 01:24:50','x','Đăng xuất','Đăng xuất thành công'),(58,'2024-04-06 01:28:12','x','Đăng nhập','Đăng nhập thành công'),(59,'2024-04-06 01:28:33','x','Tài khoản','Đổi mật khẩu tài khoản: x.'),(60,'2024-04-06 01:28:52','x','Xóa bàn','Xóa bàn: MaMoi.'),(61,'2024-04-06 01:29:00','x','Thêm bàn','Thêm bàn mới với mã: new, tên: new desk'),(62,'2024-04-06 01:29:12','x','Sửa bàn','Sửa bàn new -> new - new desk 1.'),(63,'2024-04-06 01:29:51','x','Tài khoản','Sửa tài khoản: ngan -> ngan - 0.'),(64,'2024-04-06 01:32:45','x','Đăng xuất','Đăng xuất thành công'),(65,'2024-04-06 01:34:18','x','Đăng nhập','Đăng nhập thành công'),(66,'2024-04-06 01:34:26','x','Tài khoản','Đổi mật khẩu tài khoản: x'),(67,'2024-04-06 01:34:44','x','Xóa phiếu chi','Xóa phiếu chi: 060424-002'),(68,'2024-04-06 01:35:06','x','Tài khoản','Sửa tài khoản: s -> s - 1'),(69,'2024-04-06 01:36:12','x','Đăng xuất','Đăng xuất thành công'),(70,'2024-04-06 01:36:18','admin','Đăng nhập','Đăng nhập thành công'),(71,'2024-04-06 01:36:38','admin','Đăng xuất','Đăng xuất thành công'),(72,'2024-04-07 14:17:56','admin','Đăng nhập','Đăng nhập thành công'),(73,'2024-04-07 14:29:37','admin','Đăng nhập','Đăng nhập thành công'),(74,'2024-04-07 14:30:42','admin','Đăng xuất','Đăng xuất thành công'),(75,'2024-04-07 14:38:57','admin','Đăng nhập','Đăng nhập thành công'),(76,'2024-04-07 14:39:18','admin','Đăng xuất','Đăng xuất thành công'),(77,'2024-04-08 08:58:21','ADMIN','Đăng nhập','Đăng nhập thành công'),(78,'2024-04-08 08:58:40','ADMIN','Đăng xuất','Đăng xuất thành công'),(79,'2024-04-08 20:27:03','ADMIN','Đăng nhập','Đăng nhập thành công'),(80,'2024-04-08 20:28:28','ADMIN','Đăng xuất','Đăng xuất thành công'),(81,'2024-04-09 15:41:20','admin','Đăng nhập','Đăng nhập thành công'),(82,'2024-04-09 15:41:51','admin','Đăng xuất','Đăng xuất thành công'),(83,'2024-04-09 15:42:58','admin','Đăng nhập','Đăng nhập thành công'),(84,'2024-04-09 15:43:20','admin','Đăng xuất','Đăng xuất thành công'),(85,'2024-04-09 16:34:26','admin','Đăng nhập','Đăng nhập thành công'),(86,'2024-04-09 16:34:41','admin','Đăng xuất','Đăng xuất thành công'),(87,'2024-04-09 16:35:33','admin','Đăng nhập','Đăng nhập thành công'),(88,'2024-04-09 16:35:51','admin','Đăng xuất','Đăng xuất thành công'),(89,'2024-04-09 16:38:12','admin','Đăng nhập','Đăng nhập thành công'),(90,'2024-04-09 16:38:41','admin','Đăng xuất','Đăng xuất thành công'),(91,'2024-04-09 16:38:54','admin','Đăng nhập','Đăng nhập thành công'),(92,'2024-04-09 16:39:02','admin','Đăng xuất','Đăng xuất thành công'),(93,'2024-04-09 16:39:13','admin','Đăng nhập','Đăng nhập thành công'),(94,'2024-04-09 16:39:22','admin','Đăng xuất','Đăng xuất thành công'),(95,'2024-04-09 16:39:42','admin','Đăng nhập','Đăng nhập thành công'),(96,'2024-04-09 16:40:18','admin','Đăng xuất','Đăng xuất thành công'),(97,'2024-04-09 16:43:33','admin','Đăng nhập','Đăng nhập thành công'),(98,'2024-04-09 16:45:16','admin','Đăng xuất','Đăng xuất thành công'),(99,'2024-04-09 16:47:20','admin','Đăng nhập','Đăng nhập thành công'),(100,'2024-04-09 16:47:56','admin','Đăng xuất','Đăng xuất thành công'),(101,'2024-04-09 16:50:10','admin','Đăng nhập','Đăng nhập thành công'),(102,'2024-04-09 16:50:17','admin','Đăng xuất','Đăng xuất thành công'),(103,'2024-04-09 16:53:44','admin','Đăng nhập','Đăng nhập thành công'),(104,'2024-04-09 16:53:53','admin','Đăng xuất','Đăng xuất thành công'),(105,'2024-04-09 17:01:29','admin','Đăng nhập','Đăng nhập thành công'),(106,'2024-04-09 17:01:42','admin','Đăng xuất','Đăng xuất thành công'),(107,'2024-04-09 17:04:00','admin','Đăng nhập','Đăng nhập thành công'),(108,'2024-04-09 17:05:31','admin','Đăng xuất','Đăng xuất thành công'),(109,'2024-04-09 19:59:55','admin','Đăng nhập','Đăng nhập thành công'),(110,'2024-04-09 20:01:24','admin','Đăng xuất','Đăng xuất thành công'),(111,'2024-04-09 20:16:21','admin','Đăng nhập','Đăng nhập thành công'),(112,'2024-04-09 20:19:14','admin','Đăng nhập','Đăng nhập thành công'),(113,'2024-04-09 20:19:17','admin','Đăng xuất','Đăng xuất thành công'),(114,'2024-04-09 20:19:47','admin','Đăng xuất','Đăng xuất thành công'),(115,'2024-04-09 20:20:57','admin','Đăng nhập','Đăng nhập thành công'),(116,'2024-04-09 20:21:44','admin','Đăng xuất','Đăng xuất thành công'),(117,'2024-04-09 20:21:48','admin','Đăng nhập','Đăng nhập thành công'),(118,'2024-04-09 20:22:08','admin','Đăng xuất','Đăng xuất thành công'),(119,'2024-04-09 20:22:30','admin','Đăng nhập','Đăng nhập thành công'),(120,'2024-04-09 20:25:34','admin','Đăng xuất','Đăng xuất thành công'),(121,'2024-04-09 20:25:51','admin','Đăng nhập','Đăng nhập thành công'),(122,'2024-04-09 20:27:53','admin','Đăng xuất','Đăng xuất thành công'),(123,'2024-04-09 20:27:59','admin','Đăng nhập','Đăng nhập thành công'),(124,'2024-04-09 20:28:40','admin','Đăng xuất','Đăng xuất thành công'),(125,'2024-04-09 20:28:46','admin','Đăng nhập','Đăng nhập thành công'),(126,'2024-04-09 20:29:24','admin','Đăng xuất','Đăng xuất thành công'),(127,'2024-04-09 20:29:29','admin','Đăng nhập','Đăng nhập thành công'),(128,'2024-04-09 20:45:51','admin','Đăng xuất','Đăng xuất thành công'),(129,'2024-04-09 21:07:59','admin','Đăng nhập','Đăng nhập thành công'),(130,'2024-04-09 21:08:19','admin','Đăng xuất','Đăng xuất thành công'),(131,'2024-04-09 21:08:40','admin','Đăng nhập','Đăng nhập thành công'),(132,'2024-04-09 21:09:39','admin','Đăng xuất','Đăng xuất thành công'),(133,'2024-04-09 21:09:44','admin','Đăng nhập','Đăng nhập thành công'),(134,'2024-04-09 21:22:09','admin','Đăng xuất','Đăng xuất thành công'),(135,'2024-04-09 21:22:29','admin','Đăng nhập','Đăng nhập thành công'),(136,'2024-04-09 21:22:38','admin','Đăng xuất','Đăng xuất thành công'),(137,'2024-04-09 21:50:22','admin','Đăng nhập','Đăng nhập thành công'),(138,'2024-04-09 21:51:25','admin','Đăng xuất','Đăng xuất thành công'),(139,'2024-04-09 21:51:31','admin','Đăng nhập','Đăng nhập thành công'),(140,'2024-04-09 21:51:46','admin','Đăng xuất','Đăng xuất thành công'),(141,'2024-04-09 21:52:43','admin','Đăng nhập','Đăng nhập thành công'),(142,'2024-04-09 21:53:09','admin','Đăng xuất','Đăng xuất thành công'),(143,'2024-04-09 22:11:23','admin','Đăng nhập','Đăng nhập thành công'),(144,'2024-04-09 22:11:37','admin','Đăng xuất','Đăng xuất thành công'),(145,'2024-04-09 22:13:50','admin','Đăng nhập','Đăng nhập thành công'),(146,'2024-04-09 22:15:08','admin','Đăng xuất','Đăng xuất thành công'),(147,'2024-04-09 22:15:14','admin','Đăng nhập','Đăng nhập thành công'),(148,'2024-04-09 22:16:37','admin','Đăng xuất','Đăng xuất thành công'),(149,'2024-04-09 22:17:35','admin','Đăng nhập','Đăng nhập thành công'),(150,'2024-04-09 22:18:52','admin','Đăng xuất','Đăng xuất thành công'),(151,'2024-04-09 22:20:58','admin','Đăng nhập','Đăng nhập thành công'),(152,'2024-04-09 22:21:21','admin','Đăng xuất','Đăng xuất thành công'),(153,'2024-04-09 22:25:10','admin','Đăng nhập','Đăng nhập thành công'),(154,'2024-04-09 22:25:32','admin','Đăng xuất','Đăng xuất thành công'),(155,'2024-04-10 19:55:18','admin','Đăng nhập','Đăng nhập thành công'),(156,'2024-04-10 19:55:32','admin','Đăng xuất','Đăng xuất thành công'),(157,'2024-04-10 20:26:34','admin','Đăng nhập','Đăng nhập thành công'),(158,'2024-04-10 20:28:31','admin','Đăng xuất','Đăng xuất thành công'),(159,'2024-04-10 20:35:05','admin','Đăng nhập','Đăng nhập thành công'),(160,'2024-04-10 20:37:10','admin','Đăng xuất','Đăng xuất thành công'),(161,'2024-04-11 10:43:21','admin','Đăng nhập','Đăng nhập thành công'),(162,'2024-04-11 10:43:23','admin','Đăng xuất','Đăng xuất thành công'),(163,'2024-04-11 10:46:06','admin','Đăng nhập','Đăng nhập thành công'),(164,'2024-04-11 10:46:09','admin','Đăng xuất','Đăng xuất thành công'),(165,'2024-04-11 10:52:37','admin','Đăng nhập','Đăng nhập thành công'),(166,'2024-04-11 10:52:40','admin','Đăng xuất','Đăng xuất thành công'),(167,'2024-04-11 10:53:49','admin','Đăng nhập','Đăng nhập thành công'),(168,'2024-04-11 10:53:51','admin','Đăng xuất','Đăng xuất thành công'),(169,'2024-04-11 11:04:34','admin','Đăng nhập','Đăng nhập thành công'),(170,'2024-04-11 11:08:33','admin','Đăng nhập','Đăng nhập thành công'),(171,'2024-04-11 11:08:49','admin','Đăng xuất','Đăng xuất thành công'),(172,'2024-04-11 11:51:48','admin','Đăng nhập','Đăng nhập thành công'),(173,'2024-04-11 11:51:50','admin','Đăng xuất','Đăng xuất thành công'),(174,'2024-04-11 12:38:08','admin','Đăng nhập','Đăng nhập thành công'),(175,'2024-04-11 12:38:10','admin','Đăng xuất','Đăng xuất thành công'),(176,'2024-04-11 13:07:19','admin','Đăng nhập','Đăng nhập thành công'),(177,'2024-04-11 13:07:20','admin','Đăng xuất','Đăng xuất thành công'),(178,'2024-04-11 15:50:23','admin','Đăng nhập','Đăng nhập thành công'),(179,'2024-04-11 15:50:47','admin','Đăng xuất','Đăng xuất thành công'),(180,'2024-04-11 15:52:09','admin','Đăng nhập','Đăng nhập thành công'),(181,'2024-04-11 15:52:17','admin','Đăng xuất','Đăng xuất thành công'),(182,'2024-04-11 16:30:07','admin','Đăng nhập','Đăng nhập thành công'),(183,'2024-04-11 16:37:23','admin','Đăng xuất','Đăng xuất thành công'),(184,'2024-04-11 16:39:48','admin','Đăng nhập','Đăng nhập thành công'),(185,'2024-04-11 16:44:05','admin','Đăng xuất','Đăng xuất thành công'),(186,'2024-04-11 16:44:11','admin','Đăng nhập','Đăng nhập thành công'),(187,'2024-04-11 16:45:43','admin','Đăng xuất','Đăng xuất thành công'),(188,'2024-04-11 17:12:37','admin','Đăng nhập','Đăng nhập thành công'),(189,'2024-04-11 17:13:20','admin','Đăng xuất','Đăng xuất thành công'),(190,'2024-04-11 17:19:24','admin','Đăng nhập','Đăng nhập thành công'),(191,'2024-04-11 19:02:12','admin','Đăng xuất','Đăng xuất thành công'),(192,'2024-04-11 20:54:14','admin','Đăng nhập','Đăng nhập thành công'),(193,'2024-04-12 01:09:27','admin','Đăng nhập','Đăng nhập thành công'),(194,'2024-04-12 01:09:53','admin','Đăng xuất','Đăng xuất thành công'),(195,'2024-04-12 01:19:08','admin','Đăng nhập','Đăng nhập thành công'),(196,'2024-04-12 01:19:11','admin','Đăng xuất','Đăng xuất thành công'),(197,'2024-04-12 14:45:03','ADMIN','Đăng nhập','Đăng nhập thành công'),(198,'2024-04-12 14:47:08','ADMIN','Đăng xuất','Đăng xuất thành công'),(199,'2024-04-12 14:49:16','ADMIN','Đăng nhập','Đăng nhập thành công'),(200,'2024-04-12 14:57:32','ADMIN','Đăng xuất','Đăng xuất thành công'),(201,'2024-04-12 15:29:12','admin','Đăng nhập','Đăng nhập thành công'),(202,'2024-04-12 15:30:29','admin','Đăng xuất','Đăng xuất thành công'),(203,'2024-04-12 16:24:55','admin','Đăng nhập','Đăng nhập thành công'),(204,'2024-04-12 16:27:12','admin','Đăng xuất','Đăng xuất thành công'),(205,'2024-04-12 16:34:13','admin','Đăng nhập','Đăng nhập thành công'),(206,'2024-04-12 16:34:29','admin','Đăng xuất','Đăng xuất thành công'),(207,'2024-04-12 16:36:44','admin','Đăng nhập','Đăng nhập thành công'),(208,'2024-04-12 16:55:06','admin','Đăng nhập','Đăng nhập thành công'),(209,'2024-04-12 16:55:19','admin','Đăng xuất','Đăng xuất thành công'),(210,'2024-04-12 16:58:32','admin','Đăng nhập','Đăng nhập thành công'),(211,'2024-04-12 16:58:47','admin','Đăng xuất','Đăng xuất thành công'),(212,'2024-04-12 16:59:08','admin','Đăng nhập','Đăng nhập thành công'),(213,'2024-04-12 16:59:15','admin','Đăng xuất','Đăng xuất thành công'),(214,'2024-04-12 16:59:25','admin','Đăng nhập','Đăng nhập thành công'),(215,'2024-04-12 16:59:32','admin','Đăng xuất','Đăng xuất thành công'),(216,'2024-04-12 17:03:13','admin','Đăng nhập','Đăng nhập thành công'),(217,'2024-04-12 17:03:19','admin','Đăng xuất','Đăng xuất thành công'),(218,'2024-04-12 17:05:18','admin','Đăng nhập','Đăng nhập thành công'),(219,'2024-04-12 17:05:32','admin','Đăng xuất','Đăng xuất thành công'),(220,'2024-04-12 17:06:04','admin','Đăng nhập','Đăng nhập thành công'),(221,'2024-04-12 17:06:24','admin','Đăng xuất','Đăng xuất thành công'),(222,'2024-04-12 17:11:06','admin','Đăng nhập','Đăng nhập thành công'),(223,'2024-04-12 17:11:56','admin','Đăng xuất','Đăng xuất thành công'),(224,'2024-04-12 17:17:15','admin','Đăng nhập','Đăng nhập thành công'),(225,'2024-04-12 17:18:47','admin','Đăng nhập','Đăng nhập thành công'),(226,'2024-04-12 17:21:46','admin','Đăng xuất','Đăng xuất thành công'),(227,'2024-04-12 23:56:34','admin','Đăng nhập','Đăng nhập thành công'),(228,'2024-04-12 23:56:42','admin','Đăng xuất','Đăng xuất thành công'),(229,'2024-04-12 23:58:27','admin','Đăng nhập','Đăng nhập thành công'),(230,'2024-04-13 00:11:26','admin','Đăng xuất','Đăng xuất thành công'),(231,'2024-04-13 00:11:45','admin','Đăng nhập','Đăng nhập thành công'),(232,'2024-04-13 00:11:50','admin','Đăng xuất','Đăng xuất thành công'),(233,'2024-04-13 00:12:03','admin','Đăng nhập','Đăng nhập thành công'),(234,'2024-04-13 00:12:31','admin','Đăng xuất','Đăng xuất thành công'),(235,'2024-04-13 00:32:23','admin','Đăng nhập','Đăng nhập thành công'),(236,'2024-04-13 00:34:02','admin','Đăng nhập','Đăng nhập thành công'),(237,'2024-04-13 00:34:07','admin','Đăng xuất','Đăng xuất thành công'),(238,'2024-04-13 00:34:17','admin','Đăng xuất','Đăng xuất thành công'),(239,'2024-04-13 00:36:09','admin','Đăng nhập','Đăng nhập thành công'),(240,'2024-04-13 00:36:14','admin','Đăng xuất','Đăng xuất thành công'),(241,'2024-04-13 00:38:46','admin','Đăng nhập','Đăng nhập thành công'),(242,'2024-04-13 00:38:51','admin','Đăng xuất','Đăng xuất thành công'),(243,'2024-04-13 00:39:42','admin','Đăng nhập','Đăng nhập thành công'),(244,'2024-04-13 00:41:08','admin','Đăng xuất','Đăng xuất thành công'),(245,'2024-04-13 00:41:12','admin','Đăng nhập','Đăng nhập thành công'),(246,'2024-04-13 00:41:19','admin','Đăng xuất','Đăng xuất thành công'),(247,'2024-04-13 00:43:34','admin','Đăng nhập','Đăng nhập thành công'),(248,'2024-04-13 00:43:39','admin','Đăng xuất','Đăng xuất thành công'),(249,'2024-04-13 00:44:19','admin','Đăng nhập','Đăng nhập thành công'),(250,'2024-04-13 00:44:24','admin','Đăng xuất','Đăng xuất thành công'),(251,'2024-04-13 00:45:17','admin','Đăng nhập','Đăng nhập thành công'),(252,'2024-04-13 00:45:25','admin','Đăng xuất','Đăng xuất thành công'),(253,'2024-04-13 00:47:18','admin','Đăng nhập','Đăng nhập thành công'),(254,'2024-04-13 00:47:26','admin','Đăng xuất','Đăng xuất thành công'),(255,'2024-04-13 00:48:16','admin','Đăng nhập','Đăng nhập thành công'),(256,'2024-04-13 00:48:32','admin','Đăng xuất','Đăng xuất thành công'),(257,'2024-04-13 00:48:58','admin','Đăng nhập','Đăng nhập thành công'),(258,'2024-04-13 00:49:15','admin','Đăng xuất','Đăng xuất thành công'),(259,'2024-04-13 00:51:54','admin','Đăng nhập','Đăng nhập thành công'),(260,'2024-04-13 00:52:03','admin','Đăng xuất','Đăng xuất thành công'),(261,'2024-04-13 00:52:56','admin','Đăng nhập','Đăng nhập thành công'),(262,'2024-04-13 00:53:04','admin','Đăng xuất','Đăng xuất thành công'),(263,'2024-04-13 00:53:37','admin','Đăng nhập','Đăng nhập thành công'),(264,'2024-04-13 00:53:48','admin','Đăng xuất','Đăng xuất thành công'),(265,'2024-04-13 01:01:45','admin','Đăng nhập','Đăng nhập thành công'),(266,'2024-04-13 01:01:59','admin','Đăng xuất','Đăng xuất thành công'),(267,'2024-04-13 01:09:06','admin','Đăng nhập','Đăng nhập thành công'),(268,'2024-04-13 01:09:33','admin','Đăng xuất','Đăng xuất thành công'),(269,'2024-04-13 01:12:27','admin','Đăng nhập','Đăng nhập thành công'),(270,'2024-04-13 01:12:54','admin','Đăng xuất','Đăng xuất thành công'),(271,'2024-04-13 11:11:46','admin','Đăng nhập','Đăng nhập thành công'),(272,'2024-04-13 11:18:39','admin','Đăng xuất','Đăng xuất thành công'),(273,'2024-04-13 11:19:58','admin','Đăng nhập','Đăng nhập thành công'),(274,'2024-04-13 11:20:19','admin','Đăng xuất','Đăng xuất thành công'),(275,'2024-04-13 12:39:07','admin','Đăng nhập','Đăng nhập thành công'),(276,'2024-04-13 12:39:12','admin','Đăng xuất','Đăng xuất thành công'),(277,'2024-04-13 13:00:24','admin','Đăng nhập','Đăng nhập thành công'),(278,'2024-04-13 13:00:51','admin','Đăng xuất','Đăng xuất thành công'),(279,'2024-04-13 18:36:31','admin','Đăng nhập','Đăng nhập thành công'),(280,'2024-04-13 18:37:16','admin','Đăng xuất','Đăng xuất thành công'),(281,'2024-04-13 18:39:21','admin','Đăng nhập','Đăng nhập thành công'),(282,'2024-04-13 18:40:04','admin','Đăng xuất','Đăng xuất thành công'),(283,'2024-04-13 18:46:22','admin','Đăng nhập','Đăng nhập thành công'),(284,'2024-04-13 18:47:01','admin','Đăng xuất','Đăng xuất thành công'),(285,'2024-04-13 18:49:49','admin','Đăng nhập','Đăng nhập thành công'),(286,'2024-04-13 18:52:49','admin','Đăng xuất','Đăng xuất thành công'),(287,'2024-04-13 19:21:18','admin','Đăng nhập','Đăng nhập thành công'),(288,'2024-04-13 19:21:48','admin','Đăng xuất','Đăng xuất thành công'),(289,'2024-04-13 19:22:49','admin','Đăng nhập','Đăng nhập thành công'),(290,'2024-04-13 19:52:37','admin','Đăng xuất','Đăng xuất thành công'),(291,'2024-04-13 20:24:16','admin','Đăng nhập','Đăng nhập thành công'),(292,'2024-04-13 20:24:27','admin','Đăng xuất','Đăng xuất thành công'),(293,'2024-04-13 21:28:26','admin','Đăng nhập','Đăng nhập thành công'),(294,'2024-04-13 21:28:40','admin','Đăng xuất','Đăng xuất thành công'),(295,'2024-04-13 21:29:30','admin','Đăng nhập','Đăng nhập thành công'),(296,'2024-04-13 21:30:39','admin','Đăng xuất','Đăng xuất thành công'),(297,'2024-04-13 21:39:26','admin','Đăng nhập','Đăng nhập thành công'),(298,'2024-04-13 21:39:31','admin','Đăng xuất','Đăng xuất thành công'),(299,'2024-04-13 21:41:02','admin','Đăng nhập','Đăng nhập thành công'),(300,'2024-04-13 21:43:10','admin','Đăng xuất','Đăng xuất thành công'),(301,'2024-04-13 21:50:19','admin','Đăng nhập','Đăng nhập thành công'),(302,'2024-04-13 21:50:33','admin','Đăng xuất','Đăng xuất thành công'),(303,'2024-04-13 21:52:14','admin','Đăng nhập','Đăng nhập thành công'),(304,'2024-04-13 21:53:04','admin','Đăng xuất','Đăng xuất thành công'),(305,'2024-04-13 21:53:28','admin','Đăng nhập','Đăng nhập thành công'),(306,'2024-04-13 21:54:19','admin','Đăng xuất','Đăng xuất thành công'),(307,'2024-04-13 22:10:24','admin','Đăng nhập','Đăng nhập thành công'),(308,'2024-04-13 22:10:41','admin','Đăng xuất','Đăng xuất thành công'),(309,'2024-04-13 22:15:52','admin','Đăng nhập','Đăng nhập thành công'),(310,'2024-04-13 22:16:58','admin','Đăng xuất','Đăng xuất thành công'),(311,'2024-04-15 12:27:53','admin','Đăng nhập','Đăng nhập thành công'),(312,'2024-04-15 12:33:09','admin','Đăng xuất','Đăng xuất thành công'),(313,'2024-04-15 13:09:15','admin','Đăng nhập','Đăng nhập thành công'),(314,'2024-04-15 13:09:44','admin','Đăng xuất','Đăng xuất thành công'),(315,'2024-04-15 13:20:33','admin','Đăng nhập','Đăng nhập thành công'),(316,'2024-04-15 13:20:47','admin','Đăng xuất','Đăng xuất thành công'),(317,'2024-04-15 13:22:00','admin','Đăng nhập','Đăng nhập thành công'),(318,'2024-04-15 13:22:21','admin','Đăng xuất','Đăng xuất thành công'),(319,'2024-04-15 13:23:43','admin','Đăng nhập','Đăng nhập thành công'),(320,'2024-04-15 13:24:04','admin','Đăng xuất','Đăng xuất thành công'),(321,'2024-04-15 13:24:27','admin','Đăng nhập','Đăng nhập thành công'),(322,'2024-04-15 13:24:39','admin','Đăng xuất','Đăng xuất thành công'),(323,'2024-04-15 13:24:58','admin','Đăng nhập','Đăng nhập thành công'),(324,'2024-04-15 13:25:07','admin','Đăng xuất','Đăng xuất thành công'),(325,'2024-04-15 13:27:10','admin','Đăng nhập','Đăng nhập thành công'),(326,'2024-04-15 13:27:17','admin','Đăng xuất','Đăng xuất thành công'),(327,'2024-04-15 13:29:11','admin','Đăng nhập','Đăng nhập thành công'),(328,'2024-04-15 13:29:20','admin','Đăng xuất','Đăng xuất thành công'),(329,'2024-04-15 13:30:17','admin','Đăng nhập','Đăng nhập thành công'),(330,'2024-04-15 13:30:25','admin','Đăng xuất','Đăng xuất thành công'),(331,'2024-04-15 13:30:46','admin','Đăng nhập','Đăng nhập thành công'),(332,'2024-04-15 13:30:51','admin','Đăng xuất','Đăng xuất thành công'),(333,'2024-04-15 13:31:18','admin','Đăng nhập','Đăng nhập thành công'),(334,'2024-04-15 13:32:08','admin','Đăng xuất','Đăng xuất thành công'),(335,'2024-04-15 13:32:51','admin','Đăng nhập','Đăng nhập thành công'),(336,'2024-04-15 13:33:31','admin','Đăng nhập','Đăng nhập thành công'),(337,'2024-04-15 13:34:00','admin','Đăng xuất','Đăng xuất thành công'),(338,'2024-04-15 13:34:21','admin','Đăng xuất','Đăng xuất thành công'),(339,'2024-04-15 13:34:26','admin','Đăng nhập','Đăng nhập thành công'),(340,'2024-04-15 13:34:31','admin','Đăng xuất','Đăng xuất thành công'),(341,'2024-04-15 13:35:33','admin','Đăng nhập','Đăng nhập thành công'),(342,'2024-04-15 13:36:01','admin','Đăng xuất','Đăng xuất thành công'),(343,'2024-04-15 13:37:09','admin','Đăng nhập','Đăng nhập thành công'),(344,'2024-04-15 13:38:05','admin','Đăng xuất','Đăng xuất thành công'),(345,'2024-04-15 13:44:49','admin','Đăng nhập','Đăng nhập thành công'),(346,'2024-04-15 13:44:56','admin','Đăng xuất','Đăng xuất thành công'),(347,'2024-04-15 13:45:39','admin','Đăng nhập','Đăng nhập thành công'),(348,'2024-04-15 13:52:39','admin','Đăng xuất','Đăng xuất thành công'),(349,'2024-04-15 13:52:46','admin','Đăng nhập','Đăng nhập thành công'),(350,'2024-04-15 13:53:42','admin','Đăng xuất','Đăng xuất thành công'),(351,'2024-04-15 13:54:15','admin','Đăng nhập','Đăng nhập thành công'),(352,'2024-04-15 13:54:23','admin','Đăng xuất','Đăng xuất thành công'),(353,'2024-04-15 13:58:20','admin','Đăng nhập','Đăng nhập thành công'),(354,'2024-04-15 14:02:27','admin','Đăng nhập','Đăng nhập thành công'),(355,'2024-04-15 14:02:33','admin','Đăng xuất','Đăng xuất thành công'),(356,'2024-04-15 14:05:24','admin','Đăng xuất','Đăng xuất thành công'),(357,'2024-04-15 14:05:57','admin','Đăng nhập','Đăng nhập thành công'),(358,'2024-04-15 14:07:00','admin','Đăng nhập','Đăng nhập thành công'),(359,'2024-04-15 14:07:11','admin','Đăng xuất','Đăng xuất thành công'),(360,'2024-04-15 14:07:27','admin','Đăng nhập','Đăng nhập thành công'),(361,'2024-04-15 14:07:39','admin','Đăng xuất','Đăng xuất thành công'),(362,'2024-04-15 14:08:10','admin','Đăng nhập','Đăng nhập thành công'),(363,'2024-04-15 14:08:12','admin','Đăng nhập','Đăng nhập không thành công'),(364,'2024-04-15 14:08:17','admin','Đăng nhập','Đăng nhập thành công'),(365,'2024-04-15 14:08:21','admin','Đăng xuất','Đăng xuất thành công'),(366,'2024-04-15 14:08:21','admin','Đăng xuất','Đăng xuất thành công'),(367,'2024-04-15 14:08:55','admin','Đăng nhập','Đăng nhập thành công'),(368,'2024-04-15 14:09:12','admin','Đăng xuất','Đăng xuất thành công'),(369,'2024-04-15 14:09:40','admin','Đăng nhập','Đăng nhập thành công'),(370,'2024-04-15 14:09:54','admin','Đăng xuất','Đăng xuất thành công'),(371,'2024-04-15 14:14:43','admin','Đăng nhập','Đăng nhập thành công'),(372,'2024-04-15 14:16:54','admin','Đăng nhập','Đăng nhập thành công'),(373,'2024-04-15 14:18:35','admin','Đăng nhập','Đăng nhập thành công'),(374,'2024-04-15 14:18:42','admin','Đăng xuất','Đăng xuất thành công'),(375,'2024-04-15 14:24:11','admin','Đăng nhập','Đăng nhập thành công'),(376,'2024-04-15 14:24:20','admin','Đăng xuất','Đăng xuất thành công'),(377,'2024-04-15 14:26:03','admin','Đăng nhập','Đăng nhập không thành công'),(378,'2024-04-15 14:26:08','admin','Đăng nhập','Đăng nhập không thành công'),(379,'2024-04-15 14:26:14','admin','Đăng nhập','Đăng nhập thành công'),(380,'2024-04-15 14:26:46','admin','Đăng xuất','Đăng xuất thành công'),(381,'2024-04-15 14:30:32','admin','Đăng nhập','Đăng nhập thành công'),(382,'2024-04-15 14:31:02','admin','Đăng xuất','Đăng xuất thành công'),(383,'2024-04-15 14:32:48','admin','Đăng nhập','Đăng nhập thành công');
/*!40000 ALTER TABLE `activity_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ban`
--

DROP TABLE IF EXISTS `ban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ban` (
  `maban` varchar(15) NOT NULL,
  `tenban` varchar(45) NOT NULL,
  `trangthai` varchar(25) NOT NULL DEFAULT 'free',
  PRIMARY KEY (`maban`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ban`
--

LOCK TABLES `ban` WRITE;
/*!40000 ALTER TABLE `ban` DISABLE KEYS */;
INSERT INTO `ban` VALUES ('aaaa','Mang về','ádasda'),('B-2','ban 11','free'),('B-3','ban 1112','free'),('B-4','bàn mới','free'),('b12','ban 12','free'),('new','new desk 1','free');
/*!40000 ALTER TABLE `ban` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`user0`@`%`*/ /*!50003 TRIGGER `generate_table_id` BEFORE INSERT ON `ban` FOR EACH ROW BEGIN
    DECLARE next_id INT;
    DECLARE new_id VARCHAR(10);

    IF NEW.Maban IS NULL OR NEW.Maban = '' THEN
        -- Tìm mã bàn tiếp theo
        SELECT COALESCE(MAX(CAST(SUBSTRING(Maban, 3) AS UNSIGNED)), 0) + 1 INTO next_id FROM ban;
        SET new_id = CONCAT('B-', next_id);
    ELSE
        SET new_id = NEW.Maban;
    END IF;

    SET NEW.Maban = new_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `chitiet_hd`
--

DROP TABLE IF EXISTS `chitiet_hd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitiet_hd` (
  `MaHD` varchar(25) NOT NULL,
  `MaSP` varchar(10) NOT NULL,
  `SoLuong` int NOT NULL DEFAULT '1',
  `GiaSP` float NOT NULL DEFAULT '0',
  `ThanhTien` float GENERATED ALWAYS AS ((`GiaSP` * `SoLuong`)) STORED,
  PRIMARY KEY (`MaHD`,`MaSP`),
  KEY `HD-ChiTietHD_idx` (`MaHD`),
  KEY `SP-ChitietHD_idx` (`MaSP`),
  CONSTRAINT `HD-ChiTietHD` FOREIGN KEY (`MaHD`) REFERENCES `hoadon` (`MaHD`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `SP-Chitiet_hd` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitiet_hd`
--

LOCK TABLES `chitiet_hd` WRITE;
/*!40000 ALTER TABLE `chitiet_hd` DISABLE KEYS */;
INSERT INTO `chitiet_hd` (`MaHD`, `MaSP`, `SoLuong`, `GiaSP`) VALUES ('1','A01',3,20000),('1','A02',2,18000),('1','A04',1,35000),('1','AA03',2,35000),('2','A05',1,40000),('2','N05',1,18000),('3','N05',1,18000),('4','A01',2,20000),('4','AA03',3,35000),('4','N05',1,18000);
/*!40000 ALTER TABLE `chitiet_hd` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`user0`@`%`*/ /*!50003 TRIGGER `update_GiaSP_TenSP_before_insert` BEFORE INSERT ON `chitiet_hd` FOR EACH ROW BEGIN
    DECLARE gia_san_pham FLOAT;
    DECLARE ten_san_pham VARCHAR(50);

    -- Lấy giá sản phẩm từ bảng Sanpham
    SET gia_san_pham = (SELECT GiaSP FROM Sanpham WHERE MaSP = NEW.MaSP);

    -- Lấy tên sản phẩm từ bảng Sanpham
    SET ten_san_pham = (SELECT TenSP FROM Sanpham WHERE MaSP = NEW.MaSP);

    -- Đặt giá sản phẩm và tên sản phẩm cho dòng mới trong bảng chitiet_hd
    SET NEW.GiaSP = gia_san_pham;
    SET NEW.TenSP = ten_san_pham;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`user0`@`%`*/ /*!50003 TRIGGER `update_TongTien` AFTER INSERT ON `chitiet_hd` FOR EACH ROW BEGIN
    DECLARE total_amount FLOAT;
    SET total_amount = (SELECT SUM(ThanhTien) FROM chitiet_hd WHERE MaHD = NEW.MaHD);
    UPDATE hoadon SET TongTien = total_amount WHERE MaHD = NEW.MaHD;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`user0`@`%`*/ /*!50003 TRIGGER `update_GiaSP_before_update` BEFORE UPDATE ON `chitiet_hd` FOR EACH ROW BEGIN
    DECLARE gia_san_pham FLOAT;
    SET gia_san_pham = (SELECT GiaSP FROM Sanpham WHERE MaSP = NEW.MaSP);
    SET NEW.GiaSP = gia_san_pham;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`user0`@`%`*/ /*!50003 TRIGGER `update_TongTien_after_update` AFTER UPDATE ON `chitiet_hd` FOR EACH ROW BEGIN
    DECLARE total_amount FLOAT;
    SET total_amount = (SELECT SUM(ThanhTien) FROM chitiet_hd WHERE MaHD = NEW.MaHD);
    UPDATE Hoadon SET TongTien = total_amount WHERE MaHD = NEW.MaHD;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`user0`@`%`*/ /*!50003 TRIGGER `update_TongTien_after_delete` AFTER DELETE ON `chitiet_hd` FOR EACH ROW BEGIN
    DECLARE total_amount FLOAT;
    SET total_amount = (SELECT SUM(ThanhTien) FROM chitiet_hd WHERE MaHD = OLD.MaHD);
    UPDATE Hoadon SET TongTien = total_amount WHERE MaHD = OLD.MaHD;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon` (
  `MaHD` varchar(25) NOT NULL,
  `usname` varchar(15) NOT NULL,
  `TrangThai` int NOT NULL DEFAULT '0',
  `GhiChu` varchar(150) DEFAULT 'Không có ghi chú',
  `maban` varchar(15) NOT NULL DEFAULT '0',
  `TongTien` float NOT NULL DEFAULT '0',
  `ChietKhau` float NOT NULL DEFAULT '0',
  `TongThanhToan` float GENERATED ALWAYS AS ((`TongTien` - ((`TongTien` * `ChietKhau`) / 100))) STORED,
  `NgayLapHD` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`MaHD`),
  KEY `HD-TK_idx` (`usname`),
  CONSTRAINT `HD-TK` FOREIGN KEY (`usname`) REFERENCES `taikhoan` (`usname`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
INSERT INTO `hoadon` (`MaHD`, `usname`, `TrangThai`, `GhiChu`, `maban`, `TongTien`, `ChietKhau`, `NgayLapHD`) VALUES ('1','a',1,'thêm đường vào cafe','0',201000,0,'2024-03-26 20:56:02'),('2','admin',1,'không có ghi chú','0',58000,0,'2024-03-26 20:56:02'),('250324-00001','a',1,'Không có ghi chú','NewDesk',0,0,'2024-03-26 20:56:02'),('3','a',1,'Không có ghi chú','0',18000,10,'2024-03-26 20:56:02'),('4','a',1,'Không có ghi chú','0',163000,15,'2024-04-01 20:56:02'),('5','admin',1,'cafe đá riêng','NewDesk',0,0,'2024-03-26 20:56:02'),('INV040424-00001','a',1,'không có gì','0',0,0,'2024-04-04 11:48:02'),('INV250324-00001','a',1,'HD1','0',0,0,'2024-03-26 20:56:02'),('INV250324-00002','a',1,'HD2','0',0,0,'2024-03-28 20:56:02'),('INV250324-00004','a',1,'HD100','0',0,0,'2024-03-26 20:56:02'),('INV250324-00006','a',1,'HD6','0',0,0,'2024-03-26 20:56:02'),('INV250324-00099','admin',1,'HD99','NewDesk',0,0,'2024-03-26 20:56:02'),('INV260324-00001','a',1,'HD6','0',0,0,'2024-03-26 20:56:02'),('INV260324-00002','a',1,'HD3','0',0,0,'2024-03-26 20:56:01'),('INV260324-00003','a',1,'HD2','0',0,0,'2024-03-26 20:56:02'),('INV260324-00005','a',1,'Không có ghi chú','0',0,0,'2024-03-26 20:56:01');
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`user0`@`%`*/ /*!50003 TRIGGER `update_NgayLapHD` BEFORE INSERT ON `hoadon` FOR EACH ROW BEGIN
    SET NEW.NgayLapHD = NOW();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`user0`@`%`*/ /*!50003 TRIGGER `before_insert_HoaDon` BEFORE INSERT ON `hoadon` FOR EACH ROW BEGIN
    DECLARE today_date VARCHAR(6);
    DECLARE count_today INT;
    DECLARE new_MaHD VARCHAR(15);
    DECLARE maHD_exists INT;

    SET today_date = DATE_FORMAT(CURDATE(), '%d%m%y');

    -- Kiểm tra xem MaHD đã được cung cấp hay chưa
    IF NEW.MaHD IS NULL THEN
        -- Tính số lượng hóa đơn đã tồn tại trong ngày
        SET count_today = (SELECT COUNT(*) FROM HoaDon WHERE MaHD LIKE CONCAT('INV-', today_date, '-%'));

        -- Tạo MaHD mới ban đầu
        SET new_MaHD = CONCAT('INV', today_date, '-', LPAD(count_today + 1, 5, '0'));

        -- Gán MaHD mới cho dòng mới
        SET NEW.MaHD = new_MaHD;

        -- Kiểm tra xem MaHD mới đã tồn tại hay chưa
        SELECT COUNT(*) INTO maHD_exists FROM HoaDon WHERE MaHD = new_MaHD;

        -- Nếu MaHD mới đã tồn tại, thì lặp lại quá trình tạo MaHD với số cuối tăng thêm 1 đơn vị
        WHILE maHD_exists > 0 DO
            SET count_today = count_today + 1;
            SET new_MaHD = CONCAT('INV', today_date, '-', LPAD(count_today + 1, 5, '0'));
            SET NEW.MaHD = new_MaHD;
            SELECT COUNT(*) INTO maHD_exists FROM HoaDon WHERE MaHD = new_MaHD;
        END WHILE;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`user0`@`%`*/ /*!50003 TRIGGER `create_ban_trangthai` AFTER INSERT ON `hoadon` FOR EACH ROW BEGIN
    DECLARE maban_temp VARCHAR(15);
    
    -- Lấy mã bàn từ dữ liệu mới
    SELECT maban INTO maban_temp FROM hoadon WHERE mahd = NEW.mahd;
    
    -- Kiểm tra trạng thái của hóa đơn mới
    IF NEW.trangthai = 0 THEN
        -- Cập nhật trạng thái của bàn tương ứng thành mã hóa đơn mới
        UPDATE ban SET trangthai = NEW.mahd WHERE maban = maban_temp;
    ELSE
        -- Cập nhật trạng thái của bàn tương ứng thành 'free'
        UPDATE ban SET trangthai = 'free' WHERE maban = maban_temp;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`user0`@`%`*/ /*!50003 TRIGGER `update_ban_trangthai` AFTER UPDATE ON `hoadon` FOR EACH ROW BEGIN
    DECLARE maban_temp VARCHAR(15);
    
    -- Lấy mã bàn từ dữ liệu mới
    SELECT maban INTO maban_temp FROM hoadon WHERE mahd = NEW.mahd;
    
    -- Kiểm tra trạng thái của hóa đơn mới
    IF NEW.trangthai = 0 THEN
        -- Cập nhật trạng thái của bàn tương ứng thành mã hóa đơn mới
        UPDATE ban SET trangthai = NEW.mahd WHERE maban = maban_temp;
    ELSE
        -- Cập nhật trạng thái của bàn tương ứng thành 'free'
        UPDATE ban SET trangthai = 'free' WHERE maban = maban_temp;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `phieuchi`
--

DROP TABLE IF EXISTS `phieuchi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieuchi` (
  `MaPC` varchar(10) NOT NULL,
  `NoiDungPC` text NOT NULL,
  `TGChi` datetime DEFAULT CURRENT_TIMESTAMP,
  `SoTien` float NOT NULL DEFAULT '0',
  `usname` varchar(15) NOT NULL,
  PRIMARY KEY (`MaPC`),
  KEY `User_PC_idx` (`usname`),
  CONSTRAINT `User_PC` FOREIGN KEY (`usname`) REFERENCES `taikhoan` (`usname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieuchi`
--

LOCK TABLES `phieuchi` WRITE;
/*!40000 ALTER TABLE `phieuchi` DISABLE KEYS */;
INSERT INTO `phieuchi` VALUES ('060424-001','Chi thử nghiệm','2024-04-06 01:29:29',0,'x'),('110424-001','Chi mới 11/04','2024-04-11 16:44:51',120000,'admin'),('110424-002','cho 0đ','2024-04-11 16:45:21',0,'admin'),('200324-001','Nước đá','2024-03-20 19:02:22',35000,'a'),('210324-001','Lấy cà phê','2024-03-21 10:35:51',1500000,'admin'),('250324-001','lấy trà thảo mộc','2024-03-25 22:39:14',5000000,'admin'),('260324-001','lấy đá 26/03','2024-03-26 00:10:39',50000,'a'),('260324-002','lấy cafe 26/03','2024-03-26 00:11:12',20000,'a'),('260324-003','lấy nhân sâm','2024-03-26 00:11:33',1500000,'a'),('260324-005','lấy siro','2024-03-26 00:15:27',200000,'admin'),('260324-006','lấy trứng bắc thảo','2024-03-26 00:15:50',850000,'admin');
/*!40000 ALTER TABLE `phieuchi` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`user0`@`%`*/ /*!50003 TRIGGER `before_insert_phieuchi` BEFORE INSERT ON `phieuchi` FOR EACH ROW BEGIN
    DECLARE today_date VARCHAR(6);
    DECLARE count_today INT;
    DECLARE new_MaPC VARCHAR(10);
    DECLARE maPC_exists INT;

    SET today_date = DATE_FORMAT(CURDATE(), '%d%m%y');

    -- Kiểm tra xem MaPC được nhập vào là NULL hay không
    IF NEW.MaPC IS NULL THEN
        -- Tạo MaPC mới ban đầu
        SET count_today = (SELECT COUNT(*) FROM phieuchi WHERE MaPC LIKE CONCAT(today_date, '-%'));
        SET new_MaPC = CONCAT(today_date, '-', LPAD(count_today + 1, 3, '0'));
        SET NEW.MaPC = new_MaPC;

        -- Kiểm tra xem MaPC mới đã tồn tại hay chưa
        SELECT COUNT(*) INTO maPC_exists FROM phieuchi WHERE MaPC = new_MaPC;

        -- Nếu MaPC mới đã tồn tại, thì lặp lại quá trình tạo MaPC với số cuối tăng thêm 1 đơn vị
        WHILE maPC_exists > 0 DO
            SET count_today = count_today + 1;
            SET new_MaPC = CONCAT(today_date, '-', LPAD(count_today + 1, 3, '0'));
            SET NEW.MaPC = new_MaPC;
            SELECT COUNT(*) INTO maPC_exists FROM phieuchi WHERE MaPC = new_MaPC;
        END WHILE;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanpham` (
  `MaSP` varchar(10) NOT NULL,
  `TenSP` varchar(50) NOT NULL,
  `GiaSP` float NOT NULL DEFAULT '0',
  `LoaiSP` int NOT NULL DEFAULT '1',
  `GhiChu` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`MaSP`),
  UNIQUE KEY `TenSP_UNIQUE` (`TenSP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES ('a','aaa',12000,-1,''),('A01','Mì trộn',20000,0,NULL),('A02','Bánh mì bò lá lốt',18000,0,NULL),('A04','Cơm sườn bì chả',35000,0,NULL),('A05','Cơm chiên hải sản',40000,0,NULL),('A06','Há cảo',35000,0,'Há cảo ngũ vị'),('AA001','Tương ớt',2000,0,'Tương ớt Cholimex cực ngon'),('AA03','Cơm tấm long xuyên',35000,0,'Cơm tấm Long Xuyên mang về'),('M01','Nui xào bò',35000,0,NULL),('MXB','Mì xào bò',35000,0,'thêm ghi chú test'),('MXG','Mì xào giòn',45000,0,'Mì xào cùng với thịt bò ba chỉ cắt lát'),('N02','Nước suối',7000,1,NULL),('N03','Sinh tố bơ',25000,1,NULL),('N04','Nước mía',10000,1,NULL),('N05','Cà phê sữa đá',18000,1,NULL);
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taikhoan` (
  `usname` varchar(15) NOT NULL,
  `passwd` varchar(30) NOT NULL DEFAULT '12345678',
  `access` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`usname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES ('a','a',1),('admin','admin',0),('b','b',1),('ngan','123456',0),('s','12345678',1),('x','xzxzxz',0);
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'htql_banhang'
--

--
-- Dumping routines for database 'htql_banhang'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-15 14:32:52
