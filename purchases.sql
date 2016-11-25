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
-- Table structure for table `purchases`
--

CREATE TABLE IF NOT EXISTS `purchases` (
  `name` text NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` double NOT NULL,
  `username` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchases`
--

INSERT INTO `purchases` (`name`, `quantity`, `price`, `username`) VALUES
('PSVR', 1, 400, 'fugi'),
('PS4', 1, 300, 'abc'),
('PSVR', 1, 400, 'abc'),
('PS4', 1, 300, 'abc'),
('PSVR', 1, 400, 'email@email.com'),
('PSVR', 2, 400, 'email@email.com'),
('PSVR', 1, 400, 'das'),
('<img src="https://cdn2.hubspot.net/hubfs/500440/Blog_Content/bacon.jpg" alt="bacon" />', 2, 0.68, '-'),
('car', 1, 50.5, 'Cristal'),
('car', 1, 50.5, 'food0601'),
('PSVR', 1, 400, 'Abc'),
('<img src="https://cdn2.hubspot.net/hubfs/500440/Blog_Content/bacon.jpg" alt="bacon" />', 12, 0.68, 'Abc'),
('car', 2, 50.5, 'Pablo'),
('<img src="https://cdn2.hubspot.net/hubfs/500440/Blog_Content/bacon.jpg" alt="bacon" />', 1, 0.68, '123'),
('PSVR', 2, 400, 'memes'),
('car', 1, 50.5, 'user '),
('<img src="https://cdn2.hubspot.net/hubfs/500440/Blog_Content/bacon.jpg" alt="bacon" />', 7, 0.68, 'user '),
('car', 5, 50.5, 'hola'),
('<img src="https://cdn2.hubspot.net/hubfs/500440/Blog_Content/bacon.jpg" alt="bacon" />', 5, 0.68, 'hola'),
('car', 1, 50.5, 'q'),
('car', 2, 50.5, 'q'),
('car', 1, 50.5, 'A'),
('Playstation 5', 1, 1000, 'Something'),
('Playstation 5', 1, 1000, 'Something'),
('car', 1, 50.5, 'clark@k.ent'),
('car', 1, 50.5, 'Batman'),
('car', 1, 50.5, 'fugi'),
('<img src="https://cdn2.hubspot.net/hubfs/500440/Blog_Content/bacon.jpg" alt="bacon" />', 2, 0.68, 'fugi'),
('<img src="https://cdn2.hubspot.net/hubfs/500440/Blog_Content/bacon.jpg" alt="bacon" />', 8, 0.68, '1'),
('car', 3, 50.5, '1'),
('iPad', 1, 799.99, 'Jo3'),
('iPad', 1, 799.99, 'fugi'),
('iPad', 1, 799.99, 'john@doe.com'),
('Watches', 2, 34, 'fugi'),
('iPad', 2, 799.99, 'fugi'),
('Watches', 10, 34, 'fugi'),
('PSR Pro', 1, 400, 'fugi'),
('PSR Pro', 1, 400, 'fugi'),
('Tamales', 1, 1.5, 'abc'),
('Cars', 1, 350, 'john@doe.com');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
