-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 115.74.233.26    Database: htql_banhang
-- ------------------------------------------------------
-- Server version	8.0.35

CREATE SCHEMA `htql_banhang` ;
USE htql_banhang;


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

DROP TABLE IF EXISTS `htql_banhang`.`activity_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `htql_banhang`.`activity_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user` varchar(15) NOT NULL,
  `action` varchar(255) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `TK_Log_idx` (`user`),
  CONSTRAINT `TK_Log` FOREIGN KEY (`user`) REFERENCES `taikhoan` (`usname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1573 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ban`
--

DROP TABLE IF EXISTS `htql_banhang`.`ban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `htql_banhang`.`ban` (
  `maban` varchar(15) NOT NULL,
  `tenban` varchar(45) NOT NULL,
  `trangthai` varchar(25) NOT NULL DEFAULT 'free',
  PRIMARY KEY (`maban`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`user0`@`%`*/ /*!50003 TRIGGER `generate_table_id` BEFORE INSERT ON `htql_banhang`.`ban` FOR EACH ROW BEGIN
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

DROP TABLE IF EXISTS `htql_banhang`.`chitiet_hd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `htql_banhang`.`chitiet_hd` (
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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`user0`@`%`*/ /*!50003 TRIGGER `update_GiaSP_TenSP_before_insert` BEFORE INSERT ON `htql_banhang`.`chitiet_hd` FOR EACH ROW BEGIN
    DECLARE gia_san_pham FLOAT;

    -- Lấy giá sản phẩm từ bảng Sanpham
    SET gia_san_pham = (SELECT GiaSP FROM Sanpham WHERE MaSP = NEW.MaSP);

    -- Đặt giá sản phẩm và tên sản phẩm cho dòng mới trong bảng chitiet_hd
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
/*!50003 CREATE*/ /*!50017 DEFINER=`user0`@`%`*/ /*!50003 TRIGGER `update_TongTien` AFTER INSERT ON `htql_banhang`.`chitiet_hd` FOR EACH ROW BEGIN
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
/*!50003 CREATE*/ /*!50017 DEFINER=`user0`@`%`*/ /*!50003 TRIGGER `update_GiaSP_before_update` BEFORE UPDATE ON `htql_banhang`.`chitiet_hd` FOR EACH ROW BEGIN
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
/*!50003 CREATE*/ /*!50017 DEFINER=`user0`@`%`*/ /*!50003 TRIGGER `chitiet_hd_AFTER_UPDATE` AFTER UPDATE ON `htql_banhang`.`chitiet_hd` FOR EACH ROW BEGIN
    DECLARE total_amount FLOAT;

    -- Tính tổng thành tiền của các dòng còn lại có cùng MaHD
    SELECT IFNULL(SUM(ThanhTien), 0) INTO total_amount FROM chitiet_hd WHERE MaHD = OLD.MaHD;

    -- Kiểm tra nếu không có dòng nào còn lại có cùng MaHD, đặt TongTien = 0
    IF total_amount IS NULL THEN
        SET total_amount = 0;
    END IF;

    -- Cập nhật TongTien trong Hoadon
    UPDATE Hoadon SET TongTien = total_amount WHERE MaHD = OLD.MaHD;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`user0`@`%`*/ /*!50003 TRIGGER `update_TongTien_after_update` AFTER DELETE ON `htql_banhang`.`chitiet_hd` FOR EACH ROW BEGIN
    DECLARE total_amount FLOAT;
    
    -- Tính tổng thành tiền của các dòng còn lại có cùng MaHD
    SELECT IFNULL(SUM(ThanhTien), 0) INTO total_amount FROM chitiet_hd WHERE MaHD = OLD.MaHD;
    
    -- Kiểm tra nếu không có dòng nào còn lại có cùng MaHD, đặt TongTien = 0
    IF total_amount IS NULL THEN
        SET total_amount = 0;
    END IF;
    
    -- Cập nhật TongTien trong Hoadon
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

DROP TABLE IF EXISTS `htql_banhang`.`hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `htql_banhang`.`hoadon` (
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
  KEY `HD-Ban_idx` (`maban`),
  CONSTRAINT `HD-Ban` FOREIGN KEY (`maban`) REFERENCES `ban` (`maban`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `HD-TK` FOREIGN KEY (`usname`) REFERENCES `taikhoan` (`usname`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`user0`@`%`*/ /*!50003 TRIGGER `update_NgayLapHD` BEFORE INSERT ON `htql_banhang`.`hoadon` FOR EACH ROW BEGIN
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
/*!50003 CREATE*/ /*!50017 DEFINER=`user0`@`%`*/ /*!50003 TRIGGER `before_insert_HoaDon` BEFORE INSERT ON `htql_banhang`.`hoadon` FOR EACH ROW BEGIN
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
/*!50003 CREATE*/ /*!50017 DEFINER=`user0`@`%`*/ /*!50003 TRIGGER `create_ban_trangthai` AFTER INSERT ON `htql_banhang`.`hoadon` FOR EACH ROW BEGIN
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
/*!50003 CREATE*/ /*!50017 DEFINER=`user0`@`%`*/ /*!50003 TRIGGER `update_ban_trangthai` AFTER UPDATE ON `htql_banhang`.`hoadon` FOR EACH ROW BEGIN
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

DROP TABLE IF EXISTS `htql_banhang`.`phieuchi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `htql_banhang`.`phieuchi` (
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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`user0`@`%`*/ /*!50003 TRIGGER `before_insert_phieuchi` BEFORE INSERT ON `htql_banhang`.`phieuchi` FOR EACH ROW BEGIN
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

DROP TABLE IF EXISTS `htql_banhang`.`sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `htql_banhang`.`sanpham` (
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
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `htql_banhang`.`taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `htql_banhang`.`taikhoan` (
  `usname` varchar(15) NOT NULL,
  `passwd` varchar(200) NOT NULL,
  `access` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`usname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `htql_banhang`.`taikhoan` (`usname`, `passwd`, `access`) VALUES ('admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '0');
/*!40101 SET character_set_client = @saved_cs_client */;

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

-- Dump completed on 2024-05-05 15:06:07
