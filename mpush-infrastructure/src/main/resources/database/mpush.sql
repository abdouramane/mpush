-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 04, 2017 at 09:30 PM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mpush`
--

-- --------------------------------------------------------

--
-- Table structure for table `Customer`
--

CREATE TABLE `Customer` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) COLLATE utf8_bin NOT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `Customer`
--

INSERT INTO `t_person` (DISCRIMINATOR, `PERSON_FIRSTNAME`, `PERSON_EMAIL`) VALUES
  ('User', 'Peter', 'peter.parker@spider.com'),
  ('User', 'Daryl', 'daryl@lexus.fr'),
  ('User', 'Samadou', 'samadou@ensimag.fr'),
  ('User', 'Anonymous', 'unknow@anonymous.fr');

INSERT INTO `t_person` (DISCRIMINATOR, `PERSON_FIRSTNAME`, `PERSON_EMAIL`) VALUES
  ('Contact', 'Lucy', 'lucy@scarlet.com'),
  ('Contact', 'Carmelo', 'carmelo.anthony@nba.com'),
  ('Contact', 'Henry', 'henry@fox.com'),
  ('Contact', 'Kader', 'kad@scarlet.com'),
  ('Contact', 'Merlou', 'merlou.anthony@nba.com'),
  ('Contact', 'Sam', 'sam@fox.com');

INSERT INTO `t_person` (DISCRIMINATOR, `PERSON_FIRSTNAME`, `PERSON_EMAIL`, USER_LOGIN) VALUES
  ('User', 'Abdou', 'abdou@chef.fr', 'test');

--
-- Indexes for dumped tables
--


COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
