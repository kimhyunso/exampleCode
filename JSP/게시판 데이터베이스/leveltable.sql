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
-- 테이블 구조 `leveltable`
--

CREATE TABLE IF NOT EXISTS `leveltable` (
  `idx` int(10) NOT NULL AUTO_INCREMENT,
  `level` int(3) DEFAULT '1',
  `title` char(20) NOT NULL DEFAULT 'no title',
  `useflag` int(1) DEFAULT '1',
  `isadmin` int(1) DEFAULT '0',
  `isdev` int(1) DEFAULT '0',
  PRIMARY KEY (`idx`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- 테이블의 덤프 데이터 `leveltable`
--

INSERT INTO `leveltable` (`idx`, `level`, `title`, `useflag`, `isadmin`, `isdev`) VALUES
(1, 1, '정회원', 1, 0, 0),
(2, 5, 'VIP', 1, 0, 0),
(3, 9, '관리자', 1, 1, 0),
(4, 13, '개발자', 1, 0, 1),
(6, 3, '특별회원', 1, 0, 0);
