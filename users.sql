-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 25, 2016 at 08:21 AM
-- Server version: 5.5.49-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cs3220stu27`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_name` text NOT NULL,
  `password` text NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=38 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_name`, `password`, `id`) VALUES
('fugi', 'aa', 1),
('mary@jane.com', 'bb', 4),
('john@doe.com', 'aa', 6),
('cnguyen', 'cs3220pw', 7),
('sam', '123', 16),
('Beard', '1224', 17),
('abc', 'abc', 18),
('email@email.com', 'abcd', 19),
('das', 'free', 20),
('-', '-', 21),
('Batman', 'abc', 22),
('Cristal', '1234', 23),
('food0601', 'eat1994', 24),
('q', '2', 25),
('Abc', '123', 26),
('Pablo', 'man', 27),
('123', '123', 28),
('memes', '123', 29),
('user', 'password', 30),
('hola', 'hola1234', 31),
('Duff', 'password', 32),
('A', 'a', 33),
('Something', 'password', 34),
('clark@k.ent', 'superman', 35),
('1', '1', 36),
('Jo3', 'champ', 37);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
