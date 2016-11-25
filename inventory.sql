-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 25, 2016 at 08:20 AM
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
-- Table structure for table `inventory`
--

CREATE TABLE IF NOT EXISTS `inventory` (
  `name` text NOT NULL,
  `description` text NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` double NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`name`, `description`, `quantity`, `price`, `id`) VALUES
('PS4', 'Almost like new', 0, 300, 10),
('PSVR', 'virtual reality core for the PS4', 0, 400, 11),
('car', 'a car', 0, 50.5, 13),
('<img src="https://cdn2.hubspot.net/hubfs/500440/Blog_Content/bacon.jpg" alt="bacon" />', 'This is top-quality bacon. Quantity in strips.', 0, 0.68, 14),
('Playstation 5', 'With that price you might as well get a pc!!!', -1, 1000, 15),
('iPad', 'Apple', 0, 799.99, 16),
('Watches', 'gold watches', 0, 34, 17),
('PSR Pro', 'Has an updated graphics card', 11, 400, 18),
('Tamales', 'theyre aight', 14, 1.5, 19),
('Cars', 'We riding Bentleys', 349, 350, 20);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
