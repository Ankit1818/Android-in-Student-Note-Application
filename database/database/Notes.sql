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
-- Table structure for table `Notes`
--

CREATE TABLE `Notes` (
  `Id` int(255) NOT NULL,
  `Name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `NoteTitle` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `NoteSubject` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `NoteDetails` varchar(355) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `Notes`
--

INSERT INTO `Notes` (`Id`, `Name`, `NoteTitle`, `NoteSubject`, `NoteDetails`) VALUES
(10, 'Admin', 'Test Demoghhh', 'Test sub', 'test demo'),
(11, 'Admin', 'Test Title', 'Testing add', 'checking change proper working or not'),
(16, 'add', 'Gdhdhd', 'Bxjc', 'Bxncn '),
(18, 'add', 'Trry', 'Ugcg vhjvhkn', 'Yhgchn gnvngbvgghbv'),
(20, 'admin', 'Hhg', 'Ggj', 'Hgjk'),
(21, 'admin', 'Gdemo', 'Jchcjg', 'Fbcjvkvgxjcjckxgbcnncbcbbbxbbx'),
(22, 'staff', 'Hgxnx', 'Bznc', 'nxn n m \nvcv\nvhcmf\nc'),
(28, 'staff', 'Ghv', 'Ggbb', 'vcbn'),
(29, 'admin', 'Bsbfj', 'Bxhc', '.cjckf'),
(30, 'admin', '', '', ''),
(31, 'admin', 'Znzhshhsh', 'Gshshsh', 'jdjdjdi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Notes`
--
ALTER TABLE `Notes`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Notes`
--
ALTER TABLE `Notes`
  MODIFY `Id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
