# library
-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.7.17-log - MySQL Community Server (GPL)
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- library 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `library` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `library`;

-- 테이블 library.book 구조 내보내기
CREATE TABLE IF NOT EXISTS `book` (
  `book_code` int(11) NOT NULL AUTO_INCREMENT,
  `library_id` varchar(50) NOT NULL,
  `state_code` int(10) NOT NULL DEFAULT '1',
  `genre_code` int(10) NOT NULL,
  `book_name` varchar(50) NOT NULL,
  `book_author` varchar(50) NOT NULL,
  `book_publisher` varchar(50) NOT NULL,
  `book_firstday` datetime DEFAULT NULL,
  `book_totalday` int(11) NOT NULL DEFAULT '0',
  `book_totalcount` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`book_code`),
  KEY `FK__library` (`library_id`),
  KEY `FK__state` (`state_code`),
  KEY `FK__genre` (`genre_code`),
  CONSTRAINT `FK_book_genre` FOREIGN KEY (`genre_code`) REFERENCES `genre` (`genre_code`),
  CONSTRAINT `FK_book_library` FOREIGN KEY (`library_id`) REFERENCES `library` (`library_id`),
  CONSTRAINT `FK_book_state` FOREIGN KEY (`state_code`) REFERENCES `state` (`state_code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 테이블 데이터 library.book:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` (`book_code`, `library_id`, `state_code`, `genre_code`, `book_name`, `book_author`, `book_publisher`, `book_firstday`, `book_totalday`, `book_totalcount`) VALUES
	(1, '관리자001', 2, 2, '도서도서', '저자저자', '출판출판', '2017-02-01 22:46:00', 2, 1),
	(2, '도서관가입', 3, 3, '도서도도서', '저자저저자', '출판출판사', NULL, 0, 0);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;

-- 테이블 library.disposal 구조 내보내기
CREATE TABLE IF NOT EXISTS `disposal` (
  `disposal_code` int(11) NOT NULL AUTO_INCREMENT,
  `genre_code` int(11) NOT NULL,
  `book_code` int(11) NOT NULL,
  `disposal_bookname` varchar(50) NOT NULL,
  `disposal_author` varchar(50) NOT NULL,
  `disposal_publisher` varchar(50) NOT NULL,
  `disposal_registerday` datetime NOT NULL,
  PRIMARY KEY (`disposal_code`),
  UNIQUE KEY `book_code` (`book_code`),
  KEY `FK_disposal_genre` (`genre_code`),
  CONSTRAINT `FK_disposal_genre` FOREIGN KEY (`genre_code`) REFERENCES `genre` (`genre_code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 테이블 데이터 library.disposal:~1 rows (대략적) 내보내기
/*!40000 ALTER TABLE `disposal` DISABLE KEYS */;
INSERT INTO `disposal` (`disposal_code`, `genre_code`, `book_code`, `disposal_bookname`, `disposal_author`, `disposal_publisher`, `disposal_registerday`) VALUES
	(3, 2, 1, '도서도서', '저자저자', '출판출판', '2017-01-29 19:09:53'),
	(4, 3, 2, '도서도도서', '저자저저자', '출판출판사', '2017-01-30 21:42:45');
/*!40000 ALTER TABLE `disposal` ENABLE KEYS */;

-- 테이블 library.genre 구조 내보내기
CREATE TABLE IF NOT EXISTS `genre` (
  `genre_code` int(11) NOT NULL AUTO_INCREMENT,
  `genre_name` varchar(50) NOT NULL,
  PRIMARY KEY (`genre_code`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 테이블 데이터 library.genre:~5 rows (대략적) 내보내기
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` (`genre_code`, `genre_name`) VALUES
	(1, '소설'),
	(2, '수필'),
	(3, '현대문학'),
	(4, '고전문학'),
	(5, '외국도서');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;

-- 테이블 library.library 구조 내보내기
CREATE TABLE IF NOT EXISTS `library` (
  `library_id` varchar(50) NOT NULL,
  `local_code` int(10) NOT NULL,
  `library_pw` varchar(50) NOT NULL,
  PRIMARY KEY (`library_id`),
  KEY `FK_library_local` (`local_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 library.library:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `library` DISABLE KEYS */;
INSERT INTO `library` (`library_id`, `local_code`, `library_pw`) VALUES
	('관리자001', 1, 'pw001'),
	('관리자002', 4, 'pw002'),
	('도서관가입', 5, 'pw001');
/*!40000 ALTER TABLE `library` ENABLE KEYS */;

-- 테이블 library.local 구조 내보내기
CREATE TABLE IF NOT EXISTS `local` (
  `local_code` int(11) NOT NULL AUTO_INCREMENT,
  `local_name` varchar(50) NOT NULL,
  PRIMARY KEY (`local_code`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 테이블 데이터 library.local:~7 rows (대략적) 내보내기
/*!40000 ALTER TABLE `local` DISABLE KEYS */;
INSERT INTO `local` (`local_code`, `local_name`) VALUES
	(1, '서울'),
	(2, '경기'),
	(3, '충청'),
	(4, '강원'),
	(5, '전라'),
	(6, '경상'),
	(7, '제주');
/*!40000 ALTER TABLE `local` ENABLE KEYS */;

-- 테이블 library.member 구조 내보내기
CREATE TABLE IF NOT EXISTS `member` (
  `member_id` varchar(50) NOT NULL,
  `memberlevel_code` int(11) NOT NULL,
  `member_name` varchar(50) NOT NULL,
  `member_phone` varchar(50) NOT NULL,
  PRIMARY KEY (`member_id`),
  KEY `FK_member_memberlevel` (`memberlevel_code`),
  CONSTRAINT `FK_member_memberlevel` FOREIGN KEY (`memberlevel_code`) REFERENCES `memberlevel` (`memberlevel_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 library.member:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` (`member_id`, `memberlevel_code`, `member_name`, `member_phone`) VALUES
	('메엠버', 2, '이르음', '여언락처'),
	('아이디', 1, '이름', '연락처'),
	('아이디2', 2, '이름', '연락처');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;

-- 테이블 library.memberlevel 구조 내보내기
CREATE TABLE IF NOT EXISTS `memberlevel` (
  `memberlevel_code` int(10) NOT NULL AUTO_INCREMENT,
  `memberlevel_name` varchar(50) NOT NULL,
  `payment` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`memberlevel_code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 테이블 데이터 library.memberlevel:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `memberlevel` DISABLE KEYS */;
INSERT INTO `memberlevel` (`memberlevel_code`, `memberlevel_name`, `payment`) VALUES
	(1, '유료회원', 500),
	(2, '일반회원', 300),
	(3, '비회원', 10000);
/*!40000 ALTER TABLE `memberlevel` ENABLE KEYS */;

-- 테이블 library.rental 구조 내보내기
CREATE TABLE IF NOT EXISTS `rental` (
  `rental_code` int(11) NOT NULL AUTO_INCREMENT,
  `book_code` int(11) NOT NULL,
  `member_id` varchar(50) NOT NULL,
  `rentalstate_code` int(11) NOT NULL DEFAULT '1',
  `rental_start` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `rental_end` datetime DEFAULT NULL,
  `rental_payment` int(10) DEFAULT NULL,
  `rental_prepayment` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`rental_code`),
  KEY `FK_rental_member` (`member_id`),
  KEY `FK_rental_book` (`book_code`),
  KEY `FK_rental_rentalstate` (`rentalstate_code`),
  CONSTRAINT `FK_rental_book` FOREIGN KEY (`book_code`) REFERENCES `book` (`book_code`),
  CONSTRAINT `FK_rental_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `FK_rental_rentalstate` FOREIGN KEY (`rentalstate_code`) REFERENCES `rentalstate` (`rentalstate_code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 테이블 데이터 library.rental:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `rental` DISABLE KEYS */;
INSERT INTO `rental` (`rental_code`, `book_code`, `member_id`, `rentalstate_code`, `rental_start`, `rental_end`, `rental_payment`, `rental_prepayment`) VALUES
	(4, 1, '메엠버', 2, '2017-01-30 21:43:54', '2017-02-01 22:46:00', 600, 0);
/*!40000 ALTER TABLE `rental` ENABLE KEYS */;

-- 테이블 library.rentalstate 구조 내보내기
CREATE TABLE IF NOT EXISTS `rentalstate` (
  `rentalstate_code` int(11) NOT NULL AUTO_INCREMENT,
  `rentalstate_name` varchar(50) NOT NULL,
  PRIMARY KEY (`rentalstate_code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 테이블 데이터 library.rentalstate:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `rentalstate` DISABLE KEYS */;
INSERT INTO `rentalstate` (`rentalstate_code`, `rentalstate_name`) VALUES
	(1, '대여중'),
	(2, '반납완료');
/*!40000 ALTER TABLE `rentalstate` ENABLE KEYS */;

-- 테이블 library.state 구조 내보내기
CREATE TABLE IF NOT EXISTS `state` (
  `state_code` int(11) NOT NULL AUTO_INCREMENT,
  `state_name` varchar(50) NOT NULL,
  PRIMARY KEY (`state_code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 테이블 데이터 library.state:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` (`state_code`, `state_name`) VALUES
	(1, '대여가능'),
	(2, '대여중'),
	(3, '도서손상');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;

-- 테이블 library.test 구조 내보내기
CREATE TABLE IF NOT EXISTS `test` (
  `a` varchar(50) DEFAULT NULL,
  `b` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 library.test:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` (`a`, `b`) VALUES
	(NULL, NULL);
/*!40000 ALTER TABLE `test` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
