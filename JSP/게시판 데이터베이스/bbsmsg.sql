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
-- 테이블 구조 `bbsmsg`
--

CREATE TABLE IF NOT EXISTS `bbsmsg` (
  `midx` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(11) DEFAULT '0',
  `bidx` int(11) DEFAULT '0',
  `memo` blob,
  `id` char(20) DEFAULT NULL,
  `name` char(20) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `ip` char(20) DEFAULT NULL,
  PRIMARY KEY (`midx`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=31 ;

--
-- 테이블의 덤프 데이터 `bbsmsg`
--

INSERT INTO `bbsmsg` (`midx`, `bid`, `bidx`, `memo`, `id`, `name`, `time`, `ip`) VALUES
(8, 1, 24, 0xed858cec8aa4ed8ab832313331333132333133, 'admin', '관리자', '2019-12-24 14:05:50', '127.0.0.1'),
(7, 1, 24, 0xeb8c93eab880ed858cec8aa4ed8ab8, 'admin', '관리자', '2019-12-24 14:05:40', '127.0.0.1'),
(9, 1, 21, 0xeb8e83eab88020ec9e85eba0a5ec9e85eb8b88eb8ba42e2e2e, 'admin', '관리자', '2019-12-24 14:06:02', '127.0.0.1'),
(12, 1, 21, 0xeca080eb8a942056495020eab3a0eab09dec9e85eb8b88eb8ba42e2e20ed858cec8aa4ed8ab82e2e2e2e, 'qwer', 'qwer', '2019-12-24 14:32:52', '127.0.0.1'),
(11, 1, 24, 0xeca080eb8a9420ed858cec8aa4ed84b020ec9e85eb8b88eb8ba42e2e2e2e2e, 'test', 'aa', '2019-12-24 14:26:13', '127.0.0.1'),
(13, 1, 21, 0x76697020eab3a0eab09dec9e85eb829f2e2e2e, 'qwer', 'qwer', '2019-12-24 14:33:16', '127.0.0.1'),
(14, 1, 21, 0xec9584eb8b99eb8b88eb8ba42e2e2e2e2e, 'qwer', 'qwer', '2019-12-24 14:33:27', '127.0.0.1'),
(15, 1, 24, 0xeca080eb8a942056495020eab3a0eab09dec9e85eb8b8f2c, 'qwer', 'qwer', '2019-12-24 14:35:33', '127.0.0.1'),
(16, 1, 24, 0xed858cec8aa4ed8ab8, 'qwer', 'qwer', '2019-12-24 14:35:38', '127.0.0.1'),
(17, 1, 24, 0xe38582e38588e384b7e38588e38582e384b7e38582e38588e384b7, 'qwer', 'qwer', '2019-12-24 14:35:41', '127.0.0.1'),
(18, 1, 26, 0xeb8c93eab880ec9e85eba0a5ec9d84ed95b4ebb485eb8b88eb8ba42e, 'qwer', 'qwer', '2019-12-24 14:52:31', '127.0.0.1'),
(20, 1, 26, 0xeb8c93eab880ec9d8420ec9e85eba0a5ed95b4ebb485eb8b88eb8ba42e0d0a0d0a0d0a0d0a0d0a0d0a0d0a0d0a0d0a0d0a0d0a0d0a0d0a0d0a0d0a0d0a0d0a0d0a0d0a0d0a0d0aeb9d84ec96b4ec93b0eab8b0, 'qwer', 'qwer', '2019-12-24 15:09:05', '127.0.0.1'),
(21, 1, 26, 0xeb8c93eab880ec9d8420ec9e85eba0a5ed95a9eb8b88eb8ba42e0d0a3c62723e, 'qwer', 'qwer', '2019-12-24 15:09:21', '127.0.0.1'),
(26, 1, 29, 0xeb8c93eab880ed858cec8aa4ed8ab8, 'admin', '관리자', '2019-12-26 09:28:45', '127.0.0.1'),
(27, 1, 29, 0xeb82b4eab08020ec9e91ec84b1ed959ceb8c93eab880, 'admin', '관리자', '2019-12-26 09:28:51', '127.0.0.1'),
(28, 1, 24, 0xed858cec8aa4ed8ab8eab08020eab080eb8aa5ed959ceca78020ed858cec8aa4ed8ab8eba5bced95a9eb8b88eb8ba42e2e2e2e2e, 'test', 'aa', '2019-12-26 09:51:35', '127.0.0.1'),
(29, 1, 29, 0x3c5320432052204920502054204e6f74416c6c6f7765643e616c65727428277465737427293a3c2f5320432052204920502054204e6f74416c6c6f7765643e, 'admin', '관리자', '2019-12-26 10:07:25', '127.0.0.1'),
(30, 1, 29, 0x3c5320432052204920502054204e6f74416c6c6f7765643e4c204f2043204120542049204f204e204e6f74416c6c6f7765642e687265663d276d61696e2e6a7370273c2f5320432052204920502054204e6f74416c6c6f7765643e, 'admin', '관리자', '2019-12-26 10:08:57', '127.0.0.1');
