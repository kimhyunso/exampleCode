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
-- 테이블 구조 `bbscat`
--

CREATE TABLE IF NOT EXISTS `bbscat` (
  `cidx` int(10) NOT NULL AUTO_INCREMENT,
  `title` char(20) NOT NULL DEFAULT 'no title',
  `odr` int(3) DEFAULT '1',
  `useflag` int(1) DEFAULT '1',
  PRIMARY KEY (`cidx`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 테이블의 덤프 데이터 `bbscat`
--

INSERT INTO `bbscat` (`cidx`, `title`, `odr`, `useflag`) VALUES
(1, '학습게시판', 1, 1),
(2, '테스트게시판', 2, 1);
