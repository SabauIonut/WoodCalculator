-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 21, 2021 at 01:06 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `users_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `busteni`
--

CREATE TABLE `busteni` (
  `ID` int(11) NOT NULL,
  `cantitate` int(11) NOT NULL,
  `lungime` int(11) NOT NULL,
  `diametru` int(11) NOT NULL,
  `volum` double(11,2) NOT NULL,
  `username` varchar(100) NOT NULL,
  `fname` varchar(100) NOT NULL,
  `data` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `busteni`
--

INSERT INTO `busteni` (`ID`, `cantitate`, `lungime`, `diametru`, `volum`, `username`, `fname`, `data`) VALUES
(449, 1, 4, 34, 0.36, 'sabauionut15@gmail.com', 'test1', '2021-06-17 15:51:21'),
(450, 1, 4, 34, 0.36, 'sabauionut15@gmail.com', 'test1', '2021-06-17 15:51:21'),
(451, 1, 5, 23, 0.21, 'sabauionut15@gmail.com', 'test1', '2021-06-17 15:51:21'),
(788, 1, 5, 34, 0.45, 'beatrice_clepcea', 'test1', '2021-06-17 21:50:21'),
(906, 1, 3, 40, 0.38, 'test', 'test_file1_busteni', '2021-06-21 11:55:49'),
(907, 1, 4, 35, 0.38, 'test', 'test_file1_busteni', '2021-06-21 11:55:49'),
(908, 1, 3, 40, 0.38, 'test', 'test_file1_busteni', '2021-06-21 11:55:49'),
(909, 1, 4, 35, 0.38, 'test', 'test_file1_busteni', '2021-06-21 11:55:49'),
(910, 1, 6, 40, 0.75, 'test', 'test_file1_busteni', '2021-06-21 11:55:49'),
(911, 1, 4, 40, 0.50, 'test', 'test_file1_busteni', '2021-06-21 11:55:49'),
(912, 1, 6, 35, 0.58, 'test', 'test_file1_busteni', '2021-06-21 11:55:49'),
(913, 1, 7, 29, 0.46, 'test', 'test_file1_busteni', '2021-06-21 11:55:49'),
(914, 1, 6, 38, 0.68, 'test', 'test_file1_busteni', '2021-06-21 11:55:49'),
(915, 1, 8, 36, 0.81, 'test', 'test_file1_busteni', '2021-06-21 11:55:49'),
(916, 1, 5, 26, 0.27, 'test', 'test_file1_busteni', '2021-06-21 11:55:49'),
(917, 1, 3, 49, 0.57, 'test', 'test_file1_busteni', '2021-06-21 11:55:49'),
(918, 1, 5, 46, 0.83, 'test', 'test_file1_busteni', '2021-06-21 11:55:49'),
(919, 1, 6, 78, 2.87, 'test', 'test_file1_busteni', '2021-06-21 11:55:49'),
(920, 1, 5, 35, 0.48, 'test', 'test_file1_busteni', '2021-06-21 11:55:49'),
(921, 1, 4, 45, 0.64, 'test', 'test_file2_busteni', '2021-06-21 11:56:01'),
(922, 10, 4, 34, 3.60, 'test', 'test_file2_busteni', '2021-06-21 11:56:01'),
(923, 15, 4, 25, 3.00, 'test', 'test_file2_busteni', '2021-06-21 11:56:01'),
(924, 5, 4, 32, 1.60, 'test', 'test_file2_busteni', '2021-06-21 11:56:01'),
(925, 1, 6, 35, 0.58, 'test', 'test_file2_busteni', '2021-06-21 11:56:01');

-- --------------------------------------------------------

--
-- Table structure for table `copaci`
--

CREATE TABLE `copaci` (
  `ID` int(11) NOT NULL,
  `cantitate` int(11) NOT NULL,
  `specie` varchar(20) NOT NULL,
  `inaltime` int(11) NOT NULL,
  `diametrupiept` int(11) NOT NULL,
  `volum` double(11,2) NOT NULL,
  `username` varchar(100) NOT NULL,
  `fname` varchar(100) NOT NULL,
  `data` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `copaci`
--

INSERT INTO `copaci` (`ID`, `cantitate`, `specie`, `inaltime`, `diametrupiept`, `volum`, `username`, `fname`, `data`) VALUES
(193, 1, 'Brad', 35, 40, 3.04, 'sabauionut15@gmail.com', 'testcopac1', '2021-06-17 15:52:12'),
(194, 1, 'Brad', 30, 35, 1.99, 'sabauionut15@gmail.com', 'testcopac1', '2021-06-17 15:52:12'),
(195, 1, 'Brad', 27, 43, 2.70, 'sabauionut15@gmail.com', 'testcopac1', '2021-06-17 15:52:12'),
(358, 1, 'Brad', 25, 45, 2.75, 'test', 'test_file2_copaci', '2021-06-21 12:03:01'),
(359, 1, 'Brad', 25, 34, 1.57, 'test', 'test_file2_copaci', '2021-06-21 12:03:01'),
(360, 1, 'Brad', 25, 46, 2.86, 'test', 'test_file2_copaci', '2021-06-21 12:03:01'),
(361, 1, 'Brad', 25, 22, 0.66, 'test', 'test_file2_copaci', '2021-06-21 12:03:01'),
(362, 1, 'Brad', 25, 21, 0.60, 'test', 'test_file2_copaci', '2021-06-21 12:03:01'),
(363, 1, 'Brad', 25, 35, 1.66, 'test', 'test_file2_copaci', '2021-06-21 12:03:01'),
(364, 10, 'Brad', 25, 46, 28.63, 'test', 'test_file2_copaci', '2021-06-21 12:03:01'),
(365, 1, 'Anin Alb', 25, 45, 2.79, 'test', 'test_file1_copaci', '2021-06-21 12:06:02'),
(366, 1, 'Anin Alb', 35, 30, 1.73, 'test', 'test_file1_copaci', '2021-06-21 12:06:02'),
(367, 1, 'Anin Alb', 26, 35, 1.75, 'test', 'test_file1_copaci', '2021-06-21 12:06:02'),
(368, 1, 'Anin Alb', 26, 37, 1.96, 'test', 'test_file1_copaci', '2021-06-21 12:06:02'),
(369, 1, 'Anin Alb', 20, 39, 1.67, 'test', 'test_file1_copaci', '2021-06-21 12:06:02'),
(370, 1, 'Anin Alb', 21, 36, 1.50, 'test', 'test_file1_copaci', '2021-06-21 12:06:02'),
(371, 1, 'Anin Alb', 20, 26, 0.74, 'test', 'test_file1_copaci', '2021-06-21 12:06:02'),
(372, 1, 'Anin Alb', 21, 45, 2.34, 'test', 'test_file1_copaci', '2021-06-21 12:06:02');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(40) NOT NULL,
  `phone` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `full_name`, `username`, `password`, `phone`) VALUES
(1240, 'test', 'test', '123', '0712345678'),
(1241, 'Sabau Ionut Alexandru', 'sabauionut15@gmail.com', 'parola', '0772095466'),
(1249, 'Clepcea Beatrice', 'beatrice_clepcea', 'poli123', '0745326123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `busteni`
--
ALTER TABLE `busteni`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `copaci`
--
ALTER TABLE `copaci`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `busteni`
--
ALTER TABLE `busteni`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=926;

--
-- AUTO_INCREMENT for table `copaci`
--
ALTER TABLE `copaci`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=373;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1250;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
