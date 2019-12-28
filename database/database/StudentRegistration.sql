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
-- Table structure for table `StudentRegistration`
--

CREATE TABLE `StudentRegistration` (
  `StudentID` int(255) NOT NULL,
  `StudentName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `StudentLogID` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `StudentPassword` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `StudentEmail` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `StudentRollno` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `StudentRegistration`
--

INSERT INTO `StudentRegistration` (`StudentID`, `StudentName`, `StudentLogID`, `StudentPassword`, `StudentEmail`, `StudentRollno`) VALUES
(10, 'demo', 'demo@111', '5558', 'demo@gmail.com', 111),
(12, 'rthf', 'rthf@556', '5674', 'vdgjbv', 556),
(13, 'vvb', 'vvb@666', '7876', 'narejarajiya1154@gmail.com', 666),
(14, 'tegd', 'tegd@123', '1234', 'vcfhh', 123),
(16, 'rtyu', 'rtyu@123', '1234', 'fsgh@gmail.com', 123),
(18, 'Ytr', 'Ytr@214563', '7896', 'gfhjj@ghg', 214563),
(19, 'Rrr', 'Rrr@123', '1234', 'rrr@gmail.com', 123);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `StudentRegistration`
--
ALTER TABLE `StudentRegistration`
  ADD PRIMARY KEY (`StudentID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `StudentRegistration`
--
ALTER TABLE `StudentRegistration`
  MODIFY `StudentID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
