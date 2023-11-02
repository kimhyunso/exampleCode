-- phpMyAdmin SQL Dump
-- version 3.2.3
-- http://www.phpmyadmin.net
--
-- 호스트: localhost
-- 처리한 시간: 19-12-27 14:16 
-- 서버 버전: 5.1.41
-- PHP 버전: 5.2.12

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 데이터베이스: `itbank2`
--

-- --------------------------------------------------------

--
-- 테이블 구조 `log`
--

CREATE TABLE IF NOT EXISTS `log` (
  `idx` int(11) NOT NULL AUTO_INCREMENT,
  `title` char(100) DEFAULT NULL,
  `memo1` blob,
  `memo2` blob,
  `id` char(20) DEFAULT NULL,
  `name` char(20) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `ip` char(20) DEFAULT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=45 ;

--
-- 테이블의 덤프 데이터 `log`
--

INSERT INTO `log` (`idx`, `title`, `memo1`, `memo2`, `id`, `name`, `time`, `ip`) VALUES
(1, '[ Login ] admin, 관리자', NULL, NULL, 'admin', '관리자', '2019-12-26 11:03:48', '127.0.0.1'),
(39, '[ Logout ] dev, 개발자', NULL, NULL, 'dev', '개발자', '2019-12-26 13:11:29', '127.0.0.1'),
(3, '[ Login ] dev, 개발자', NULL, NULL, 'dev', '개발자', '2019-12-26 11:06:24', '127.0.0.1'),
(4, '[ Login ] dev, 개발자', NULL, NULL, 'dev', '개발자', '2019-12-26 11:08:09', '127.0.0.1'),
(5, '[ Login ] dev, 개발자', NULL, NULL, 'dev', '개발자', '2019-12-26 11:11:12', '127.0.0.1'),
(6, '[ Login ] dev, 개발자', NULL, NULL, 'dev', '개발자', '2019-12-26 11:18:23', '127.0.0.1'),
(7, '[ Login ] dev, 개발자', NULL, NULL, 'dev', '개발자', '2019-12-26 11:18:28', '127.0.0.1'),
(8, '[ Login ] dev, 개발자', NULL, NULL, 'dev', '개발자', '2019-12-26 11:20:26', '127.0.0.1'),
(9, '[ Logout ] dev, 개발자', NULL, NULL, 'dev', '개발자', '2019-12-26 11:20:30', '127.0.0.1'),
(10, '[ Login ] test, aa', NULL, NULL, 'test', 'aa', '2019-12-26 11:20:33', '127.0.0.1'),
(11, '[ Logout ] test, aa', NULL, NULL, 'test', 'aa', '2019-12-26 11:20:34', '127.0.0.1'),
(12, '[ Login ] dev, 개발자', NULL, NULL, 'dev', '개발자', '2019-12-26 11:20:40', '127.0.0.1'),
(13, '[ Login ] admin, 관리자', NULL, NULL, 'admin', '관리자', '2019-12-26 11:34:03', '127.0.0.1'),
(14, '[ 글작성 ] admin, 관리자', NULL, NULL, 'admin', '관리자', '2019-12-26 11:34:20', '127.0.0.1'),
(15, '[ Logout ] admin, 관리자', NULL, NULL, 'admin', '관리자', '2019-12-26 11:34:33', '127.0.0.1'),
(16, '[ Login ] dev, 개발자', NULL, NULL, 'dev', '개발자', '2019-12-26 11:34:43', '127.0.0.1'),
(17, '[ Login ] admin, 관리자', NULL, NULL, 'admin', '관리자', '2019-12-26 11:43:55', '127.0.0.1'),
(38, '[ Login ] dev, 개발자', NULL, NULL, 'dev', '개발자', '2019-12-26 12:44:21', '127.0.0.1'),
(19, '[ 글작성 ] admin, 관리자', NULL, NULL, 'admin', '관리자', '2019-12-26 11:44:14', '127.0.0.1'),
(20, '[ Logout ] admin, 관리자', NULL, NULL, 'admin', '관리자', '2019-12-26 11:44:17', '127.0.0.1'),
(21, '[ Login ] dev, 개발자', NULL, NULL, 'dev', '개발자', '2019-12-26 11:44:21', '127.0.0.1'),
(22, '[ Login ] dev, 개발자', NULL, NULL, 'dev', '개발자', '2019-12-26 11:45:06', '127.0.0.1'),
(35, '[ Logout ] dev, 개발자', NULL, NULL, 'dev', '개발자', '2019-12-26 12:40:22', '127.0.0.1'),
(36, '[ Login ] dev, 개발자', NULL, NULL, 'dev', '개발자', '2019-12-26 12:40:58', '127.0.0.1'),
(24, '[ 글작성 ] dev, 개발자', NULL, NULL, 'dev', '개발자', '2019-12-26 11:45:32', '127.0.0.1'),
(43, '[ Login ] admin, 관리자', NULL, NULL, 'admin', '관리자', '2019-12-26 15:18:23', '127.0.0.1'),
(26, '[ Login ] admin, 관리자', NULL, NULL, 'admin', '관리자', '2019-12-26 11:48:50', '127.0.0.1'),
(37, '[ Login ] dev, 개발자', NULL, NULL, 'dev', '개발자', '2019-12-26 12:43:48', '127.0.0.1'),
(28, '[ Logout ] admin, 관리자', NULL, NULL, 'admin', '관리자', '2019-12-26 11:48:57', '127.0.0.1'),
(29, '[ Login ] dev, 개발자', NULL, NULL, 'dev', '개발자', '2019-12-26 11:49:00', '127.0.0.1'),
(40, '[ Login ] admin, 관리자', NULL, NULL, 'admin', '관리자', '2019-12-26 13:11:48', '127.0.0.1'),
(31, 'No Tilte [ 글삭제 ] admin, 관리자', NULL, NULL, 'admin', '관리자', '2019-12-26 11:49:40', '127.0.0.1'),
(32, '[ Logout ] admin, 관리자', NULL, NULL, 'admin', '관리자', '2019-12-26 11:49:42', '127.0.0.1'),
(33, '[ Login ] dev, 개발자', NULL, NULL, 'dev', '개발자', '2019-12-26 11:49:44', '127.0.0.1'),
(34, '[ Login ] dev, 개발자', NULL, NULL, 'dev', '개발자', '2019-12-26 12:35:47', '127.0.0.1'),
(41, '[ Logout ] admin, 관리자', NULL, NULL, 'admin', '관리자', '2019-12-26 13:11:49', '127.0.0.1'),
(42, '[ Login ] dev, 개발자', NULL, NULL, 'dev', '개발자', '2019-12-26 13:11:52', '127.0.0.1'),
(44, '[ Login ] admin, 관리자', NULL, NULL, 'admin', '관리자', '2019-12-26 15:38:21', '127.0.0.1');
