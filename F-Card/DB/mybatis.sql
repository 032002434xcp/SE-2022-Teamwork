-- phpMyAdmin SQL Dump
-- version 4.4.15.10
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2022-11-15 16:54:54
-- 服务器版本： 8.0.24
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mybatis`
--

-- --------------------------------------------------------

--
-- 表的结构 `card`
--

CREATE TABLE IF NOT EXISTS `card` (
  `ability1` int DEFAULT NULL,
  `ability2` int DEFAULT NULL,
  `ability3` int DEFAULT NULL,
  `ability4` int DEFAULT NULL,
  `ability5` int DEFAULT NULL,
  `cardLevel` int DEFAULT NULL,
  `experience` int DEFAULT NULL,
  `rank` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cardName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `introduction` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `preferance` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- 转存表中的数据 `card`
--

INSERT INTO `card` (`ability1`, `ability2`, `ability3`, `ability4`, `ability5`, `cardLevel`, `experience`, `rank`, `cardName`, `introduction`, `preferance`) VALUES
(5, 5, 5, 5, 5, 1, 0, '教授', '张栋', '一个很帅的老师', '软件工程'),
(5, 5, 5, 5, 4, 1, 0, '教授', '栋哥', '一个很帅的老师', '软件工程'),
(5, 5, 5, 5, 5, 1, 0, '副教授', '栋哥1号', '一个很帅的老师', '软件工程'),
(5, 5, 5, 5, 5, 1, 0, '讲师', '栋哥2号', '一个很帅的老师', '软件工程'),
(5, 5, 5, 5, 5, 1, 0, '学士', '栋哥3号', '一个很帅的老师', '软件工程');

-- --------------------------------------------------------

--
-- 表的结构 `cardinhand`
--

CREATE TABLE IF NOT EXISTS `cardinhand` (
  `ability1` int DEFAULT NULL,
  `ability2` int DEFAULT NULL,
  `ability3` int DEFAULT NULL,
  `ability4` int DEFAULT NULL,
  `ability5` int DEFAULT NULL,
  `cardName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rank` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `introduction` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `preferance` varchar(300) DEFAULT NULL,
  `UID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `experience` int DEFAULT NULL,
  `cardLevel` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- 转存表中的数据 `cardinhand`
--

INSERT INTO `cardinhand` (`ability1`, `ability2`, `ability3`, `ability4`, `ability5`, `cardName`, `rank`, `introduction`, `preferance`, `UID`, `experience`, `cardLevel`) VALUES
(5, 5, 5, 5, 5, '张栋', '教授', '一个很帅的老师', '软件工程', '666666', 0, 1);

-- --------------------------------------------------------

--
-- 表的结构 `personalcard`
--

CREATE TABLE IF NOT EXISTS `personalcard` (
  `ability1` int DEFAULT NULL,
  `ability2` int DEFAULT NULL,
  `ability3` int DEFAULT NULL,
  `ability4` int DEFAULT NULL,
  `ability5` int DEFAULT NULL,
  `cardLevel` int DEFAULT NULL,
  `experience` int DEFAULT NULL,
  `rank` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cardName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `introduction` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `preferance` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `situation` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `dateTime` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `duplicateCards` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- 转存表中的数据 `personalcard`
--

INSERT INTO `personalcard` (`ability1`, `ability2`, `ability3`, `ability4`, `ability5`, `cardLevel`, `experience`, `rank`, `cardName`, `introduction`, `preferance`, `situation`, `UID`, `dateTime`, `duplicateCards`) VALUES
(5, 5, 5, 5, 5, 3, 0, '教授', '张栋', '一个很帅又幽默的老师', '软件工程', '闲置', '666666', '2022-11-4', 1),
(5, 5, 5, 5, 5, 1, 0, '副教授', '栋哥1号', '一个很帅的老师', '软件工程', '闲置', '666666', '', 4),
(5, 5, 5, 5, 5, 1, 0, '讲师', '栋哥2号', '一个很帅的老师', '软件工程', '闲置', '666666', '', 2);

-- --------------------------------------------------------

--
-- 表的结构 `question`
--

CREATE TABLE IF NOT EXISTS `question` (
  `questionAbility1` float DEFAULT NULL,
  `questionAbility2` float DEFAULT NULL,
  `questionAbility3` float DEFAULT NULL,
  `questionAbility4` float DEFAULT NULL,
  `questionAbility5` float DEFAULT NULL,
  `questionName` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `preferance` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- 转存表中的数据 `question`
--

INSERT INTO `question` (`questionAbility1`, `questionAbility2`, `questionAbility3`, `questionAbility4`, `questionAbility5`, `questionName`, `preferance`) VALUES
(4, 3, 5, 1, 2, 'AI绘画', '机器学习');

-- --------------------------------------------------------

--
-- 表的结构 `rank`
--

CREATE TABLE IF NOT EXISTS `rank` (
  `collegeInfluence` int DEFAULT NULL,
  `grade` int DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `college` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `dateTime` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `rank` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- 转存表中的数据 `rank`
--

INSERT INTO `rank` (`collegeInfluence`, `grade`, `name`, `college`, `dateTime`, `rank`) VALUES
(50, 100, '李福安', '计算机学院', '2022-11-4', 2),
(50, 90, '李鹏程', '计算机学院', '2022-11-4', 3),
(50, 110, '陈斌', '计算机学院', '2022-11-4', 1);

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `collegeInfluence` int DEFAULT NULL,
  `coin` int DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `college` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `phoneNumber` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `dateTime` varchar(50) DEFAULT NULL,
  `task` varchar(3000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `towerNumber` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`collegeInfluence`, `coin`, `name`, `password`, `college`, `phoneNumber`, `UID`, `dateTime`, `task`, `towerNumber`) VALUES
(100, 999, '林子键', '123456', '计算机学院', '13110635554', '666661', '2022-11-14', '每日任务：未完成', 66),
(100, 999, '李福安', '123456', '计算机学院', '13110635554', '6666666', '2022-11-14', '每日任务：未完成', 66);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `card`
--
ALTER TABLE `card`
  ADD PRIMARY KEY (`cardName`);

--
-- Indexes for table `cardinhand`
--
ALTER TABLE `cardinhand`
  ADD PRIMARY KEY (`UID`,`cardName`);

--
-- Indexes for table `personalcard`
--
ALTER TABLE `personalcard`
  ADD PRIMARY KEY (`UID`,`cardName`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`questionName`);

--
-- Indexes for table `rank`
--
ALTER TABLE `rank`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`UID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
