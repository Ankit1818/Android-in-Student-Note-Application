-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Sep 18, 2019 at 11:59 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id8849175_info`
--

-- --------------------------------------------------------

--
-- Table structure for table `AdminRegistration`
--

CREATE TABLE `AdminRegistration` (
  `AdminID` int(11) NOT NULL,
  `AdminName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `AdminEmail` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `AdminPassword` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `AdminRegistration`
--

INSERT INTO `AdminRegistration` (`AdminID`, `AdminName`, `AdminEmail`, `AdminPassword`) VALUES
(1, 'admin', 'admin@gmail.com', 'admin'),
(2, 'add', 'add@gmail.com', '1add');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `AdminRegistration`
--
ALTER TABLE `AdminRegistration`
  ADD PRIMARY KEY (`AdminID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `AdminRegistration`
--
ALTER TABLE `AdminRegistration`
  MODIFY `AdminID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
