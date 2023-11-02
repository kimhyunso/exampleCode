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
-- 테이블 구조 `member_table`
--

CREATE TABLE IF NOT EXISTS `member_table` (
  `idx` int(10) NOT NULL AUTO_INCREMENT,
  `id` char(20) NOT NULL,
  `pass` char(50) DEFAULT NULL,
  `level` int(3) DEFAULT '1',
  `name` char(20) NOT NULL,
  `mobile` char(15) DEFAULT NULL,
  `zipcode` char(7) DEFAULT NULL,
  `addr1` char(100) DEFAULT NULL,
  `addr2` char(100) DEFAULT NULL,
  `gender` int(1) DEFAULT '1',
  `email` char(50) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `regdate` date DEFAULT NULL,
  `lastupdate` date DEFAULT NULL,
  PRIMARY KEY (`idx`),
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- 테이블의 덤프 데이터 `member_table`
--

INSERT INTO `member_table` (`idx`, `id`, `pass`, `level`, `name`, `mobile`, `zipcode`, `addr1`, `addr2`, `gender`, `email`, `birth`, `regdate`, `lastupdate`) VALUES
(1, 'test', '*89C6B530AA78695E257E55D63C00A6EC9AD3E977', 1, 'aa', '010-1111-1111', '13473', '경기 성남시 분당구 경부고속도로 409 (삼평동)', '경부고속도로', 1, 'test@naver.com', '2019-10-11', '2019-12-18', '2019-12-23'),
(2, 'admin', '*99BBDABB3B71B35EBBA5996FB4D6088517E4B6B5', 9, '관리자', '010-0000-0000', '04716', '서울 성동구 행당로8길 8 (행당동, 행당두산위브아파트)', '두산위브아파트 201동 1101호', 1, 'gustn9515@naver.com', '1996-01-06', '2019-12-18', '2019-12-18'),
(3, 'dev', '*89C6B530AA78695E257E55D63C00A6EC9AD3E977', 13, '개발자', '010-0000-0000', '13480', '경기 성남시 분당구 대왕판교로 477 (판교동, 낙생고등학교)', '테스트1', 1, 'test@naver.com', '2019-10-11', '2019-12-20', '2019-12-20'),
(4, 'qwer', '*2491CA5000A9614AA28C39036702D965584486EC', 5, 'qwer', '010-0000-0000', '13536', '경기 성남시 분당구 판교역로 4 (백현동)', 'ㅁㄴㅇㅁㅇㅁㅇ', 2, 'test@naver.com', '2019-10-11', '2019-12-24', '2019-12-24');
