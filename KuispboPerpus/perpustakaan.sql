-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 15, 2020 at 01:16 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpustakaan`
--

-- --------------------------------------------------------

--
-- Table structure for table `anggota`
--

CREATE TABLE `anggota` (
  `NIS` varchar(10) NOT NULL,
  `Namasiswa` varchar(20) NOT NULL,
  `Ttl` date NOT NULL,
  `Jenkel` varchar(10) NOT NULL,
  `Agama` varchar(10) NOT NULL,
  `Daftar` date NOT NULL,
  `Berlaku` date NOT NULL,
  `Kelas` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `anggota`
--

INSERT INTO `anggota` (`NIS`, `Namasiswa`, `Ttl`, `Jenkel`, `Agama`, `Daftar`, `Berlaku`, `Kelas`) VALUES
('112', 'amal', '2001-03-10', 'Perempuan', 'Islam', '2020-04-01', '2020-04-30', 'b'),
('113', 'doni', '2001-02-20', 'Laki-laki', 'Kristen', '2020-02-11', '2021-02-11', 'c'),
('114', 'timmy', '2001-03-17', 'Laki-laki', 'Islam', '2019-02-11', '2020-02-11', 'c');

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `Kodebuku` varchar(5) NOT NULL,
  `Namabuku` varchar(20) NOT NULL,
  `Npengarang` varchar(20) NOT NULL,
  `Nterbit` varchar(20) NOT NULL,
  `Tterbit` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`Kodebuku`, `Namabuku`, `Npengarang`, `Nterbit`, `Tterbit`) VALUES
('123', 'Bumi', 'Nama Saya', 'Gramedia', '2020'),
('124', 'Polusi', 'Cahya Nisa', 'Bukune', '2001'),
('125', 'People', 'anak orang', 'gramed', '2010');

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `NIK` varchar(5) NOT NULL,
  `Namakaryawan` varchar(20) NOT NULL,
  `Jenkel` varchar(10) NOT NULL,
  `Gol` varchar(20) NOT NULL,
  `Jabatan` varchar(20) NOT NULL,
  `Tunjang` varchar(10) NOT NULL,
  `Tgaji` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`NIK`, `Namakaryawan`, `Jenkel`, `Gol`, `Jabatan`, `Tunjang`, `Tgaji`) VALUES
('221', 'aku', 'Pria', '2', 'staff', '50000', '1850000'),
('222', 'siti', 'Perempuan', '3', 'magang', '0', '500000'),
('223', 'brian', 'Pria', '1', 'supervisor', '100000', '2100000');

-- --------------------------------------------------------

--
-- Table structure for table `pinjam`
--

CREATE TABLE `pinjam` (
  `Nopinjam` varchar(5) NOT NULL,
  `NIS` varchar(10) NOT NULL,
  `Namasiswa` varchar(20) NOT NULL,
  `Kelas` varchar(5) NOT NULL,
  `Kodebuku` varchar(4) NOT NULL,
  `Namabuku` varchar(20) NOT NULL,
  `Npenerbit` varchar(20) NOT NULL,
  `Tglpinjam` date NOT NULL,
  `Tglkembali` date NOT NULL,
  `Lama` varchar(5) NOT NULL,
  `Denda` varchar(9) NOT NULL,
  `NIK` varchar(10) NOT NULL,
  `Karyawan` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pinjam`
--

INSERT INTO `pinjam` (`Nopinjam`, `NIS`, `Namasiswa`, `Kelas`, `Kodebuku`, `Namabuku`, `Npenerbit`, `Tglpinjam`, `Tglkembali`, `Lama`, `Denda`, `NIK`, `Karyawan`) VALUES
('001', '112', 'amal', 'b', '125', 'People', 'gramed', '2020-04-01', '2020-04-08', '7', '0', '222', 'siti');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
