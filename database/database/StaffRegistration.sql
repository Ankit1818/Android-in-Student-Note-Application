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
-- Table structure for table `StaffRegistration`
--

CREATE TABLE `StaffRegistration` (
  `StaffID` int(11) NOT NULL,
  `StaffName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `StaffPassword` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `StaffEmail` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `StaffRegistration`
--

INSERT INTO `StaffRegistration` (`StaffID`, `StaffName`, `StaffPassword`, `StaffEmail`) VALUES
(1, 'staff', '1111', 'staff@gmail.com'),
(2, 'staf', '1111', 'staf@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `StaffRegistration`
--
ALTER TABLE `StaffRegistration`
  ADD PRIMARY KEY (`StaffID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `StaffRegistration`
--
ALTER TABLE `StaffRegistration`
  MODIFY `StaffID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
