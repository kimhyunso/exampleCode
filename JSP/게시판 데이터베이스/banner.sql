-- phpMyAdmin SQL Dump
-- version 3.2.3
-- http://www.phpmyadmin.net
--
-- 호스트: localhost
-- 처리한 시간: 19-12-27 14:17 
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
-- 테이블 구조 `banner`
--

CREATE TABLE IF NOT EXISTS `banner` (
  `idx` int(10) NOT NULL AUTO_INCREMENT,
  `title` char(100) DEFAULT NULL,
  `pos` int(3) DEFAULT '1',
  `odr` int(3) DEFAULT '1',
  `day` date DEFAULT NULL,
  `useflag` int(1) DEFAULT '1',
  `url` char(255) DEFAULT NULL,
  `file` char(30) DEFAULT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- 테이블의 덤프 데이터 `banner`
--

INSERT INTO `banner` (`idx`, `title`, `pos`, `odr`, `day`, `useflag`, `url`, `file`) VALUES
(1, '동작구청홈페이지', 1, 1, '2019-12-26', 1, 'http://www.dongjak.go.kr/portal/main/main.do', '다운로드.png');
