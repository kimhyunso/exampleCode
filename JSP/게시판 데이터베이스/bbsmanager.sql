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
-- 테이블 구조 `bbsmanager`
--

CREATE TABLE IF NOT EXISTS `bbsmanager` (
  `idx` int(10) NOT NULL AUTO_INCREMENT,
  `cat` int(10) DEFAULT '0',
  `title` char(20) DEFAULT 'no title',
  `useflag` int(1) DEFAULT '1',
  `manager` char(100) DEFAULT '',
  `odr` int(3) DEFAULT '1',
  `rlevel` int(3) DEFAULT '1',
  `wlevel` int(3) DEFAULT '1',
  `mwlevel` int(3) DEFAULT '1',
  `downlevel` int(3) DEFAULT '1',
  `heads` char(200) DEFAULT '질문,답변,정보,기타',
  `lpp` int(3) DEFAULT '10',
  `filecount` int(3) DEFAULT '2',
  `ext` char(100) DEFAULT 'jpg,jpeg,png,gif',
  `css` blob,
  `cssno` char(255) DEFAULT NULL,
  `csshead` char(255) DEFAULT NULL,
  `csstitle` char(255) DEFAULT NULL,
  `csswriter` char(255) DEFAULT NULL,
  `cssfile` char(255) DEFAULT NULL,
  `csstime` char(255) DEFAULT NULL,
  `csshit` char(255) DEFAULT NULL,
  `cssleft` char(255) DEFAULT NULL,
  `cssright` char(255) DEFAULT NULL,
  `uplogo` char(30) DEFAULT NULL,
  `downlogo` char(30) DEFAULT NULL,
  `wysiwyg` int(1) DEFAULT '0',
  `isdft` int(1) DEFAULT '0',
  PRIMARY KEY (`idx`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- 테이블의 덤프 데이터 `bbsmanager`
--

INSERT INTO `bbsmanager` (`idx`, `cat`, `title`, `useflag`, `manager`, `odr`, `rlevel`, `wlevel`, `mwlevel`, `downlevel`, `heads`, `lpp`, `filecount`, `ext`, `css`, `cssno`, `csshead`, `csstitle`, `csswriter`, `cssfile`, `csstime`, `csshit`, `cssleft`, `cssright`, `uplogo`, `downlogo`, `wysiwyg`, `isdft`) VALUES
(1, 1, '자바', 1, '관리자1', 1, 1, 1, 1, 1, '질문, 답변, 정보, 기타', 10, 2, 'jpg,jpeg,gif,png', '', 'col-md-1 hidden-xs hidden-sm', 'col-md-1 hidden-xs hidden-sm', 'col-md-4 col-xs-9 col-sm-9 ellipsis', 'col-md-2 col-xs-3 col-sm-3 ellipsis', 'col-md-1 hidden-xs hidden-sm', 'col-md-2 hidden-xs hidden-sm', 'col-md-1 hidden-xs hidden-sm', 'col-md-2 col-sm-2 col-xs-2', 'col-md-10 col-xm-10 col-xm-10', NULL, NULL, 1, 1),
(2, 1, '자바FX', 1, '관리자1', 2, 1, 1, 1, 1, '질문, 답변, 정보, 기타', 15, 2, 'jpg,jpeg,gif,png', '', 'col-md-1 hidden-xs hidden-sm', 'col-md-1 hidden-xs hidden-sm', 'col-md-4 col-xs-9 col-sm-9 ellipsis', 'col-md-2 col-xs-3 col-sm-3 ellipsis', 'col-md-1 hidden-xs hidden-sm', 'col-md-2 hidden-xs hidden-sm', 'col-md-1 hidden-xs hidden-sm', 'col-md-2 col-sm-2 col-xs-2', 'col-md-10 col-xm-10 col-xm-10', NULL, NULL, 1, 0),
(3, 1, 'C언어 게시판', 1, '관리자1', 1, 1, 1, 5, 1, '질문, 답변, 정보, 기타', 15, 2, 'jpg,jpeg,gif,png', 0x2e6d79436c6173737b0d0a2020206261636b67726f756e642d636f6c6f723a234646303030303b0d0a7d, 'col-md-1 hidden-xs hidden-sm', 'col-md-1 hidden-xs hidden-sm', 'col-md-4 col-xs-9 col-sm-9 ellipsis', 'col-md-2 col-xs-3 col-sm-3 ellipsis', 'col-md-1 hidden-xs hidden-sm', 'col-md-2 hidden-xs hidden-sm', 'col-md-1 hidden-xs hidden-sm', 'col-md-2 col-sm-2 col-xs-2', 'col-md-10 col-xm-10 col-xm-10', NULL, NULL, 0, 0),
(4, 1, '테스트 입니다.', 1, '관리자1', 1, 9, 9, 9, 9, '질문, 답변, 정보, 기타', 15, 2, 'jpg,jpeg,gif,png', '', 'col-md-1 hidden-xs hidden-sm', 'col-md-1 hidden-xs hidden-sm', 'col-md-4 col-xs-9 col-sm-9 ellipsis', 'col-md-2 col-xs-3 col-sm-3 ellipsis', 'col-md-1 hidden-xs hidden-sm', 'col-md-2 hidden-xs hidden-sm', 'col-md-1 hidden-xs hidden-sm', 'col-md-2 col-sm-2 col-xs-2', 'col-md-10 col-xm-10 col-xm-10', NULL, NULL, 0, 0);
